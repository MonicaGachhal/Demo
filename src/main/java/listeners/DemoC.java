package listeners;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoC {
	@Test
	public void testF()
	{
		Reporter.log("TestF()................",true);
	}

	@Test
	public void testG()
	{
		Reporter.log("TestG()................",true);
	}
}
