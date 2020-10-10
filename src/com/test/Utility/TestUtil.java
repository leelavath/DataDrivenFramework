package com.test.Utility;

import java.util.ArrayList;

import com.excel.Utility.XLS_Reader;




public class TestUtil {
	static XLS_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel () {
		
		ArrayList<Object[]> exceltestData=new ArrayList<Object[]>();   //In Object Array we can store different types of data 
		String sheetname="Registration";
		try {
			reader=new XLS_Reader("./src/Excel/tests/Registeration.xlsx");
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		int rowCount=reader.getRowCount(sheetname);
		for(int rownum=2;rownum<=rowCount;rownum++) {
			String UserID=reader.getCellData(sheetname, "UserID", rownum);
			String Firstname1=reader.getCellData(sheetname, "Firstname1", rownum);
			String Firstname=reader.getCellData(sheetname, "Firstname", rownum);
			String Lastname=reader.getCellData(sheetname, "Lastname", rownum);
			String HintAnswer=reader.getCellData(sheetname, "HintAnswer", rownum);
			String Address1=reader.getCellData(sheetname, "Address1", rownum);
			String address2=reader.getCellData(sheetname, "address2", rownum);
			String city=reader.getCellData(sheetname, "city", rownum);
			String state=reader.getCellData(sheetname, "state", rownum);
			String pincode=reader.getCellData(sheetname, "pincode", rownum);
			String email_address=reader.getCellData(sheetname, "email_address", rownum);
			String Mobilenum=reader.getCellData(sheetname, "Mobilenum", rownum);
            
			Object[] obj= {UserID,Firstname1,Firstname,Lastname,HintAnswer,Address1,address2,city,state,pincode,email_address,Mobilenum};
			exceltestData.add(obj);

		}
		return exceltestData;
	}


}
