package com.utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class RadioButtonUtility {
	
	public static void clickRadioButton(List<WebElement>elements,String text)
	{	for(WebElement element:elements){
				if(element.getAttribute("value").equals(text))
				{
					element.click();
					break;
				}
		}
		
	}
	public static void clickRadioButton(String text,List<WebElement>elements)
	{	for(WebElement element:elements){
				if(element.getText().equals(text))
				{
					element.click();
					break;
				}
		}
		
	}
}
