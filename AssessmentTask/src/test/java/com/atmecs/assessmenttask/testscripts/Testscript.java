package com.atmecs.assessmenttask.testscripts;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.assessmenttask.constants.FilePath;
import com.atmecs.assessmenttask.pageactions.PageActions;
import com.atmecs.assessmenttask.testbase.TestBase;
import com.atmecs.assessmenttask.utils.PropertiesFileReader;




public class Testscript extends TestBase {
	Properties properties;
	PageActions pageactions;
	
	
	public Testscript() throws IOException {
		PropertiesFileReader property ;
	    pageactions = new PageActions();
	    properties=new PropertiesFileReader().loadingPropertyFile(FilePath.LOCATORS_FILE);
	}
	
	@Test
	public void bookingAutomation() throws IOException {
	
		pageactions.clickingTheElement(driver,properties.getProperty("loc.english"));
	    String str = "GeeksForGeeks"; 
	    char[] ch = str.toCharArray(); 
	    for(char c:ch) {
	    	System.out.println(c);
	    }
	    Date date = new Date();
	 
       }
}
