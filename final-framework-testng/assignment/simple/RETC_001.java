package simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RETC_001 {
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://realestatem1.upskills.in/");
		driver.findElement(By.xpath("//a[@class='sign-in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("revasharma@gmail.com");
		driver.findElement(By.id("first-name")).sendKeys("reva");
		driver.findElement(By.id("last-name")).sendKeys("sharma");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='notification success closeable']")).getText());
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='notification success closeable']")).getText(), "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.");
		driver.quit();
		
		
	}

}
