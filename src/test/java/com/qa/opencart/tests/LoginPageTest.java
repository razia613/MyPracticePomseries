package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.Conssstants;

public class LoginPageTest extends BaseTest {
	// so that we can access all the pavge class objs and driverfactory objects
	@Test(priority =1)
	public void liginPageTest() {
		String actualTitle = logIn.getLogInPageTitle();
		Assert.assertEquals(actualTitle, Conssstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority =2)
	public void liginUrlTest() {
		String url = logIn.getLogInPageUrl();
		Assert.assertTrue(url.contains(Conssstants.LOG_PAGR_URL_FRACTION));
	}

	@Test(priority =3)
	public void registerPageLinkExixtsTest() {

		Assert.assertTrue(logIn.isRegisterlinkExists());
	}

	@Test(priority =4)
	public void forgotPaswordLinkExixtsTest() {

		Assert.assertTrue(logIn.isForgotPwdLinkExixts());
	}
	
	@Test(priority =5)
	public void logInPageTest() {
	AccountsPage accPage = logIn.doLogIn(prop.getProperty("username").trim(), prop.getProperty("password").trim());//dologim method returns account page class object so store it in acc page reference
	String AccPageTitle= accPage.getAccountPageTitle();
	System.out.println(AccPageTitle);
	Assert.assertEquals(AccPageTitle, Conssstants.Acc_PAGE_TITLE);
	Assert.assertTrue(accPage.isLogOutExists());//will give u boolean comparing with assert boolean
	}

	
}