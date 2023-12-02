package com.inetBanking.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.inetBanking.actiondriver.Actionclass;
import com.inetBanking.excelUtilities.DataFromExcelSheet;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {

	public static Properties prop;
	public static WebDriver driver;
	public FileInputStream fis;
	public static Actionclass ac = new Actionclass();
	public static DataFromExcelSheet dataFromExcelSheet=new DataFromExcelSheet();
	public static Logger log=Logger.getLogger(Baseclass.class);
	
	
	

	@BeforeTest
	public void loadConfig() {
		
		PropertyConfigurator.configure("Log4j.properties");

		try {
			prop = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir") + "//configurations//config.properties");

			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	public void launchApplication() {
		PropertyConfigurator.configure("Log4j.properties");
		
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\prave\\inetBanking\\browserExecutables\\chromedriver.exe");
			
			driver = new ChromeDriver();
			log.debug("chrome Browser is launched");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else {	
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
		}

	}

	@AfterClass
	public void tearDown() {
		
		log.info("the browser will close");
		driver.quit();
	}
}
