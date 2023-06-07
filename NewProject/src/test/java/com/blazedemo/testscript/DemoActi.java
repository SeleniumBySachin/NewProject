package com.blazedemo.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoActi {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}
	@Test
	public void testDemo() {
		Reporter.log("Demo ****",true);
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com");
		String title = driver.getTitle();
		System.out.println(title);
	}

}
