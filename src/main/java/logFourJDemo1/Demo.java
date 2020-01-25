package logFourJDemo1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import logFourJDemo.Demo1;

public class Demo {
	static Logger log= LogManager.getLogger(Demo.class.getName());
	@Test
	 public void testB()
	 {
		log.info("This is info log");
		log.error("Error Log");
		log.fatal("Fatal Log");
		log.debug("Debug Log");
		log.warn("Warn Log");
		log.trace("Trace Log");
	 }
}
