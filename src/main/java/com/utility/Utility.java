package com.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Utility {
	WebDriver driver;

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void sendkeys(WebElement element, String datatoEnter) {
		element.sendKeys(datatoEnter);
	}
	public static Map<String, String> getActualDataUsingMap(String text,List<WebElement>keys,List<WebElement>keyValue){
		int i=0;
		Map<String,String>actData=new HashMap<>();
		for (WebElement webElement : keyValue) {
			String k=webElement.getText();
			if(k.equals(text))
			{	String name=keys.get(i).getText();
			  actData.put(name,k);
			}
			i++;
		}
		return actData;
	}

	public static ArrayList<String> getActualListOfHeadingOfTable(List<WebElement> headers) {
		ArrayList<String> actHead = new ArrayList<String>();
		for (WebElement element : headers) {
			actHead.add(element.getText());
		}
		return actHead;
	}

	public static ArrayList<String> getActualTableRowData(List<WebElement> tableData) {
		ArrayList<String> actHead = new ArrayList<String>();
		for (WebElement element : tableData) {
			String text = element.getText();
			actHead.add(text);
			System.out.println(text);
		}
		return actHead;
	}

	public static ArrayList<String> getActualDataOfTableFully(List<WebElement> headers, List<WebElement> tableData) {
		ArrayList<String> actHead = new ArrayList<String>();
		for (WebElement element : headers) {
			actHead.add(element.getText());
		}
		for (WebElement element : tableData) {
			actHead.add(element.getText());
		}
		return actHead;
	}

	public static void clear(WebElement button) {
		button.clear();
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String stringText(WebElement element) {
		return element.getText();
	}

	public static String alertHandle(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		String alertmsg = al.getText();
		al.accept();
		return alertmsg;

	}

	public static String alertToDismiss(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		String alertmsg = al.getText();
		al.dismiss();
		return alertmsg;
	}

	public static String alertHandleTwoTimes(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();
		Alert al1 = driver.switchTo().alert();
		String alertmsg = al1.getText();
		al1.accept();
		return alertmsg;
	}

	public static Set<String> getWindowHandleCheckingUrl(WebDriver driver, List<WebElement> element) {
		Set<String> actNewWindowUrls = new HashSet<String>();

		String mainWindow = driver.getWindowHandle();
		for (WebElement link : element) {
			link.click();// 5 wins are opened
		}
		Set<String> wins = driver.getWindowHandles();
		for (String child : wins) {
			if (!child.equals(mainWindow)) {
				driver.switchTo().window(child);
				actNewWindowUrls.add(driver.getCurrentUrl());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		return actNewWindowUrls;
	}

	public static String getSingleWindowHandleVerifyTitle(WebDriver driver, WebElement element) {
		String parent = driver.getWindowHandle();
		Utility.click(element);

		String actWindowTitle = null;
		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				actWindowTitle = driver.getTitle();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		return actWindowTitle;
	}

	public static ArrayList<String> getWindowHandleVerifyingTitle(WebDriver driver, List<WebElement> element) {
		ArrayList<String> actData = new ArrayList<String>();

		String parent = driver.getWindowHandle();

		for (WebElement ele : element) {
			ele.click();

		}

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				actData.add(driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		return actData;
	}

	public static ArrayList<String> getExpectedNavigation() {
		ArrayList<String> expNavigationMenuText = new ArrayList<String>();
		expNavigationMenuText.add("Dashboard");
		expNavigationMenuText.add("Users");
		expNavigationMenuText.add("Operators");
		expNavigationMenuText.add("Useful Links");
		expNavigationMenuText.add("Downloads");
		expNavigationMenuText.add("Logout");
		return expNavigationMenuText;
	}
}
