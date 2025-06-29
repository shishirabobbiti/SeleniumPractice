package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableEx {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			WebElement table=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']"));
			List<WebElement> header=table.findElements(By.tagName("th"));
			for(int i=0;i<header.size();i++) {
				System.out.print(header.get(i).getText()+ "\t");
			}
			System.out.println();
			List<WebElement>rows=table.findElements(By.tagName("tr"));
			for(int j=0;j<rows.size();j++) {
				List<WebElement> cols=rows.get(j).findElements(By.xpath("td"));
				for(int k=0;k<cols.size();k++) {
					String cell=cols.get(k).getText();
					System.out.print(cell+ "\t");
//					if(cell.equals("Receptionist")) {
//						System.out.println(cell);
//						break;
//					}
				}
				System.out.println();
			}
	}

}
