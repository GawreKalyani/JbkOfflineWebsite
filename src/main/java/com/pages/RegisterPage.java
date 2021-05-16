package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.objectRepositary.RegisterPgObjectRepositary;

public class RegisterPage extends RegisterPgObjectRepositary {
	WebDriver driver;

	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getUrl()
	{
		String expectedUrl = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html" ; 
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
	public boolean getTitleOfPage() 
	{ 	
		String expectedTitle = "JavaByKiran | Registration Page" ; 
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
	public boolean heading() 
	{ 	
		String actualHeading = heading1.getText();
		String expectedHeading = "Java By Kiran" ;
		
		if(actualHeading.equals(expectedHeading))
		{
			System.out.println("Heading is matched");
			return true ;
		}
		else 
		{
			System.out.println("Heading not matched");
			return false ;
		}
	}
	public boolean alreadyMemberText() 
	{ 	
		String actualAlreadyMemberLinkText = alreadyMember.getText();
		String expectedAlreadyMemberLinkText = "I already have a membership" ;
		
		if(actualAlreadyMemberLinkText.equals(expectedAlreadyMemberLinkText))
		{
			System.out.println("Text is matched");
			return true ;
		}
		else 
		{
			System.out.println("Text not matched");
			return false ;
		}
	}
	public boolean placeholders() 
	{ 	
		ArrayList <String>actPlaceholderText = new ArrayList <String>();
		
		ArrayList <String>expPlaceholderText = new ArrayList <String>();
		expPlaceholderText.add("Name");
		expPlaceholderText.add("Mobile");
		expPlaceholderText.add("Email");
		expPlaceholderText.add("Password");
		
		for (WebElement element : placeholdersList)
		{
			actPlaceholderText.add(element.getAttribute("placeholder"));
		}
		
		if(actPlaceholderText.equals(expPlaceholderText))
		{
			System.out.println("Placeholders are matched");
			return true ;
		}
		else 
		{
			System.out.println("Placeholders are not matched");
			return false ;
		}
	}
	public boolean validSignIn() 
	{
		name.sendKeys("Alisha");
		mobile.sendKeys("9666666612");
		uname.sendKeys("alisha@gmail.com");
		pass.sendKeys("123999");
		loginButton.click();
		
		Alert al = driver.switchTo().alert();
		String alMessage = al.getText();
		al.accept();
		
		if(alMessage.equals("User registered successfully."))
		{
			System.out.println("Registered successfully.");
			return true ;
		}
		else 
		{
			System.out.println("Registered unsuccessfully.");
			return false ;
		}
	}
	public boolean invalidDataEntry()
	{
				name.clear();
				mobile.clear();
				uname.clear();
				pass.clear();
				name.sendKeys("uo");
				mobile.sendKeys("96");
				uname.sendKeys("ali");
				pass.sendKeys("1239");
				loginButton.click();
		
		Alert al = driver.switchTo().alert();
		String alMessage = al.getText();
		al.accept();
		
		if(alMessage.equals("User registered successfully."))
		{
			System.out.println("Registered successfully.");
			return true ;
		}
		else 
		{
			System.out.println("Registered unsuccessfully.");
			return false ;
		}
	}
	
	public boolean alreadyMemberLink() 
	{ 
		alreadyMember.click();
		
		String expectedTitle = "JavaByKiran | Log in" ; 
		String actualTitle = driver.getTitle() ;
		
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Link is Working Properly");
			return true ;
		}
		else 
		{
			System.out.println("Link is not Working Properly");
			return false ;
		}
	}
	
public boolean getRegPgErrorMsg(){
	name.clear();
	mobile.clear();
	uname.clear();
	pass.clear();
	name.sendKeys("");
	mobile.sendKeys("");
	uname.sendKeys("");
	pass.sendKeys("");
	loginButton.click();
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("Please enter Name.");
	expData.add("Please enter Mobile.");
	expData.add("Please enter Email.");
	expData.add("Please enter Password.");
	ArrayList<String>actData=new ArrayList<String>();
	for(WebElement ele:rgErrormsg){
		String text=ele.getText();
		actData.add(text);
		System.out.println(text);
	}
	if(actData.equals(expData))
		return true;
	else
		return false;
				
}

}
