package testScripts;

import java.io.IOException;

import org.automationcore.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class RegisterPageTest extends Baseclass {
	
	@Test
	public void verifyUserRegistration() throws IOException {
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		String name=ExcelUtility.getStringData(0, 0, "RegisterPage");
		String lastname=ExcelUtility.getStringData(0, 1, "RegisterPage");
		String password=ExcelUtility.getIntegerData(0, 2, "RegisterPage");
		String email=ExcelUtility.getStringData(0, 4, "RegisterPage");
		String message=ExcelUtility.getStringData(0, 3, "RegisterPage");
		
		WebElement register=driver.findElement(By.xpath("//input[@class='button-1 register-button']"));
		register.click();
		WebElement radioButtonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		radioButtonMale.click();
		
		
		WebElement namefield=driver.findElement(By.xpath("//input[@id='FirstName']"));
		namefield.sendKeys(name);
		WebElement  lastNamefield=driver.findElement(By.xpath("//input[@id='LastName']"));
		lastNamefield.sendKeys(lastname);
		WebElement  emailfield=driver.findElement(By.xpath("//input[@id='Email']"));
		emailfield.sendKeys(email);
		WebElement  passwordfield=driver.findElement(By.xpath("//input[@id='Password']"));
		passwordfield.sendKeys(password);
		WebElement  confirmpassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys(password);
		WebElement  registerButton=driver.findElement(By.xpath("//input[@id='register-button']"));
		registerButton.click();
		
		
		String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(actualMessage, message, "Inavlid Message");
		
		//String expectedEmail="basil@ariesesolutions.com";
		//String actualEMail=driver.findElement(By.xpath("//a[@class='account']")).getText();
		//Assert.assertEquals(actualEMail, expectedEmail,"Inavlid Email id");
		
	}

}
