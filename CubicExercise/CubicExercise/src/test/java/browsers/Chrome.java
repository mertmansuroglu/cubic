package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.HashMap;

public class Chrome implements BrowserSelectable {

    private ChromeDriverService chromeDriverService;
    /**
     * Here, I implemented the methods of BrowserSelectable interface and override the methods according to Chrome browser
     * I also added --headless option to the add argument in case the user want to run the test in the background but I put the code in comment
     *
     */
    @Override
    public MutableCapabilities getCapabilities() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--log-level=3");
        options.addArguments("--disable-notifications");
//        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-logging");
//        options.addArguments("--headless", "--window-size=1440,768", "--disable-gpu");

        return options;
    }

    @Override
    public RemoteWebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriverService = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        try {
            chromeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(chromeDriverService.getUrl(), getCapabilities());
    }
}
