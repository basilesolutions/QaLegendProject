package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import constants.Messages;
import pageObject.LoginPage;
import pageObject.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends BaseClass {

	@Test

	public void verifyResetPageWithValidMail() {

		String email = ExcelUtility.getStringData(0, 0,Constants.RESET_PAGE);
		String confirmMessage = ExcelUtility.getStringData(1, 0, Constants.RESET_PAGE);
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.forgotPasswordButton();
		reset.enterForgotPasswordEmail(email);
		reset.sendPasswordResetButton();
		String successMessage = reset.emailSendMessage();
		Assert.assertEquals(successMessage, confirmMessage,Messages.RESET_SUCCESS_MESSAGE);

	}

	@Test
	public void verifyResetPageWithInvalidMail()  {

		String email = ExcelUtility.getStringData(4, 1, Constants.RESET_PAGE);
		String expMessage = ExcelUtility.getStringData(5, 1,Constants.RESET_PAGE);
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.forgotPasswordButton();
		reset.enterForgotPasswordEmail(email);
		reset.sendPasswordResetButton();
		String successMessage = reset.emailNotFoundMessage();
		Assert.assertEquals(successMessage, expMessage,Messages.RESET_FAILED_MESSAGE);

	}

}
