package logFourJDemo1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import logFourJDemo.LogDemo;

public class Demo1
{
	static Logger log= LogManager.getLogger(Demo1.class.getName());
	@Test
	public void testA()
	{
		if(10>5)
		{
		 log.info("Pass");
		}
		else
		{
			log.error("Fail");
		}
	}
}
