package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPgObjectRepositary {
	@FindBy(tagName="h1")
	public WebElement dashHeading;
	
	@FindBy(xpath="//p[text()='Kiran']")
	public WebElement kiranHead;
	
	@FindBy(xpath="//a[text()='JavaByKiran']")
	public WebElement javaByKiranLink;

	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement dashboard;
	
	@FindBy(xpath = "//a[text()='JavaByKiran']")
	public WebElement jbkLink;
	
	@FindBy(xpath="//footer")
	public WebElement footer;
	
	@FindBy(xpath="//a[text()=' Online']")
	public WebElement onlineStatus;
	
	@FindBy(xpath="//ol")
	public WebElement seqHD;
	
	@FindBy(tagName="img")
	public WebElement image;
	
	@FindBy(xpath="//b[contains(text(),'By')]")
	public WebElement heading1;
	
	@FindBy(linkText="LOGOUT")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//span[text()='Users']")
	public WebElement userBtn;
	
	@FindBy(xpath="//span[text()='Operators']")
	public WebElement operatorBtn;
	
	@FindBy(xpath="//span[contains(text(),'Links')]")
	public WebElement usefulLinkBtn;
	
	@FindBy(xpath="//span[contains(text(),'Do')]")
	public WebElement downloadsBtn;
	
	@FindBy(tagName="h3")
	public List<WebElement> courses;
	
	@FindBy(xpath="//h3//following::p")
	public List<WebElement> subcourse; 
	
	@FindBy(partialLinkText="More info")
	public List<WebElement> moreinfo;

	@FindBy(xpath="//li//span")
	public List<WebElement> navigator;
	
	
}
