package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class AddUserPgObjectRepositary extends PageBase {
	
	@FindBy(xpath="//button//preceding::label")
	public List<WebElement> labels;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="mobile")
	public WebElement mob;

	@FindBy(id="course")
	public WebElement course;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(xpath="//input[@value='Male']")
	public WebElement maleradio;

	@FindBy(xpath="//input[@value='Female']")
	public WebElement femaleradio;
	
	@FindBy(xpath="//select")
	public WebElement selectstate;

	@FindBy(xpath="//button[text()='Submit']")
	public WebElement submitbutton;
	
	@FindBy(xpath = "//option[@value='Maharashtra']")
	public WebElement maharashtra;
	
	@FindBy(xpath = "//option[@value='Delhi']")
	public WebElement Delhi;
	
	@FindBy(xpath = "//option[@value='HP']")
	public WebElement HP;
	
	@FindBy(xpath = "//option[@value='Punjab']")
	public WebElement Punjab;
	
}
