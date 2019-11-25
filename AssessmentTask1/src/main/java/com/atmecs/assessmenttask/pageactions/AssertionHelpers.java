package com.atmecs.assessmenttask.pageactions;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecs.assessmenttask.constants.FilePath;
import com.atmecs.assessmenttask.utils.LocatorSeparator;
import com.atmecs.assessmenttask.utils.PropertiesFileReader;

/**
 * This class has methods for various assertion like asserting two string text,
 * verifying the expected page title with the actual page title
 */


/**
 * This method is used for checking the actual 
 */
public class AssertionHelpers {
	LocatorSeparator separatinglocators;
	Properties properties;
	PageActions pageactions;
	
	/**
	 * This constructor loads the locators.properties file
	 */
	public AssertionHelpers() throws IOException {
		
		separatinglocators=new LocatorSeparator();
		properties= new PropertiesFileReader().loadingPropertyFile(FilePath.LOCATORS_FILE);
		pageactions= new PageActions();
	}
	

	/**
	 * This method gets the actual string text from webpage and get the expected string text from the properties
	 *  assert whether actual string texts and expected string texts are equal or not
	 */
	public void assertingStringTexts(WebDriver driver,String actualelementlocator,String expectedelementlocator) throws IOException {
		
		WebElement element =driver.findElement(separatinglocators.separatingLocators(properties.getProperty(actualelementlocator)));
	    String actualvalue=element.getText();
	    String expectedvalue=properties.getProperty(expectedelementlocator);
	    
	    Assert.assertEquals(actualvalue, expectedvalue);
	
}
	

	/**
	 * This method gets the actual pagetitle from webpage and get the expected page title from properties file
	 *  assert whether actual pagetitle and expected pagetitle are equal or not
	 */
	public  void assertingPageTitle(WebDriver driver,String expectedtitlelocator) {

		String actualpagetitle=driver.getTitle();
		String expectedpagetitle=properties.getProperty(expectedtitlelocator);
		Assert.assertEquals(actualpagetitle, expectedpagetitle);
	}
	
	public void assertingArrayWithIndex(WebDriver driver,String expecteddataarraykey,int iterationnumber,int numberofproducts,String actualcommonelementlocator,String verifyingcontent) {
		
		for(int index=0;index<iterationnumber;index++) {
		String expecteddata=properties.getProperty(expecteddataarraykey);
		String expecteddataarray[]=new String[numberofproducts];
		expecteddataarray=expecteddata.split("\\s");
		List<WebElement> actualdata=driver.findElements(separatinglocators.separatingLocators(properties.getProperty(actualcommonelementlocator)));
		
		switch (verifyingcontent) {
			
		    case "innertext":
		    WebElement element=actualdata.get(index);
		    
			element.getText();
			
			case "footerpagetitle":
			pageactions.click();
		}
   	}
	}
   
	
}

