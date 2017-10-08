package com.automation.excelhelper;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {

	 public  String[][] data;
	 public	 XSSFCell x;
	 public   XSSFWorkbook workbook;
	 public  String Path;
	 public   String Sheetname;
	 public XSSFSheet sheets;
	 private XSSFRow row;
	 
	 
	
	 public ExcelDriven(String excelname, String sheetname) {
		 
		 try {
			workbook = new XSSFWorkbook(new FileInputStream(excelname));
		} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		 sheets = workbook.getSheet(sheetname);
	 }
	 
	public  String[][] DataProviderExcel() 
	 {
			  try 
			  {
					   int rowcount = sheets.getLastRowNum(); //how many instances to be loaded
					   int cellcount = sheets.getRow(0).getLastCellNum();  //how many data for each instance
					  data = new String[rowcount][cellcount];
					   for (int i = 1; i <=rowcount; i++) 
					   
					   {
					    XSSFRow r = sheets.getRow(i);
					      for (int j = 0; j < cellcount; j++) 
					      {
					          XSSFCell d = r.getCell(j);
					          
					          if (d != null) {
					     
					              d.setCellType(CellType.STRING);
					         
					              data[i-1][j] = d.getStringCellValue();
					          }
					              else
					            	  data[i-1][j] = "";
					      }
					   }
					   return data;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				
					System.out.println(e.getMessage());
				return data;
			}
			  
	  }


	 public int getLastRowNum(){
		 
		return sheets.getLastRowNum();
		 
	 }
	 
	 public void getRow(int i){
		 
		row = sheets.getRow(i);
	 }
	 
	 public short getLastCellNum(){
		 
		return row.getLastCellNum();

	 }

	 public String getCellData(int i){
		 

		 return row.getCell(i).getStringCellValue();
	 }
	 
	 public void closeworkbook() throws IOException{
		 
			workbook.close();
	 }
	 


}