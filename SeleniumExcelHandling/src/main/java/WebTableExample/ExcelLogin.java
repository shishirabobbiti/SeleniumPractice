package WebTableExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		File file = new File("src/main/resources/Cred.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = 2;
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				if (j == 0) {
					driver.findElement(By.id("userEmail")).clear();
					driver.findElement(By.id("userEmail")).sendKeys(cell.getStringCellValue());
					Thread.sleep(3000);

				} else {
					driver.findElement(By.id("userPassword")).clear();
					driver.findElement(By.id("userPassword")).sendKeys(cell.getStringCellValue());
					Thread.sleep(3000);
					driver.findElement(By.id("login")).click();
					Thread.sleep(3000);
					Boolean msg=false;
					try {
						msg = driver.findElement(By.id("login")).isDisplayed();
					}
					catch(Exception e) {
						
					}
					
					System.out.println(msg);
					String dataToUpdate = null;
					if (msg) {
						dataToUpdate = "Invalid User";
					} else {
						dataToUpdate = "Valid User";
						driver.findElement(By.xpath("//*[text()=' Sign Out ']")).click();
						
					}
					Cell cellNew=sheet.getRow(i).createCell(2);
					cellNew.setCellValue(dataToUpdate);
					 FileOutputStream fos = new FileOutputStream(file);
				        workbook.write(fos);
				        
				}

			}

		}

	}

}
