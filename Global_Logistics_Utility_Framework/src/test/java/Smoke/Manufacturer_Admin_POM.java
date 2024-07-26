package Smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GlobalLogistics.generic.FileUtility.ExcelUtility;
import com.GlobalLogistics.generic.FileUtility.FileUtility;
import com.GlobalLogistics.generic.WebDriverUtility.JavaUtility;
import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;
import com.Global_logistics.objectRepositoryUtility.AddManufacturerPage;
import com.Global_logistics.objectRepositoryUtility.Admin_Home_Page;
import com.Global_logistics.objectRepositoryUtility.LoginPage;
import com.Global_logistics.objectRepositoryUtility.manufacturerPage;

public class Manufacturer_Admin_POM
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
	
	driver.get(URL);
	w.implicitely_Wait(driver);
	w.manageWindowMaximize(driver);
	
	LoginPage l=new LoginPage(driver);
	Admin_Home_Page admin=new Admin_Home_Page(driver);
	AddManufacturerPage addManufacturerPage=new AddManufacturerPage(driver);
	manufacturerPage mp=new manufacturerPage(driver);
	
	
	l.loginAdmin(USERNAME,PASSWORD);
	admin.getAddManufacturerLnk().click();
	addManufacturerPage.getAddManufacturerName().sendKeys(name);
	addManufacturerPage.getAddManufacturerEmail().sendKeys(email);
	addManufacturerPage.getAddManufacturerPhone().sendKeys(phone);
	addManufacturerPage.getAddManufacturerUserName().sendKeys(un);
	addManufacturerPage.getAddManufacturerPassword().sendKeys(pwd);
	addManufacturerPage.getSubmitButton().click();
	w.switchToAlertAndAccept(driver);
	admin.getManufacturerLnk().click();
	
	String actual=mp.getPhoneNumber().getText();
	if(actual.equals(phone))
	{
		System.out.println("Data is added==PASS");
	}
	
	else
	{
		System.out.println("Data is not added==FAIL");
		
		
	}
	
	/*
	driver.findElement(By.xpath("//a[text()='Manufacturers']")).click();
	
	String actual=driver.findElement(By.xpath("//table/tbody/tr[128]/td[text()=' 98765mp.43234 ']")).getText();
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
	
	driver.quit();	*/
	
	}

}
