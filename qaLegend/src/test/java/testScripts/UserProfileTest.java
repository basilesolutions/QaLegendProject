package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import utilities.ExcelUtility;

public class UserProfileTest extends BaseClass {
	
	@Test
	public void VerifyEditProfile() {
		
		String userName = ExcelUtility.getStringData(0, 0, "LoginScreen");
		String password = ExcelUtility.getIntegerData(0, 1, "LoginScreen");
     	String prefixdata = ExcelUtility.getStringData(1, 0, "RegisterPage");
		
		WebElement userLogin=driver.findElement(By.xpath("//input[@id='username']"));
		userLogin.sendKeys(userName);
		
		WebElement passwordField=driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys(password);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		loginButton.click();
		
		WebElement endTourButton =driver.findElement(By.xpath("//button[text()=\"End tour\"]"));
		 endTourButton.click();
		 
		 WebElement adminMenu=driver.findElement(By.xpath("//li[@class='dropdown user user-menu']"));
		 adminMenu.click();
		
		 WebElement profile=driver.findElement(By.xpath("//a[text()='Profile']"));
		 profile.click();
		
		 WebElement editPrefix=driver.findElement(By.xpath("//input[@id='surname']"));
		 editPrefix.sendKeys("MR");
		 
	}

}
