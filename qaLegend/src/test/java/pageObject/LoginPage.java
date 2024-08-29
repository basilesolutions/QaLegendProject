 package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath ="//a[@class='btn btn-link']")
	WebElement forgotPasswordButton;
	
	
	
	
	public void enterUsername(String userName) {
		usernamefield.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
				
		
	}
	public HomePage submitButton() {
		submitButton.click();
		return new HomePage(driver);
		
	}
	public ResetPage forgotPasswordButton() {
		forgotPasswordButton.click();
		return new ResetPage(driver);
		
		
	}
	
	
}

