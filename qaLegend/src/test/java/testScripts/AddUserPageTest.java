package testScripts;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import constants.Messages;
import pageObject.AddUserPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends BaseClass {

	@Test(groups="Sanity")
	public void verifyAddUser() {

		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String successMessage = ExcelUtility.getStringData(7, 0, Constants.ADD_PAGE);

		String prefix = RandomDataUtility.getPrefix();
		String firstName = RandomDataUtility.getFirstName();
		String lastName = RandomDataUtility.getLastName();
		String email = firstName + "." + lastName + Constants.MAIL_DETAIL;
		String role = ExcelUtility.getStringData(3, 1, Constants.ADD_PAGE);
		String admin = firstName + "123";

		String userPassword = firstName + "@" + lastName;
		String salesPercent = ExcelUtility.getIntegerData(6, 0, Constants.ADD_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		HomePage home = login.submitButton();
		home.clickTourButton();
		home.clickMainDropDown();
		home.clickUserDropdown();
		AddUserPage user = new AddUserPage(driver);

		user.clickAdduserButton();
		user.enterPrefix(prefix);
		user.enterFirstName(firstName);
		user.enterLastName(lastName);
		user.enterEmail(email);
		// user.selectRoleDropDown(role);
		user.enterUserName(userName);
		user.enterPasswordForLogin(userPassword);
		user.enterConfirmPassword(userPassword);
		user.enterCommision(salesPercent);
		user.clickSubmit();
		Assert.assertEquals(successMessage, Messages.USERADDEDSUCCESS, Messages.USERADDFAIL);

	}
@Test(groups="Smoke")
	public void verifyUserLoginWithNewlyAddedUser() {

		String userName = ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String successMessage = ExcelUtility.getStringData(7, 0, Constants.ADD_PAGE);

		String prefix = RandomDataUtility.getPrefix();
		String firstName = RandomDataUtility.getFirstName();
		String lastName = RandomDataUtility.getLastName();
		String email = firstName + "." + lastName + Constants.MAIL_DETAIL;
		String role = ExcelUtility.getStringData(3, 1, Constants.ADD_PAGE);
		String admin = firstName + "123";

		String userPassword = firstName + "@" + lastName;
		String expectedwelcomemessagefield = Constants.EXPECTED_MESSAGE_PREFIX+ " " + firstName + Constants.EXPECTED_MESSAGE_SUFFIX;
		String salesPercent = ExcelUtility.getIntegerData(6, 0, Constants.ADD_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		HomePage home = login.submitButton();
		home.clickTourButton();
		home.clickMainDropDown();
		home.clickUserDropdown();
		AddUserPage user = new AddUserPage(driver);

		user.clickAdduserButton();
		user.enterPrefix(prefix);
		user.enterFirstName(firstName);
		user.enterLastName(lastName);
		user.enterEmail(email);
		// user.selectRoleDropDown(role);
		user.enterUserName(userName);
		user.enterPasswordForLogin(userPassword);
		user.enterConfirmPassword(userPassword);
		user.enterCommision(salesPercent);
		user.clickSubmit();
		home.clickHomeIcon();
		home.clickAdmin();
		home.clickLogOut();
		login.enterUsername(admin);
		login.enterPassword(userPassword);
		login.submitButton();
		String messageForLoggedUser=home.WelcomemessageForUserLogin();
		Assert.assertEquals(messageForLoggedUser,expectedwelcomemessagefield,Messages.USER_CREATION_FAIL_MESSAGE);
	}

}
