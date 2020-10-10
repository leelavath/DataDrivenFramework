package com.parametersinTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametersTest {
    WebDriver driver;
    
	@Test
	@Parameters({"URL","username","password"})
	public void loginPage(String browser,String URL,String username,String password) {
		if(browser.equals("chrome")) 
		{
		 System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//Automation//chromedriver.exe");  
		 driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) 
		{
		 System.setProperty("webdriver.gecko.driver", "C://Users//Admin//Documents//Automation//chromedriver//geckodriver.exe");  
		 driver=new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
	}


}
