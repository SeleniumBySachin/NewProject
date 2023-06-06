package com.blazedemo.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage {
	

	
	@FindBy(xpath="//input[@value='Choose This Flight']/parent::td/parent::tr/child::td[6]")
	private List<WebElement>price;
	
	@FindBy(xpath="//td[6]/parent::tr/child::td[1]")
	private List<WebElement>chooseFileBtn;
	
	public ReservePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String setPrice() {
		String text = price.get(0).getText();
		char[] ch = text.toCharArray();
		String t="";
		for(int i=0;i<text.length();i++) {
			String s=ch[i]+"";
			if(s.contains("$")) {
				
			}else {
				t=t+s;
			}
		}
		double small=Double.parseDouble(t);
		
		for(int i=1;i<price.size();i++) {
			String s1=price.get(i).getText();
			char[] ch1 = s1.toCharArray();
			String t1="";
			for(int j=0;j<ch1.length;j++) {
				String s2=ch1[j]+"";
				  if(s2.contains("$")) {
					  
				  }else {
					  t1=t1+s2;
				  }
			}
			double t2=Double.parseDouble(t1);
			if(t2<small) {
				small=t2;
			}
		}
		String sm="$"+small;
		for(int i=0;i<price.size();i++) {
			String s=price.get(i).getText();
			if(s.equals(sm)) {
				chooseFileBtn.get(i).click();
			}
		}
		
		
		
		return sm;
	}
	
}
