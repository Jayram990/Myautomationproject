package com.inetbanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Operations {
	
WebDriver ldriver;
	
	public Operations(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

    @FindBy(xpath = "/html/body/div[1]/div[2]/nav/div/div/ul/li[1]/a" )
    @CacheLookup
    WebElement Selectlnk;
    
    @FindBy(xpath = "//a[text()=\"Radio & Checkbox Demo\"]" )
    @CacheLookup
    WebElement Selectradio;
	
    @FindBy(xpath = "//a[text()='Radio & Checkbox Demo']" )
    @CacheLookup
    WebElement Radiolnk;
    
    @FindBy(xpath ="//input[@type='radio']")
    @CacheLookup
    List<WebElement> Radiobtn;
    
    @FindBy(xpath ="//input[@type='checkbox']")
    @CacheLookup
    List<WebElement> Checkbox;
    
    
    public WebElement MouseoverSelect()
	{
    	return Selectlnk;
    			
	}
    
    public WebElement MouseoverRadio()
   	{
       	return Selectradio;
       			
   	}
    
    public List<WebElement> checkboxes()
    {
    	return Checkbox;
    }
    
    public List<WebElement> Radiobuttons()
    {
    	return Radiobtn;
    } 
       
    
}
