package com.atmecs.assessment_automation.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.assessment_automation.testbase.BrowserInvoke;



public class WebTables extends BrowserInvoke{

	public void webTableCellData(int rowno,int cellno) {

		int actualrowno=rowno+2;

		String textfirst  = "#rb-calendar_onward_cal tr:nth-of-type(";
		String textsec    = Integer.toString(actualrowno);
		String textthird  = ")>td:nth-of-type(";
		String textfourth = Integer.toString(cellno);
		String textfifth  =  ")";

		String textfull   = textfirst+textsec+textthird+textfourth+textfifth;
		WebElement celldata = driver.findElement(By.cssSelector("#rb-calendar_onward_cal tr:nth-of-type(4)>td:nth-of-type(5)"));
		String celltext   = celldata.getText();
		System.out.println(celltext);
	}

	public int  webTableRowNo() {
		List  row = driver.findElements(By.cssSelector("div#rb-calendar_return_cal table tbody tr")); 
		System.out.println("No of rows are : " + row.size());
		return row.size();
	}

	public int webTableColNo() {
		List  col = driver.findElements(By.cssSelector("div#rb-calendar_onward_cal table tbody tr:nth-of-type(5) td"));
		System.out.println("No of cols are : " +col.size()); 
		return col.size();
	}
	public void webtablerowvalues(int rowno) {
		String textfirst  = "div#rb-calendar_onward_cal table tbody tr:nth-of-type(";
		String textsec    = Integer.toString(rowno);
		String textthird  = ") td:nth-of-type(";
		List<WebElement> listsize = driver.findElements(By.cssSelector(textfirst+textsec+textthird));
		int size=listsize.size();
		
		for(int listindex = 0;listindex<size;listindex++) {
			String textfourth = Integer.toString(listindex)+")"; 
			List<WebElement>list = driver.findElements(By.cssSelector("div#rb-calendar_onward_cal table tbody tr:nth-of-type(6) td:nth-of-type(1)"));
			driver.findElement(By.cssSelector("div#rb-calendar_onward_cal table tbody tr:nth-of-type(6) td:nth-of-type(1)"));
	  }
	}

}