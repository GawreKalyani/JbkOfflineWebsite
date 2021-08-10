package com.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase1 {
	
	 public static WebDriver driver=null;
	 public static Logger log=Logger.getLogger(Testbase1.class);
	 public static  String readProperty(String key)  {
			Properties prop= new Properties();
			try {
				
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return prop.getProperty(key);
		}
	 public WebDriver initialization(){
		 
			log.info("initializing browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
		driver=new ChromeDriver();
		log.info("chrome browser opened");
		driver.get(readProperty("url"));
		log.info("JBK Offline application is launched");
		driver.manage().window().maximize();
		return driver;
		}
}
