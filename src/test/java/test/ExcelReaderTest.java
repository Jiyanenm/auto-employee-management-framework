package test;

import org.junit.jupiter.api.Test;
import utils.ExcelReader;

public class ExcelReaderTest {

    @Test
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