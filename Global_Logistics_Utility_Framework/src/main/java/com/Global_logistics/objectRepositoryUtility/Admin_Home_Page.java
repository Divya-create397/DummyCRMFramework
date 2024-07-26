package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Home_Page 
{
	WebDriver driver;
	
	public Admin_Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Add Manufacturer']")
	WebElement AddManufacturerLnk;
	
	public WebElement getManufacturerLnk() {
		return ManufacturerLnk;
	}

	@FindBy(xpath="//a[text()='Manufacturers']")
	WebElement ManufacturerLnk;

	public WebElement getAddManufacturerLnk() 
	{
		return AddManufacturerLnk;
	}

}
