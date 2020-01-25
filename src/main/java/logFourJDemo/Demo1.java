package logFourJDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Demo1 
{
	static Logger log= LogManager.getLogger(Demo1.class.getName());
	@Test
	 public void testB()
	 {
		log.info("Info log");
		log.error("Error Log");
		log.fatal("Fatal Log");
		log.debug("Debug Log");
		log.warn("Warn Log");
		log.trace("Trace Log");
	 }
}
