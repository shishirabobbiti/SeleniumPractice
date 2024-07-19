package testngframew;

import org.testng.annotations.Test;

public class PS1 extends PS {

	@Test
	public void testRun()
	{
		int a=3;
		PS2 ps2=new PS2(a); //parameterized constructor
		dothis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		System.out.println(ps2.mutiplytwo());
		System.out.println(ps2.mutiplythree());
	}

}
