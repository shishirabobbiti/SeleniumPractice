package com.intro;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
      
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows=driver.getWindowHandles(); //parent id,childid
		Iterator<String> it=windows.iterator();
		String parentid= it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		String email=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		
	}

}
