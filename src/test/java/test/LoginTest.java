package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import utils.EnvironmentConfig;
import utils.JsonReader;

@Epic("Employee Management")
@Feature("Authentication")
public class LoginTest extends BaseTest {

    @Test
    @Tag("smoke")
    @Tag("regression")
    @Story("Valid Login")
    @Description("Verify user can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void validLoginTest() {

        // 🔥 Load test data safely
        String jsonPath = EnvironmentConfig.getProperty("json_test_data_path");

        if (jsonPath == null || jsonPath.isEmpty()) {
            throw new RuntimeException("❌ json_test_data_path is missing in config");
        }

        JsonReader json = new JsonReader(jsonPath);

        String email = json.getValue("username");
        String password = json.getValue("password");

        if (email == null || password == null) {
            throw new RuntimeException("❌ Username or password is NULL in JSON file");
        }

        // 🔥 Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        // 🔥 Wait for successful navigation
        wait.until(ExpectedConditions.urlContains("/employees"));

        String currentUrl = driver.getCurrentUrl();

        // 🔥 Assertion
        Assertions.assertTrue(
                currentUrl.contains("/employees"),
                "Login failed - user is still on login page. Current URL: " + currentUrl
        );

        System.out.println("✅ Login Successful: " + currentUrl);
    }
}