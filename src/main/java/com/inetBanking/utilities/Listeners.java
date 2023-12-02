package com.inetBanking.utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.inetBanking.base.Baseclass;

public class Listeners extends Baseclass implements ITestListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String msgBody;
	public ExtentReports reports = EXtentreports.extentManager();
	ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		ExtentTest test = reports
				.createTest(result.getTestClass().getName() + "   @TestCase :" + result.getMethod().getMethodName());
		testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		String logtext = "<b>" + "TestCase : " + methodname.toUpperCase() + "--Passed" + "</b>";
		testReport.get().log(Status.PASS, MarkupHelper.createLabel(logtext, ExtentColor.GREEN));
		reports.flush();

	}

	public void onTestFailure(ITestResult result) {

      String scname=result.getMethod().getMethodName()+".png";
		

		String exceptionmsg = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception occured :click to see"
						+ "</font>" + "</b>" + "</summary>" + exceptionmsg.replaceAll(",", "<br>") + "</details>"
						);

		try {
			Screenshot.screenshotofWebpage(scname);
			testReport.get().fail("<b>" + "<font color" + "red>" + "screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(
							System.getProperty("user.dir")+"\\screenshots\\"+ scname)
							.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String methodname = result.getMethod().getMethodName();
		String logText = "<b>" + "TestCase : " + methodname.toUpperCase() + "  Failed " + "</b>";
		testReport.get().fail( MarkupHelper.createLabel(logText, ExtentColor.RED));
		reports.flush();

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
