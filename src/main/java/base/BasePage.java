package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;



public class BasePage {

    protected WebDriver driver;
    protected WaitUtils  waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected void click(By locator) {
        waitUtils.waitForElementClickable(locator).click();
    }

    protected void type(By locator, String value) {
        waitUtils.waitForElementVisible(locator).clear();
        waitUtils.waitForElementVisible(locator).sendKeys(value);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}