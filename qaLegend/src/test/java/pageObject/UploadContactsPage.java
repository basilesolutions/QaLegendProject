package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationCore.BaseClass;

public class UploadContactsPage  {
	WebDriver driver;
	
	public void UploadContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name='contacts_csv']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement submitButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement successMessage;
	
	public void fileUpload()
	{
		chooseFile.sendKeys("\\src\\main\\resources\\Files\\Upload.csv");
	}
	public void clickSubmitButton() {
		submitButton.click();
		
	}
  public String getUploadMessage() {
	return successMessage.getText();
}
}
