package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath = "//h1[contains(text(), 'Welcome Admin')]")
	WebElement loginName;
	@FindBy(xpath="//button[@data-role='end']")
	WebElement clickTourButton;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
	WebElement loginDate;
	
	
	public String getLoginText() {
		String logName=loginName.getText();
		return logName;
		
		
	}
	public void clickTourButton() {
		clickTourButton.click();
		
	}
	
	public String getLoginDate() {
		return loginDate.getText();
		
	}
	
	public String getCurrentDate() {
		return DateUtility.getUserLoginDate("dd-MM-YYYY");
	}
	
}