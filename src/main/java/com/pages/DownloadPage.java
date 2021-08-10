package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.DownloadPgObjectRepositary;
import com.utility.ExcelUtility;
import com.utility.Utility;

public class DownloadPage extends DownloadPgObjectRepositary {
	WebDriver driver;

	public DownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/downloads.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Downloads";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getHeading() {
		String expected="Downloads";
		String actual=Utility.stringText(heading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSubHeading() {
		String expected="Downloads List";
		String actual=Utility.stringText(subheading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected="Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual=Utility.stringText(footer);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getRightCornerHeading() {
		String expected="Home Downloads";
		String actual=Utility.stringText(homeUserRight);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getStatus() {
		String expected="Online";
		String actual=Utility.stringText(onlineStatus);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getheadJBK() {
		String expected="Java By Kiran";
		String actual=Utility.stringText(jbk);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getNmKiran() {
		String expected="Kiran";
		String actual=Utility.stringText(kiranHead);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean imageDisplay() {
		return image.isDisplayed();
	}
	
	public boolean checkHeader() throws Exception {
		ArrayList<String> exp=ExcelUtility.getTableColumnData("Data.xlsx","downloadHeader",0);
		ArrayList<String> actData = Utility.getActualListOfHeadingOfTable(headers);
	
		if(actData.equals(exp))
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
		if(actData.equals(expNavigationMenuText))
			return true;
		else
			return false;
	}
	public boolean getNmFor32bit() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : bit32s) {
			if (ele.getText().equals("32bit")) {
				String name = vendors.get(i).getText();

				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmFor64bit() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : bit64s) {
			if (ele.getText().equals("64bit")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForCommonbtnAndOther() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Selenium Server Standalon Jar");
		expData.add("Selenium Server Source Jar");
		expData.add("Google Chrome Driver");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : commonCol) {
			if (ele.getText().contains("Common") || ele.getText().contains("2.52.0")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForCommonColBlankData() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Google Chrome");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : commonCol) {
			String text = ele.getText();
			if (text.equals("")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForVersion76() {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Google Chrome");
		expData.add("Google Chrome Driver");
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : versions) {
			String text = ele.getText();
			if (text.equals("76.0")) {
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean getNmForOfficialWeb() {
		int i=0;
		ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Java Development Kit (JDK)");
		expData.add("Selenium Server Standalon Jar");
		expData.add("Selenium Server Source Jar");
		expData.add("Google Chrome");
		expData.add("Google Chrome Driver");
		expData.add("Mozilla Firefox");
		expData.add("Gecko Driver for Latest firefox");
		for (WebElement ele : official) {
			String text = ele.getText();
			if (text.equals("Official Website"))
			{
				String name = vendors.get(i).getText();
				actData.add(name);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}

	public boolean completeDownloadsTable() throws Exception
	{
		ArrayList <String>actData=Utility.getActualDataOfTableFully(headers, tableData);
		ArrayList <String>expData=ExcelUtility.getTableDataFully("Data.xlsx","download");
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}


	public boolean getVendorAndVersionFor32bit() throws Exception {
		HashMap<String,List<String>>actualhm=new HashMap<>();
		
		for (int i = 0; i < vendors.size(); i++) {
			String bit=bit32s.get(i).getText();
			String version=versions.get(i).getText();
			String vendor=vendors.get(i).getText();
			
			List<String>al=new ArrayList<>();
			al.add(vendor);
			al.add(version);
			actualhm.put(bit, al);
			System.out.println("Actual:"+actualhm);
		}
		HashMap<String,List<String>>exphm=ExcelUtility.readUnameAndPass("Data.xlsx", "downCol3", 0, 1, 2);
		System.out.println("Expected"+exphm);
		if(actualhm.equals(exphm))
			return true ;
		else 	
			return false ;
	
	}
	
}
