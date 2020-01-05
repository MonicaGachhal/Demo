package listeners;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoB {
	@Test
	public void testD()
	{
		Reporter.log("TestD()................",true);
	}

	@Test
	public void testE()
	{
		Reporter.log("TestE()................",true);
	}
}
