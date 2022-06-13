package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Conssstants;
import com.qa.opencart.utils.ElementUtil;


public class SearchResultsPage {
	
	WebDriver driver;
	ElementUtil eleUtil;
	
	private By resultsPageHeader = By.cssSelector("div#content h1");
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public String getResultsPageHeader() {
		return eleUtil.doGetElementText(resultsPageHeader);
		//For this test will be written in Class its not like everypage class should have same no of test class
	}
	public ProductInfoPage selectProductName(String mainProductName) {
		WebElement mainProductEle = 
					eleUtil.waitForElementVisible(By.linkText(mainProductName), Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		mainProductEle.click();
		return new ProductInfoPage(this.driver);//if u click on product it will navigate to product page information
	}
	public ProductInfoPage seletproductname(String productname)
	{
	WebElement element = 	eleUtil.waitForElementVisible(By.linkText(productname),Conssstants.DEFAULT_ELEMENT_WAIT_TIME_OUT);
		element.click();
		return new  ProductInfoPage(driver);
	}
	
	


}
