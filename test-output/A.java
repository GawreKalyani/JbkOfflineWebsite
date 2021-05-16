package com.testcases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A {
@Test
public void test01() {
		
		Set <String> expNewWindowUrls = new HashSet <String>();
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/java-j2ee-syllabus-jbk.pdf");		
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/pdf/python-syllabus.pdf");
		expNewWindowUrls.add("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html#");

		Set <String> actNewWindowUrls = new HashSet <String>();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();// browser open
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		
				driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");// entering a text in to text box
				driver.findElement(By.id("password")).sendKeys("123456");
				driver.findElement(By.xpath("//button")).click();
				String mainWindow= driver.getWindowHandle();
				List<WebElement>links = driver.findElements(By.partialLinkText("More"));
				for(WebElement link : links) {
					link.click();// 5 wins are opened
				}
				Set<String> wins= driver.getWindowHandles();
				for(String name: wins) {
					if(!name.equals(mainWindow)) {
						driver.switchTo().window(name);
						actNewWindowUrls.add(driver.getCurrentUrl());
					}
				}
				Assert.assertEquals(actNewWindowUrls, expNewWindowUrls);
}
}
