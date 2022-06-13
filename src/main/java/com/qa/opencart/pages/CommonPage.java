package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Conssstants;
import com.qa.opencart.utils.ElementUtil;

import bsh.org.objectweb.asm.Constants;

public class CommonPage {
	//create/maintain common page actions on the page here
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	public CommonPage(WebDriver driver) 
	{
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public SearchResultsPage doSearch(String productName) {
		WebElement searchEle = eleUtil.waitForElementPresent(search, Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		searchEle.clear();
		searchEle.sendKeys(productName);
		eleUtil.doClick(searchIcon);//if we click here we are landing on the next page which is SearchResultsPage
		return new SearchResultsPage(this.driver);
	}

}
