package driver;

import browsers.*;
import enums.Browsers;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class DriverManager {

    private static DriverManager instances = null;
    private BrowserSelectable browserSelectable;
    private WebDriver driver;
    private Browsers browsersType;
    private String browserName;
    static final String PROP_FILE_NAME = "config.properties";
    Properties configProps;
    /**
     * I have implemented DriverManager with singleton design pattern.
     * The main reason is we have one driver only and we can use this one driver whole project all the time
     * So, constantly creating new driver instance and inheriting base class to use driver is not a good behaviour. We will just create a static method
     * and we will use our driver whenever its needed
     *
     * getInstances(): When you call this method if there is not any driver, it will create driver. Otherwise, it will return the already initiated driver
     *
     * CreateLocalDriver(): Its about reading which browser will be used. By default chrome browser wil be opened.
     * If we want to run the test in different browser, all we need it just put desired browser name to the config.properties
     */

    private DriverManager() {

    }

    public static DriverManager getInstances() {
        if (instances == null) {
            instances = new DriverManager();
        }
        return instances;
    }


    public void createLocalDriver() throws IOException {
        InputStream is=  ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME);
        configProps = new Properties();
        configProps.load(is);
        browserName = configProps.getProperty("browser");
        Browsers browserType = Browsers.valueOf(browserName.toUpperCase(Locale.ROOT));
        setBrowsersType(browserType);
        switch (browserType) {
            case OPERA -> {
                browserSelectable = new Opera();
                setDriver(browserSelectable.getBrowser());
                getDriver().manage().window().maximize();
            }
            case EDGE -> {
                browserSelectable = new Edge();
                setDriver(browserSelectable.getBrowser());
            }
            case SAFARI -> {
                browserSelectable = new Safari();
                setDriver(browserSelectable.getBrowser());
                getDriver().manage().window().maximize();
            }
            case FIREFOX -> {
                browserSelectable = new Firefox();
                setDriver(browserSelectable.getBrowser());
                getDriver().manage().window().maximize();
            }
            case CHROME -> {
                browserSelectable = new Chrome();
                setDriver(browserSelectable.getBrowser());
            }
            default -> throw new IllegalArgumentException(String.format("%s undefined type of browser", browserType));

        }
    }


    public void quitDriver() {
        try {
            if (getDriver() != null) {
                getDriver().close();
                getDriver().quit();
            }
        } catch (NoSuchSessionException e) {
            //  log.warn("Driver already closed");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Browsers getBrowsersType() {
        return browsersType;
    }

    public void setBrowsersType(Browsers browsers) {
        this.browsersType = browsers;
    }

}
