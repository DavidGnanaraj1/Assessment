package com.atmecs.assessmenttask.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.assessmenttask.constants.FilePath;

/**
 * This class is used to read the excel file's particular cell data and
 * get the row count and column count of the excel file 
 */

public class ExcelFileReader {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	File file;
	String path;

	/**
	 * This constructor will get the filepath of the testdata file
	 * and create the Xssfworkbook object
	 */
	public ExcelFileReader(String filepath) throws IOException {
		
		File file = new File(filepath);
		FileInputStream fileinput = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileinput);
	}

	/**
	 * This method will return the value of the particular cell from the excel file
	  */
	public String gettingExcelFileCellValue(int index, int rownumber, int cellnumber) {
	
		sheet = workbook.getSheetAt(index);
		String data = sheet.getRow(rownumber).getCell(cellnumber).getStringCellValue();
		return data;
	}

	/**
	 * This method will return the total number of rows in an excel file
	  */
	public int countingTheNumberOfRows(int sheetindex) {
		
		int rowcount = workbook.getSheetAt(sheetindex).getLastRowNum();
		return rowcount;
	}

	/**
	 * This method will return the total number of column in an  excel file
	  */
	public int countingTheNumberOfColumns(int sheetindex,int rownum) {
	
		int columncount = workbook.getSheetAt(sheetindex).getRow(1).getLastCellNum();
		return columncount;
	}
    
	
	public String gettingExcelFileData(int sheetindex, int rownumber, int columnnumber) {

		int index;
		String[] array = new String[30];
		for (index = rownumber; index < array.length; index++) {
			array[index - 1] = gettingExcelFileCellValue(sheetindex, index, columnnumber);
		}
		return array[index - 1];
	}

	public static void main(String[] args) throws IOException{
	
		ExcelFileReader readexcelfile = new ExcelFileReader(FilePath.TESTDATA_FILE);
		readexcelfile.countingTheNumberOfRows(0);
		readexcelfile.countingTheNumberOfColumns(0,1);

	}
}
