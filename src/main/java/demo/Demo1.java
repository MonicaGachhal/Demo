package demo;
//reading data from hidden element
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	
	public void testA() throws InterruptedException
	{
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");
		WebElement fromPlace = driver.findElement(By.id("fromPlaceName"));
		
		Actions act= new Actions(driver);
		act.moveToElement(fromPlace).click().keyDown(Keys.SHIFT).sendKeys("ban").perform();
		for(int i=0; i<=5;i++)
		{
			fromPlace.sendKeys(Keys.DOWN);
		}
		fromPlace.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return document.getElementById('fromPlaceName').value");
		System.out.println("Selected place is :"+text);
		driver.close();
		
	}
	
}
