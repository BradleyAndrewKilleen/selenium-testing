package com.glassdoor.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	
	public WebDriver setBrowser(int browserID) {		
		
		if(browserID == 1) {
			
			System.setProperty("webdriver.gecko.driver","/Users/bradleykilleen/Desktop/SeleniumDrivers/geckodriver");
			FirefoxOptions options = new FirefoxOptions().addPreference("browser.formfill.enable", "false");
			WebDriver driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			return driver;
		} 
		
		else if (browserID == 2) {
			
			System.setProperty("webdriver.chrome.driver","/Users/bradleykilleen/Desktop/SeleniumDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			//options.addPreference("browser.formfill.enable", "false");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			return driver;
		} 
		
		else {
			return null;
		}
	}
}

