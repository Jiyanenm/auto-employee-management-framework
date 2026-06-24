package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.EnvironmentConfig;
import utils.ScreenshotUtil;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        EnvironmentConfig.loadEnvironment();

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        boolean headless =
                Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (headless) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String url = ConfigReader.getBaseUrl();

        if (url == null || url.isEmpty()) {
            throw new RuntimeException("base.url is missing in config file");
        }

        driver.get(url);

        System.out.println("OPENED URL: " + driver.getCurrentUrl());

        // ✅ Wait page fully loaded
        wait.until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        // ✅ WAIT LOGIN FIELD VISIBLE (NOT just present)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[type='email']")
        ));

        System.out.println("LOGIN PAGE READY");
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterEach
    public void captureFailure(TestInfo testInfo) {
        ScreenshotUtil.capture(driver, testInfo.getDisplayName());
    }
    protected void takeScreenshot(String name) {
        ScreenshotUtil.capture(driver, name);
    }

    // 🔥 GLOBAL UTILITY (VERY IMPORTANT)
    protected void waitForOverlayToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".overlay, .toast, .toast-title, .loading")
            ));
        } catch (Exception ignored) {}
    }
}