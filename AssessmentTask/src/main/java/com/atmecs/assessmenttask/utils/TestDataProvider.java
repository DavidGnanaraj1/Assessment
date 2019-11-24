package com.atmecs.assessmenttask.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.assessmenttask.constants.FilePath;
  
/**
 * This class is used for running the testscript multiple times 
 * for data in each row starting from the rowindex 1 provided in the testdata file
 */
public class TestDataProvider {
	String path;
	ExcelFileReader readExcel;
   
	@DataProvider(name = "login")
	public Object[][] providingTestData() throws IOException {
		readExcel = new ExcelFileReader(FilePath.TESTDATA_FILE);
		int sheetindex = 0;
		int rownumber = 1;
		int rowcount = readExcel.countingTheNumberOfRows(sheetindex);
		int colcount = readExcel.countingTheNumberOfColumns(sheetindex, rownumber);

		Object[][] excelfiledata = new Object[rowcount][colcount];

		for (int rowindex = 0; rowindex < rowcount; rowindex++) {
			for (int columnindex = 0; columnindex < colcount; columnindex++) {

				  excelfiledata[rowindex][columnindex] = readExcel.gettingExcelFileData(sheetindex, rowindex + 1,
						columnindex);
			}
		}
		return excelfiledata;
	}
}
