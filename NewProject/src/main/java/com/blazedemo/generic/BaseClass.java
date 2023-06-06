package com.blazedemo.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}
	
	public WebDriver driver;
	@BeforeTest
	public void openBrowser() throws IOException {
	//	Reporter.log("openBrowser",true);
		FileLib f=new FileLib();
		String s = f.getPropertyData("url");
		driver=new ChromeDriver();
		driver.get(s);
		driver.manage().window().maximize();
		f.waitForPageLoad(driver);
	}
	@BeforeMethod
	public void login() {
	//	Reporter.log("login",true);
		FileLib f=new FileLib();
		f.waitForPageLoad(driver);
		
	}
	@AfterMethod
	public void logout() {
		//Reporter.log("logout",true);
	}
	@AfterTest
	public void closeBrowser() {
	//	Reporter.log("closebrowser",true);
		driver.close();
	}

}
