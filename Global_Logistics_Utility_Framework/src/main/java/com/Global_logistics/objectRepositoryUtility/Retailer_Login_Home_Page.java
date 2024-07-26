package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retailer_Login_Home_Page 
{
	
	public Retailer_Login_Home_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
		
	

	@FindBy(xpath="//a[text()='New Order']")
	WebElement NewOrderLnk;
	
	public WebElement getNewOrderLnk() 
	{
		return NewOrderLnk;
		
	}
	
	
}
