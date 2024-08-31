package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logout {
	
	public String BaseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.out.println("this is before test executed");
		
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
		
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equals("OrangeHRM"))
		{
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		}
	}
	public void logout()
	{
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("(//a[@role=\"menuitem\"])[4]")).click();
	}
	@AfterTest
	public void teardown() throws Throwable
	{
		Thread.sleep(5000);
		logout();
		Thread.sleep(5000);
		driver.close();
		
	
}
	

}
