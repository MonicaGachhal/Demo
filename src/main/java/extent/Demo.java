package extent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA()
	{
		//to create HTML Report File
		ExtentHtmlReporter htmlreport= new ExtentHtmlReporter("./Reports/TestResult.html");
		
		//to attach the created report
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlreport);
		
		ExtentTest log= extent.createTest("testA", "Go to Google and Enter QSPIDERS");
		
		WebDriver driver= new ChromeDriver();
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
		}
		catch (Exception e) 
		{
			log.error("Failed");
			log.error(e.getMessage());
		}
		log.info("Closing the Browser");
		driver.close();
		extent.flush();
		}
	}

