package com.hrm.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ContactDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		LibraryHrm lb = new LibraryHrm();
		LibraryHrm.Launch_Url("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		LibraryHrm.Admin_Login("Admin", "admin123");

		FileInputStream fis = new FileInputStream(
				"D:\\Practice Programs (Selenium)\\OrangeHrmExcelDataDiven2\\src\\com\\hrm\\testdata\\Data2Sample.xlsx");

//Workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
//WorkSheet
		XSSFSheet ws = wb.getSheet("cDetails");
//Row count
		int rCount = ws.getLastRowNum();
		System.out.println(rCount);
//loop-row
		for (int i = 1; i <= rCount; i++) {
			XSSFRow wr = ws.getRow(i);

			// cell
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.getCell(4);
			XSSFCell wc5 = wr.getCell(5);
			XSSFCell wc6 = wr.getCell(6);
			XSSFCell wc7 = wr.createCell(7);

			String st1 = wc.getStringCellValue();
			String st2 = wc1.getStringCellValue();
			String ct = wc2.getStringCellValue();
			String zp = wc3.getStringCellValue();
			String cnty = wc4.getStringCellValue();
			String mb = wc5.getStringCellValue();
			String ml = wc6.getStringCellValue();

			String res = LibraryHrm.myInfo(st1, st2, ct, zp, cnty, mb, ml);
			System.out.println(res);
			wc7.setCellValue(res);
		}
		FileOutputStream fos = new FileOutputStream(
				"D:\\Practice Programs (Selenium)\\OrangeHrmExcelDataDiven2\\src\\com\\hrm\\result\\cdetail1.xlsx");
		wb.write(fos);
		wb.close();

	}

}
