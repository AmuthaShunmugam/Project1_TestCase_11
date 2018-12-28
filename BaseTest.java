package com.ibm.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.pages.AdminPage;
import com.ibm.pages.AdminPage1;
import com.ibm.pages.UserPage;
import com.ibm.utilities.ExcelUtil;
import com.ibm.utilities.PropertiesFileHandler;

public class BaseTest {
	WebDriver driver;
	WebDriverWait wait;
	PropertiesFileHandler propFIleHandler;
	HashMap<String, String> data;

	@BeforeSuite
	public void propertiesfile() throws IOException {
		String file = "./TestData/data.properties";
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		data = propFileHandler.getPropertiesAsMap(file);
	}

	@BeforeMethod
	public void BrowserInitialization() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void DeleteCategoryCheckInDataBase() throws InterruptedException, SQLException {
		
		String url = data.get("url");
		String userName = data.get("username");
		String password = data.get("password");
		String CouponName=data.get("Coupon");
		String CouponCode=data.get("Code");
		String CouponDiscount=data.get("Discount");
		String Hd=data.get("Header");
		String SuccessMessage=data.get("SuccMsg");
		String ErrorMessage=data.get("ErrorMsg");
		driver.get(url);
		System.out.println("Add a coupon, Check the Success Message, Check for the record added in admin panel and in database");
		AdminPage1 home = new AdminPage1(driver, wait);
		home.EnetrEmailAddress(userName);
		home.EnetrPassword(password);
		home.ClickonLoginButton();
		home.ClickOnMarketing();
        home.ClickOnCoupon();
      //1.Validate the presence of coupon header
      	WebElement headcheck=driver.findElement(By.xpath("//div[@class='header-title']/h1"));
      	String headercheck= headcheck.getText();
      	System.out.println(headercheck);
      	Assert.assertEquals(Hd,headercheck);
		home.ClickonAddButton();
		home.EnterCouponName(CouponName);
		home.EnterCouponCode(CouponCode);
		home.EnterCouponDiscount(CouponDiscount);
		home.ClickonTheSaveButton();Thread.sleep(2000);
		Thread.sleep(2000);
    	//3.1Validate the Success Message
		WebElement Success=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String Msg=Success.getText().replace("×","").trim();
		System.out.println(Msg);
		Assert.assertEquals(Msg,SuccessMessage);
		//3.2. Validate the presence of record in the admin panel table
		WebElement Name=driver.findElement(By.xpath("//table[@id='dataTableExample2']/tbody/tr[1]/td[2]"));
		WebElement Code=driver.findElement(By.xpath("//table[@id='dataTableExample2']/tbody/tr[1]/td[3]"));
		WebElement discount=driver.findElement(By.xpath("//table[@id='dataTableExample2']/tbody/tr[1]/td[4]"));
		String Name1=Name.getText();
		String Code1=Code.getText();
		String Discount1=discount.getText().replace("%","").trim();
		Assert.assertEquals(Name1, CouponName);
		Assert.assertEquals(Code1, CouponCode);
		Assert.assertEquals(Discount1, CouponDiscount);
		//3.3 Validate the presence of record in the DB table
		Connection c = DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries",
				"foodsonfinger_atoz", "welcome@123");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * from as_coupons where name='ForTest'  ");
		   while (rs.next()) 
			{
				System.out.println("The coupon name added:" +rs.getString("name"));
				System.out.println("The coupon discount added:" +rs.getString("discount"));
				System.out.println("The coupon code added:" +rs.getString("code"));
				Assert.assertEquals(rs.getString("name"), CouponName);
				Assert.assertEquals(rs.getString("discount"), CouponDiscount);
				Assert.assertEquals(rs.getString("code"), CouponCode);
				
		}
		   //2.Validate the error message
		   //Login with the user id alone and click on login button and validate the error message
		   System.out.println("To Check the error message");
		   driver.navigate().to("https://atozgroceries.com/admin");
		   home.EnetrEmailAddress(userName);
	   	   home.ClickonLoginButton();
		   WebElement Error=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		   String ErrMessage= Error.getText().replace("×","").trim();
		   System.out.println("The error message:" +ErrMessage);
		   Assert.assertEquals(ErrMessage, ErrorMessage);

		}

		
	}




