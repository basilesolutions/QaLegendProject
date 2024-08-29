package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends BaseClass {
	
	@Test
	public void verifyUsrLoginDate()
	{
		String userName = ExcelUtility.getStringData(0, 0, "LoginScreen");
		String password = ExcelUtility.getIntegerData(0, 1, "LoginScreen");
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        HomePage homePage = new HomePage(driver);
		homePage.clickTourButton();
        //String actualText=home.getLoginText();
        //Assert.assertEquals(actualText, finalMessage);
		
		String homePageDate =homePage.getLoginDate();
		String todayDate=homePage.getCurrentDate();
		Assert.assertEquals(homePageDate, todayDate, "Date Mismatch");
        
		
	}

}
