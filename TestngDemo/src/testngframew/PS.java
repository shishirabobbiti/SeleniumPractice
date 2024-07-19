package testngframew;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	
	@BeforeMethod
	public void beforeRun()
	{
		System.out.println("Before Run");
	}
	public static void dothis()
	
	{
		System.out.println("I am inherated");
		
	}
	@AfterMethod
	public void afterRun()
	{
		System.out.println("After Run");
	}
	
}
