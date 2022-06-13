package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	WebDriver driver;
	Properties prop;

	/**
	 * * This methods is used to initialise the Driver on the basis of given browser
	 * name from config file
	 *
	 * @param broweserName
	 * @return
	 */

	public WebDriver init_Driver(Properties prop) {
		String broweserName = prop.getProperty("browser").trim();
		System.out.println("This is my :" + broweserName);
		if (broweserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (broweserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (broweserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else
			System.out.println("There is no browser to intitialise please pass the browser name");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;
	}
	
	/*This method will read alla the values from properties file so that we can avoid hardcoding
	 * 
	 */

	public Properties init_Prop() {
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/config/properties");
			prop = new Properties();
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
