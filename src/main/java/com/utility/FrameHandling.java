package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandling {
	
	public static WebDriver driver;
	
	public static void frame(int index){
		//to pass the value of ID attribute as a parameter.
		driver.switchTo().frame(index);
	}
	
	public static void frame(String nameAttributeValue){
		//to pass the value of NAME attribute
		
		driver.switchTo().frame("nameAttributeValue");
	}
	
	public static void frame(WebElement frameElement){
	//any of the 8 locating strategies to locate an iframe element and pass the reference to switchTo().frame() method.	
		driver.switchTo().frame("frameElement");
	}
}
