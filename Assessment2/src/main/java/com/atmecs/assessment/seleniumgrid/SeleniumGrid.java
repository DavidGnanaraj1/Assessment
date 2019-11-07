package com.atmecs.assessment.seleniumgrid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.Assesment_automation.constants.FilePath;
import com.atmecs.assessment_automation.utils.PropertiesFileReader;
import com.atmecs.assesssment_automation.reports.LogReport;





public class SeleniumGrid {
	public WebDriver driver; 
	LogReport log =new LogReport();
	PropertiesFileReader prop = new PropertiesFileReader();

	@BeforeTest
	public void gridMethod() throws IOException {
		prop.loadProperty(FilePath.CONFIG_FILE);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(prop.getData("browser"));		
		String huburl =prop.getData("huburl");
		driver = new RemoteWebDriver(new URL(huburl), cap);
		driver.get(prop.getData("url"));

		log.info("Application is open");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}
