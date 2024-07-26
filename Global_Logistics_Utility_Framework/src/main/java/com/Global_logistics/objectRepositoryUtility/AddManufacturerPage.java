package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;

public class AddManufacturerPage
{

	WebDriverUtility w=new WebDriverUtility();
	WebDriver driver;
	
	public AddManufacturerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="manufacturer:name")
	private WebElement AddManufacturerName;
	
	@FindBy(id="manufacturer:email")
	private WebElement AddManufacturerEmail;
	
	@FindBy(id="manufacturer:phone")
	private WebElement AddManufacturerPhone;
	
	@FindBy(id="manufacturer:username")
	private WebElement AddManufacturerUserName;
	
	@FindBy(id="manufacturer:password")
	private WebElement AddManufacturerPassword;
	
	@FindBy(xpath="//input[@value='Add Manufacturer']")
	private WebElement submitButton;

	public WebElement getAddManufacturerName() 
	{
		return AddManufacturerName;
	}

	public WebElement getAddManufacturerEmail()
	{
		return AddManufacturerEmail;
	}

	public WebElement getAddManufacturerPhone() 
	{
		return AddManufacturerPhone;
	}

	public WebElement getAddManufacturerUserName() 
	{
		return AddManufacturerUserName;
	}

	public WebElement getAddManufacturerPassword()
	{
		return AddManufacturerPassword;
	}

	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	
	
}
