package com.atmecs.assessment.dynamictestng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.Assesment_automation.constants.FilePath;
import com.atmecs.Assessment_automations.pageactions.PageActionsScrollDown;
import com.atmecs.assessment_automation.helpers.WebTables;
import com.atmecs.assessment_automation.testbase.BrowserInvoke;
import com.atmecs.assessment_automation.utils.PropertiesFileReader;

public class Testscript2 extends BrowserInvoke {
	@Test
		public void listofWebElements() throws IOException {
//					PageActionsScrollDown scroll= new PageActionsScrollDown();
//				    scroll.scrollDown
			//		PropertiesFileReader prop = new PropertiesFileReader();
			//		prop.loadProperty(FilePath.LOCATORS_FILE);
			List<WebElement> list = driver.findElements(By.cssSelector(".menu-horizontal-02 ul li a"));
			System.out.println(list.size());
			String array[] = new String[list.size()];
			//		for(WebElement elements:list) {
			//			String text=elements.getText();
			//			System.out.println(text);}
			for (int i = 0; i < list.size(); i++) {
				array[i] = list.get(i).getText();
				System.out.println(array[i]);
			}
			String arrayactual[] = new String[list.size()];
			String arrayact = "Hotels,Flights,Tours,Transfer,Visa";

			String []arrayvaluesact = new String[list.size()];
			arrayvaluesact=arrayact.split(",");
			for (int i = 0; i < list.size(); i++) {

				System.out.println(arrayvaluesact[i]);
				//			if(!(arrayvaluesact[i].equalsIgnoreCase(array[i]))) {
				//				System.out.println("footers not matching");
				//				}
				Assert.assertTrue(arrayvaluesact[i].equalsIgnoreCase(array[i]),"passed");

				//			File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				//		       FileUtils.copyFile(shot, new File("C:\\ shot1.jpg"));
			}

			driver.close();
		}

		//@Test
		public void webTables() throws IOException {
			//exttest = extent.startTest("webTables");
			PropertiesFileReader prop = new PropertiesFileReader();
			prop.loadProperty(FilePath.LOCATORS_FILE);
			PageActionsScrollDown pageactions= new PageActionsScrollDown();
			//pageactions.scrollUptoElement(driver, driver.findElement(By.cssSelector(prop.getData("loc.actions"))));
			WebTables webtable= new WebTables();
			driver.findElement(By.cssSelector(".fl.icon-calendar_icon-new.icon-onward-calendar.icon")).click();
			//webtable.webTableCellData(5,5);
			webtable.webTableColNo();
			webtable.webTableRowNo();
			//exttest.log(LogStatus.PASS, "All details are validated"); 
		}


}
