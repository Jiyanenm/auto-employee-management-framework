package test;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.JsonReader;

public class AddEmployeeTest extends BaseTest {

    @Tag("smoke")
    @Tag("regression")
    @Test
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Add Employee")
    public void addEmployeeTest() throws InterruptedException {

        JsonReader json = new JsonReader(
                "src/test/resources/testdata/employee.json"
        );

        String email = json.getValue("email");
        String password = json.getValue("password");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(email, password);

        Thread.sleep(3000);

        EmployeePage employeePage = new EmployeePage(driver);

        employeePage.clickAddEmployee();

        Thread.sleep(1000);

        employeePage.addEmployee(
                json.getValue("name"),
                json.getValue("emailAddress"),
                json.getValue("department"),
                json.getValue("status")
        );

        Thread.sleep(3000);

        Assertions.assertTrue(
                driver.getPageSource().contains("Automation User")
        );
    }
}