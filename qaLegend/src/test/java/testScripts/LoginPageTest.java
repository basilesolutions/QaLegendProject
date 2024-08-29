package testScripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constants;
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
        LoginPage login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        String actualText=home.getLoginText();
        Assert.assertEquals(actualText, finalMessage);
		
		//WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
		//userNameField.sendKeys(userName);
		//WebElement passwordFeild = driver.findElement(By.xpath("//input[@id='password']"));
		//passwordFeild.sendKeys(password);
		//WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		//loginButton.click();

		//WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome Admin')]"));
		//String message = welcomeMessage.getText();
		//Assert.assertEquals(finalMessage, message, "Admin  not logged in Successfully");

	}

	@Test
	public void verifyLoginErrorMessageWithInvalidCredentials() {

		String userName = ExcelUtility.getStringData(2, 0, "LoginScreen");
		String password = ExcelUtility.getIntegerData(2, 1, "LoginScreen");
		String finalMessage = ExcelUtility.getStringData(3, 0, "LoginScreen");

		WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
		usernameField.sendKeys(userName);
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();

		WebElement welcomMessage = driver
				.findElement(By.xpath("//strong[contains(text(),'These credentials do not match our records.')]"));
		String message = welcomMessage.getText();
		Assert.assertEquals(finalMessage, message, "Not working");

	}

	@Test(dataProvider = "invalidData",dataProviderClass = DataProviders.class)
	public void InvalidDataDataProvider(String username,String password) throws IOException {
		
		String finalMessage = ExcelUtility.getStringData(3, 0, "LoginScreen");
		
		WebElement userNameField =driver.findElement(By.xpath("//input[@id='username']"));
		userNameField.sendKeys(username);
		WebElement passwordField=driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys(password);
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		
		
		WebElement message=driver.findElement(By.xpath("//strong[contains(text(),'These credentials do not match our records.')]"));
		String messageInfo=message.getText();
		Assert.assertEquals(finalMessage,messageInfo);
		

	}

}
