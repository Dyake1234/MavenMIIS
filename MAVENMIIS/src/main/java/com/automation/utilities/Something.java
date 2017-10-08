package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Something {
	
	public static String Excelpropertieslocation ="D:\\MavenProjects\\MAVENMIIS\\src\\main\\java\\utilities\\Excel.properties";
	public static Properties prop = new Properties();
	
	 public static void  main(String[] args) throws IOException, InvalidFormatException{
			
		 
		 
	
System.out.println("ha");
		 prop.load(new FileInputStream(Excelpropertieslocation));

 
/*		 ExcelDriven excel = new ExcelDriven();

		 String beans =  prop.getProperty("Excelpath");
		 String bean =	 prop.getProperty("UnitofMeasure");
		 
		 System.out.println(beans+bean);
		 excel.setWorkbook(beans);
		 excel.setSheet(bean);
		 
		 ArrayList<String> list = new ArrayList<String> ();
		 
			for(int i =1 ; i<excel.getLastRowNum()+1;i++)
			{
				excel.getRow(i);

					for (int d = 0; d<excel.getLastCellNum();d++)
					{
							list.add(excel.getCellData(d));	
					}
			}
	
	
			
			System.out.println(list);*/

//	excel.closeworkbook();


		 
	
	
	
}
}


