package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.objectRepositary.AddUserPgObjectRepositary;

public class AddUserPage extends AddUserPgObjectRepositary{
WebDriver driver;
	
	public AddUserPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getLabels(){
		ArrayList<String> expLabels = new ArrayList<String>();
		expLabels.add("Username");
		expLabels.add("Mobile");
		expLabels.add("Email");
		expLabels.add("Courses");
		expLabels.add("Gender");
		expLabels.add("State");
		expLabels.add("Password");
		ArrayList<String> actLabels = new ArrayList<String>();
		for (WebElement label : labels) {
			String text = label.getText();
			actLabels.add(text);
		}
		if(actLabels.equals(expLabels))
				return true;
		else
			return false;
	}
	public boolean addUserValid(){
		username.sendKeys("Alihan");
		mob.sendKeys("9876673773");
		email.sendKeys("alihan@gmail.com");
		course.sendKeys("Selenium");
		maleradio.click();
		maharashtra.click();
		pass.sendKeys("jhh");
		submitbutton.click();
		Alert al = driver.switchTo().alert();
		String actMsg = al.getText();
		al.accept();
		
		String expMsg = "User Added Successfully. You can not see added user.";
		
		if(actMsg.equals(expMsg))
			return true ;
		else
			return false ;
	}
	public boolean getListOfStateOptions()
	{
		ArrayList <String> actDragDownOptions = new ArrayList <String>();
		
		ArrayList <String> expDragDownOptions  = new ArrayList <String>();
		expDragDownOptions.add("--Select State--");
		expDragDownOptions.add("Maharashtra");
		expDragDownOptions.add("Delhi");
		expDragDownOptions.add("HP");
		expDragDownOptions.add("Punjab");
		
		Select state = new Select(selectstate);
		
		List <WebElement> list = state.getOptions();
		
		for(WebElement element : list)
		{
			actDragDownOptions.add(element.getText());
			System.out.println(element.getText());
		}
		
		if(actDragDownOptions.equals(expDragDownOptions))
			return true ;
		else
			return false ;
	}
	public boolean getOptFromExcel() throws Exception
	{
		ArrayList <String> actDragDownOptions1 = new ArrayList <String>();
		
		ArrayList <String> expDragDownOptions1  = new ArrayList <String>();
		
		Select states = new Select(selectstate);
		
		List <WebElement> list = states.getOptions();
		
		for(WebElement element : list)
		{
			actDragDownOptions1.add(element.getText());
			System.out.println(element.getText());
		}
		String path=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
		String value=null;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("statelist");
		int row=sh.getPhysicalNumberOfRows();
		
		for (int i=0 ; i<row ; i++) 
		{
			int col=sh.getRow(i).getLastCellNum();
			for (int j=0; j<col ; j++) 
			{
				Cell cell=sh.getRow(i).getCell(j);
				DataFormatter df=new DataFormatter();
				value=df.formatCellValue(cell);
				expDragDownOptions1.add(value);
			}
		}
		
		if(actDragDownOptions1.equals(expDragDownOptions1))
			return true ;
		else
			return false ;
	}
	


}
