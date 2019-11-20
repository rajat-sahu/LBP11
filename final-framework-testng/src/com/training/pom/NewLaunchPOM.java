package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewLaunchPOM {
	private WebDriver driver;
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(.,'Real Estate')]")
	private WebElement homeIcon;
	
	public void clickHomeIcon() {
		this.homeIcon.click();
	}
	
	@FindBy(xpath = "//a[contains(@data-show,'posts')]")
	private WebElement newpost;
	
	public void mouseOverNewPost() {
		Actions act = new Actions(driver);
		act.moveToElement(this.newpost).build().perform();
	}
	
	@FindBy(xpath = "(//a[@title='Nullam hendrerit Apartments'])[2]")
	private WebElement nullamapt;
	
	public void clickNullamApt() {
		this.nullamapt.click();
	}

	@FindBy(xpath = "//input[@name='your-name']")
	private WebElement inputname;
	
	public void enterName(String yourname) {
		this.inputname.sendKeys(yourname);
	}
	
	@FindBy(xpath = "//input[@name='your-email']")
	private WebElement inputemail;
	
	public void enterEmail(String email) {
		this.inputemail.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@name='your-subject']")
	private WebElement inputsubject;
	
	public void enterSubject(String sub) {
		this.inputsubject.sendKeys(sub);
	}
	
	@FindBy(xpath = "//textarea[@name='your-message']")
	private WebElement message;
	
	public void enterSearchText(String search) {
		this.message.sendKeys(search);
	}
	
	@FindBy(xpath = "//input[@value='Send']")
	private WebElement send;
	
	public void clickSend() {
		this.send.click();
	}
	
	@FindBy(xpath = "//input[@name='amount']")
	private WebElement amount;
	
	public void inputAmount(String amt) {
		this.amount.sendKeys(amt);
	}
	
	@FindBy(xpath = "//input[@placeholder='Down Payment']")
	private WebElement downpymt;
	
	public void inputDownPayment(String downpmt) {
		this.downpymt.sendKeys(downpmt);
	}
	
	@FindBy(xpath = "//input[@placeholder='Loan Term (Years)']")
	private WebElement loanyrs;
	
	public void inputDownPymtYears(String downPymtyrs) {
		this.loanyrs.sendKeys(downPymtyrs);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Interest Rate')]")
	private WebElement intrate;
	
	public void inputIntRate(String rate) {
		this.intrate.sendKeys(rate);
	}
	
	@FindBy(xpath = "//button[@class='button calc-button']")
	private WebElement calc;
	
	public void clickCalculate() {
		this.calc.click();
	}
	
	@FindBy(xpath = "//strong[@class='calc-output']")
	private WebElement montlypamt;
	
	public void monthlyPymtOutput() {
		System.out.println(this.montlypamt.getText());
	}
}