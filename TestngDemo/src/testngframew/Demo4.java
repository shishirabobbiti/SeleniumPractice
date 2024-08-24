package testngframew;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Demo4 {
	
	@Test
	public void MobileloginHome() {
		
		System.out.println("MobileloginHome");
	}
	
	@Test
	public void MobilesigninHome() {
		
		System.out.println("MobilesigninHome");
	}
	
	@Test
	public void signoutHome() {
		
		System.out.println("MobilesignoutHome");
	}
	@Test(groups={"Smoke"})
	public void bmwcarloan() {
		
		System.out.println("bmwcarloan");
	}
	@Test(groups={"Smoke"})
	public void audicarloan() {
		
		System.out.println("audicarloan");
	}
	

}
