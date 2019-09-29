package com.OvenStory.Assignment.base;

import java.io.FileInputStream;
import java.util.Properties;



public class Lib implements IAutoConstant{
	
	
	
	
	
	public static String getProperty (String CONFIG_PATH, String key) {
		String property = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			property = prop.getProperty(key);
		} 
		catch (Exception e) {
		}

		return property;
		
	}
	
	
}
