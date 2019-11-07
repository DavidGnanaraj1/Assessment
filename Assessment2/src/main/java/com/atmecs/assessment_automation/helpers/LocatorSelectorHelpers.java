package com.atmecs.assessment_automation.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.assesssment_automation.reports.LogReport;

public class LocatorSelectorHelpers {
	LogReport log = new LogReport();
	
 	public By locatorSelector(String locator) {
		By by = null;
		String[] locators = locator.split(",");

		switch (locators[0].toUpperCase()) {
		
case "ID":
	by = By.id(locators[1]);
		break;
case "NAME":
		by = By.name(locators[1]);
		break;
case "CLASSNAME":
        by = By.className(locators[1]);
		break;
case "LINKTEXT":
		by = By.linkText(locators[1]);
		break;
case "PARTIALLINKTEXT":
		by = By.partialLinkText(locators[1]);
		break;
case "XPATH":
		by = By.xpath(locators[1]);
		break;
case "CSS":
		by = By.cssSelector(locators[1]);
		break;

		
		}
		return by;
		}

	
		}

