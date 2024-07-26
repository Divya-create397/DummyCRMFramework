package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GlobalLogistics.generic.WebDriverUtility.WebDriverUtility;

public class LoginPage 
{
	
	WebDriverUtility w=new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="login:username")
	private WebElement userNameTxt;
	
	@FindBy(id="login:password")
	private WebElement passwordTxt;
	
	@FindBy(id="login:type")
	private WebElement  loginTypeDropdwn;
	
	@FindBy(className="submit_button")
	private WebElement loginBtn;
	
	public void loginAdmin(String username,String password)
	{
		getUserNameTxt().sendKeys(username);
		getPasswordTxt().sendKeys(password);
		w.selectVText(getLoginTypeDropdwn(), "Admin");
		loginBtn.click();
	}
	
	public void loginRetailer(String username,String password)
	{
		getUserNameTxt().sendKeys(username);
		getPasswordTxt().sendKeys(password);
		w.selectVText(getLoginTypeDropdwn(), "Retailer");
		loginBtn.click();
	}

	public WebElement getLoginTypeDropdwn() {
		return loginTypeDropdwn;
	}

	public WebElement getUserNameTxt()
	{
		return userNameTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	
}
