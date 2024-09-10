package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import constants.Messages;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;
import java.text.SimpleDateFormat;
import java.util.Date;





public class HomePageTest extends BaseClass {
	
	@Test
	public void verifyHomePageTitle()
	{
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String expectedTitle = ExcelUtility.getStringData(4, 0, Constants.LOGIN_PAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        HomePage homePage = new HomePage(driver);
		homePage.clickTourButton();
		String actualHomePageTitle = driver.getTitle();
		System.out.println(actualHomePageTitle);
        String actualText=home.getLoginText();
        Assert.assertEquals(actualHomePageTitle,expectedTitle,Messages.HOMEPAGE_MISMATCH_PAGETITLE );
		
	
        
		
	}
    @Test
	public void verifyUsrLoginDate()
	{
		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		
        LoginPage login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        HomePage homePage = new HomePage(driver);
		homePage.clickTourButton();
        
		
		String homePageDate =homePage.getLoginDate();
		String todayDate=homePage.getCurrentDate();
		Assert.assertEquals(homePageDate, todayDate,Messages.DATE_MISMATCH);
        
		
	}
}
