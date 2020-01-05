package headlessbrowser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessPhantomBrowser 
{
	static
	{
		WebDriverManager.phantomjs().setup();
	}
	
	@Test
	public void testA() throws InterruptedException, IOException 
	{
	WebDriver driver= new PhantomJSDriver();
	driver.manage().window().maximize();
	driver.get("https://selenium.dev/");
	Thread.sleep(3000);
	TakesScreenshot ts= (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshot/img1.png"));
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	Reporter.log("Title is: " + title, true);
	Reporter.log("URL is: " + url, true);
	driver.close();
}
}
