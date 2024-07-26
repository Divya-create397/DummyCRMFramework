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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.GlobalLogistics.generic.FileUtility.ExcelUtility;
import com.GlobalLogistics.generic.FileUtility.FileUtility;
import com.GlobalLogistics.generic.WebDriverUtility.JavaUtility;
import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;

public class Manufacturer_admin 
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
		
		String name=e.getDataFromExcel("AddManufacturer",1,0);
		String email=e.getDataFromExcel("AddManufacturer",1,1);
		String phone=e.getDataFromExcel("AddManufacturer",1,2);
		String un=e.getDataFromExcel("AddManufacturer",1,3);
		String pwd=e.getDataFromExcel("AddManufacturer",1,4);
		
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
	driver.findElement(By.xpath("//a[text()='Add Manufacturer']")).click();
	
	driver.findElement(By.id("manufacturer:name")).sendKeys(name);
	driver.findElement(By.id("manufacturer:email")).sendKeys(email);
	driver.findElement(By.id("manufacturer:phone")).sendKeys(phone);
	driver.findElement(By.id("manufacturer:username")).sendKeys(un);
	driver.findElement(By.id("manufacturer:password")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@value='Add Manufacturer']")).click();
	
	w.switchToAlertAndAccept(driver);
	driver.findElement(By.xpath("//a[text()='Manufacturers']")).click();
	
	String actual=driver.findElement(By.xpath("//table/tbody/tr[128]/td[text()=' 9876543234 ']")).getText();
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
	
	driver.quit();	
	
	}
}
