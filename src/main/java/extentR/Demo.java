package extentR;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Demo extends BaseTest 
{
	@Test
	public void testA() throws Exception
	{
		logger= extent.createTest("TestA", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestA is started");
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
		logger.log(Status.INFO, "TestA is Finished");
	}
	
	@Test
	public void testB() throws Exception
	{
		logger= extent.createTest("TestB", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestB is started");
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
		logger.log(Status.INFO, "TestB is Finished");
	}
	
	@Test
	public void testC() throws Exception
	{
		logger= extent.createTest("TestC", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestC is started");
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
		logger.log(Status.INFO, "TestC is Finished");
	}
	@Test
	public void testD() throws Exception
	{
		logger= extent.createTest("TestD", "Go to Google and Enter QSPIDERS");
		logger.log(Status.INFO, "TestD is started");
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
		logger.log(Status.INFO, "TestD is Finished");
	}
}


