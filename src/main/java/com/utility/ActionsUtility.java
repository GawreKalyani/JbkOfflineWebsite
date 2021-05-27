package com.utility;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {
	WebDriver driver;
	
	public static void robotAction(int key)
	{
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		robot.keyPress(key);
		
	}
	public static void actionsToPerform(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
}
