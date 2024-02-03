package cust_report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test1rep{
	
	WebDriver driver;
	
	Reporter1 R1;
	
  @Test
  public void f() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");	
	    driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String str ="Gopi";
		
		R1=new Reporter1(driver,str);
		
		R1.TakeScreenShotAuto(driver,"enter url","pass");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		R1.TakeScreenShotAuto(driver,"enter username","pass");
		
		
	 
  }
}
