package WebTableExample;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSeleniumExample {
    public static void main(String[] args) throws IOException {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Load Excel file
        File file = new File("data.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // Read data from the first row and column
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String searchQuery = cell.getStringCellValue();
        workbook.close();

        // Use the data to perform a Google search
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery);
        searchBox.submit();

        // Close browser
        driver.quit();
    }
}

