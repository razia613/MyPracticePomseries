package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Conssstants;
import com.qa.opencart.utils.ElementUtil;

import bsh.org.objectweb.asm.Constants;

public class AccountsPage {
	private WebDriver driver;
	//private ElementUtil eleUtil;

	private By header = By.cssSelector("div#logo h1 a");
	private By accountSectionsHeader = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");

	
	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		//get all the elements from Element ulil class to avoid hotcodding.
		//return driver.getTitle();
		return eleUtil.waitForTitleIs(Conssstants.Acc_PAGE_TITLE, Conssstants.DEFAULT_TIME_OUT);
	}

	public String getAccountPageUrl() {
		//return driver.getCurrentUrl(); OR Below from ElementUtil class we can het the methods 
		return eleUtil.waitForUrlContains(Conssstants.LOG_PAGR_URL_FRACTION,Conssstants.DEFAULT_TIME_OUT);
	}

	public String getAccPageHeader() {
		//return driver.findElement(header).getText();
		return eleUtil.waitForElementVisible(header, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT).getText();
	}

		public List<String> getAccSecList() {
		
		List<WebElement> accSecList =eleUtil.waitForElementsVisible(accountSectionsHeader, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT) ;
		List<String> accSecValList = new ArrayList<String>();
		for(WebElement e:accSecList) {
			accSecValList.add(e.getText());
		}
		return accSecValList;
	}
		public boolean isLogOutExists() {
			return eleUtil.waitForElementVisible(logoutLink, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT).isDisplayed();
		}
		public LoginPage clickOnLogOut() {
			if(isLogOutExists() )
			{ eleUtil.doClick(logoutLink);
			//when v click on logout ir will return to login page class so we need to return the log in page class object
			return new LoginPage(driver);}
			return null;
		}
		public boolean isSearchExists() {
			return eleUtil.doIsDisplayed(search);
		}
		
}
