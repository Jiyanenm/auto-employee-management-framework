package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.EnvironmentConfig;

public class DeleteEmployeeTest extends BaseTest {

    @Tag("smoke")
    @Tag("regression")
    @Test
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Delete Employee")
    public void deleteEmployeeTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                EnvironmentConfig.getProperty("username"),
                EnvironmentConfig.getProperty("password")
        );

        Thread.sleep(3000);

        EmployeePage employeePage = new EmployeePage(driver);

        employeePage.deleteFirstEmployee();

        Thread.sleep(3000);

        System.out.println("Employee deleted successfully");
    }
}