package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.Operations;

public class TC_CheckboxOperations extends BaseClass{
	
	@Test(groups = { "smoke" })
	public void performcheckOperations() throws InterruptedException, IOException
	{
        
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		Operations op = new Operations(driver);
		
		Actions act  = new Actions(driver);
		
		act.moveToElement(op.MouseoverSelect()).click().perform();
		Thread.sleep(3000);
		logger.info("Mousehover&clicked on Selenium");
		act.moveToElement(op.MouseoverRadio()).click().perform();
		Thread.sleep(3000);
		logger.info("Mousehovered on Radio&check");
		
		
		for(WebElement wb: op.checkboxes())
		{
			wb.click();
		}
		
		Thread.sleep(10000);
		boolean status = driver.findElement(By.xpath("//input[@value='checkbox3']")).isSelected();
		
		if(status = true)
		{
			logger.info("Checkbox is selected");
			Assert.assertTrue(true);
			logger.info("Test case is passed");
		}
		
		else 
		{ 
			Assert.assertTrue(false);
			captureScreen(driver,"Performoperations");
			logger.info("Test case is failed");
		}
			
	}

}
