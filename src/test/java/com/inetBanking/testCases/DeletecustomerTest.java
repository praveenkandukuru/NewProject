package com.inetBanking.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.DeleteCustomerPage;
import com.inetBanking.PageObjects.Homepage;
import com.inetBanking.PageObjects.Loginpage;
import com.inetBanking.PageObjects.NewCustomerPage;
import com.inetBanking.base.Baseclass;

public class DeletecustomerTest extends Baseclass{
	@Test()
	public void deletecustomer() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Random random = new Random();
		int value = random.nextInt(1000);

		Loginpage lp=new Loginpage();
	Homepage hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	NewCustomerPage ncp=hp.newCustomer();
	ncp.createCustomer("hai", "02-12-1994", "varadaiah palem", "andhrapardesh", "tirupathi", "517457",
			"aasad" + value + "@gmail.com", "7896541230", "hsdfhabesd");
	String idString = dataFromExcelSheet.getdatafromExcelSheet("Sheet1", 1, 1);
	System.out.println(idString);
	DeleteCustomerPage dcp=	hp.deleteCustomer();

	dcp.deleteCount(idString);
	
	
		
		
	}

}
