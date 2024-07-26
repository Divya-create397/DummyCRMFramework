package Smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GlobalLogistics.generic.FileUtility.ExcelUtility;
import com.GlobalLogistics.generic.FileUtility.FileUtility;
import com.GlobalLogistics.generic.WebDriverUtility.JavaUtility;
import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;
import com.Global_logistics.objectRepositoryUtility.LoginPage;
import com.Global_logistics.objectRepositoryUtility.Retailer_Login_Home_Page;
import com.Global_logistics.objectRepositoryUtility.Retailer_New_Order_page;

public class Retailer_New_Order_POM 
{
	public static void main(String[] args) throws Throwable 
	{
		//Creating an objects
		FileUtility f=new FileUtility();
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		WebDriverUtility w=new WebDriverUtility();
				
		//Read common data from properties file
		String BROWSER=f.getDataFromPropertiesFile("browser");
		String URL=f.getDataFromPropertiesFile("url");
		String USERNAME=f.getDataFromPropertiesFile("username1");
		String PASSWORD=f.getDataFromPropertiesFile("password1");
		
		String burger=e.getDataFromExcel("RetailerNewOrder",1,0);
		String puff=e.getDataFromExcel("RetailerNewOrder",1,1);
		
		//Select Browser
				WebDriver driver=null;
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("edge"))
				{
					driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
				
				driver.get(URL);
				w.implicitely_Wait(driver);
				w.manageWindowMaximize(driver);
				
				LoginPage l=new LoginPage(driver);
				Retailer_Login_Home_Page r=new Retailer_Login_Home_Page(driver);
				
				l.loginRetailer(USERNAME, PASSWORD);
				
				r.getNewOrderLnk().click();
				
				Retailer_New_Order_page r1=new Retailer_New_Order_page(driver);
				r1.enterDataPuffCorn(burger, puff);
				
				
			/*	
				driver.findElement(By.xpath("//a[text()='New Order']")).click();
				driver.findElement(By.xpath("//input[@id='1']")).sendKeys(burger);
				driver.findElement(By.xpath("//input[@id='2']")).sendKeys(puff);
				
				WebElement btn=driver.findElement(By.xpath("//form[@method='POST']/child::input[@id='btnSubmit']"));
				w.WebDriver_Wait(driver, btn);
				
				WebElement link=driver.findElement(By.xpath("//input[@id='btnSubmit']"));
				
				//Retrieves x and y coordinates of the webelement
				
				int x=link.getLocation().getX();
				int y=link.getLocation().getY();
				
				//Converts the object from webdriver to java script executor
				JavascriptExecutor jj=(JavascriptExecutor) driver;
				
				//Enters the data into disabled text box
				jj.executeScript("window.scrollBy("+x+","+y+")");
				
				//w.scrollToElement(driver, driver.findElement(By.xpath("//input[@id='btnSubmit']")));
				driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();*/
				
			
}

}
