package com.atmecs.Assessment_automations.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.assesssment_automation.reports.LogReport;




public class PageActionsCheckAvailablity {

  LogReport log = new LogReport();

	public  void validateProduct(WebDriver driver,String path) {
	boolean isDisplayed=driver.findElement(By.xpath(path)).isDisplayed();
	
	if(isDisplayed==true)
	{
		log.info("Yellow tie dye bardot bodycon mini dress is present");
	}
	else
	{
		log.info("Yellow tie dye bardot bodycon mini dress is not present");
	}
	}
}
