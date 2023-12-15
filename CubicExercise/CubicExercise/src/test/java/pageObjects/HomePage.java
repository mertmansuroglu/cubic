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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage extends Utils {

    static final String PROP_FILE_NAME = "config.properties";
    private final String topMenu = "//div[@id=\"block_top_menu\"]";
    String homePageUrl;
    private Logger log = LogManager.getLogger(HomePage.class);
    @FindBy(how = How.XPATH, using = topMenu + "/ul/li/a[@title='Women']")
    private WebElement womenLink;
    @FindBy(how = How.XPATH, using = topMenu + "/ul/li/a[@title='Dresses']")
    private WebElement dressesLink;
    @FindBy(how = How.XPATH, using = topMenu + "/ul/li/a[@title='T-shirts']")
    private WebElement tshirtsLink;
    @FindBy(how = How.CSS, using = ".header_user_info a.login")
    private WebElement loginButton;
    @FindBy(how = How.CSS, using = "#home-page-tabs .homefeatured")
    private WebElement popularButton;
    @FindBy(how = How.CSS, using = "#home-page-tabs .blockbestsellers")
    private WebElement bestSellerButton;
    public HomePage() {
        AjaxElementLocatorFactory ajaxWait = new AjaxElementLocatorFactory(DriverManager.getInstances().getDriver(), 15);
        PageFactory.initElements(ajaxWait, this);
    }


    /**
     * If we want to run the test in different url, all we need it just put desired base.url name to the config.properties
     * In that way,we are not hardcoding test data to code and getting them from properties file
     */
    public void gotoHomePage() throws IOException {
        InputStream is=  ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME);
        Properties configProps = new Properties();
        configProps.load(is);
        homePageUrl = configProps.getProperty("base.url");
        gotoUrl(homePageUrl);
        log.info("User is heading to the home page");
    }

    public void gotoLoginPage() {
        click(loginButton);
        log.info("User clicked the login page button");

    }

}
