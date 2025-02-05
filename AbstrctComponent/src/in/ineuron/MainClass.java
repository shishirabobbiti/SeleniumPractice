package in.ineuron;

public class MainClass {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		LandingPage l=new LandingPage(driver);
		l.landingMethod();
	}

}
