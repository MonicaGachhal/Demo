package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testData.DataUtility;

public class Demo
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	
	@Test
	public void testA() throws InterruptedException
	{
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = DataUtility.getPropertyData("url");
		String un = DataUtility.getPropertyData("un");
		String pw = DataUtility.getPropertyData("pw");
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		
	}
}
