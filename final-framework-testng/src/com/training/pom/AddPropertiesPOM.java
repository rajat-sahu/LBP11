package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AddPropertiesPOM {
	private WebDriver driver;
	public AddPropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//div[@class='wp-menu-name'][contains(text()='Properties')]")
	@FindBy(xpath = "(//div[contains(.,'Properties')])[4]")
	private WebElement properties;
	
	public void clickProperties() {
		this.properties.click();
	}
	
	@FindBy(xpath = "(//a[contains(.,'Add New')])[5]")
	private WebElement addnewprop;
	
	public void clickAddNew() {
		this.addnewprop.click();
	}
	
	@FindBy(xpath = "//a[contains(.,'All Properties')]")
	private WebElement allprop;
	
	public void clickAllProperties() {
		this.allprop.click();
	}
	@FindBy(xpath = "//h1[contains(.,'Add Property')]")
	private WebElement addprop;
	
	@FindBy(xpath = "(//a[@class='row-title'])[1]")
	private WebElement proptitle;
	
	public void assertPropTitle(String title) {
		Assert.assertEquals(this.proptitle.getText(), title);
	}
	
	public void verifyHeaderTitle() {
		String text = this.addprop.getText();
		Assert.assertEquals(text, "Add Property");
	}
	
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement posttitle;
	
	public void postTitle(String title) {
		this.posttitle.sendKeys(title);
	}
	
	@FindBy(xpath = "//iframe[@id='content_ifr']")
	private WebElement iframe;
	
	public void switchFrame() {
		driver.switchTo().frame(iframe);
	}
	
	@FindBy(xpath = "//body[@id='tinymce']")
	private WebElement textbox;
	
	public void propDescription(String desc) {
		this.textbox.sendKeys(desc);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath = "//a[contains(.,'Price')]")
	private WebElement pricetab;
	
	public void clickPriceTab() {
		this.pricetab.click();
	}
	@FindBy(xpath = "//textarea[@name='_price']")
	private WebElement price;
	
	public void pPrice(String inr) {
		this.price.sendKeys(inr);
	}
	
	@FindBy(xpath = "//input[@name='_price_per']")
	private WebElement pricepersqft;
	
	public void priceSqFt(String psqft) {
		this.pricepersqft.sendKeys(psqft);
	}
	
	@FindBy(xpath = "//a[contains(.,'Main Details')]")
	private WebElement maindetailtab;
	
	public void clickMainTab() {
		this.maindetailtab.click();
	}
		
	@FindBy(xpath = "//input[@name='_status']")
	private WebElement status;
	
	public void inputStstus(String stat) {
		this.status.sendKeys(stat);
	}
	
	@FindBy(xpath = "//input[@name='_location']")
	private WebElement loc;
	
	public void inputLoc(String location) {
		this.loc.sendKeys(location);
	}
	
	@FindBy(xpath = "//input[@name='_possession']")
	private WebElement possession;
	
	public void inputPossession(String poss) {
		this.possession.sendKeys(poss);
	}
	
	@FindBy(xpath = "//a[contains(.,'Location')]")
	private WebElement loctab;
	
	public void clickLocationTab() {
		this.loctab.click();
	}
	
	@FindBy(xpath = "//input[@name='_friendly_address']")
	private WebElement friadd;
	
	public void inputFriAdd(String fradd) {
		this.friadd.sendKeys(fradd);
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter a location']")
	private WebElement gooloc;
	
	public void googleLoc(String gloc) {
		this.gooloc.sendKeys(gloc);
	}
	
	@FindBy(xpath = "//input[@name='_geolocation_lat']")
	private WebElement geolat;
	
	public void geoLattitude(String lat) {
		this.geolat.sendKeys(lat);
	}
	
	@FindBy(xpath = "//input[@name='_geolocation_long']")
	private WebElement geolong;
	
	public void geoLongitude(String longi) {
		this.geolong.sendKeys(longi);
	}
	
	@FindBy(xpath = "//a[@href='#details_tab']")
	private WebElement detailtab;
	
	public void clickDetailTab() {
		this.detailtab.click();
	}
	
	@FindBy(xpath = "//input[@name='_storage_room']")
	private WebElement storageroom;
	
	public void inputStoreRoom(String sroom) {
		this.storageroom.sendKeys(sroom);
	}
	
	@FindBy(xpath = "(//span[contains(.,'Central Bangalore')])[1]")
	private WebElement keywardtag;
	
	public void keywordTagCheckbox() {
		this.keywardtag.click();
	}
	
	@FindBy(xpath = "(//div[@id='publishing-action']//input[@id='publish'])")
	private WebElement publishbtn;
	
	public void clickPublishBtn() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", publishbtn);
		//this.publishbtn.click();
	}
	
	@FindBy(xpath = "//p[contains(.,'Post published. View post')]")
	private WebElement postmsg;
	
	public void postMsg() {
		String exp=this.postmsg.getText();
		Assert.assertEquals(exp, "Post published. View post");
	}
	//--------------------------------------------------------------------//
	
	

}
