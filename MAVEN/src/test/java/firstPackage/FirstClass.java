package firstPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstClass {

	
	@Test
	public void TC1()
	{
		Reporter.log("this is tc1",true);
	}
}
