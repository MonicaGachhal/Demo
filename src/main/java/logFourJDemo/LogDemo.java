package logFourJDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogDemo {

	static Logger log= LogManager.getLogger(LogDemo.class.getName());//create reference variable for for Logger and
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
