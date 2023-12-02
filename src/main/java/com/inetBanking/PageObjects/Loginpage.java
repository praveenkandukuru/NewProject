package com.inetBanking.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.Baseclass;

public class Loginpage extends Baseclass {
	
	
	public Loginpage()
	{
		//rdriver=ldriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[name='uid']")
	WebElement username;
	
	@FindBy(css="[name='password']")
	WebElement enterEmail;
	
	@FindBy(css="[name='btnLogin']")
	WebElement submit;
	
	public Homepage login(String usn,String pwd) throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));
		log.info("entered url");
		ac.type(username, usn);
		ac.type(enterEmail, pwd);
		submit.click();
		log.info("successfully logged in");
		
		return new Homepage();
	}
	
	

}
