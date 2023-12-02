package com.inetBanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class EXtentreports {
	
	private static ExtentReports extent;

	public static ExtentReports extentManager()
	{
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(".//extentreports//report.html");
		
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("inetBanking");
		reporter.config().setReportName("inetBankingReport");
		
	    extent=new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Automation Tester","prabhas");
	    extent.setSystemInfo("Designation ","fresher");
	    extent.setSystemInfo("application","inetBanking");
	    extent.setSystemInfo("os", System.getProperty("os.name"));
	    
	    return extent;
	}
	

}
