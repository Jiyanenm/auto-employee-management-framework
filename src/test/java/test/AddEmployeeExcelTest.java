//package test;
//
//import base.BaseTest;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pages.EmployeePage;
//import pages.LoginPage;
//import utils.ConfigReader;
//import utils.EnvironmentConfig;
//import utils.ExcelReader;
//
//public class AddEmployeeExcelTest extends BaseTest {
//
//    @Test
//    public void addEmployeeTest() throws Exception {
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.login(
//                ConfigReader.getProperty("username"),
//                ConfigReader.getProperty("password")
//        );
//
//        Thread.sleep(3000);
//
//        ExcelReader excel =
//                new ExcelReader(
//                        "src/test/resources/testdata/employees.xlsx"
//                );
//
//        String name =
//                excel.getCellData("Employees", 1, 0);
//
//        String email =
//                excel.getCellData("Employees", 1, 1);
//
//        String department =
//                excel.getCellData("Employees", 1, 2);
//
//        String status =
//                excel.getCellData("Employees", 1, 3);
//
//        EmployeePage employeePage =
//                new EmployeePage(driver);
//
//        employeePage.clickAddEmployee();
//
//        Thread.sleep(1000);
//
//        employeePage.addEmployee(
//                name,
//                email,
//                department,
//                status
//        );
//
//        Thread.sleep(3000);
//
//        Assertions.assertTrue(
//                driver.getPageSource().contains(name)
//        );
//
//        System.out.println("Employee Added Successfully: " + name);
//    }
//
//    @Test
//    public void addMultipleEmployeesTest() throws Exception {
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.login(
//                EnvironmentConfig.getProperty("email"),
//                EnvironmentConfig.getProperty("password")
//        );
//
//        Thread.sleep(3000);
//
//        ExcelReader excel =
//                new ExcelReader(
//                        "src/test/resources/testdata/employees.xlsx"
//                );
//
//        EmployeePage employeePage =
//                new EmployeePage(driver);
//
//        int rows = excel.getRowCount("Employees");
//
//        for (int i = 1; i <= rows; i++) {
//
//            String name =
//                    excel.getCellData("Employees", i, 0);
//
//            String email =
//                    excel.getCellData("Employees", i, 1);
//
//            String department =
//                    excel.getCellData("Employees", i, 2);
//
//            String status =
//                    excel.getCellData("Employees", i, 3);
//
//            employeePage.clickAddEmployee();
//
//            Thread.sleep(1000);
//
//            employeePage.addEmployee(
//                    name,
//                    email,
//                    department,
//                    status
//            );
//
//            Thread.sleep(2000);
//
//            System.out.println("Added Employee: " + name);
//        }
//    }
//}