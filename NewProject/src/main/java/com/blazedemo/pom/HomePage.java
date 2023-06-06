package com.blazedemo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.generic.FileLib;

public class HomePage {
	
	@FindBy(xpath="//h1")
	private WebElement welText;
	
	@FindBy(linkText="destination of the week! The Beach!")
	private WebElement detinationLink;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	private WebElement departureListBx;
	
	@FindBy(xpath="//select[@name='toPort']")
	private WebElement destinationListBx;
	
	@FindBy(xpath="//input[@value='Find Flights']")
	private WebElement findFlightBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String setWelcomeText() {
		welText.isDisplayed();
		String text = welText.getText();
		return text;
	}
	
	public void setDestinationLink() {
		detinationLink.click();;
	}
	
	public void setDeparturesListBx() {
		FileLib f=new FileLib();
		f.getListBoxValue(departureListBx, "Mexico City");
	}
	
	public void setDestinationListBx() {
		FileLib f=new FileLib();
		f.getListBoxForDestination(destinationListBx, 2);
	}
	
	public void setFindFlightBtn() {
		findFlightBtn.click();
	}
	
	

}
