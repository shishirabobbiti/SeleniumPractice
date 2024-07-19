package com.intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Additems {
	static WebDriver driver = new ChromeDriver();
	static WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

	public static void main(String[] args) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String[] itemsneeded = { "Cauliflower", "Tomato", "Banana" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// Thread.sleep(3000);
		cartitems(driver, itemsneeded);
		driver.quit();

	}

	public static void cartitems(WebDriver driver, String[] itemsneeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			// Onion - 1 Kg
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();

			List itemsneededlist = Arrays.asList(itemsneeded);
			if (itemsneededlist.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsneeded.length) {
					break;
				}

			}

		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

	}
}
