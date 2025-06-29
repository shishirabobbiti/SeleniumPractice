package com.intro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InterviewExample {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		//https://getbootstrap.com/docs/4.0/components/dropdowns
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dezlearn.com/webtable-example");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src , new File("D:\\screenshot.png"));
		//driver.switchTo().window("//https://getbootstrap.com/docs/4.0/components/dropdowns");
		driver.navigate().to("https://getbootstrap.com/docs/4.0/components/dropdowns");
		driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();
		List<WebElement>items=driver.findElements(By.xpath("//div[@aria-labelledby='dropdownMenuLink']"));
		for(int i=0;i<items.size();i++) {
			WebElement item=items.get(i);
			if(item.getText().equalsIgnoreCase("Another action")) {
				item.click();
			}
		}
		driver.navigate().back();
		driver.navigate().to("https://rahulshettyacademy.com/client");
		WebElement userName=driver.findElement(By.id("userEmail"));
		js.executeScript("arguments[0].value='shishira36@gmail.com';",userName);
		System.out.println(driver.findElement(By.id("userPassword")).getAttribute("formcontrolname"));
		System.out.println(driver.findElement(By.id("userPassword")).getAttribute("placeholder"));
		driver.findElement(By.id("userPassword")).sendKeys("Shishirareddy");
		WebElement login=driver.findElement(By.id("login"));
		js.executeScript("arguments[0].click();", login);
        driver.navigate().to("https://www.file.io");
        String filePath="D:\\Timetable.xlsx";
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
        Thread.sleep(3000);
        
        //WebElement upload=driver.findElement(By.xpath("//label[@for='select-files-input']"));
       // upload.click();
       // Thread.sleep(6000);
       
//        StringSelection selection = new StringSelection(filePath);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//        Robot r=new Robot();
//        r.keyPress(KeyEvent.VK_CONTROL);
//        r.keyPress(KeyEvent.VK_V);
//        r.keyRelease(KeyEvent.VK_V);
//        r.keyRelease(KeyEvent.VK_CONTROL);
//        r.keyPress(KeyEvent.VK_ENTER);
//        r.keyRelease(KeyEvent.VK_ENTER);
       
        driver.navigate().to("https://www.dezlearn.com/webtable-example");
        driver.navigate().refresh();
        WebElement table=driver.findElement(By.xpath("//table[@class='tg']"));
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		//System.out.println(rows.size());
		for(int i=1;i<rows.size();i++) {
			WebElement row=rows.get(i);
			List<WebElement>cols=row.findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++) {
				String name=cols.get(j).getText();
				if(name.equalsIgnoreCase("Mayur Deshmukh")) {
					table.findElement(By.xpath("(//td[text()='"+name+"']//following-sibling::td//input[@type='checkbox'])[1]")).click();
					Thread.sleep(2000);
					table.findElement(By.xpath("(//td[text()='"+name+"']//following-sibling::td//input[@type='checkbox'])[2]")).click();
					Thread.sleep(2000);
					Select dropdown=new Select(table.findElement(By.xpath("//td[text()='"+name+"']//following-sibling::td//select")));
					dropdown.selectByVisibleText("Sedan");
				table.findElement(By.xpath("//td[text()='"+name+"']//following-sibling::td//input[@type='text']")).sendKeys("Test");
				js.executeScript("window.scrollBy(0,500)");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Update']")).click();
				String msg=driver.findElement(By.xpath("//p[@id='updateDiv']")).getText();
				Assert.assertEquals(msg, "Details updated successfully.");
				Thread.sleep(15000);
				driver.close();
				}
			}
			
		}
		
	}

}
