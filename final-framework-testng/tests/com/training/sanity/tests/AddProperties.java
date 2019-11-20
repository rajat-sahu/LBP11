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
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.sanity.tests.LoginTests;
import com.training.pom.AddPropertiesPOM;

public class AddProperties {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddPropertiesPOM addprop;
	private NewLaunchPOM newlaunch;
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
		addprop = new AddPropertiesPOM(driver);
		newlaunch = new NewLaunchPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	
		loginPOM.clickLoginorRegisterlink();
		loginPOM.sendUserName("administrator");
		loginPOM.sendPassword("administrator@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("/ValidLogin");
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority=1, enabled=true)
	public void addNewProperty() throws InterruptedException {
		addprop.clickProperties();
		addprop.clickAddNew();
		addprop.verifyHeaderTitle();
		addprop.postTitle("new launch");
		addprop.switchFrame();
		Thread.sleep(1000);
		addprop.propDescription("new launch");
		addprop.clickPriceTab();
		addprop.pPrice("50000.00");
		addprop.priceSqFt("200.00");
		addprop.clickMainTab();
		addprop.inputStstus("New");
		addprop.inputLoc("Electronic city");
		addprop.inputPossession("immediate");
		addprop.clickLocationTab();
		addprop.inputFriAdd("yeshwanthapur");
		addprop.googleLoc("yeshwanthapur");
		addprop.geoLattitude("120");
		addprop.geoLongitude("56");
		addprop.clickDetailTab();
		addprop.inputStoreRoom("2");
		addprop.keywordTagCheckbox();
		Thread.sleep(2000);
		addprop.clickPublishBtn();
		Thread.sleep(5000);
		addprop.postMsg();
		screenShot.captureScreenShot("/postproperty");
		
		
	}
	
	@Test(priority=2, enabled=true)
	public void newLaunch() throws InterruptedException {
		newlaunch.clickHomeIcon();
		newlaunch.mouseOverNewPost();
		newlaunch.clickNullamApt();
		newlaunch.enterName("selenium");
		newlaunch.enterEmail("selenium@gmail.com");
		newlaunch.enterSubject("apartment");
		newlaunch.enterSearchText("looking for apartment");
		newlaunch.clickSend();
		newlaunch.inputAmount("40000");
		newlaunch.inputDownPayment("2000");
		newlaunch.inputDownPymtYears("2");
		newlaunch.inputIntRate("5");
		Thread.sleep(1000);
		newlaunch.clickCalculate();
		Thread.sleep(5000);
		newlaunch.monthlyPymtOutput();
	}
	
	@Test(priority=3, enabled=true)
	public void allProperties() throws InterruptedException {
		addprop.clickProperties();
		addprop.clickAddNew();
		addprop.verifyHeaderTitle();
		addprop.postTitle("new launch3");
		addprop.switchFrame();
		Thread.sleep(1000);
		addprop.propDescription("new launch");
		Thread.sleep(2000);
		addprop.clickPublishBtn();
		Thread.sleep(10000);
		addprop.clickAllProperties();
		Thread.sleep(2000);
		addprop.assertPropTitle("new launch3");
		screenShot.captureScreenShot("/postedproperty");
	}
}
