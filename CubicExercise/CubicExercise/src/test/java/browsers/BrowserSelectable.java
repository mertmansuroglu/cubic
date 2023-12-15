package browsers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * Here, I have created an interface for the browsers, the meain reason is I want to add general methods for the browsers
 * Then, override the general methods spesific to the browsers.
 *
 * @getCapabilities : Its a method to get the capabilities of the browsers by the help of ChromeOptions addArguments method
 * @getBrowser : We are initiating the remotewebdriver by the help of this method specific to teh browsers and adding the capabilities to browsers
 */
public interface BrowserSelectable {
    MutableCapabilities getCapabilities();

    RemoteWebDriver getBrowser();


}
