package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.objectRepositary.AddUserPgObjectRepositary;
import com.utility.ExcelUtility;
import com.utility.Utility;

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
		Utility.sendkeys(username,"Alihan");
		Utility.sendkeys(mob,"9876673773");
		Utility.sendkeys(email,"alihan@gmail.com");
		Utility.sendkeys(course,"Selenium");
		
		Utility.click(maleradio); //radio button
		
		Utility.selectBy(selectstate,"Maharashtra");
		
		Utility.sendkeys(pass, "jhh");
		Utility.click(submitbutton);
		
		String actMsg=Utility.alertHandle(driver);
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
		
		ArrayList <String> expDragDownOptions1=ExcelUtility.getTableColumnData("Data.xlsx", "statelist", 0);
		
		Select states = new Select(selectstate);
		
		List <WebElement> list = states.getOptions();
		
		for(WebElement element : list)
		{
			actDragDownOptions1.add(element.getText());
		}
	
		if(actDragDownOptions1.equals(expDragDownOptions1))
			return true ;
		else
			return false ;
	}
	


}
