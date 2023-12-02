package com.inetBanking.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.base.Baseclass;

public class Homepage extends Baseclass {

	public Homepage() {
		System.out.println("in homepage");
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/following-sibling::ins[1]/div/iframe")
	WebElement iframElement;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	WebElement closElement;

	@FindBy(partialLinkText = "New Customer")
	WebElement newcustomerpagElement;

	@FindBy(partialLinkText = "Edit Customer")
	WebElement editcustomerpagElement;

	@FindBy(partialLinkText = "Delete Customer")
	WebElement deletecustomerpagElement;

	@FindBy(partialLinkText = "New Account")
	WebElement newAccountpagElement;

	@FindBy(partialLinkText = "Edit Account")
	WebElement editaccountpagElement;

	@FindBy(partialLinkText = "Mini Statement")
	WebElement ministatementElement;

	@FindBy(partialLinkText = "Customised Statement")
	WebElement customizedElement;

	@FindBy(partialLinkText = "Log out")
	 WebElement logoutElement;

	public NewCustomerPage newCustomer() throws InterruptedException {
		
		
		newcustomerpagElement.click();
		
		log.info("click on newCustomer link");

		return new NewCustomerPage();
	}
	
	public EditCustomerPage Editcustomer(String id)
	{
		editaccountpagElement.click();
		log.info("click on editcustomer link link");
		
		return new EditCustomerPage();
	}
	
	public   Loginpage clickonlogout()
	{
		logoutElement.click();
		
		return new Loginpage();
	}
	
	public DeleteCustomerPage deleteCustomer()
	{
		deletecustomerpagElement.click();
		log.info("click on delete customer link");
		return new DeleteCustomerPage();
	}
	
	public NewAccountpage newAccountPage()
	{
		newAccountpagElement.click();
		log.info("click on NewACcount page link");
		
		return new  NewAccountpage(); 
		
	}
}
