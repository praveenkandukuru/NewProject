package com.inetBanking.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.base.Baseclass;

public class NewAccountpage  extends Baseclass{
	
	public NewAccountpage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="selaccount")
	WebElement acctype;
	
	@FindBy(name="inideposit")
	WebElement initdep;
	
	@FindBy(name="button2")
	WebElement subbtn;
	
	public void createNewAccount(String cust_id,String value,String depamt)
	{
		custid.sendKeys(cust_id);
		acctype.click();
		ac.selectByValue(acctype,value);
		initdep.sendKeys("depamt");
		subbtn.click();
		
	}

}
