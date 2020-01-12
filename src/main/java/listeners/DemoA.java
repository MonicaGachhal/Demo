package listeners;

import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.DemoListeners.class)(packagename
public class DemoA 
{
@Test
public void testA()
{
	Reporter.log("TestA()................",true);
}

@Test
public void testB()
{
	Reporter.log("TestB()................",true);
	Assert.fail();
}

@Test(dependsOnMethods="testB")
public void testC()
{
	Reporter.log("TestC()................",true);
}
}
