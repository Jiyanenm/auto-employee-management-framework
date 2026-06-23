package test;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.EnvironmentConfig;
import utils.JsonReader;

public class LoginTest extends BaseTest {

    @Tag("smoke")
    @Tag("regression")
    @Test
    public void validLoginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        JsonReader json =
                new JsonReader(EnvironmentConfig.getProperty("json_test_data_path"));

        String email = json.getValue("username");
        String password = json.getValue("password");

        loginPage.login(email, password);

        Thread.sleep(5000);

        Assertions.assertNotEquals(
                "https://employee-management-app-tau-ashen.vercel.app/login",
                driver.getCurrentUrl()
        );

        System.out.println("Login Successful");
    }
}