package com.atmecs.assessment_automation.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.Assesment_automation.constants.FilePath;
import com.atmecs.assessment_automation.testbase.BrowserInvoke;


public class TestDataProvider extends BrowserInvoke {



	@DataProvider(name = "Php travels")
	public Object[][] testData() throws IOException
	{


		ExcelReader readExcel = new ExcelReader(FilePath.TESTDATA_FILE);
		int sheetIndex = 0;

		int rowNum = readExcel.rowCounting(sheetIndex);
		int colNum = readExcel.columnCounting(sheetIndex);



		Object[][] details = new Object[rowNum][colNum];

		for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
			for (int colIndex = 0; colIndex < colNum; colIndex++) {

				details[rowIndex][colIndex] = readExcel.getData(sheetIndex, rowIndex + 1, colIndex);
			}
		}
		return details;
	}

}