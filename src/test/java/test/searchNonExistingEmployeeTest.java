package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.EnvironmentConfig;

public class searchNonExistingEmployeeTest extends BaseTest {

    @Tag("smoke")
    @Tag("regression")
    @Test
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Search inValid Employee")
    public void searchNonExistingEmployeeTest() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                EnvironmentConfig.getProperty("username"),
                EnvironmentConfig.getProperty("password")
        );

        Thread.sleep(3000);

        EmployeePage employeePage = new EmployeePage(driver);

        employeePage.searchEmployee("EmployeeDoesNotExist123");

        Thread.sleep(2000);

        Assertions.assertFalse(
                employeePage.employeeExists("EmployeeDoesNotExist123")
        );

        System.out.println("Non-existing employee was not found as expected");
    }



}
