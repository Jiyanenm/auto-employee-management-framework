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



    protected void type(By locator, String value) {
        waitUtils.waitForElementVisible(locator).clear();
        waitUtils.waitForElementVisible(locator).sendKeys(value);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public void click(By locator) {

        try {

            waitUtils.waitForElementClickable(locator).click();

        } catch (ElementClickInterceptedException e) {

            WaitUtils.waitForOverlayToDisappear(driver);
            waitForToastToDisappear(driver);

            waitUtils.waitForElementClickable(locator).click();
        }
    }
    public static void waitForToastToDisappear(WebDriver driver) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(
                            By.cssSelector(".toast-title")
                    )
            );

        } catch (Exception ignored) {
        }
    }
}