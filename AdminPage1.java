package com.ibm.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage1 {
	// Following are the Xpath from the page
	// To give the login mail id
	@FindBy(xpath = "//input[@name='email']")
	WebElement Emailele;

	// To give the password
	@FindBy(xpath = "//input[@name='pword']")
	WebElement PasswordEle;

	// To click on the login button
	@FindBy(xpath = "//button[@class='btn btn-labeled btn-info m-b-5']")
	WebElement LoginButtonEle;

	// To click on the Catalog Tab
	@FindBy(xpath = "//a[@href='#']")
	WebElement CatalogTabEle;

	// To click on the 'Category' under 'Catalog'
	@FindBy(xpath = "//a[text()=' Categories']")
	WebElement CategoriesEle;

	// To click on the 'Add new' button
	@FindBy(xpath = "//a[@title='Add New']")
	WebElement AddButtonEle;

	// To add Category name
	@FindBy(xpath = "//input[@name='name']")
	WebElement CategoryNameELe;

	// To add Category tag title
	@FindBy(xpath = "//input[@name='tag_title']")
	WebElement TagTitleELe;

	// To add the sort
	@FindBy(xpath = "//input[@name='sort']")
	WebElement SortEle;

	// To change the status
	@FindBy(xpath = "//select[@name='status']/option[2]")
	WebElement StatusEle;
	
	//To go to the top of page
	@FindBy(xpath="//div[@id='toTop']")
	WebElement TopEle;
	
    //To save the content 
    @FindBy(xpath="//button[@title='Save']")
    WebElement SaveEle;

  //To click on Action for the added record
  	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[1]/td[6]/div/button")
  	WebElement ActionButtonEle;
  	
  	//To click on Delete button 
  	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[1]/td[6]/div/ul/li[2]")
  	WebElement DeleteEle;
  	
  	//To delete the record
  	@FindBy(xpath="//button[@class='confirm']")
  	WebElement DeleteRecordEle;
  	
	//To click on the System Tab
	@FindBy(xpath="//a[text()='   System']")
	WebElement SystemEle;
	
	//To Click on Setting under 'System'
	@FindBy(xpath="//a[text()=' Settings']")
	WebElement SettingEle;
	
	//To change the email
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailEle;
	
	//To change the phone number
	@FindBy(xpath="//input[@id='phonenumber']")
	WebElement PhoneEle;
	
	//To click on 'Product' under 'Catalog'
	@FindBy(xpath="//a[text()=' Products']")
	WebElement ProductEle;
	
	//To click on action of product record
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[3]/td[9]/div/button")
	WebElement ProducActionEle;
	
	//To Click on Edit of the product recotd
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[3]/td[9]/div/ul/li[1]")
	WebElement ProductEditEle;
	
	//To click on Data tab
	@FindBy(xpath="//a[@href='#tab2']")
	WebElement DataEle;
	
	//To change the value of GST
	@FindBy(xpath="//input[@name='gst']")
	WebElement GSTEle;
	
	//To give value for SPecial Discount
	@FindBy(xpath="//input[@name='special_dis']")
	WebElement SpecialDisEle;
	
	//To click on the 'Marketing' tab
	@FindBy(xpath="//a[text()='  Marketing']")
	WebElement MarketEle;
	
	//TO click on 'Coupons' under 'Marketing' tab 
	@FindBy(xpath="//a[text()=' Coupons']")
	WebElement CouponEle;
	
	//To Enter the coupon name
	@FindBy(xpath="//input[@name='name']")
	WebElement CouponNameEle;
	
	//To enter the Coupon code
	@FindBy(xpath="//input[@name='code']")
	WebElement CouponCodeEle;
	
	//To enter the coupon discount
	@FindBy(xpath="//input[@name='discount']")
	WebElement CouponDiscountEle;
	
	//To click on action of coupon 
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[1]/td[8]/div/button")
	WebElement CouponActionEle;
	
	//To Click on Delete of the coupon record
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr[1]/td[8]/div/ul/li[2]")
	WebElement CouponDeleteEle;
		
  
	WebDriverWait wait;
	WebDriver driver;

	// For using webdriver
	public AdminPage1(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void EnetrEmailAddress(String userName) {
		Emailele.sendKeys(userName);
	}

	public void EnetrPassword(String password) {
		PasswordEle.sendKeys(password);
	}

	public void ClickonLoginButton() {
		LoginButtonEle.click();
	}

	public void ClickonCatalogTabButton() {
		CatalogTabEle.click();
	}

	public void ClickonCategories() {
		CategoriesEle.click();
	}

	public void ClickonAddButton() {
		AddButtonEle.click();
	}

	public void EnterCategoryName(String name)
	{
		CategoryNameELe.sendKeys(name);
	}

	public void EnterTheTagTitle(String tag)
	{
		TagTitleELe.sendKeys(tag);
	}

	public void EnterTheSortOrder() 
	{
		SortEle.sendKeys("0");
	}

	public void EntertheStatus()
	{
		StatusEle.click();
	}
	
	public void ClickToGoTop()
	{
		TopEle.click();
	}
	public void ClickonTheSaveButton()
	{
		SaveEle.click();
		
	}
	
	public void ClickonActionButton()
	{
		ActionButtonEle.click();
	}
	
	public void ClickonDelete()
	{
		DeleteEle.click();
	}

	public void ClickonDeleteRecord()
	{
		DeleteRecordEle.click();
	}
	
	public void ClickOnSystemOptions()
	{
		SystemEle.click();
	}
	
	public void ClickonSettings()
	{
		SettingEle.click();
	}
	
	public void EnterTheNewEmail(String email)
	{
	    EmailEle.clear();
		EmailEle.sendKeys(email);
	}

	public void EnterTheNewPhone(String number)
	{
		PhoneEle.clear();
		PhoneEle.sendKeys(number);
	}
	
	public void ClickonProduct()
	{
		ProductEle.click();
	}
	
	public void ClickonProductAction()
	{
		ProducActionEle.click();
	}
	
	public void ClickonProductEdit()
	{
		ProductEditEle.click();
	}
	
	public void ClickonData()
	{
		DataEle.click();
	}
	
	public void EntertheGSTValue(String gst)
	{
		GSTEle.clear();
		GSTEle.sendKeys(gst);
	}
	
	public void EnterSpecialDiscount(String discount)
	{
		SpecialDisEle.clear();
		SpecialDisEle.sendKeys(discount); 
	}
	
     public void takescreennshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
	    File file=ts.getScreenshotAs(OutputType.FILE);
	    Date date= new Date();
	    String currentDate=date.toString().replaceAll(":", "-");
        FileUtils.copyFile(file, new File("./screenshots/Adminpage_"+currentDate+".png"));
	}
	
	public void ScrollUpDownInPage()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
	}
	
	public void ClickOnMarketing()
	{
		MarketEle.click();
	}
	
	public void ClickOnCoupon()
	{
		CouponEle.click();
	}
	
	public void EnterCouponName(String coupon)
	{
		CouponNameEle.sendKeys(coupon);
	}
	
	public void EnterCouponCode(String Code)
	{
		CouponCodeEle.sendKeys(Code);
	}
	
	public void EnterCouponDiscount(String disc)
	{
		CouponDiscountEle.sendKeys(disc);
	}
	
	public void ClickonCouponAction()
	{
		CouponActionEle.click();
	}
	
	public void ClickonCouponDelete()
	{
		CouponDeleteEle.click();
	}
	
}
