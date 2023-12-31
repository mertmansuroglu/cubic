package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.HashMap;

public class Opera implements BrowserSelectable {

    private OperaDriverService operaDriverService;
    /**
     * Here, I implemented the methods of BrowserSelectable interface and override the methods according to Opera browser
     *
     *
     */
    @Override
    public MutableCapabilities getCapabilities() {
        OperaOptions options = new OperaOptions();
        var prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        return options;
    }

    @Override
    public RemoteWebDriver getBrowser() {
        WebDriverManager.operadriver().setup();
        operaDriverService = new OperaDriverService.Builder()
                .usingAnyFreePort()
                .build();
        try {
            operaDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(operaDriverService.getUrl(), getCapabilities());
    }
}
