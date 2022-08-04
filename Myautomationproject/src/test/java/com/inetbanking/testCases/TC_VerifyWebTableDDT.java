package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class TC_VerifyWebTableDDT extends BaseClass{
	
	@Test(groups = { "smoke" })
	public void webtabletest() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		WebElement sellnk = driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[11]/a"));
        Actions act = new Actions(driver);
      
        
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/nav/div/div/ul/li[11]/a")));
        act.moveToElement(sellnk).click().perform();
        driver.findElement(By.xpath("//a[text() = 'Page-2']")).click();
        Thread.sleep(5000);
		
        int rowcount = driver.findElements(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr")).size();
        
        int colcount = driver.findElements(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr[1]//td")).size();
        String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/WebTableData.xlsx";
        System.out.println(rowcount);
        
        for(int i=1;i<=rowcount;i++)
        	
        {
        	
         String SNo = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[1]")).getText();
         String CourseName = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[2]")).getText();		
         String Rating = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[3]")).getText();
         String Provider = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[4]")).getText();
         String Cert = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[5]")).getText();
         String Price = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[6]")).getText();
         String CourseContent = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[7]")).getText();
         String Link = driver.findElement(By.xpath("//table[@Class = 'table table-striped']//tbody[2]//tr["+i+"]//td[8]")).getText();
         
         
         
         //Writing data into excel
         
         XLUtils.setCellData(path, "Sheet1", i, 0, SNo);
         XLUtils.setCellData(path, "Sheet1", i, 1, CourseName);
         XLUtils.setCellData(path, "Sheet1", i, 2, Rating);
         XLUtils.setCellData(path, "Sheet1", i, 3, Provider);
         XLUtils.setCellData(path, "Sheet1", i, 4, Cert);
         XLUtils.setCellData(path, "Sheet1", i, 5, Price);
         XLUtils.setCellData(path, "Sheet1", i, 6, CourseContent);
         XLUtils.setCellData(path, "Sheet1", i, 7, Link);
         
         System.out.println("Data writen to excel sucessfully");

        }
        
        Assert.assertTrue(true);
		logger.info("Webtable test passed");
                
     }
		
		
	}


