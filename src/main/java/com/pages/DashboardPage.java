package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.objectRepositary.DashboardPgObjectRepositary;

public class DashboardPage extends DashboardPgObjectRepositary {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean url()
	{
		String expectedUrl = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html" ; 
		String actualUrl = driver.getCurrentUrl() ;
		
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Url is matched");
			return true ;
		}
		else
		{
			System.out.println("Url is not matched");
			return false ;
		}
	}
	public boolean title() 
	{ 	
		String expectedTitle = "JavaByKiran | Dashboard" ; 
		String actualTitle = driver.getTitle() ;
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title is matched");
			return true ;
		}
		else 
		{
			System.out.println("Title not matched");
			return false ;
		}		
	}
	public boolean userImage() 
	{	
		if(image.isDisplayed()==true)
		{
			System.out.println("User Image is displayed");
			return true ;
		}
		else
		{
			System.out.println("User Image is not displayed");
			return false ;
		}
	}
	public boolean cornerHeading() 
	{ 	
		String actCornerHeading = heading1.getText();
		String expCornerHeading = "Java By Kiran" ;
		
		if(actCornerHeading.equals(expCornerHeading))
		{
			System.out.println("Corner Heading is matched");
			return true ;
		}
		else 
		{
			System.out.println("Corner Heading not matched");
			return false ;
		}
	}
	

	public boolean getStatus() {
		String expected="Online";
		String actual= onlineStatus.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}

	public boolean getSeq() {
		String expected="Home Dashboard";
		String actual=seqHD.getText();
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

	public boolean getCourses() {
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Selenium");
		expData.add("Java / J2EE");
		expData.add("Python");
		expData.add("Php");
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : courses) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else 
			return false;
	}

	public boolean getSubCourses() {
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Automation Testing");
		expData.add("Software Development");
		expData.add("Data Science");
		expData.add("Web Development");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : subcourse) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else 
			return false;
	}

	public boolean getDashHeading() {
		String actMainHeading = dashHeading.getText();
		String expMainHeading = "Dashboard Courses Offered" ;
		
		if(actMainHeading.equals(expMainHeading))
		{
			System.out.println("Main Heading is matched");
			return true ;
		}
		else 
		{
			System.out.println("Main Heading not matched");
			return false ;
		}
	}

	

	public boolean usefulLinkMenu() {
		usefulLinkBtn.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Useful Links" ;
		dashboard.click();
		if(actTitle.equals(expTitle))
		{
			System.out.println("Useful Links Menu is working properly");
			return true ;
		}
		else 
		{
			System.out.println("Useful Links Menu is not working properly");
			return false ;
		}
	}
	public boolean downloadsMenu () 
	{
		downloadsBtn.click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Downloads" ;
				
		dashboard.click();
		
		if(actTitle.equals(expTitle))
		{
			System.out.println("Downloads Menu is working properly");
			return true ;
		}
		else 
		{
			System.out.println("Downloads Menu is not working properly");
			return false ;
		}
	}

	

	public boolean usersMenu() {
		userBtn.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | User" ;
				
		dashboard.click();
		
		if(actTitle.equals(expTitle))
		{
			System.out.println("Users Menu is working properly");
			return true ;
		}
		else 
		{
			System.out.println("Users Menu is not working properly");
			return false ;
		}
	}

	
	public boolean operatorsMenu () 
	{
		operatorBtn.click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Operators" ;
				
		dashboard.click();
		
		if(actTitle.equals(expTitle))
		{
			System.out.println("Operators Menu is working properly");
			return true ;
		}
		else 
		{
			System.out.println("Operators Menu is not working properly");
			return false ;
		}
	}

	public boolean verifyRightCornerLogOutLink() 
	{
		logoutBtn.click();
		
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Log in" ;
		
		if(actTitle.equals(expTitle))
		{
			return true ;
		}
		else 
		{
			return false ;
		}
	}

	public boolean getAllWindow() {
		
		Set <String> expNewWindowUrls = new HashSet <String>();
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");		
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html#");
		
		
		Set<String> actNewWindowUrls = new HashSet<String>();

		String mainWindow = driver.getWindowHandle();

		for (WebElement link : moreinfo) {
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
		if(actNewWindowUrls.equals(expNewWindowUrls))
		return true;
		else
			return false;
	}

	public boolean getFooter() {
		String expected = "Design for Selenium Automation Test V 2.3.0\n" +"Copyright © 2005-2019 JavaByKiran. All rights reserved.";

		String actual= footer.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getMoreInfoLinks() {
		ArrayList <String>expMoreInfoTags = new ArrayList <String>();
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");		
		expMoreInfoTags.add("More info");
		expMoreInfoTags.add("More info");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : moreinfo) {
			String text = ele.getText();
			actData.add(text);
		}
		if(actData.equals(expMoreInfoTags))
			return true;
		else 
			return false;
	}

	public boolean getNavigatorLinks() {
		ArrayList <String> expNavigationMenuText = new ArrayList <String>();
		expNavigationMenuText.add("Dashboard");
		expNavigationMenuText.add("Users"); 
		expNavigationMenuText.add("Operators");
		expNavigationMenuText.add("Useful Links");
		expNavigationMenuText.add("Downloads");
		expNavigationMenuText.add("Logout");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement ele : navigator) {
			String text = ele.getText();
			System.out.println(text);
			actData.add(text);
		}
		if(actData.equals(expNavigationMenuText))
			return true;
		else 
			return false;
	}
	public boolean jbk_Link () throws InterruptedException 
	{
		String parent = driver.getWindowHandle();
		
		jbkLink.click();
		Thread.sleep(10000);
		
		Set <String> allWindows = driver.getWindowHandles();
		
		String actWindowTitle = null ;
		String expWindowTitle = "Java Classes in Pune | Selenium Training | Python Courses in pune";
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actWindowTitle = driver.getTitle();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
		if(actWindowTitle.equals(expWindowTitle))
		{
			System.out.println("New window title is matched");
			return true ;
		}
		else 
		{
			System.out.println("New window title is not matched");
			return false ;
		}
	}
	public boolean courseHeadingExcel () throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		ArrayList <String>expData = new ArrayList <String>();
		
		for (WebElement element : courses)
		{
			actData.add(element.getText());
		}
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("dashboard");
		int row=sh.getPhysicalNumberOfRows();
		
		for (int i=1 ; i<row ; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j=0; j<col-2 ; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
			}
		}
		
		if(actData.equals(expData))
			return true ;
		else 
			return false ;
	}
	
	//23
	public boolean courseSubHeadingExcel () throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		ArrayList <String>expData = new ArrayList <String>();
		
		for (WebElement element : subcourse)
		{
			actData.add(element.getText());
		}
		
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("dashboard");
		int row=sh.getPhysicalNumberOfRows();
		
		for (int i=1 ; i<row ; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j=1; j<col-1 ; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
			}
		}
		
		if(actData.equals(expData))
			return true ;
		else 
			return false ;
	}
}
