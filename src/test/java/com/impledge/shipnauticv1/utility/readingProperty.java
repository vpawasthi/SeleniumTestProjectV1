package com.impledge.shipnauticv1.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readingProperty {
	
	static String sPropertyValue=null;
	
	    public  static String   getSingleProperty (String  propertyKey) {

	        	try {

		        		String sPath="D:\\eclipse-workspace\\shipnauticv1\\src\\test\\java\\com\\impledge\\shipnauticv1\\config\\";
		        		String sFileName="config.properties";
	        		
			        	InputStream input = new FileInputStream(sPath+sFileName);
			        	
			        	Properties prop = new Properties();
		
			        
			            // load a properties file
			            prop.load(input);
		
			            // get the property value and print it out
			            System.out.println(prop.getProperty("browserDriver.Browser"));
			            
			            return sPropertyValue= prop.getProperty(propertyKey);
			
	            
	        	} catch (IOException ex) {
	        		ex.printStackTrace();
	        
	        }
	        	return sPropertyValue;
	    }
}
	


