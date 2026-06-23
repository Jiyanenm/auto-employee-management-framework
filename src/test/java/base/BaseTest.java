package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import utils.EnvironmentConfig;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {

        EnvironmentConfig.loadEnvironment();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {

        if (driver != null && testInfo.getTags().contains("failed")) {
            ScreenshotUtil.capture(driver, testInfo.getDisplayName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
    protected void takeScreenshot(String name) {

        ScreenshotUtil.capture(
                driver,
                name
        );
    }
}