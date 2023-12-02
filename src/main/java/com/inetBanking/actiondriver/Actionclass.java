package com.inetBanking.actiondriver;

import java.time.Duration;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.Baseclass;

public class Actionclass extends Baseclass {

	public void scrollByVisibilityOfElement(WebElement ele, WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public void click(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.click(ele);
	}

	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		}

		catch (Exception e) {
			flag = false;

		} finally {

			if (flag) {
				System.out.println("element is diaplayed in the webpage");
			} else {
				System.out.println("element is not displayed in the webpage");
			}

		}

		return flag;
	}

	public boolean isDispalyed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		System.out.println(driver);
		flag = findElement(driver, ele);

		if (flag) {
			ele.isDisplayed();
			System.out.println("the element is displayed");
		} else {
			System.out.println("the element is not displayed");
		}
		return flag;
	}

	public boolean isSelected(WebElement ele, WebDriver driver) {
		boolean flag = false;
		flag = findElement(driver, ele);

		if (flag) {
			ele.isSelected();
			System.out.println("the element is selected");
		} else {
			System.out.println("the element is not selected");
		}
		return flag;
	}

	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("the element is enabled");
			} else {
				System.out.println("the element is not enabled");
			}

		}
		return flag;

	}

	public void type(WebElement ele, String text) {
		boolean flag = false;

		flag = ele.isDisplayed();
		if (flag) {
			ele.clear();
			ele.sendKeys(text);
		} else {
			System.out.println(("element is not found"));
		}

	}

	public boolean selectBySendkeys(WebElement ele, String text) {
		boolean flag = false;

		try {
			ele.sendKeys(text);
			flag = true;

			return true;

		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("text is entered");
			} else {

				System.out.println("text is not entered");

			}

		}

	}

	public boolean selectByIndex(WebElement ele, int index) {
		boolean flag = false;
		try {
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("element is selected by index");
			} else {
				
					System.out.println(("element is not selected by index"));
				
			}
		}

	}
	
	public boolean selectByValue(WebElement ele,String value)
	{
		boolean flag=false;
		try {
			Select select=new Select(ele);
			 select.selectByValue(value);
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
			{
				System.out.println("element is selected by value");
			}else {
					System.out.println("element id not selected by value");
			}
			
		}
		 
	}
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	public void clickByJavaScript(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0],click();", ele);
		
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(index);
	}
	
	public boolean switchToFrameById(WebDriver driver,WebElement ele)
	{
		boolean flag=false;
		try {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(ele);
		
		flag=true;
		return true;
		}catch(Exception exception )
		{
			flag=false;
			return flag;
		}
		finally {
			
				if(flag)
				{
					System.out.println("frame is located by the webelement");
				}else
                      System.out.println("frame is not located by the webelement");
			
		}
	}
	public boolean switchtoframeByName(WebDriver driver,String namevalue)
	{
		boolean flag=false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(namevalue);
			
			flag=true;
			 return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		finally {
			if(flag)
			{
				System.out.println("switch toi the frame with name value : "+ namevalue);
			}else {
				System.out.println("Not switched to the frame with name value : "+namevalue);
			}
		}
	}
	
	public boolean switchtoframeById(WebDriver driver,String idvalue)
	{
		boolean flag=false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(idvalue);
			
			flag=true;
			 return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		finally {
			if(flag)
			{
				System.out.println("switch toi the frame with name value : "+ idvalue);
			}else {
				System.out.println("Not switched to the frame with name value : "+idvalue);
			}
		}
	}
	
	public void acceptAlert(WebDriver driver)
	{
		Alert altAlert=driver.switchTo().alert();
		altAlert.accept();
		
	}
	
	public void sendMessageToAlert(WebDriver driver,String msg)
	{
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(msg);
		
		
	}
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}}
		}
	
		public void dismissAlert()
		{
			Alert altAlert=driver.switchTo().alert();
			altAlert.dismiss();
		}
	
	
	

}
