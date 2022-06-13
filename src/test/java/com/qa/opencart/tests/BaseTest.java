package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.Driverfactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CommonPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	private Driverfactory df;
	WebDriver driver;
	Properties prop;
	protected LoginPage logIn;
	protected AccountsPage accPage;
	protected CommonPage comPage;
	protected SearchResultsPage srchPage;
	protected ProductInfoPage prodInfoPage;
	SoftAssert softAssert;
	
	@BeforeTest
	public void setUp()
	{
		df = new Driverfactory();
		prop = df.init_Prop();
		driver= df.init_Driver(prop);
		logIn = new LoginPage(driver);//for log in page test no need to log in for log in opage test
		softAssert = new SoftAssert();
	}
	@AfterTest
	public void tearDown()
	{
	//	driver.quit();
		
	}

}
