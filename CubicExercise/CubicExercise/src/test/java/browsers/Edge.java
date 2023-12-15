package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.HashMap;

public class Edge implements BrowserSelectable {


    /**
     * Here, I implemented the methods of BrowserSelectable interface and override the methods according to Edge browser
     *
     *
     */
    private EdgeDriverService EdgeDriverService;

    @Override
    public MutableCapabilities getCapabilities() {
        EdgeOptions options = new EdgeOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        return options;
    }

    @Override
    public RemoteWebDriver getBrowser() {
        WebDriverManager.edgedriver().setup();
        EdgeDriverService = new EdgeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        try {
            EdgeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(EdgeDriverService.getUrl(), getCapabilities());
    }
}

