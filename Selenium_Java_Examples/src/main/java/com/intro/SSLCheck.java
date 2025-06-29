package com.intro;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class SSLCheck {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src,new File("D:\\screeshot.png"));
		FileHandler.copy(src, new File("D:\\screeshot.png"));
	}

}
