package com.atmecs.assessment_automation.testbase;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.Assesment_automation.constants.FilePath;
import com.atmecs.assessment_automation.helpers.Suites;
import com.atmecs.assessment_automation.utils.PropertiesFileReader;
import com.atmecs.assesssment_automation.reports.ExtentReport;
import com.atmecs.assesssment_automation.reports.LogReport;
import com.relevantcodes.extentreports.ExtentReports;


public class BrowserInvoke extends Suites{
    public  WebDriver driver;
@SuppressWarnings("deprecation")
@Parameters("browser")
@BeforeTest
public  void browserInvoke() throws IOException {
	
    PropertiesFileReader prop = new PropertiesFileReader();
	prop.loadProperty(FilePath.CONFIG_FILE);
	String browser = prop.getData("browser");
    LogReport log = new LogReport();
	String url =prop.getData("url");
	System.out.println(browser);
	
	switch (browser) {
	
	case "chrome":
		System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
		driver = new ChromeDriver();
		log.info("Chrome browser opens");
		break;

	case "firefox":
		System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_FILE);
		driver = new FirefoxDriver();
	    log.info("Firefox browser opens");
		break;
		
	case "internet explorer":
		System.setProperty("webdriver.ie.driver", FilePath.IE_FILE);
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
		driver = new InternetExplorerDriver(capabilities);
	    log.info("IE browser opens");
		break;
	}
	
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();

}
}
