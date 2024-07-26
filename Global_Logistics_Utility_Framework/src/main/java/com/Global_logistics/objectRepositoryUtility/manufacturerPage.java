
package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class manufacturerPage
{
	WebDriver driver;
	public manufacturerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//table/tbody/tr[last()]/td[text()=' 9876543234 ']")
	WebElement phoneNumber;
	
	
	public WebElement getPhoneNumber()
	{
		return phoneNumber;
	}
	
	
}
