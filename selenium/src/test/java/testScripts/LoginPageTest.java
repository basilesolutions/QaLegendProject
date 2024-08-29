package testScripts;

import java.io.IOException;

import org.automationcore.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends Baseclass {
	
	
	@Test(groups = {"smoke","regression"})
	public void userLoginWithValidCredentials()  {
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		String emailId=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getIntegerData(0, 1, "LoginPage");
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(emailId);
		
		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='Password']"));
		passwordfield.sendKeys(password);
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
		checkBox.click();
		WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButtton.click();
		
		//String expectedMail ="basil@ariesesolutions.com";
		WebElement mailid=driver.findElement(By.xpath("//a[text()='basil@ariesesolutions.com']"));
		String actualEmailId = mailid.getText();
		Assert.assertEquals(actualEmailId,emailId,"Login success");
		
	}
	
	//@Test
//	public void userLoginWithValidEmailAndInvalidPassword() 
//	{
//		
//		driver.get("https://demowebshop.tricentis.com/login");
//		
//		String emailId=ExcelUtility.getStringData(1, 0, "LoginPage");
//		String password=ExcelUtility.getIntegerData(1, 1, "LoginPage");
//		String expectedErrorMessage=ExcelUtility.getStringData(4, 0, "LoginPage");
//		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
//		email.sendKeys(emailId);
//				
//		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='Password']"));
//		passwordfield.sendKeys(password);
//		WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
//		checkBox.click();
//		WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
//		loginButtton.click();
//		
//		
//		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span")).getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
//		Assert.assertEquals(actualErrorMessage,expectedErrorMessage, "Invalid Error Message");
//		
//	}
	
	//@Test
	//public void userLoginWithInValidEmailAndvalidPassword() 
	//{
	//	driver.get("https://demowebshop.tricentis.com/login");
	//	String emailId=ExcelUtility.getStringData(2, 0, "LoginPage");
	//	String password=ExcelUtility.getIntegerData(2, 1, "LoginPage");
	//	String finalErrorMessage=ExcelUtility.getStringData(4, 0, "LoginPage");
	//	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
	//	email.sendKeys(emailId);
		
		
		
	//	WebElement passwordfield = driver.findElement(By.xpath("//input[@id='Password']"));
	//	passwordfield.sendKeys(password);
	//	WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
	//	checkBox.click();
	//	WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	//	loginButtton.click();
		
		//String expectedErrorMessage = finalErrorMessage;
		//String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span")).getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
		//Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
		
		
	//}
	//@Test
	//public void userLoginWithInValidEmailAndInvalidPassword() 
	//{
	//	driver.get("https://demowebshop.tricentis.com/login");
		
	//	String emailId=ExcelUtility.getStringData(3,0, "LoginPage");
	//	String password3=ExcelUtility.getIntegerData(3,1, "LoginPage");
	//	String finalErrorMessage=ExcelUtility.getStringData(4, 0, "LoginPage");
	//	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
	//	email.sendKeys(emailId);
		
		
	//	WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
	//	password.sendKeys(password3);
	//	WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
	//	checkBox.click();
	//	WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	//	loginButtton.click();
		
	//	String expectedErrorMessage = finalErrorMessage;
	//	String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span")).getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
	//	Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
			
	//}
	
	@Test(dataProvider = "InvalidUserCredentials",dataProviderClass = DataProviders.class)
	public void verifyInvalidUserLoginWithDataProvider(String username,String userPassword) throws IOException {
		
	driver.get("https://demowebshop.tricentis.com/login");
		
	String Message=ExcelUtility.getStringData(5, 0, "LoginPage");
		
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(username);
		
		
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys(userPassword);
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
		checkBox.click();
		WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButtton.click();
		
		String expectedErrorMessage = Message;
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
		
	}
}
