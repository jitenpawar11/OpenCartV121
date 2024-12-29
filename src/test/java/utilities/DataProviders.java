package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String excelfilepath = ".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(excelfilepath);
		
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		//Created two dimension array which can store the data user and password
		
		String logindata[][] = new String[totalrows][totalcols];
		
		//Read the data from excel file and store in a two dimensional array
		
		for(int r=1;r<=totalrows;r++)
		{
			for(int c=0;c<totalcols;c++)
			{
				logindata[r-1][c]=xlutil.getCellData("Sheet1", r, c);         //r=1, c=0
			}
		}
		
		return logindata;  //returning two dimension array
	}
	
	
	    //DataProvider 2
	
		//DataProvider 3
		
		//DataProvider 4


}
