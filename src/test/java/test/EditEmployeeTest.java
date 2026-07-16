package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.EnvironmentConfig;
import utils.JsonReader;

public class EditEmployeeTest extends BaseTest {

    @Test
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Edit Employee")
    public void editEmployeeTest() throws InterruptedException {

        // Load JSON test data once
        JsonReader json = new JsonReader("src/test/resources/testdata/employee.json");

        LoginPage loginPage = new LoginPage(driver);

        String email = json.getValue("email");
        String password = json.getValue("password");
        loginPage.login(email,password);

        EmployeePage employeePage = new EmployeePage(driver);

        employeePage.clickEditFirstEmployee();

        employeePage.updateEmployee(
                json.getValue("name"),
                json.getValue("emailAddress"),
                json.getValue("department"),
                json.getValue("status")
        );


        System.out.println("Expected Name: " + json.getValue("name"));
        System.out.println("Page Source Snapshot: " + driver.getPageSource());

        System.out.println(driver.getCurrentUrl());


      // ADD THIS (temporary fix)
        Thread.sleep(2000);
        Assertions.assertTrue(
                driver.getPageSource().contains(
                        json.getValue("name")
                )
        );
    }
}