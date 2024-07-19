package testngframew;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {
	
	@AfterTest(timeOut=4000)
	public void aftertest() {
		
		System.out.println("i will execute last");
	}
	@Test(enabled=false)
	public void enable() {
		
		System.out.println("testenabled");
	}
	@Parameters({"URL","key"})
	@Test
	public void test(String urlname,String keyvalue) {
		
		System.out.println("Hello");
		System.out.println(urlname +","+ keyvalue );
	}
	@Test(dependsOnMethods="test")
	public void sectest() {
		
		System.out.println("Bye");
	}
	@BeforeTest
	public void beforetest() {
		
		System.out.println("i will execute first");
	}
	@Test(dataProvider="dp")
	public void testdp(String username,String pass) {
		
		System.out.println("i will execute dp");
		System.out.println(username +","+ pass);
	}
	@Test
	public void testlistener() {
		
		System.out.println("checking listeners");
		Assert.assertTrue(false);
	}
	@DataProvider
	public Object[][] dp() {
		//lst combination username password --good credit history 
		//2nd combination usernmae,password  --no credit history
		//3rdcombination usernam,password  --fraud history
		Object[][]data=new Object[3][2];
		
		data[0][0]="firstusername";
		data[0][1]="password";
		
		data[1][0]="Secondusername";
		data[1][1]="password";
		
		data[2][0]="thirdusername";
		data[2][1]="password";
		return data;
		
		
	}

}
