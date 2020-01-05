package screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotUsingRobotClass 
{
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws IOException, AWTException, InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[3]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		Thread.sleep(3000);
	
		//create object of robot class
		Robot r= new Robot();
		//get the size of screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//create rectangle class
		Rectangle rect= new Rectangle(d);
		//take the screenshot
		BufferedImage img = r.createScreenCapture(rect);
		//store in location
		ImageIO.write(img, "png", new File("./Screenshot/popup1.png"));
		driver.close();
	}
}
