package WebTableExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebHandler {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Boolean next;
		File file = new File("src\\main\\resources\\selenium.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.createSheet("excelwriting9");
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.id("example"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		Thread.sleep(3000);	
		Integer flag=0;
		
		do {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 0; i <rows.size()-1; i++) {
				int rowCount = sheet.getPhysicalNumberOfRows();
				System.out.println(rowCount);
				Row row = sheet.createRow(rowCount);
	            if(i==0 && flag==0) {
	            	List<WebElement> headers= driver.findElements(By.xpath("//thead/tr/th"));
	            	for (int j = 0; j < headers.size(); j++) {
	            		Cell cell=row.createCell(j);
						WebElement header = headers.get(j);
						System.out.print(header.getText().trim() + "\t||");	
						cell.setCellValue(header.getText());
						flag++;
	               }
	            }
	            else {
	            	List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
	            	for(int k=0;k<cols.size();k++) {
	            		Cell cell1=row.createCell(k);
	            		WebElement col=cols.get(k);
	            		System.out.print(col.getText().trim()+ "\t||");
	            		cell1.setCellValue(col.getText());
	            	}
	            }
				
				System.out.println();
			}
			next=false;
			try {
				next=driver.findElement(By.xpath("//button[@aria-label='Next' and @aria-disabled='true']")).isDisplayed();
			}
			catch(Exception e){
				driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
			}
			
			
		}while(!next);
		 FileOutputStream fos = new FileOutputStream(file);
	        workbook.write(fos);

		driver.close();

	}

}
