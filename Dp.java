package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import base.BaseClass;

public class Dp extends BaseClass{

	public static String[][] POI(String SheetName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb1 = new XSSFWorkbook("./data/"+SheetName+".xlsx");
		XSSFSheet ws1 = wb1.getSheet("sheet1");
		//get row count
		int rc = ws1.getLastRowNum();
		//get column count
		int cc = ws1.getRow(0).getLastCellNum();
		String[][] D = new String[rc][cc];
		for (int i = 1; i <= rc; i++) {
			for (int j = 0; j < cc; j++) {
				String data = ws1.getRow(i).getCell(j).getStringCellValue();
				// System.out.println(data);
				D[i - 1][j] = data;
			}
}
		wb1.close();
		//System.out.println("Create inputs are : " + D);
		return D;
	
	}
}
	
