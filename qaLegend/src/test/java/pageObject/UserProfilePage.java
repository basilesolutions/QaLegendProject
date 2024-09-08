package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {
	WebDriver driver;
	public UserProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton;
	
	public void editEmail(String emailId) {
		email.clear();
		email.sendKeys(emailId);
				
	}
	public void updateButtonClick() {
		updateButton.click();
			}
	public String getEmail() {
		return email.getText();
		
	}
}
