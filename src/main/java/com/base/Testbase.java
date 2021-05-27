package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.utility.PageBase;

public class Testbase extends PageBase {
	public static WebDriver driver;
	Properties prop;
	
	//public static Logger log = Logger.getLogger(Testbase.class);
	
	public WebDriver initialization(String propertyfileName) throws Exception {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/"+propertyfileName);
		//System.getProperty("user.dir") + "/src/main/resources/config.properties");
				
		prop.load(fis);
		// String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			
			testLog().info("initializing browser");
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			
			testLog().info("chrome browser opened");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			testLog().info("initializing browser");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
			
			testLog().info("mozilla firefox browser opened");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("IE")) {
			testLog().info("initializing browser");
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer.exe");
			
			testLog().info("Internet explorer browser opened");
			driver = new InternetExplorerDriver();
		}
		
		testLog().info("JBK Offline application is launched");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		testLog().info("maximizing browser window");
		driver.manage().window().maximize();
		return driver;
	}
}
