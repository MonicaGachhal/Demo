package headlessbrowser;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HeadlessHtmlUnit
{
	@Test
	public void testA() throws InterruptedException, IOException
	{
		WebDriver driver= new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		Thread.sleep(3000);
		/*TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/img2.png"));*/
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is: " + title, true);
		Reporter.log("URL is: " + url, true);
		driver.close();
	}
}
