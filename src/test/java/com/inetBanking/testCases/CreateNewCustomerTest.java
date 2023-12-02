package com.inetBanking.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.Homepage;
import com.inetBanking.PageObjects.Loginpage;
import com.inetBanking.PageObjects.NewCustomerPage;
import com.inetBanking.base.Baseclass;

public class CreateNewCustomerTest extends Baseclass {

	@Test(retryAnalyzer =com.inetBanking.analyzer.RetryAnalyzer.class)
	public void createcustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Random random = new Random();
		int value = random.nextInt(1000);
		
		

		Loginpage lp=new Loginpage();
		Homepage hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		NewCustomerPage ncp = hp.newCustomer();
		ncp.createCustomer("hai", "02-12-1994", "varadaiah palem", "andhrapardesh", "tirupathi", "517457",
				"aasad" + value + "@gmail.com", "7896541230", "hsdfhabesd");
		Assert.assertTrue(false);

	}

}
