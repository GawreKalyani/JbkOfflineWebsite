package com.utility;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;

public class WaitUtility extends Testbase {
	
	public static void pageLoad(long timeinSec){
		driver.manage().timeouts().pageLoadTimeout(timeinSec, TimeUnit.SECONDS);
	}
	
	public static void imlicitWait(long timeinSec){
		driver.manage().timeouts().implicitlyWait(timeinSec, TimeUnit.SECONDS);
	}
	
	 public static void explicitWaitforanelement(WebElement element,int timeinSec)
	    {	
	        WebDriverWait wait = new WebDriverWait(driver,timeinSec);
	         wait.until(ExpectedConditions.visibilityOf(element));
	    }
	 
	 public static void explicitWaitforanAllelement(List<WebElement> element,int timeinSec)
	    {	
	        WebDriverWait wait = new WebDriverWait(driver,timeinSec);
	         wait.until(ExpectedConditions.visibilityOfAllElements(element));
	    }
	 
	 public static void sleep(long milisec) throws Exception
	 {
		Thread.sleep(milisec); 
	 }

}