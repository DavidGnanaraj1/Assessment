package com.atmecs.assessment_automation.helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;




public class Suites  {


	@SuppressWarnings("deprecation")
	
	@Test

	public  void suitemethod() {

		String[] browser = {"firefox","internet explorer","chrome"};

		List<String> browsernames = new ArrayList<String>();
		for (String browsername : browser) {
			browsernames.add(browsername);
		}
		XmlSuite suite = new XmlSuite();
		suite.setParallel("tests");
		suite.setThreadCount(browsernames.size());

		List<XmlSuite> suites = new ArrayList<XmlSuite>();

		List<XmlClass> class1 = new ArrayList<XmlClass>();

		for (String browser1: browsernames) {
			XmlTest xmlTest = new XmlTest(suite);
			Map<String, String> map = new HashMap<String, String>();
			map.put("browser",browser1);
			xmlTest.setParameters(map);
			xmlTest.setName(browser1);			
			XmlClass xmlClass = new XmlClass(Testscript.class);
			class1.add(xmlClass);
			xmlTest.setXmlClasses(class1);
		}
		TestNG testng = new TestNG();
		suites.add(suite);
		testng.setXmlSuites(suites);
		testng.run();

	}

}