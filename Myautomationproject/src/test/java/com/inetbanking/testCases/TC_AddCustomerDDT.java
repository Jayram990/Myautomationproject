package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_AddCustomerDDT extends BaseClass{

	@Test(dataProvider="CustomerData")
	
		public void addNewCustomer(String CustomerName, String Gender, String Month, String Date, String Year, String Address, String city, String state, String pin, String mobnum, String email, String Password ) throws InterruptedException, IOException
		{
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			
			Thread.sleep(3000);
			
			AddCustomerPage addcust=new AddCustomerPage(driver);
			
			addcust.clickAddNewCustomer();
			
			logger.info("providing customer details....");
			
			
			addcust.custName(CustomerName);
			addcust.custgender(Gender);
			addcust.custdob(Month, Date, Year);
			Thread.sleep(5000);
			addcust.custaddress(Address);
			addcust.custcity(city);
			addcust.custstate(state);
			addcust.custpinno(pin);
			addcust.custtelephoneno(mobnum);
			addcust.custemailid(email);
			addcust.custpassword(Password);
			addcust.custsubmit();
			
			Thread.sleep(3000);
			
			logger.info("validation started....");
			
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				lp.clickHome();
				Thread.sleep(2000);
				lp.clickLogout();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();	
			}
			
			else
			{
				logger.info("test case failed....");
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
				
		}
		
		
	
		
	
@DataProvider(name="CustomerData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Customer_Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}	
	

