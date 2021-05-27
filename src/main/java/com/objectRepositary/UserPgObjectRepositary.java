package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class UserPgObjectRepositary extends PageBase{
	@FindBy(xpath="//button[text()='Add User']")
	public WebElement addUserButton;
	
	@FindBy(tagName="h1")
	public WebElement heading;
	
	@FindBy(xpath="//footer")
	public WebElement footer;
	
	@FindBy(tagName="h3")
	public WebElement subheading;
	
	@FindBy(xpath="//span[text()='Delete']")
	public List<WebElement> deleteBtn;
	
	@FindBy(linkText="LOGOUT")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//p[text()='Kiran']")
	public WebElement kiranHead;
	
	@FindBy(xpath="//span[@class='logo-lg']")
	public WebElement jbk;
	
	@FindBy(xpath="//ol")
	public WebElement homeDashRight;
	
	@FindBy(xpath="//th")
	public List<WebElement>headers;
	
	@FindBy(xpath="//td")
	public List<WebElement>tableData;
	
	@FindBy(xpath="//a[text()=' Online']")
	public WebElement onlineStatus;
	
	@FindBy(tagName="img")
	public WebElement image;
	
	@FindBy(xpath="//li//span")
	public List<WebElement>navigator;
	
	@FindBy(xpath="//td[1]")
	public List<WebElement>srno;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> names;
	
	@FindBy(xpath="//td[3]")
	public List<WebElement>emails;
	
	@FindBy(xpath="//td[4]")
	public List<WebElement>mobiles;
	
	@FindBy(xpath="//td[5]")
	public List<WebElement>course;
	
	@FindBy(xpath="//td[6]")
	public List<WebElement>gender;
	
	@FindBy(xpath="//td[7]")
	public List<WebElement> states;
	
	@FindBy(xpath="//td[8]")
	public List<WebElement> actions;
	
	@FindBy(xpath="//span[contains(@onclick,'alert')]")
	public List<WebElement> row1row3DeleteBtn;
	
	@FindBy(xpath="//span[contains(@onclick,'user')]")
	public List<WebElement> row2row4DeleteBtn;
}
