package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.EnvironmentConfig;
import utils.JsonReader;

public class LogoutTest extends BaseTest {

    @Test
    @Tag("smoke")
    @Tag("regression")
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Logout Employee")
    public void logoutTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        JsonReader json =
                new JsonReader(EnvironmentConfig.getProperty("json_test_data_path"));

        String email = json.getValue("username");
        String password = json.getValue("password");

        loginPage.login(email, password);

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.logout();

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("login")
        );
    }
}