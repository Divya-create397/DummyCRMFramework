package Smoke;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GlobalLogistics.generic.FileUtility.ExcelUtility;
import com.GlobalLogistics.generic.FileUtility.FileUtility;
import com.GlobalLogistics.generic.WebDriverUtility.JavaUtility;
import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;

public class Manage_Stocks 
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
		String USERNAME=f.getDataFromPropertiesFile("username2");
		String PASSWORD=f.getDataFromPropertiesFile("password2");
				
		String quantity=e.getDataFromExcel("ManageStock",1,0);
		
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
		
		Actions a=new Actions(driver);
		//Login as manufacturer
		w.implicitely_Wait(driver);
		driver.get(URL);
		w.manageWindowMaximize(driver);
		
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement listbox=driver.findElement(By.id("login:type"));
		w.selectVText(listbox, "Manufacturer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[text()='Manage Stock']")).click();
		
		WebElement val = driver.findElement(By.xpath("//input[@name='txtQuantity[11]']"));
		val.clear();
		val.sendKeys(quantity);
		
		WebElement link=driver.findElement(By.xpath("//input[@id='btnSubmit']"));
		
		//Retrieves x and y coordinates of the webelement
		
		int x=link.getLocation().getX();
		int y=link.getLocation().getY();
		
		//Converts the object from webdriver to java script executor
		JavascriptExecutor jj=(JavascriptExecutor) driver;
		
		//Enters the data into disabled text box
		jj.executeScript("window.scrollBy("+x+","+y+")");
		
		//w.scrollToElement(driver, driver.findElement(By.xpath("//input[@id='btnSubmit']")));
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		
		w.switchToAlertAndAccept(driver);
		
		val = driver.findElement(By.xpath("//input[@name='txtQuantity[11]']"));
		if(val.getAttribute("value").equals(quantity))
		{
		
			System.out.println("Quantity 25 added successfully");
		}
		
	

	}

	

}
