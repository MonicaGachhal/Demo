package headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void testA()
	{
		FirefoxOptions fo= new FirefoxOptions();//create object of firefoxoptions class
		fo.setHeadless(true);
		WebDriver driver= new FirefoxDriver(fo);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is: "+title, true);
		Reporter.log("URL is: "+url, true);
		driver.close();
	}
}
