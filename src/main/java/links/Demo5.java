package links;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//to verify if the image is broken or not
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo5 {

	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	
	WebDriver driver;
	@Test
	public void testA() throws IOException
	{
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///D:/HTML%20Webpages/images.html");
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println("Total Number of images: "+allImages.size());
		for(WebElement image: allImages)
		{
			String src = image.getAttribute("src");
			URL url= new URL(src);
			HttpURLConnection httpUrlConnection= (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(2000);//to handle syncronization
			httpUrlConnection.connect();
			int code =httpUrlConnection.getResponseCode();
			//String msg = httpUrlConnection.getResponseMessage();
			String value = image.getAttribute("value");
			if(code==200)
			{
				System.out.println(value+ "Image is working fine"+ " Response code is: "+code);
			}
			else
			{
				System.out.println(value+ "Image is broken "+" Response code is: "+code);
			}
		}
	}
	
}
