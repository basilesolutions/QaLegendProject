package testScripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import constants.Messages;
import dataProvider.DataProviders;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass {

	@Test
	public void verifyLoginWithValidCredentials() {

		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String finalMessage = ExcelUtility.getStringData(1, 0, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		HomePage home = login.submitButton();
		String actualText = home.getLoginText();
		Assert.assertEquals(actualText, finalMessage, Messages.INVALID_LOGIN);

	}

	@Test(dataProvider = "invalidData", dataProviderClass = DataProviders.class)
	public void InvalidDataDataProvider(String userName, String password)  {

		String finalMessage = ExcelUtility.getStringData(3, 0, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		String actualErrorMessage = login.getInvalidMessage();
		Assert.assertEquals(actualErrorMessage, finalMessage, Messages.INVALID_LOGIN);

	}

}
