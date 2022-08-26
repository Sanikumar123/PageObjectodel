package com.w2a.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class ExcelReader extends TestBase {

	
    public static Object[][] readData(String path, String sheetname) throws IOException 
    {
    
      FileInputStream fin = new FileInputStream(path);
      XSSFWorkbook workbook = new XSSFWorkbook(fin);
      XSSFSheet sheet = workbook.getSheet(sheetname);
      XSSFRow row = sheet.getRow(1);
      int rownum=sheet.getLastRowNum();
      int colnum=row.getLastCellNum();
      
      Object[][] data = new Object[rownum][colnum];

      
      for(int i=0;i<sheet.getLastRowNum();i++)
      {
    	  for(int j=0;j<row.getLastCellNum();j++)
    	  {
    		  data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();

    	  }
      }
      
     // System.out.println(sheet.getLastRowNum());
     // System.out.println(row.getLastCellNum());
      
     return data;
	
    }
}
