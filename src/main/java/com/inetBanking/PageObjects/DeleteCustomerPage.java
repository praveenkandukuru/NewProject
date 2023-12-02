package com.inetBanking.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.Baseclass;

public class DeleteCustomerPage extends Baseclass {
	
	public DeleteCustomerPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[name='cusid']")
	WebElement d_custid;
	
	@FindBy(name="AccSubmit")
	WebElement d_submit;
	
	public void deleteCount(String custid)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cusid']")));

		d_custid.sendKeys(custid);
		d_submit.click();
		
	}
	
	

}
