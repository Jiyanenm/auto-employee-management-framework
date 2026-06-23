package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
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

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // GitHub Actions / Linux Support
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {

        if (driver != null) {
            driver.quit();
        }
    }

    protected void takeScreenshot(String name) {
        ScreenshotUtil.capture(driver, name);
    }
}