package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.UsefulLinkPgObjectRepositary;

public class UseFulLinkPage extends UsefulLinkPgObjectRepositary{
WebDriver driver;
	public UseFulLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogout() {
		logoutBtn.click();
		return new LoginPage(driver);
	}
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/links.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Useful Links";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getHeading(){	
		String expected="Useful Links";
		String actual= heading.getText();
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
		String actual=kiranHead.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean checkHeader() throws Exception {
		ArrayList<String> exp=new ArrayList<String>();
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("usefulheader");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			Cell cell=sh.getRow(i).getCell(0);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				exp.add(value);
				System.out.println(value);
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
	public boolean imageDisplay() {
		return image.isDisplayed();
	}
	public boolean getSubHeading(){
		String expected="* Internet Required";
		String actual= subheading.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
		}
	public boolean getRightCornerHeading() {
		String expected="Home Useful Links";
		String actual= homeUseFulRight.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getFooter() {
		String expected = "Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual=footer.getText();
		if(actual.equals(expected))
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
	public boolean getUsefulLinkTableRowdata() throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("useful");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 1; i < row; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j = 0; j <col; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				System.out.print("    "+value);
			}
			System.out.println();
		}
		ArrayList<String> actData = new ArrayList<String>();
		
			for (WebElement ele : tableData) {
				String text = ele.getText();
				actData.add(text);
			}
			if(actData.equals(expData))
				return true;
			else
				return false;
	}
	public boolean contentForClickCol(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Schedule");
		expData.add("Video Lactures All Topics");
		expData.add("Selenium Interview Questions");
		expData.add("Java Interview Questions");
		expData.add("Courses");
		expData.add("Placement");
		
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:goCol){
			String text=element.getText();
			if(text.contains("Go !"))
			{
			   String name=content.get(i).getText();
				System.out.println(name);
				actData.add(name);
			}
			i++;
		}
	if(actData.equals(expData))
			return true;
	else
		return false;
	}
	public boolean clickGO() throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Live Videos | javabyKiran");
		expData.add("Page not found | javabyKiran");
	
		String parent = driver.getWindowHandle();
		
		for (WebElement element : goCol)
		{
			element.click();
			Thread.sleep(5000);
		}
		
		Set <String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actData.add(driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;	
	}
	
	//2
	public boolean clickGoExcel() throws Exception 
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("goLink");
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
		String parent = driver.getWindowHandle();
		
		for (WebElement element : goCol)
		{
			element.click();
			Thread.sleep(5000);
		}
		
		Set <String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				actData.add(driver.getTitle());
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;	
	}
	
	//3
	public boolean complete_UsefulLinksTable() throws Exception 
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("useful");
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
		}
		
		for (WebElement element : tableData)
		{
			String data = element.getText();
			actData.add(data);
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
}
