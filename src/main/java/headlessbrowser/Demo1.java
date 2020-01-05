package headlessbrowser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	static {
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void testA() throws InterruptedException, IOException {
		ChromeOptions co = new ChromeOptions();//create obj and ref variable of ChromeOptions class
		co.setHeadless(true);//give arg in setHeadless as true  if you dont want to show the browser execution
		WebDriver driver = new ChromeDriver(co);//select chromeDriver(options)
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		Thread.sleep(3000);
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/img.png"));
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is: " + title, true);
		Reporter.log("URL is: " + url, true);
		driver.close();
	}
}
