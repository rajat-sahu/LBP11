package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void userRegisterTest() {
		loginPOM.clickLoginorRegisterlink();
		loginPOM.clickRegisterTab();
		loginPOM.sendEmail("revasharma4@gmail.com");
		loginPOM.sendFirstName("reva");
		loginPOM.sendlastName("sharma");
		loginPOM.clickOnRegister();
		screenShot.captureScreenShot("/RegistartionPage");
	}
	
	@Test(priority=2)
	public void validLoginTest() {
		loginPOM.clickLoginorRegisterlink();
		loginPOM.sendUserName("revasharma@gmail.com");
		loginPOM.sendPassword("revasharma@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("/ValidLogin");
	}
	
	@Test(priority=3)
	public void forgotPasswd() throws InterruptedException {
		loginPOM.clickLoginorRegisterlink();
		loginPOM.clickLoginTab();
		Thread.sleep(5000);
		loginPOM.clickLostPassword();
		loginPOM.emailForLostPwd("revasharma@gmail.com");
		loginPOM.clickRestPwdBtn();
		loginPOM.errorMsg();
		screenShot.captureScreenShot("/ErrorPage");
		
	}
}
