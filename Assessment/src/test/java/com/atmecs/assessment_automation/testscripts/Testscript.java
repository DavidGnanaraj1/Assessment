package com.atmecs.assessment_automation.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebElement;


import org.testng.annotations.Test;

import com.atmecs.Assesment_automation.constants.FilePath;
import com.atmecs.Assessment_automations.pageactions.PageActions;
import com.atmecs.Assessment_automations.pageactions.PageActionsScrollDown;
import com.atmecs.assessment.seleniumgrid.SeleniumGrid;
import com.atmecs.assessment_automation.testbase.BrowserInvoke;
import com.atmecs.assessment_automation.utils.PropertiesFileReader;
import com.atmecs.assessment_automation.utils.TestDataProvider;



public class Testscript extends BrowserInvoke{

	int adultno = 10, childno = 15, infantno = 20;

	//	@BeforeTest
	//	public void startReports() {
	//		startReport();
	//	} 

	@Test(dataProvider="Php travels",dataProviderClass=TestDataProvider.class)
	public void validation(String fromcityname,String tocityname ) throws IOException {
		PropertiesFileReader prop = new PropertiesFileReader();
		prop.loadProperty(FilePath.LOCATORS_FILE);
		PageActions pageactions = new PageActions();
		PageActionsScrollDown scroll= new PageActionsScrollDown();
		
		WebElement adultplusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.adultplusbtn")));
		scroll.scrollUptoElement(driver,adultplusbtn);
		WebElement adultminusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.adultminusbtn")));
		WebElement childplusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.childplusbtn")));
		WebElement childminusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.childminusbtn")));
		WebElement infantplusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.infantplusbtn")));
		WebElement infantminusbtn = driver
				.findElement(By.cssSelector(prop.getData("loc.infantminusbtn")));

		//pageactions.clickWhenElementDisplayed(driver,prop.getData("loc.flightslinktext"));
		driver.findElement(By.cssSelector(prop.getData("loc.flightslinktext"))).click();
//		WebElement
//		fromcity=driver.findElement(By.cssSelector(prop.getData("loc.fromcitysearchinputbox")));
//		fromcity.click();
//		fromcity.sendKeys(fromcityname);
//
//		WebElement
//		tocity=driver.findElement(By.cssSelector(prop.getData("loc.tocitysearchinputbox")));
//		fromcity.click();
//		fromcity.sendKeys(tocityname);

		WebElement adulttext = driver
				.findElement(By.cssSelector(prop.getData("loc.adulttext")));
		JavascriptExecutor execute = (JavascriptExecutor) driver;

		for (int adultnoindex = 0;adultnoindex < adultno;adultnoindex++) {
			adultplusbtn.click();
			driver.findElement(By.cssSelector(prop.getData("loc.outerarea"))).click();

			String sText = execute.executeScript(
					"return document.querySelector(\".row.gap-5 div.col-4:nth-child(1) input\").value;")
					.toString();
			System.out.println(sText);
		}

		for (int chilldnoindex = 0; chilldnoindex < childno; chilldnoindex++) {
			childplusbtn.click();
			driver.findElement(By.cssSelector(prop.getData("loc.outerarea"))).click();
		}

		for (int infantnoindex = 0; infantnoindex< infantno;infantnoindex++) {
			infantplusbtn.click();
			driver.findElement(By.cssSelector(prop.getData("loc.outerarea"))).click();
		}

	}
	//driver.close();
}



