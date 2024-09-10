package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {

	WebDriver driver;

	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement buttonClick;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement noMailMessage;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement successMessage;

	public void enterForgotPasswordEmail(String email) {
		emailField.sendKeys(email);

	}

	public void sendPasswordResetButton() {
		buttonClick.click();

	}

	public String emailNotFoundMessage() {
		return noMailMessage.getText();
	}
	public String emailSendMessage() {
		return successMessage.getText();
	}


}
