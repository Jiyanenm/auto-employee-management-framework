package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    protected WaitUtils  waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

//    protected void click(By locator) {
//        waitUtils.waitForElementClickable(locator).click();
//    }

    protected void type(By locator, String value) {
        waitUtils.waitForElementVisible(locator).clear();
        waitUtils.waitForElementVisible(locator).sendKeys(value);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public void click(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }
}