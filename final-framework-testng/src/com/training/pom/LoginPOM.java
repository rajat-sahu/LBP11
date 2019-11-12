package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'sign-in')]")
	private WebElement login;
	
	@FindBy(xpath = "//a[@href='#tab1'][contains(text()='Log In')]")
	private WebElement logintab;
	
	@FindBy(name="log")
	private WebElement userName; 
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath = "//a[@href='#tab2'][contains(.,'Register')]")
	private WebElement registertab;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstname;
	
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement register;
	
	public void clickLoginorRegisterlink() {
		this.login.click();
	}
	
	public void clickLoginTab() {
		this.logintab.click();
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
		this.registertab.click();
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void sendlastName(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	
	public void clickOnRegister() {
		this.register.click();
	}
	
}
