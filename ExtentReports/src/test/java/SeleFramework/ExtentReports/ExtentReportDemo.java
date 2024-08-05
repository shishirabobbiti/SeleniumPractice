package SeleFramework.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void ExtentReports()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Extent Reporter Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shishira");
		
	}

	@Test
	public void intialDemo()
	{
		ExtentTest test=extent.createTest("intialDemo");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.fail("results don not match");
		driver.close();
		extent.flush();
	}
	@Test
	public void secondDemo()
	{
		ExtentTest test=extent.createTest("secondDemo");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
}
