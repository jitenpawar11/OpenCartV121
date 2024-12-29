package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;




/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/


public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String expresult)
	{
		
		logger.info("**** Starting TC003_LoginDDT *****");
		
			try
			{
				//HomePage
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();                           //Login link under MyAccount
				
				
				//LoginPage
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();                           //Login button
				
				//My Account Page
				MyAccountPage macc = new MyAccountPage(driver);
				boolean targetpage=macc.isMyAccountPageExists();
				
				if(expresult.equalsIgnoreCase("Valid"))
				{
					if(targetpage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(expresult.equalsIgnoreCase("Invalid"))
				{
					if(targetpage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
			    }
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred :"+e.getMessage());
			}
		
		   logger.info("**** Finished TC_003_LoginDDT *****");
		
	}
	
}
