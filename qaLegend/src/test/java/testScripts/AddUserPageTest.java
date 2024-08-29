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
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pageObject.AddUserPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends BaseClass {
	
	@Test
	public void verifyAddUser() {
		
		
		String userName = ExcelUtility.getStringData(0, 0, "LoginScreen");	
		String password = ExcelUtility.getIntegerData(0, 1, "LoginScreen");
		
		String prefix = RandomDataUtility.getPrefix();
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String email=firstName +"." +lastName+"@gmail.com";
		String role = ExcelUtility.getStringData(3, 1, "AddUser");
		String admin =firstName+"123";
	
		String userPassword=firstName +"@"+lastName;
		String salesPercent= ExcelUtility.getIntegerData(6, 0, "AddUser");
		
		LoginPage login=new LoginPage(driver);	
        login.enterUsername(userName);
        login.enterPassword(password);
        HomePage home=login.submitButton();
        home.clickTourButton();
        
       AddUserPage user=new AddUserPage(driver);
       user.clickMainDropDown();
       user.clickUserDropdown();
       user.clickAdduserButton();
       user.enterPrefix(prefix);
       user.enterFirstName(firstName);
       user.enterLastName(lastName);
       user.enterEmail(email);
       //user.selectRoleDropDown(role);
       user.enterUserName(userName);
       user.enterPasswordForLogin(userPassword);
       user.enterConfirmPassword(userPassword);
       user.enterCommision(salesPercent);
       user.clickSubmit();
      
        
        
        
		
//		WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
//		userNameField.sendKeys(userName);
//		WebElement passwordFeild = driver.findElement(By.xpath("//input[@id='password']"));
//		passwordFeild.sendKeys(password);
//		WebElement rememberMeBox =driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
//		rememberMeBox.click();
//		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//		loginButton.click();
//		 WebElement endTourButton =driver.findElement(By.xpath("//button[text()=\"End tour\"]"));
//		 endTourButton.click();
//		
//		WebElement userManagementDropDown=driver.findElement(By.xpath("//span[@class='pull-right-container']"));
//		userManagementDropDown.click();
//		
//		
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement users =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")));
//	    users.click();
//	    
//	    
//		WebElement addUser=driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
//		addUser.click();
//		
//		
//		WebElement prefixField=driver.findElement(By.xpath("//input[@id='surname']"));
//		prefixField.sendKeys(prefix);
//		
//		
//		WebElement firstNameField=driver.findElement(By.xpath("//input[@name='first_name']"));
//		firstNameField.sendKeys(firstName);
//		
//		
//		WebElement lastNameField=driver.findElement(By.xpath("//input[@name='last_name']"));
//		lastNameField.sendKeys(lasttName);
//		
//		
//		WebElement emailField=driver.findElement(By.xpath("//input[@name='email']"));
//		emailField.sendKeys(email);
//		
//		
//		WebElement roleDropDown=driver.findElement(By.xpath("//span[@id='select2-role-container']"));
//		roleDropDown.click();
//		
//		List<WebElement> rolelist=driver.findElements(By.xpath("//li[@class='select2-results__option']"));
//		
//		for(int i=0; i<rolelist.size();i++) {
//			if (rolelist.get(i).getText().equals(role)) {
//				rolelist.get(i).click();
//				break;
//			}
//		}
//		
//		
//		WebElement usernameField=driver.findElement(By.xpath("//input[@id='username']"));
//		usernameField.sendKeys(admin);
//		
//		 
//		WebElement userpasswordField=driver.findElement(By.xpath("//input[@id='password']"));
//		userpasswordField.sendKeys(userPassword);
//		
//		WebElement confirmPasswordField=driver.findElement(By.xpath("//input[@id='confirm_password']"));
//		confirmPasswordField.sendKeys(password);
//		
//		
//		WebElement salesBox=driver.findElement(By.xpath("//input[@id='cmmsn_percent']"));
//		salesBox.sendKeys(salesPercent);
//		
//		WebElement saveButton=driver.findElement(By.xpath("//button[@id='submit_user_button']"));
//		saveButton.click();
//		
//		
//		
//		
//		
//		
//		
//		
}

}
