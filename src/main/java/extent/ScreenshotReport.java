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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotReport {
	WebDriver driver;
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws Exception
	{
		//to create HTML Report File
		ExtentHtmlReporter htmlreport= new ExtentHtmlReporter("./Reports/TestResult1.html");
		
		//to attach the created report
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlreport);
		
		ExtentTest log= extent.createTest("testA", "Go to Google and Enter QSPIDERS");
		
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
		log.info("Closing the Browser");
		driver.close();
		extent.flush();
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
