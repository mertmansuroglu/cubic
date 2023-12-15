package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepsDefiniton {
    private Logger log = LogManager.getLogger(LoginPage.class);
    private HomePage homePage;
    private LoginPage loginPage;

    public LoginStepsDefiniton() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Given("goto  Home Page")
    public void gotoHomePage() {
        try {
            homePage.gotoHomePage();
        } catch (RuntimeException e) {
            log.error("User could not enter to the home page");
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @When("go to login page")
    public void goToLoginPage() {

        try {
            homePage.gotoLoginPage();
        } catch (RuntimeException e) {
            log.error("User could not enter to the login page");
            throw e;
        }
    }

    @Then("verify login page and see page header as {string}")
    public void verifyLoginPageAndSeePageHeaderAs(String expectedValue) {
        assertEquals(expectedValue, loginPage.getLoginPageHeaderText());
        log.info("User is currently on the login page and header text is {}", expectedValue);


    }

    @When("enter username and password as {string} and {string}")
    public void enterUsernameAndPasswordAsAnd(String username, String password) {
        loginPage.logIn(username, password);

    }

    @Then("verify Succes login message as {string}")
    public void verifySuccesLoginMessageAs(String expectedMessage) {
        assertTrue(loginPage.getLoginSuccesMessageText().contains(expectedMessage));
        log.info("User successfully logged in the page and login message is: {}", expectedMessage);
    }

    @Then("verify error Message   as {string}")
    public void verifyErrorMessageAs(String expectedMessage) {
        assertTrue(loginPage.getLoginErrorMessageText().contains(expectedMessage));
        log.info("User could not logged in the page and error message is: {}", expectedMessage);
    }
}
