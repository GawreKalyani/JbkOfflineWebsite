package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.OperatorPgObjectRepositary;

public class OperatorPg extends OperatorPgObjectRepositary{
	WebDriver driver;

	public OperatorPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickLogout() {
		logoutBtn.click();
		return new LoginPage(driver);
	}
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/operators.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Operators";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getHeading() {
		String expected="Operators";
		String actual=heading.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getSubHeading() {
		String expected="Operator List";
		String actual= subheading.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean imageDisplay() {
		return image.isDisplayed();
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
	 public boolean getSortedNms() {
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Darshit");
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : personNames) {
			String text = element.getText();
			actData.add(text);
		}
		Collections.sort(actData);
		if(actData.equals(expData))
			return true;
		else
			return false;	
	}
	public boolean checkHeaders() throws Exception {
		ArrayList<String> expData=new ArrayList<String>();
		String value=null;
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("operatorHeader");
		int row=sh.getPhysicalNumberOfRows();
		for (int i = 0; i < row; i++) 
		{
			Cell cell=sh.getRow(i).getCell(0);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expData.add(value);
				
		}
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : headers) {
			String text = element.getText();
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean getOperatorTableRowdata() throws Exception{
		ArrayList<String> expData=new ArrayList<String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("operator");
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

	public boolean getFooter() {
		String expfooter = "Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual=footer.getText();
		if(actual.equals(expfooter))
			return true;
		else
			return false;
	}
	public boolean getRightCornerHeading() {
		String expected="Home Operators";
		 String actual=homeUserRight.getText();
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
	
	public boolean getNmKiran() {
		String expected="Kiran";
		String actual=kiranHead.getText();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean teachersNamesForMobNoStarting88(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:mob){
			String text=element.getText();
			if(text.substring(0,2).equals("88"))
			{
				String name=personNames.get(i).getText();
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
	
	public boolean teachersNotPresentOnSunday(){
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Neelam");
		expData.add("Seema");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(!text.contains("Sunday"))
			{
			     //row2 names
				String name=personNames.get(i).getText();
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
	
	public boolean teacherPresentOnMonday(){
		int i=0;
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday"))
			{
				String name=personNames.get(i).getText();
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
	public boolean teacherPresentOnSunday(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Sunday"))
			{
				String name=personNames.get(i).getText();
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
	
	
	public boolean teacherPresentOnMondaySaturday(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday") && text.contains("Saturday"))
			{
				String name=personNames.get(i).getText();
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
	 public boolean teacherPresentForUrgentHelp(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:helpfor){
			String text=element.getText();
			if(text.contains("Urgent Technical Help"))
			{
				
				String name=personNames.get(i).getText();
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
	public boolean prefferedWayToConnect_WhatsApp_AND_PhoneCall(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Whats App")&& contact.contains("Phone Call")){
				String faculty=personNames.get(i).getText();
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean prefferedWayToConnect_WhatsApp(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Whats App")){
				String faculty=personNames.get(i).getText();
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean prefferedWayToConnect_PhoneCall(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Phone Call")){
				String faculty=personNames.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
		}
	public boolean contactNoLength()
	{	
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		
		System.out.println("Faculties having 10 digit Mobile No. : ");
	
		int i=0 ;
		
		for (WebElement element : mob)
		{
			String contact = element.getText();
			
			if (contact.length()==10)
			{
				String faculty = personNames.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++ ;
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
	public boolean prefferedWayToConnect_WhatsApp_ButNot_PhoneCall ()
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Darshit");
		
		System.out.println("Faculties available on WhatsApp but not on Phone Call : ");
	
		int i=0 ;
		
		for (WebElement element : preferWay)
		{
			String contact = element.getText();
			
			if (contact.contains("Whats App"))
			{
				if (!contact.contains("Phone Call"))
				{
					String faculty = personNames.get(i).getText();
					System.out.println(faculty);
					actData.add(faculty);
				}
			}
			i++ ;
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
	
	public boolean CompleteOperatorsTable () throws Exception
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("operatorTable");
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
