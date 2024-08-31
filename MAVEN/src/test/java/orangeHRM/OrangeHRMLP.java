package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRMLP {
	public String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test Executed");
		
		
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void LoginTest()
	{
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();		
		
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equals("OrangeHRM"))
		{
			System.out.println("Login Successful");
		}
		else 
		{
			System.out.println("Login Failed");
		}
		
	}
	@AfterTest
	public void teardown() throws Throwable
	{
		Thread.sleep(5000);
		driver.close();
		
		
	}

}
