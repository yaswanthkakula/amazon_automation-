package amazon_auto1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Amazonmethods {
	
	static WebDriver driver;

  @Test
  public void allmethod() throws InterruptedException {
	  Amazonmethods.openbrowser();
	  Amazonmethods.addcart();
	  Amazonmethods.checkpoint();
	    
  }
  
  
  
  public static void openbrowser()  {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get("https://www.amazon.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Implicit wait 
  }
  public static void addcart() throws InterruptedException {
		findElement(By.linkText("Mobiles")).click();
		findElement(By.id("sobe_d_b_7_1")).click();//first product clicked
		findElement(By.id("add-to-cart-button")).click();//first product add
		Thread.sleep(3000);
		findElement(By.id("attach-view-cart-button-form")).click();//product add to cart
		
		
		
		Thread.sleep(3000);
		findElement(By.linkText("Mobiles")).click();
		findElement(By.id("sobe_d_b_7_2")).click();//secondproduct product clicked
		findElement(By.id("add-to-cart-button")).click();//secondproduct product add
		Thread.sleep(3000);
		findElement(By.id("attach-view-cart-button-form")).click();//product add to cart
		Thread.sleep(2000);
	
		
		//a-autoid-0-announce//a-icon a-icon-dropdown//following::i[@class='a-icon a-icon-dropdown']	
	  findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();//product 1 adding no of product
    	findElement(By.id("quantity_2")).click();//product adding no of quatity to cart
		
		Thread.sleep(2000);
	
	 findElement(By.xpath("//span[@id='a-autoid-3-announce']")).click();//product 2 adding no of product

	/* WebElement q1= findElement(By.id("quantity_1"));//product adding no of quatity to cart
	
	 JavascriptExecutor js=(JavascriptExecutor)driver; 
	js.executeScript("arguments[0].click()", q1);*/
	 findElement(By.linkText("1")).click();
  }	
	public  static void checkpoint() {
		String product1=findElement(By.xpath("//span[text()='8,499.00']")).getText();
		
		
		String product2=findElement(By.xpath("(//span[text()='8,499.00'])[2]")).getText();
		
		
		String actualAmount=findElement(By.xpath("//span[text()='25,497.00']")).getText();

	  float product1amount = 2*removablecomma(product1);
	  System.out.println("first product value:"+product1amount);
		
		float  product2price=1*removablecomma(product2);
		System.out.println("second product value:"+product2price);
		
		float  Expectedcartsum= product1amount + product2price;
		
		
	float Actual_CartAmount=removablecomma(actualAmount);
		System.out.println("the calcuated expected value"+Expectedcartsum);
		
		
		if(Expectedcartsum==Actual_CartAmount)
		{
			Reporter.log("Cart Amount logic is worked as expected");
			System.out.println("Cart Amount logic is worked as expected");
		}
		
		else {
		
		Reporter.log("cart value is failed");
		System.out.println("cart value is failed");
		}
  
  }
  

  public static float removablecomma(String product) {
	  String str1=product.replace(",","");
	  float f=Float.parseFloat(str1);
	  	return f;
	  	
	  }



public static WebElement findElement(By by) {
	  
	  WebElement ele=driver.findElement(by);
	  if(driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='5px solid green'",ele);
			
			}
			
			return ele;
			
  }
}
