package com.atmecs.assessmenttask.pageactions;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.assessmenttask.constants.FilePath;
import com.atmecs.assessmenttask.reports.LogReport;
import com.atmecs.assessmenttask.utils.LocatorSeparator;
import com.atmecs.assessmenttask.utils.PropertiesFileReader;

public class PhptravelsHelpers {
	Properties properties;
	PageActions pageactions;
	Properties testdata;
	LocatorSeparator separatelocator;
	LogReport log;
	AssertionHelpers assertionhelpers;
	int numberofdetails =3;
	PageActionsScrollDown pageactionsscrolldown;
	
	public PhptravelsHelpers() throws IOException {
		
	    pageactions = new PageActions();
	    properties=new PropertiesFileReader().loadingPropertyFile(FilePath.LOCATORS_FILE);
	    testdata=new PropertiesFileReader().loadingPropertyFile(FilePath.EXPECTEDDATA_FILE);
	    pageactionsscrolldown= new PageActionsScrollDown();
	    separatelocator= new LocatorSeparator();
	    log= new LogReport();
	    assertionhelpers= new AssertionHelpers();
	}
	
	public void invoiceDetailsValidation(WebDriver driver,int randomnumber)
	{
	   
   	    String myaccountpageinvoicedetails[]=new String[numberofdetails+1];
	    String invoicepageinvoicedetails[]= new String[numberofdetails+1];
		String myaccountpagebookingidlocatorfirstpart=properties.getProperty("loc.myaccountpagebookingidlocatorfirstpart");
		String myaccountpagebookingidlocatorsecondpart=Integer.toString(randomnumber);
		String myaccountpagebookingidlocatorthirdpart=properties.getProperty("loc.myaccountpagebookingidlocatorthirdpart");
		String myaccountpagebookingidtextfulltext =myaccountpagebookingidlocatorfirstpart+myaccountpagebookingidlocatorsecondpart+myaccountpagebookingidlocatorthirdpart;
		WebElement myaccountpagebookingidelment= driver.findElement(By.xpath(myaccountpagebookingidtextfulltext));
	
		pageactionsscrolldown.pageScrollDownTillElementVisible(driver,myaccountpagebookingidelment);
		
	    for(int detailsindex=1;detailsindex<=numberofdetails;detailsindex++) {
	    	
		WebElement myaccountpageinvoicealldetails=driver.findElement(By.xpath("((//span[@class='grey'])["+randomnumber+"]/child::strong)["+(detailsindex+"]")));
		myaccountpageinvoicedetails[detailsindex] =myaccountpageinvoicealldetails.getText();
		System.out.println(myaccountpageinvoicedetails[detailsindex]);
	    }
	    myaccountpageinvoicedetails[numberofdetails]=driver.findElement(By.xpath(properties.getProperty("loc.myaccountpageinvoicestatusfirstpart")+randomnumber+"]")).getText();
		List<WebElement> invoicebutton=driver.findElements(separatelocator.separatingLocators(properties.getProperty("loc.invoicebuttonn")));
		invoicebutton.get(randomnumber).click();
	
		}
	}

