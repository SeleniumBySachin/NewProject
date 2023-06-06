package com.blazedemo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    
	@FindBy(xpath="//td[text()='Id']/parent::tr/child::td[2]")
	private WebElement id;
	
	public ConfirmationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String setId() {
		String text = id.getText();
		return text;
	}
}
