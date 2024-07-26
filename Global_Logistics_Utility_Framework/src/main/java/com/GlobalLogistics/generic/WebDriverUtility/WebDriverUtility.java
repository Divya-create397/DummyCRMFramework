package com.GlobalLogistics.generic.WebDriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	WebDriver driver=null;
	//1
	public void implicitely_Wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void manageWindowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	//2
	public void WebDriver_Wait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//3
	
	public void switchToTabBasedOnURL(WebDriver driver,String partialURL)
	{
		Set<String> s=driver.getWindowHandles();
		for(String lv:s)
		{
			driver.switchTo().window(lv);
			String actUrl=driver.getCurrentUrl();
			//System.out.println(title);
			if(actUrl.contains(partialURL))
			{
				break;
			}
			
		}
	}
	
	//4
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> s=driver.getWindowHandles();
		for(String lv:s)
		{
			driver.switchTo().window(lv);
			String actUrl=driver.getTitle();
			//System.out.println(title);
			if(actUrl.contains(partialTitle))
			{
				break;
			}
			
		}
	}
	
	//5
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	//6
	
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	//7
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//8
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	//9

	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	//10
	
	public void selectVText(WebElement element,String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	
	//11
	
	public void selectIndex(WebElement element,int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	//12

	public void selectValue(WebElement element,String value)
	{
		Select s= new Select(element);
		s.selectByValue(value);
	}
	
	//13
	
	public void mouseOver(WebDriver driver,WebElement element) 
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	//14
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	//15

	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	//16
	
	public void dragAndDrop(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(element1, element2).perform();
	}
	
	//17
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	//18
	
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	

}
