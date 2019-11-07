package com.atmecs.Assessment_automations.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.atmecs.assesssment_automation.reports.LogReport;

public class PageActions {
	LogReport log = new LogReport();
	
	public  void clickWhenElementDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.cssSelector(locator));
		if(element.isDisplayed()) {
			driver.findElement(By.xpath(locator)).click();
		}
		else {
			log.info(element+"Element not found");
		}
		
	}

	public  void selectValuesInDropdownByText(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.cssSelector(locator));
		if(element.isDisplayed()) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
		else {
			log.info(element+"Element not found");
		}
	}

	public  void sendKeys(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.cssSelector(locator));
		if(element.isDisplayed()) {
			element.sendKeys(value);
		}
		else {
			log.info(element+"Element not found");
		}
	}

	public void explictWait(WebDriver driver,String locator) {
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

		
	}
	public void clickWhenElementClickable(WebDriver driver,By locator, int timeout) {
		 		WebElement element = driver.findElement(locator);
		 		WebDriverWait wait = new WebDriverWait(driver, timeout);
		 		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		 		element.click();
		 
		 }
	
}
