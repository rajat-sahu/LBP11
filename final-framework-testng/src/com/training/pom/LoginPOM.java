package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath = "//a[contains(@class,'sign-in')]")
	private WebElement login;
	
	//------Login User elements------------
	
	//@FindBy(xpath = "//a[@href='#tab1'][contains(text()='Log In')]")
	@FindBy(xpath = "//a[@href='#tab1']")
	private WebElement loginTab;
	
	@FindBy(name="log")
	private WebElement userName; 
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	//------Register User elements------------
	
	//@FindBy(xpath = "//a[@href='#tab2'][contains(text()='Register')]")
	@FindBy(xpath = "//a[@href='#tab2']")
	private WebElement registerTab;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement register;
	
	//------Login Reset Password elements------------

	@FindBy(xpath = "//div[@id='wrapper']//div[@class='tab-content' and @id='tab1']/form/p[@class='lost_password']/a")
	private WebElement resetPwd;
	
	@FindBy(xpath = "//input[@name='user_login']")
	private WebElement uEmail;
	
	@FindBy(xpath = "//input[@value='Reset Password']")
	private WebElement resetBtn;
	
	@FindBy(xpath = "//p[contains(.,'The email could not be sent.')]")
	private WebElement error_msg;
	
	public void clickLoginorRegisterlink() {
		this.login.click();
	}
	
	public void clickLoginTab() {
		this.loginTab.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickRegisterTab() {
		this.registerTab.click();
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendFirstName(String firstname) {
		this.firstName.clear();
		this.firstName.sendKeys(firstname);
	}
	
	public void sendlastName(String lastname) {
		this.lastName.clear();
		this.lastName.sendKeys(lastname);
	}
	
	public void clickOnRegister() {
		this.register.click();
	}
	
	public void clickLostPassword() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", resetPwd);
		//this.resetPwd.click();
	}
	
	public void emailForLostPwd(String email) {
		this.uEmail.clear();
		this.uEmail.sendKeys(email);
	}
	
	public void clickRestPwdBtn() {
		this.resetBtn.click();
	}
	
	public void errorMsg() {
		System.out.println(error_msg.getText());
	}
}
