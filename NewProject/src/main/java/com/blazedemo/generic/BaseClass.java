package com.blazedemo.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/driver/geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "./src/main/resources/driver/msedgedriver.exe");
	}
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) throws IOException {
		Reporter.log("openBrowser",true);
		FileLib f=new FileLib();
		String s = f.getPropertyData("url");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
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
	Reporter.log("closebrowser",true);
		driver.close();
	}

}
