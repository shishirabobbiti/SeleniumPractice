package com.intro;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		SoftAssert s = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// String url = driver.findElement(By.xpath("//a[text()='Broken
		// Link']")).getAttribute("href");
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		List<WebElement> links = footer.findElements(By.tagName("a"));

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int response = conn.getResponseCode();
			System.out.println(response);
			s.assertTrue(response < 400, links.get(i).getText() + response);
			

//		if(response>403) 
//		{
//			System.out.println(links.get(i).getText() + response);
//			Assert.assertTrue(false);
//		}

		}
		s.assertAll();
	}

}
