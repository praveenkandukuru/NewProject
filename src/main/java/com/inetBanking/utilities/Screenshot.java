package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.inetBanking.base.Baseclass;

public class Screenshot extends Baseclass {

	public static void screenshotofWebpage(String scName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+"\\screenshots\\"+scName);
	   FileUtils.copyFile(srcFile, destFile);

	}
	
	public static void screenshotofWebElement(WebElement ele,String scname) throws IOException
	{
		File srcFile= ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".//screenshots//"+scname));
	}

}
