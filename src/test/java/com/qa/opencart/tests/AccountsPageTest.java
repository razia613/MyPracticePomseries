package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.CommonPage;
import com.qa.opencart.utils.Conssstants;

public class AccountsPageTest extends BaseTest {
//Precondition for Accounts page test id we have to log in first log at class level

	@BeforeClass
	public void accSetup() {
		accPage = logIn.doLogIn(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		// dologim// method returns account page class object so store it in accage
		// reference

	}

	@Test(enabled = false)
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccountPageTitle(), Conssstants.Acc_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		Assert.assertEquals(accPage.getAccPageHeader(), Conssstants.Acc_PAGE_HEADER);
	}

	@Test(enabled = false)
	public void accPageHeaderListTest() {
		List<String> accSecList = accPage.getAccSecList();
		// List<String> accSecValList = new ArrayList<String>();
		Collections.sort(accSecList);
		Collections.sort(Conssstants.ACC_PAGE_HEADER_LIST);

		Assert.assertEquals(accSecList, Conssstants.ACC_PAGE_HEADER_LIST);
	}

	@Test(enabled = false)
	public void isUserLoggedOut() {
		logIn = accPage.clickOnLogOut();
		String msg = logIn.isgetLogoutMessage();
		Assert.assertEquals(msg, Conssstants.ACC_PAGE_LOGOUT_MSG);

	}
	@DataProvider
	public Object[][] getSearchData()
	{
	return new Object[][]
				{
		{"MacBook"},
		{"iMac"},
		{"SamSung"},
		{"Apple"}
				};
	}
	
	@Test(dataProvider ="getSearchData")
	public void searchTest(String probuctname)
	{
		//we have to call the method we we are entering the search text which is in commonpage
		 comPage = new CommonPage(driver);
		 srchPage=comPage.doSearch(probuctname);
		 String searchPageHeader = srchPage.getResultsPageHeader();
		 Assert.assertTrue(searchPageHeader.contains(probuctname));
		 
		
	}
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro"},
			{"Macbook", "MacBook Air"},
			{"Samsung", "Samsung SyncMaster 941BW"}
		};
		
		//return ExcelUtil.getTestData("product");
	}
	
	@Test(dataProvider = "getProductData")
	public void productInfoTest(String productName, String mainProductName) {
		comPage = new CommonPage(driver);
		srchPage = comPage.doSearch(productName);
		prodInfoPage = srchPage.selectProductName(mainProductName);
		String mainProductNameValue = prodInfoPage.getMainProductName();
		System.out.println(mainProductNameValue);
		Assert.assertEquals(mainProductNameValue, mainProductName);
	}
}
