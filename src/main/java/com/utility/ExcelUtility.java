package com.utility;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility  {
public static ArrayList<String> getTableColumnData(String fileNm,String sheetNm,int colNo)throws Exception{
	ArrayList<String> expData=new ArrayList<String>();
	String value=null;
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetNm);
	int row=sh.getPhysicalNumberOfRows();
	for (int i = 0; i < row; i++) 
	{
		Cell cell=sh.getRow(i).getCell(colNo);
			DataFormatter df=new DataFormatter();
			value=df.formatCellValue(cell);
			expData.add(value);
			//System.out.println(value);
	}
	return expData;
}
public static ArrayList<String> getExcelTableRowData(String fileNm,String sheetNm)throws Exception{
	ArrayList<String> expData=new ArrayList<String>();
	
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	String value=null;
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetNm);
	int row=sh.getPhysicalNumberOfRows();
	for (int i = 1; i < row; i++) 
	{
		int col=sh.getRow(i).getLastCellNum();
		for (int j = 0; j <col; j++) 
		{
			Cell cell=sh.getRow(i).getCell(j);
			DataFormatter df=new DataFormatter();
			value=df.formatCellValue(cell);
			expData.add(value);
			System.out.print("    "+value);
		}
		System.out.println();
	}
	return expData;
}
public static ArrayList<String> getTableDataFully(String fileNm,String sheetNm)throws Exception{
	
	ArrayList <String>expData = new ArrayList <String>();
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	String value=null;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetNm);
	int row=sh.getPhysicalNumberOfRows();
	
	for (int i = 0; i < row; i++) 
	{
		int col=sh.getRow(i).getLastCellNum();
		for (int j = 0; j <col; j++) 
		{
			Cell cell=sh.getRow(i).getCell(j);
			DataFormatter df=new DataFormatter();
			value=df.formatCellValue(cell);
			expData.add(value);
		}
	}
	return expData;
	}





public static ArrayList<String> getDataOfAnyColumn(String fileNm,String sheetNm,int colNo)throws Exception{
	ArrayList<String> expData=new ArrayList<String>();
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	String value=null;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetNm);
	int row=sh.getPhysicalNumberOfRows();
	
	for (int i = 0; i < row; i++) 
	{
		int col=sh.getRow(i).getLastCellNum();
		for (int j = 0; j <col; j++) 
		{
			Cell cell=sh.getRow(i).getCell(colNo);
			DataFormatter df=new DataFormatter();
			value=df.formatCellValue(cell);
			expData.add(value);
		}
	}
	return expData;
}

//unameCol,passCol only
public static  HashMap<String, String> readUnameAndPass(String fileNm, String sheetName, int unameCol, int passCol) throws Exception{
	HashMap<String, String> data= new HashMap<String, String>();
	DataFormatter df = new DataFormatter();
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	
	int row= sh.getPhysicalNumberOfRows();
	
	for(int i=1;i<row;i++){
		
	String uname =df.formatCellValue(sh.getRow(i).getCell(unameCol));
	String pass =df.formatCellValue(sh.getRow(i).getCell(passCol));
		data.put(uname, pass);
		//System.out.println(data);
		
		}
	return data;
}
//Col1,Col2,col3 only
public static  HashMap<String, List<String>> readUnameAndPass(String fileNm, String sheetName, int Col1, int Col2,int Col3) throws Exception{
	HashMap<String, List<String>> data= new HashMap<>();
	DataFormatter df = new DataFormatter();
	String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	
	int row= sh.getPhysicalNumberOfRows();
	
	for(int i=1;i<row;i++){
		
	String coldata1 =df.formatCellValue(sh.getRow(i).getCell(Col1));
	String coldata2 =df.formatCellValue(sh.getRow(i).getCell(Col2));
	String coldata3=df.formatCellValue(sh.getRow(i).getCell(Col3));
	
	List<String>al=new ArrayList<>();
	al.add(coldata2);
	al.add(coldata3);
		data.put(coldata1, al);
		//System.out.println(data);
		
		}
	return data;
}


//horizontal row heading(headers)
	public static ArrayList<String> readRow(String fileNm, String sheetName, int rowNum) throws Exception{
		ArrayList<String> rowData = new ArrayList<String>();
		String path=System.getProperty("user.dir")+"/src/test/resources/"+fileNm;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row= sh.getRow(rowNum);
		int col=row.getLastCellNum();
		for(int i=0;i<col;i++){
			Cell cell=row.getCell(i);
			DataFormatter df = new DataFormatter();
			rowData.add(df.formatCellValue(cell));
			//System.out.println(df.formatCellValue(cell));
		}
		
		return rowData;
	}


	








}
