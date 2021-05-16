package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.DownloadPgObjectRepositary;

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
		String actual= heading.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSubHeading() {
		String expected="Downloads List";
		String actual=subheading.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected="Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual= footer.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getRightCornerHeading() {
		String expected="Home Downloads";
		String actual= homeUserRight.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getStatus() {
		String expected="Online";
		String actual=onlineStatus.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getheadJBK() {
		String expected="Java By Kiran";
		String actual=jbk.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getNmKiran() {
		String expected="Kiran";
		String actual= kiranHead.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean imageDisplay() {
		return image.isDisplayed();
	}
	public LoginPage clickLogout() {
		logoutBtn.click();
		return new LoginPage(driver);
	}

	public boolean checkHeader() throws Exception {
		
		ArrayList<String> exp=new ArrayList<String>();
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("downloadHeader");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			Cell cell=sh.getRow(i).getCell(0);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				exp.add(value);
				//System.out.println(value);
		}
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : headers) {
			String name = ele.getText();
			actData.add(name);
		}
		if(actData.equals(exp))
			return true;
		else
			return false;
	}
	public boolean getNavigator() {
		ArrayList<String> expNavigationMenuText = new ArrayList<String>();
		expNavigationMenuText.add("Dashboard");
		expNavigationMenuText.add("Users");
		expNavigationMenuText.add("Operators");
		expNavigationMenuText.add("Useful Links");
		expNavigationMenuText.add("Downloads");
		expNavigationMenuText.add("Logout");
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
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("download");
		int row=sh.getPhysicalNumberOfRows();
		
		for (int i = 0; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
			}
		}
		
		for (WebElement element : headers)
		{
			String data = element.getText();
			actData.add(data);
			System.out.println(data);
		}
		
		for (WebElement element : tableData)
		{
			String data = element.getText();
			actData.add(data);
			System.out.println(data);
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
}
