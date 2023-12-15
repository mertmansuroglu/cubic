package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.HashMap;

public class Firefox implements BrowserSelectable {

    /**
     * Here, I implemented the methods of BrowserSelectable interface and override the methods according to Firefox browser
     *
     *
     */
    private GeckoDriverService geckoDriverService;

    @Override
    public MutableCapabilities getCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        return options;
    }

    //burda neden buildli startli kullandik ??? porttan calistirmak istedigimiz icin mi
    @Override
    public RemoteWebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        geckoDriverService = new GeckoDriverService.Builder()
                .usingAnyFreePort()
                .build();
        try {
            geckoDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(geckoDriverService.getUrl(), getCapabilities());
    }
}
