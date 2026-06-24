package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import utils.ExcelReader;

public class ExcelReaderTest {

    @Test
    @Owner("Nkosinathi Jiyane")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Employee Management")
    @Feature("Employee CRUD")
    @Story("Read Data From Excel Employee")
    public void readExcelTest() {

        ExcelReader excel =
                new ExcelReader(
                        "src/test/resources/testdata/employees.xlsx"
                );

        System.out.println(
                excel.getCellData(
                        "Employees",
                        1,
                        0
                )
        );

        System.out.println(
                excel.getCellData(
                        "Employees",
                        1,
                        1
                )
        );
    }
}