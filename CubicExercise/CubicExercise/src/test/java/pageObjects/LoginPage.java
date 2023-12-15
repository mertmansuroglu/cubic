package pageObjects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Utils;

public class LoginPage extends Utils {

    /**
     * Here, I have used pager factory design
     * It is used for initialization of Page objects or to instantiate the Page object itself. It is also used to initialize Page class elements without using “FindElement/s.”
     */
    private Logger log = LogManager.getLogger(LoginPage.class);
    @FindBy(how = How.CSS, using = "#center_column h1.page-heading")
    private WebElement loginPageHeader;
    @FindBy(how = How.ID, using = "email")
    private WebElement email;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;
    @FindBy(how = How.CSS, using = "a[title='Recover your forgotten password']")
    private WebElement forgotPasswordLink;
    @FindBy(how = How.CSS, using = "p.submit button#SubmitLogin")
    private WebElement signInButton;
    @FindBy(how = How.CSS, using = "div#center_column p.info-account")
    private WebElement loginSuccesMessageText;
    @FindBy(how = How.CSS, using = "div[class='alert alert-danger'] ol li")
    private WebElement loginErrorMessageText;


    /**
     * I have used  AjaxElementLocatorFactory which helps that timeOut for a WebElement can be assigned to the Object page class
     * AjaxElementLocator is a lazy load concept in Page Factory pattern to identify WebElements only when they are used in any operation
     * The below code will wait for a maximum of 15 seconds until the elements specified by annotations are loaded.
     * If the element is not found in the given time interval, it will throw NoSuchElementException’ exception.
     * so with each call, we will wait at most 15 seconds until the specific element is there!
     */
    public LoginPage() {
        AjaxElementLocatorFactory ajaxWait = new AjaxElementLocatorFactory(DriverManager.getInstances().getDriver(), 15);
        PageFactory.initElements(ajaxWait, this);
    }

    public String getLoginPageHeaderText() {
        return readText(loginPageHeader);
    }

    public String getLoginSuccesMessageText() {
        return readText(loginSuccesMessageText);

    }

    public String getLoginErrorMessageText() {
        return readText(loginErrorMessageText);
    }

    public void logIn(String username, String password) {
        writeText(this.email, username);
        writeText(this.password, password);
        click(this.signInButton);
        log.info("User has entered username as {} and pwd as {}", username, password);

    }
}
