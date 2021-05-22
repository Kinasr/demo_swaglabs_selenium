package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * A Class loads a Excel sheet and providing this sheet.
 */
public class ExcelManager {
    private final String fileName;
    private final String sheetName;
    private Sheet sheet;

    /**
     * Set the file name and sheet name values.
     * @param fileName The name of the Excel file.
     * @param sheetName The name of the Sheet.
     */
    public ExcelManager(String fileName, String sheetName) {
        this.fileName = fileName;
        this.sheetName = sheetName;
        loadExcelSheet();
    }

    /**
     * Loads a sheet object form the Excel file.
     * and set it's value to the sheet variable.
     */
    private void loadExcelSheet() {
        try (FileInputStream inputStream = new FileInputStream(
                "src\\test\\resources\\" + fileName + ".xlsx");
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            MyLogger.severe(ExcelManager.class.getSimpleName(), "Can't read data from: "+ fileName
                    +" sheet: "+ sheetName);
            e.printStackTrace();
        }
    }

    /**
     * @return sheet variable.
     */
    public Sheet getSheet() {
        return sheet;
    }
}
