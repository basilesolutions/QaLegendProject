package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
import constants.Messages;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.UploadContactsPage;
import utilities.ExcelUtility;



public class UploadContactsPageTest extends BaseClass {
	
	@Test
	public void verifyImportContacts() {
		
		String userName=ExcelUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		String uploadMessage=ExcelUtility.getStringData(0, 0, Constants.UPLOAD_PAGE);
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        home.clickTourButton();
        home.clickContactMenu();
        home.clickImportMenu();
        UploadContactsPage upload = home.clickImportMenu();
        upload.fileUpload();
        upload.clickSubmitButton();
        Assert.assertEquals(upload.getUploadMessage(), uploadMessage,Messages.UPLOAD_FAILED);
        
	}

}
