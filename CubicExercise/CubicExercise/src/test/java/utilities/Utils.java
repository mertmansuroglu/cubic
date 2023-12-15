package utilities;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils {


    public Utils() {

    }

    protected void click(WebElement element) {
        element.click();
    }

    protected String readText(WebElement element) {
        return element.getText();
    }

    protected void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void mouseOver(WebElement element) {
        Actions actions = new Actions(DriverManager.getInstances().getDriver());
        actions.moveToElement(element);
    }

    protected void gotoUrl(String url) {
        DriverManager.getInstances().getDriver().get(url);
    }


}
