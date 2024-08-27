package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pageObject.LoginPage;
import pageObject.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends BaseClass{
	
	@Test
	
	public void verifyResetPageWithValidMail() throws IOException {
		
		String email =ExcelUtility.getStringData(0, 0, "ResetScreen");
		String confirmMessage =ExcelUtility.getStringData(1, 0, "ResetScreen");
		
		//WebElement forgotClick=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		//forgotClick.click();
		//WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		//emailField.sendKeys(email);
		//WebElement passwordResetButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		//passwordResetButton.click();
		LoginPage login =new LoginPage(driver);
		
		ResetPage reset=login.forgotPasswordButton();
		reset.enterForgotPasswordEmail(email);
		reset.sendPasswordResetButton();
		String successMessage=reset.getText();
		Assert.assertEquals(successMessage, confirmMessage);
		
		
		
		//WebElement resetMessage=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		//String finalmessage=resetMessage.getText();
		//Assert.assertEquals(finalmessage, confirmMessage, "Not working");
		
	}
	
	@Test
	public void verifyResetPageWithInvalidMail() throws IOException {
		
		String email =ExcelUtility.getStringData(4, 1, "ResetScreen");
		String invMessage =ExcelUtility.getStringData(5, 1, "ResetScreen");
		WebElement forgotClick=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotClick.click();
		WebElement emailField=driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys(email);
		WebElement passwordResetButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		passwordResetButton.click();
		
		WebElement invalidmessage=driver.findElement(By.xpath("//span[@class='help-block']/strong"));
		String invalidMessage=invalidmessage.getText();
		Assert.assertEquals(invalidMessage,invMessage,  "Message not correct");
		
	}

}
