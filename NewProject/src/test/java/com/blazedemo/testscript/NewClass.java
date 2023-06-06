package com.blazedemo.testscript;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.blazedemo.generic.BaseClass;
import com.blazedemo.pom.ConfirmationPage;
import com.blazedemo.pom.HomePage;
import com.blazedemo.pom.PurchasePage;
import com.blazedemo.pom.ReservePage;
import com.blazedemo.pom.VocationPage;

@Test
public class NewClass extends  BaseClass

{	
	@Test
	public void testNewClass() {
		HomePage h=new HomePage(driver);
		String exp="Welcome to the Simple Travel Agency!";
		String act = h.setWelcomeText();
		System.out.println(act);
		Assert.assertEquals(act, exp);
		h.setDestinationLink();
		VocationPage v=new VocationPage(driver);
		String act1 = v.setDestinationText();
		String exp1="Destination of the week: Hawaii !";
		Assert.assertEquals(exp1, act1);
		driver.navigate().back();
		h.setDeparturesListBx();
		h.setDestinationListBx();
		h.setFindFlightBtn();
		ReservePage r=new ReservePage(driver);
		r.setPrice();
		PurchasePage p=new PurchasePage(driver);
		p.setPurchaseFlight();
		ConfirmationPage c=new ConfirmationPage(driver);
		String setId = c.setId();
		Reporter.log(setId,true);
				
	}

}
