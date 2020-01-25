package demolog;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RTDemo 
{
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	
	private static Logger log= LogManager.getLogger(RTDemo.class.getName());
	
	WebDriver driver;
	@BeforeMethod
	public void preCondition()
	{
		log.info("Opening the Browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Maximised the Browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
		log.debug("Entered URL");
	}
	@Test(priority=1)
	public void testA()
	{
		log.info("Fetching the Title");
		String aTitle = driver.getTitle();
		String eTitle = "actiTIME - Login";
		try
		{
			Assert.assertEquals(aTitle,eTitle);
			log.info("Both Title are matching");
		}
		catch( Exception e)
		{
			log.error("Both Title  are not macthing");
			
		}
	}
		@Test(priority=2)
		public void testB()
		{
			log.info("Finding the Element");
			try
			{
				boolean loginBtn = driver.findElement(By.id("loginButton123")).isDisplayed();
				Assert.assertTrue(loginBtn);
				log.info("Ele is displayed");
		}
			catch(Exception e)
			{
				log.error("ele is not displayed");
			}
	}
		@AfterMethod
		public void postCondition()
		{
			log.debug("Closing the Driver");
			driver.close();
		}
	
}
