package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserProfileTest extends BaseClass {
	
	@Test
	public void VerifyEditUserProfile() {
		String userName=ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String Email=firstName+Constants.DOT+lastName+Constants.MAIL_DETAIL;
		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
		login.enterPassword(password);
		HomePage homepage = login.submitButton();
		homepage.clickTourButton();
		homepage.getLoginText();
		UserProfilePage userprofile =homepage.clickProfileButton();
		userprofile.editEmail(Email);
		userprofile.updateButtonClick();
		
	}
}
		
		

