package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {

    private Workbook workbook;

    public ExcelReader(String filePath) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            workbook =
                    WorkbookFactory.create(fis);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public String getCellData(
            String sheetName,
            int rowNum,
            int colNum) {

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    public int getRowCount(String sheetName) {

        Sheet sheet =
                workbook.getSheet(sheetName);

        return sheet.getLastRowNum();
    }
}