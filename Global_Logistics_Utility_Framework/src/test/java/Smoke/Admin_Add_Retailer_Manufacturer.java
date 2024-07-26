package Smoke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GlobalLogistics.generic.FileUtility.ExcelUtility;
import com.GlobalLogistics.generic.FileUtility.FileUtility;
import com.GlobalLogistics.generic.WebDriverUtility.JavaUtility;
import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;


public class Admin_Add_Retailer_Manufacturer
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
		String USERNAME=f.getDataFromPropertiesFile("username");
		String PASSWORD=f.getDataFromPropertiesFile("password");
		
		String un=e.getDataFromExcel("AddRetailers",2,0);
		String pwd=e.getDataFromExcel("AddRetailers",2,1);
		String phone=e.getDataFromExcel("AddRetailers",2,2);
		String email=e.getDataFromExcel("AddRetailers",2,3);
		String address=e.getDataFromExcel("AddRetailers",2,3);
		String un1=e.getDataFromExcel("AddManufacturer",1,3);
		String pwd1=e.getDataFromExcel("AddManufacturer",1,4);
		
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
				
				w.implicitely_Wait(driver);
				driver.get(URL);
				w.manageWindowMaximize(driver);
				
				driver.findElement(By.id("login:username")).sendKeys(USERNAME);
				driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
				
				WebElement listbox=driver.findElement(By.id("login:type"));
				w.selectVText(listbox, "Admin");
				
				
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				driver.findElement(By.xpath("//a[text()='Add Retailers']")).click();
				
				driver.findElement(By.id("retailer:username")).sendKeys(un);
				driver.findElement(By.id("retailer:password")).sendKeys(pwd);
				driver.findElement(By.id("retailer:phone")).sendKeys(phone);
				WebElement lb=driver.findElement(By.id("retailer:areaCode"));
				w.selectValue(lb, "1");
				
				driver.findElement(By.id("retailer:email")).sendKeys(email);
				driver.findElement(By.id("retailer:address")).sendKeys(address);
				driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
				
				w.switchToAlertAndAccept(driver);
				
				//Click on logout button
				driver.findElement(By.xpath("//input[@value='Log out']")).click();
				w.WebDriver_Wait(driver, driver.findElement(By.id("login:username")));
				
				//login as manufacturer
				driver.findElement(By.id("login:username")).sendKeys(un1);
				driver.findElement(By.id("login:password")).sendKeys(pwd1);
				WebElement lb1=driver.findElement(By.id("login:type"));
				w.selectVText(lb1, "Manufacturer");
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				//Click on retailer button
				driver.findElement(By.xpath("//a[text()='Retailers']")).click();
				
				//Validation
				String actual=driver.findElement(By.xpath("(//table//tbody//tr//td[text()=' 9876543210 '])[3]")).getText();
				System.out.println(actual);
				System.out.println(phone);
				if(actual.equals(phone))
				{
					System.out.println("Data is added==PASS");
					
				}
				else
				{
					System.out.println("Data is not added==FAIL");
					
					
				}
				
				driver.findElement(By.xpath("//input[@value='Log out']")).click();
				driver.quit();
				
				
		
	}

}
