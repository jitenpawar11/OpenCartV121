package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	public void verifyLogin()
	{
		logger.info("***** Starting TC002_LoginTest****");
		logger.debug("capturing application debug logs....");
		
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link on homepage");
		hp.clickLogin();
		logger.info("Clicked on login link under my account");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		//My Account Page
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true,"Login failed");
		//Assert.assertTrue(targetpage);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC002_LoginTest****");
		
		
	}

}
