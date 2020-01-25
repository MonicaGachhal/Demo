package extent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotForMultipleTestMethods
{
	WebDriver driver;
	static ExtentHtmlReporter htmlreport;
	static ExtentReports extent;
	static ExtentTest log;
	
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeClass
	public void preClass()
	{
		htmlreport= new ExtentHtmlReporter("./Reports/ClassResult.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlreport);
	}
	
	@AfterClass
	public void postClass()
	{
		extent.flush();
	}
	
	@Test
	public void testA() throws Exception
	{
		log= extent.createTest("TestA", "Go to Google and Enter QSPIDERS");
		driver= new ChromeDriver();
		log.info("Opening Browser");
		driver.manage().window().maximize();
		log.debug("Maximized the Browser");
		driver.get("https://www.google.com/");
		log.debug("Entered the URL");
		try 
		{
			driver.findElement(By.name("q")).sendKeys("Qspiders");
			log.info("Entered QSP");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			log.pass("Clicked on Enter Key");
			String path= getScreenshot(driver);
			log.pass("Passed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch (Exception e) 
		{
			log.error("Failed");
			log.error(e.getMessage());
			String path = getScreenshot(driver);
			log.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	@Test
		public void testB() throws Exception
		{
			log= extent.createTest("TestB", "Go to Google and Enter QSPIDERS");
			driver= new ChromeDriver();
			log.info("Opening Browser");
			driver.manage().window().maximize();
			log.debug("Maximized the Browser");
			driver.get("https://www.google.com/");
			log.debug("Entered the URL");
			try 
			{
				driver.findElement(By.name("q123")).sendKeys("Qspiders");
				log.info("Entered QSP");
				driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				log.pass("Clicked on Enter Key");
			}
			catch (Exception e) 
			{
				log.error("Failed");
				log.error(e.getMessage());
				String path = getScreenshot(driver);
				log.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
		}
			
			public static String getScreenshot (WebDriver driver) throws IOException
			{
				TakesScreenshot ts= (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./Screenshot/ABC.png");
				FileUtils.copyFile(src, dest);
				String path = dest.getAbsolutePath();
				return path;
			}
}
