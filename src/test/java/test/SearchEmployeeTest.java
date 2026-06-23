package test;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.EmployeePage;
import pages.LoginPage;
import utils.EnvironmentConfig;

public class SearchEmployeeTest extends BaseTest {

    @Tag("smoke")
    @Tag("regression")
    @Test
    public void searchEmployeeTest() throws Exception {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                EnvironmentConfig.getProperty("username"),
                EnvironmentConfig.getProperty("password")
        );

        Thread.sleep(3000);

        EmployeePage employeePage =
                new EmployeePage(driver);

        employeePage.searchEmployee(
                "Automation User"
        );

        Thread.sleep(2000);

        employeePage.searchEmployee("Automation User");

        Thread.sleep(3000);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        Assertions.assertTrue(
                employeePage.employeeExists("Automation User")
        );

        Assertions.assertTrue(
                employeePage.employeeExists(
                        "Automation User"
                )
        );

        System.out.println(
                "Employee found successfully"
        );
    }
}