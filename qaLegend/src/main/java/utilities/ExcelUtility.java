package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.Constants;

public class ExcelUtility {
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sh;
	public static String getStringData(int row,int col,String sheet)  {
		try {
		//String path =Constants.HOME_DIRECTORY+Constants.TESTDATA_EXCELPATH;
		file = new FileInputStream("C:\\Users\\Basil\\git\\Selenium_Learning\\qaLegend\\src\\test\\resources\\DataFile.xlsx");
		workbook =new XSSFWorkbook(file);
		sh= workbook.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c =r.getCell(col);
		return c.getStringCellValue();
		} catch (Exception e ) {
			
			throw new RuntimeException("Excel Sheet not found");
		}
	}

	
public static String getIntegerData(int row,int col,String sheet)  {
	try {
		
	
		file = new FileInputStream("C:\\Users\\Basil\\git\\Selenium_Learning\\qaLegend\\src\\test\\resources\\DataFile.xlsx");
		workbook =new XSSFWorkbook(file);
		sh= workbook.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c =r.getCell(col);
		int cellvalue = (int) c.getNumericCellValue();
		return String.valueOf(cellvalue);
	} catch (Exception e) {
		throw new RuntimeException("Excel Sheet not found");
	}
		
}
}