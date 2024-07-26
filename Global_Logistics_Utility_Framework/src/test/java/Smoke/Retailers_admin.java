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
import org.openqa.selenium.support.ui.Select;

public class Retailers_admin 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream f=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(f);
		
		//Read common data from command line
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		FileInputStream f1=new FileInputStream("./src/test/resources/excel1.xlsx");
		
		Workbook wb=WorkbookFactory.create(f1);
		Sheet sh=wb.getSheet("AddRetailers");
		Row r=sh.getRow(1);
		String un=r.getCell(0).toString();
		String pwd=r.getCell(1).toString();
		String phone=r.getCell(2).toString();
		String email=r.getCell(3).toString();
		String address=r.getCell(4).toString();
		
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
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement listbox=driver.findElement(By.id("login:type"));
		Select s=new Select(listbox);
		s.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[text()='Add Retailers']")).click();
		
		driver.findElement(By.id("retailer:username")).sendKeys(un);
		driver.findElement(By.id("retailer:password")).sendKeys(pwd);
		driver.findElement(By.id("retailer:phone")).sendKeys(phone);
		WebElement lb=driver.findElement(By.id("retailer:areaCode"));
		Select s1=new Select(lb);
		s1.selectByValue("3");
		driver.findElement(By.id("retailer:email")).sendKeys(email);
		driver.findElement(By.id("retailer:address")).sendKeys(address);
		driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
		
		driver.findElement(By.xpath("//a[text()='Retailers']")).click();
		String actual=driver.findElement(By.xpath("//table//tbody//tr[79]//td[text()=' 9876543237 ']")).getText();
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
