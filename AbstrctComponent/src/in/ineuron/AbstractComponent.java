package in.ineuron;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		System.out.println("AbstractComponent.AbstractComponent()");
	}

	public void waitTillElementAppeared() {
		driver.waitForElement();
		System.out.println("AbstractComponent.waitTillElementAppeared()");
	}
}
