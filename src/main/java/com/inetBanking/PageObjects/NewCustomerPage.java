package com.inetBanking.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.Baseclass;

public class NewCustomerPage extends Baseclass {

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[name='name']")
	WebElement customernamElement;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement gender;

	@FindBy(id = "dob")
	WebElement dateofBirth;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement cityname;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pincode;

	@FindBy(name = "emailid")
	WebElement email;

	@FindBy(css = "[name='telephoneno']")
	WebElement mobnumElement;

	@FindBy(css = "[name='password']")
	WebElement paswordElement;

	@FindBy(name = "sub")
	WebElement submitElement;

	@FindBy(css = "[class='heading3']")
	WebElement custcreatedElement;

	@FindBy(xpath = "(//tbody)[2]//tbody/tr[2]/td")
	WebElement textElement;

	public void createCustomer(String name, String dod, String add, String city, String stat, String pin, String mail,
			String mob, String pwd) throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

		ac.type(customernamElement, name);
		log.debug("enter custsomer name");
		ac.type(dateofBirth, dod);
		
		ac.type(address, add);
		ac.type(cityname, city);
		ac.type(state, stat);
		ac.type(pincode, pin);
		ac.type(email, mail);
		ac.type(mobnumElement, mob);
		ac.type(paswordElement, pwd);
		submitElement.click();
		log.info("entered details in all mandatory fields");
		System.out.println(custcreatedElement.getText());
		System.out.println(textElement.getText());

		List<WebElement> rows = driver.findElements(By.xpath("(//tbody)[2]//tbody/tr"));
		int count = rows.size();
		System.out.println(count);

		for (int i = 4; i <= count - 1; i++) {

			for (int j = 1; j <= 2; j++) {
				System.out
						.print(driver.findElement(By.xpath("(//tbody)[2]//tbody/tr[" + i + "]/td[" + j + "]")).getText()
								+ "    ");

			}
			System.out.println();

		}
		String idString = driver.findElement(By.xpath("(//tbody)[2]//tbody/tr[4]/td[2]")).getText();
		
		dataFromExcelSheet.setCellValueInExcel("Sheet1", 1, 1, idString);
		

	}

}
