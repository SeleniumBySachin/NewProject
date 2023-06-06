package com.blazedemo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VocationPage {
	
	@FindBy(xpath="//div[contains(text(),'Destination of the week: Hawaii !')]")
	private WebElement vocation;
	
	public VocationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String setDestinationText() {
		vocation.isDisplayed();
	String text = vocation.getText();
	return text;
	}
}
