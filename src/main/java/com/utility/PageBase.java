package com.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PageBase {
public static Logger logger;

	public Logger testLog(){
		logger=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir") + "/src/main/resources/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return logger;
	}
	
	public Logger pageLog(){
		logger=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir") + "/src/main/resources/log4jPage.properties");
		PropertyConfigurator.configure(path);
		return logger;
	}

}
