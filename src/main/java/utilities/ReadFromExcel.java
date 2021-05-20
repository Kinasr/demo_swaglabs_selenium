package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {
    public static Object[][] readDataFromExelSheet(String fileName, String sheetName) {
        Object[][] data;
        try (FileInputStream inputStream = new FileInputStream(
                "src\\test\\resources\\" + fileName + ".xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            var numOfRows = sheet.getPhysicalNumberOfRows();
            var numOfColumns = sheet.getRow(0).getLastCellNum();
            data = new Object[numOfRows - 1][numOfColumns];

            for (int rowIndex = 1; rowIndex < numOfRows; rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                for (int columnIndex = 0; columnIndex < numOfColumns; columnIndex++) {
                    data[rowIndex - 1][columnIndex] = currentRow.getCell(columnIndex).toString();
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
