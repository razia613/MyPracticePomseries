package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Conssstants;
import com.qa.opencart.utils.ElementUtil;

import bsh.org.objectweb.asm.Constants;

public class LoginPage {
	/**
	 * according to POM each page will return class object every page class will
	 * have its own webdriverinstance as private
	 */
	private ElementUtil eUtil;
	private WebDriver driver;
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By logIn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By accountlogout = By.cssSelector("div#content h1");

	// Page class constructor to initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(this.driver);

	}

	public String getLogInPageTitle() {
		String title = eUtil.waitForTitleIs(Conssstants.LOGIN_PAGE_TITLE, Conssstants.DEFAULT_TIME_OUT);//insteD OF DRIVER. GET METHOD WE ARE USINH ELE CLASS SAS WE HAVE ALREADY HAVE ALLA THE METHODS IN THAT SO WE R USING THEMyyy
		System.out.println("login page title is: "+title);
		return title;
	}

	public String getLogInPageUrl() {
		String url = eUtil.waitForUrlContains(Conssstants.LOG_PAGR_URL_FRACTION, Conssstants.DEFAULT_TIME_OUT);
		return url;
	}

	public boolean isForgotPwdLinkExixts() {
		return eUtil.waitForElementVisible(forgotPwdLink, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
	}

	public boolean isRegisterlinkExists() {
	return eUtil.waitForElementVisible(registerLink, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();	}

	public AccountsPage doLogIn(String userName, String passWord) {
		/*
		 * driver.findElement(emailId).sendKeys(userName);
		 * driver.findElement(password).sendKeys(passWord);
		 * driver.findElement(logIn).click();
		 */// after clicking we r landing on next page so we have to return naxt landing
											// page class obg i.e acc page class obj
		eUtil.waitForElementVisible(emailId,Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT).sendKeys(userName);
		eUtil.doSendKeys(password, passWord);
		eUtil.doClick(logIn);
		
		return new AccountsPage(driver);
	}

public String isgetLogoutMessage()
{
	String logoutMessage = driver.findElement(accountlogout).getText();
	System.out.println("LogOut Succeseeful Message "+logoutMessage);
	return logoutMessage;//this can be validated in accPageTest after logout
}

}
