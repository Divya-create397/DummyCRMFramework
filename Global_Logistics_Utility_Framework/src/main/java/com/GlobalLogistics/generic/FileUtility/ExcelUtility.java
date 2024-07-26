package com.GlobalLogistics.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable
	{
		FileInputStream f1=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book=WorkbookFactory.create(f1);
		String data=book.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		book.close();
		return data;
	}
	
	public int getRowCount(String sheetName)throws Throwable
	{
		FileInputStream f1=new FileInputStream("./src/test/resources/testscript1.xlsx");
		Workbook book=WorkbookFactory.create(f1);
		int rowCount=book.getSheet(sheetName).getLastRowNum();
		return rowCount;
		
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream f1=new FileInputStream("./src/test/resources/testscript1.xlsx");
		Workbook book=WorkbookFactory.create(f1);
		book.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream f2=new FileOutputStream("./src/test/resources/testscript1.xlsx");
		book.write(f2);
		book.close();
		
	}

}
