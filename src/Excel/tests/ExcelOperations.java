package Excel.tests;
import com.excel.Utility.XLS_Reader;

public class ExcelOperations {
	public static void main(String[] args) {
        XLS_Reader reader=new XLS_Reader("./src/Excel/tests/Registeration.xlsx");
           // reader.addSheet("HomePage");
            if(!reader.isSheetExist("HomePage")) {
            	reader.addSheet("HomePage");
            }
    int columnCount=        reader.getColumnCount("Registration");
    System.out.println(columnCount);
  int row_num=  reader.getCellRowNum("Registration", "Address1","17,Vijaynagar");  //on which row this data is existed
  System.out.println(row_num);
            

	}



}
