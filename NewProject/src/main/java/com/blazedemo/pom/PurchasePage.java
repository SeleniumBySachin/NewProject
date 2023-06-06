package com.blazedemo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
	@FindBy(xpath="//input[@value='Purchase Flight']")
	private WebElement purchaseFlightBtn;

	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setPurchaseFlight() {
		purchaseFlightBtn.click();
	}
}
