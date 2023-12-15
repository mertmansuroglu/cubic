package pageObjects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Utils;

public class PurchaseDataPage extends Utils {

    private Logger log = LogManager.getLogger(LoginPage.class);

    public PurchaseDataPage() {
        AjaxElementLocatorFactory ajaxWait = new AjaxElementLocatorFactory(DriverManager.getInstances().getDriver(), 15);
        PageFactory.initElements(ajaxWait, this);
    }

}
