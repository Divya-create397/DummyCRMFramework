package com.Global_logistics.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retailer_New_Order_page
{
	WebDriver driver;
	public Retailer_New_Order_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='1']")
	private WebElement BurgerTxt;
	
	@FindBy(xpath="//input[@id='2']")
	private WebElement CornPuffTxt;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	private WebElement postOrderBtn;
	
	

	public WebElement getPostOrderBtn() 
	{
		return postOrderBtn;
	}

	public WebElement getBurgerTxt() 
	{
		return BurgerTxt;
	}

	public WebElement getCornPuffTxt() 
	{
		return CornPuffTxt;
	}

	public void enterDataPuffCorn(String burger,String corn)
	{
		getBurgerTxt().sendKeys(burger);
		getCornPuffTxt().sendKeys(corn);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement link=driver.findElement(By.xpath("//input[@id='btnSubmit']"));
		int x=link.getLocation().getX();
		int y=link.getLocation().getY();
		j.executeAsyncScript("window.scrollBy("+x+","+y+")");
		getPostOrderBtn().click();
	}
}
