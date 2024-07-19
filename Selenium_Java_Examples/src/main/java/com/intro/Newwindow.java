package com.intro;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Newwindow {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// tab is required for opening new link but window is not present in new window
		// need to get id
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindowid = it.next();
		String childwindowid = it.next();
		driver.switchTo().window(childwindowid);
		// new window opened , get text and paste it parent window
		driver.get("https://courses.rahulshettyacademy.com/");
		String coursenames = driver.findElements(By.xpath("//a[contains(@href,'/p')]")).get(1).getText();
		driver.switchTo().window(parentwindowid);
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(coursenames);
		// webelement screenshot
		File src = name.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("logo.png"));
		//Get Height  width
		System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
	}

}
