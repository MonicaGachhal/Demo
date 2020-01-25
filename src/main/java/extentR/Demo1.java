package extentR;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Demo1 extends BaseTest
{
	@Test
	public void testE() throws Exception
	{
		logger= extent.createTest("TestE", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestE is started");
		try 
		{
			driver.findElement(By.name("q")).sendKeys("Qspiders");
			logger.info("Entered QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			logger.pass("Clicked on Enter Key");
			String path= getScreenshot(driver);
			logger.pass("Passed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch (Exception e) 
		{
			logger.error("Failed");
			logger.error(e.getMessage());
			String path = getScreenshot(driver);
			logger.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			Assert.fail();
		}
		logger.log(Status.INFO, "TestE is Finished");
	}
	@Test
	public void testF() throws Exception
	{
		logger= extent.createTest("TestF", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestF is started");
		try 
		{
			driver.findElement(By.name("q123")).sendKeys("Qspiders");
			logger.info("Entered QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			logger.pass("Clicked on Enter Key");
			String path= getScreenshot(driver);
			logger.pass("Passed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch (Exception e) 
		{
			logger.error("Failed");
			logger.error(e.getMessage());
			String path = getScreenshot(driver);
			logger.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			Assert.fail();
		}
		logger.log(Status.INFO, "TestF is Finished");
	}
}
