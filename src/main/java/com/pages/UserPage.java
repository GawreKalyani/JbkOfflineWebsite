package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.UserPgObjectRepositary;
import com.utility.ExcelUtility;
import com.utility.Utility;

public class UserPage extends UserPgObjectRepositary {
	WebDriver driver;

	public UserPage(WebDriver driver) { // constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getURLOfBrowser() {
		String exp = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/users.html";
		String actual = driver.getCurrentUrl();
		if (actual.equals(exp))
			return true;
		else
			return false;
	}

	public boolean getTitleOfBrowser() {
		String expected = "JavaByKiran | User";
		String actual = driver.getTitle();
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getToolTip() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		expData.add("Click to Delete");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : deleteBtn) {
			String text = ele.getAttribute("title");
			actData.add(text);
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean checkgmailIsProper() {

		for (WebElement element : emails) {
			String text = element.getText();
			boolean flag = text.contains("gmail.com");
			System.out.println(flag);
		}
		return true;
	}

	public boolean checksrno() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("1");
		expData.add("2");
		expData.add("3");
		expData.add("4");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : srno) {
			String text = element.getText();
			actData.add(text);
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean actionText() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Delete");
		expData.add("Delete");
		expData.add("Delete");
		expData.add("Delete");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : actions) {
			String text = element.getText();
			actData.add(text);
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNavigator() {
		ArrayList<String> expNavigationMenuText=Utility.getExpectedNavigation();
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : navigator) {
			String text = element.getText();
			actData.add(text);
		}
		if (actData.equals(expNavigationMenuText))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForJava() {

		String expectedFaculty = "Kiran";
		String actualFaculty = null;

		int i = 0;
		for (WebElement element : course) {
			if (element.getText().contains("Java/J2EE")) {

				String name = names.get(i).getText();
				actualFaculty = name;
			}
			i++;
		}
		if (actualFaculty.equals(expectedFaculty))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForMahararshtra() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Monica");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : states) {
			if (element.getText().equals("Maharashtra")) {
				String name = names.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForPunjab() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Sagar");
		expData.add("Kimaya");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : states) {
			if (element.getText().equals("Punjab")) {
				String name = names.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean checkHeaders() throws Exception {
		ArrayList<String> expData = ExcelUtility.getTableColumnData("Data.xlsx", "userheader", 0);

		ArrayList<String> actData = Utility.getActualListOfHeadingOfTable(headers);

		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getUserTableRowdata() throws Exception {
		ArrayList<String> expData = ExcelUtility.getExcelTableRowData("Data.xlsx", "user");

		ArrayList<String> actData = Utility.getActualTableRowData(tableData);

		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getHeading() {
		String expected = "Users";
		String actual = Utility.stringText(heading);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSubHeading() {
		String expected = "User List";
		String actual = Utility.stringText(subheading);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected = "Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual = Utility.stringText(footer);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getJbkheading() {
		String expected = "Java By Kiran";
		String actual = Utility.stringText(jbk);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getRightCornerHeading() {
		String expected = "Home Users";
		String actual = Utility.stringText(homeDashRight);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getNmKiran() {
		String expected = "Kiran";
		String actual = Utility.stringText(kiranHead);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getStatus() {
		String expected = "Online";
		String actual = Utility.stringText(onlineStatus);
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean imageDisplay() {
		return image.isDisplayed();
	}

	public boolean verifyNamesForSelenium() {
		String expectedFaculty = "Sagar";
		String actualFaculty = null;

		int i = 0;

		for (WebElement element : course) {
			if (element.getText().contains("Selenium")) {
				String name = names.get(i).getText();
				actualFaculty = name;
			}
			i++;
		}
		if (actualFaculty.equals(expectedFaculty))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForPython() {
		String expectedFaculty = "Monica";
		String actualFaculty = null;

		int i = 0;

		for (WebElement element : course) {
			if (element.getText().contains("Python")) {
				String name = names.get(i).getText();
				actualFaculty = name;
			}
			i++;
		}
		if (actualFaculty.equals(expectedFaculty))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForPHP() {
		String expectedFaculty = "Kimaya";
		String actualFaculty = null;

		int i = 0;

		for (WebElement element : course) {
			if (element.getText().contains("PHP")) {
				String name = names.get(i).getText();
				// System.out.println(name);
				actualFaculty = name;
			}
			i++;
		}
		if (actualFaculty.equals(expectedFaculty))
			return true;
		else
			return false;
	}

	public boolean verifyNamesForGenderMale() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Sagar");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : gender) {
			if (element.getText().contains("Male")) {

				String name = names.get(i).getText();
				actData.add(name);
			}
			i++;
		}

		if (actData.equals(expData))
			return true;
		else
			return false;

	}

	public boolean verifyNamesForGenderFemale() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Monica");
		expData.add("Kimaya");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : gender) {
			if (!element.getText().contains("Male")) {

				String name = names.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifyNineDigMobno() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Sagar");
		expData.add("Kimaya");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : mobiles) {
			String text = element.getText();
			int noOfDigit = text.length();
			if (noOfDigit == 9) {
				String name = names.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifyTenDigMobno() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Monica");
		int i = 0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : mobiles) {
			String text = element.getText();
			int noOfDigit = text.length();
			if (noOfDigit == 10) {
				String name = names.get(i).getText();
				// System.out.println(name);
				actData.add(name);
			}
			i++;
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifyAlertMsgForRow1and3DeleteBtn() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("You can not delete Default User");
		expData.add("You can not delete Default User");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : row1row3DeleteBtn) {
			element.click();
			String t = Utility.alertHandle(driver);
			actData.add(t);

		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifyAlertMsgForRow2and4DeleteBtn() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Are you sure you want to delete this user");
		expData.add("Are you sure you want to delete this user");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : row2row4DeleteBtn) {
			element.click();
			String t = Utility.alertToDismiss(driver);
			actData.add(t);
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean verifySecondAlertMsg() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("User deleted successfully.");
		expData.add("User deleted successfully.");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : row2row4DeleteBtn) {
			element.click();
			String t = Utility.alertHandleTwoTimes(driver);
			actData.add(t);
		}
		if (actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean userNameSorting() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kimaya");
		expData.add("Kiran");
		expData.add("Monica");
		expData.add("Sagar");
		ArrayList<String> actData1 = new ArrayList<String>();
		for (WebElement ele : names) {
			String text = ele.getText();
			actData1.add(text);
		}
		Collections.sort(actData1);
		System.out.println(actData1);
		if (actData1.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getTitleForAddUserPg() {

		Utility.click(addUserButton);

		String expected = "JavaByKiran | Add User";
		String actual = driver.getTitle();
		if (actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean CompleteUsersTable() throws Exception {
		ArrayList<String> actData = Utility.getActualDataOfTableFully(headers, tableData);
		ArrayList<String> expData = ExcelUtility.getTableDataFully("Data.xlsx","user");

		if (actData.equals(expData))
			return true;
		else
			return false;
	}
}
