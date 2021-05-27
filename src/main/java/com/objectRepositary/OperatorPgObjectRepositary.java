package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class OperatorPgObjectRepositary extends PageBase {
	@FindBy(xpath="//td[2]")
	public List<WebElement> personNames;
	
	@FindBy(xpath="//td[3]")
	public List<WebElement> helpfor;
	@FindBy(xpath="//td[4]")
	public List<WebElement> preferWay;
	
	@FindBy(xpath="//td[6]")
	public List<WebElement>timings;
	
	@FindBy(xpath="//td[5]")
	public List<WebElement>mob;
	
	@FindBy(xpath="//a[text()=' Online']")
	public WebElement onlineStatus;
	
	@FindBy(xpath="//p[text()='Kiran']")
	public WebElement kiranHead;
	
	@FindBy(tagName="img")
	public WebElement image;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']//span")
	public List<WebElement>navigator;
	
	@FindBy(xpath="//td")
	public List<WebElement>tableData;
	
	@FindBy(xpath="//ol")
	public WebElement homeUserRight;
	
	@FindBy(xpath="//th")
	public List<WebElement>headers;
	
	@FindBy(linkText="LOGOUT")
	public WebElement logoutBtn;
	
	@FindBy(tagName="h1")
	public WebElement heading;
	
	@FindBy(xpath="//footer")
	public WebElement footer;
	
	@FindBy(tagName="h3")
	public WebElement subheading;
}
