package Excel.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.Utility.XLS_Reader;


public class parameterizeTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//Automation//chromedriver.exe");  
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.indiapost.gov.in/VAS/Pages/UserRegistration.aspx");
	
        
        //Datadrivern Approach(Paramerization)--used to create data driven framework(driving the test data from excel files)
        //get data from excel
        
        XLS_Reader reader=new XLS_Reader(".src/Excel/tests/Registeration.xlsx");
    int rowCount=    reader.getRowCount("Registration");
    reader.addColumn("Registration", "Status");
    
    
    //Paramerization
    for(int rownum=2;rownum<=rowCount;rownum++) {
    	System.out.println("=========");
    	String UserID=reader.getCellData("Registration", "UserID", rownum);
    	System.out.println(UserID);
    	String Firstname1=reader.getCellData("Registration", "Firstname1", rownum);
    	System.out.println(Firstname1);
    	String Firstname=reader.getCellData("Registration", "Firstname", rownum);
    	System.out.println(Firstname);
    	String Lastname=reader.getCellData("Registration", "Lastname", rownum);
    	System.out.println(Lastname);
    	String HintQuestion=reader.getCellData("Registration", "HintQuestion", rownum);
    	System.out.println(HintQuestion);
    	String HintAnswer=reader.getCellData("Registration", "HintAnswer", rownum);
    	System.out.println(HintAnswer);
    	String Address1=reader.getCellData("Registration", "Address1", rownum);
    	System.out.println(Address1);
    	String address2=reader.getCellData("Registration", "address2", rownum);
    	System.out.println(address2);
    	String city=reader.getCellData("Registration", "city", rownum);
    	System.out.println(city	);
    	String state=reader.getCellData("Registration", "state", rownum);
    	System.out.println(state);
    	String pincode=reader.getCellData("Registration", "pincode", rownum);
    	System.out.println(pincode);
    	String email_address=reader.getCellData("Registration", "email_address", rownum);
    	System.out.println(email_address);
    	String Mobilenum=reader.getCellData("Registration", "Mobilenum", rownum);
    	System.out.println(Mobilenum);
    	
    	
    	//enterdata into the fields
    	driver.findElement(By.xpath("//input[@title='User ID']")).clear();
    	driver.findElement(By.xpath("//input[@title='User ID']")).sendKeys(UserID);
    	Select salutation=new Select(driver.findElement(By.xpath("//select[@title='Title']")));
    	salutation.selectByVisibleText(Firstname1);
    	driver.findElement(By.xpath("//input[@title='First Name']")).clear();
    	driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys(Firstname);

    	driver.findElement(By.xpath("//input[@title='Last Name']")).clear();
    	driver.findElement(By.xpath("//input[@title='Last Name']")).sendKeys(Lastname);
    	//driver.findElement(By.xpath("//*[@title='Hint Question']/option[2]']")).click();
    	Thread.sleep(2000);
    	Select HintQues=new Select(driver.findElement(By.xpath("//select[@title='Hint Question']")));
    	HintQues.selectByValue("SQ02");
    	

    	driver.findElement(By.xpath("//input[@title='Hint Answer']")).clear();
    	driver.findElement(By.xpath("//input[@title='Hint Answer']")).sendKeys(HintAnswer);

    	driver.findElement(By.xpath("(//input[@title='Address'])[1]")).clear();
    	driver.findElement(By.xpath("(//input[@title='Address'])[1]")).sendKeys(Address1);

    	driver.findElement(By.xpath("(//input[@title='Address'])[2]")).clear();
    	driver.findElement(By.xpath("(//input[@title='Address'])[2]")).sendKeys(address2);
    	Select state1=new Select(driver.findElement(By.xpath("//select[@title='State']")));
    	state1.selectByVisibleText(state);
    	Select City=new Select(driver.findElement(By.xpath("//select[@title='City / District']")));
    	City.selectByVisibleText(city);
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@title='Pincode']")).clear();
    	driver.findElement(By.xpath("//input[@title='Pincode']")).sendKeys(pincode);
    	driver.findElement(By.xpath("//input[@title='Email']")).clear();
    	driver.findElement(By.xpath("//input[@title='Email']")).sendKeys(email_address);
    	driver.findElement(By.xpath("//input[@title='Mobile']")).clear();
    	driver.findElement(By.xpath("//input[@title='Mobile']")).sendKeys(Mobilenum);
    	
    	//write operation into excel
    	reader.setCellData("Registration","Status", rownum, "Pass");
    	
    	
    	

    }
	}

	

}
