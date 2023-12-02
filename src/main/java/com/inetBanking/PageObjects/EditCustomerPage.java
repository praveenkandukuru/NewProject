package com.inetBanking.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.Baseclass;

public class EditCustomerPage extends Baseclass {
	
	
	public EditCustomerPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name="cusid")
	WebElement  custIdElement;
	
	@FindBy(name="AccSubmit")
	WebElement submitbuttonElement;
	
	@FindBy(name="name")
	WebElement custname;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(css="[name='sub']")
	WebElement subbtnElement;
	
	public void customername(String name,String dofb,String sn)
	{
		 new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(custname));
		custname.sendKeys(name);
		dob.sendKeys(dofb);
		state.sendKeys(sn);
		subbtnElement.click();

}
}
