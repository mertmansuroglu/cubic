package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Utils;

public class FAQPage extends Utils {

    public FAQPage() {
        AjaxElementLocatorFactory ajaxWait = new AjaxElementLocatorFactory(DriverManager.getInstances().getDriver(), 15);
        PageFactory.initElements(ajaxWait, this);
    }

}
