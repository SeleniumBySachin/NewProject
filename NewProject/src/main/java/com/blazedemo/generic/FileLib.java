package com.blazedemo.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FileLib {
	
	public String getPropertyData(String url) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/common.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(url);
		return data;
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void  getListBoxValue(WebElement we,String text) {
		Select s=new Select(we);
		s.selectByVisibleText(text);
	}
	public void getListBoxForDestination(WebElement we,String text) {
		Select s=new Select(we);
		s.deselectByVisibleText(text);
	}
	public void getListBoxForDestination(WebElement we,int a) {
		Select s=new Select(we);
		s.selectByIndex(a);
		
	}

}
