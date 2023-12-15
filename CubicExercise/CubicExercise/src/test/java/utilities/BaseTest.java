package utilities;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;


    /**
     * By default, we are running our test in chrome, but we can add firefox,opera etc to the parameter
     */
    @Before
    public void setUp() throws Exception {
        DriverManager.getInstances().createLocalDriver();
        DriverManager.getInstances().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.getInstances().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        DriverManager.getInstances().getDriver().manage().deleteAllCookies();
        DriverManager.getInstances().getDriver().manage().deleteAllCookies();


    }

    @After
    public void tearDown(Scenario scenario) {
        if (DriverManager.getInstances().getDriver() != null) {
            DriverManager.getInstances().getDriver().close();
            DriverManager.getInstances().getDriver().quit();
        }
    }
}
