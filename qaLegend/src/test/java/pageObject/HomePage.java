package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DateUtility;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[contains(text(), 'Welcome Admin')]")
	WebElement loginName;
	@FindBy(xpath = "//button[@data-role='end']")
	WebElement clickTourButton;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement adminButton;
	@FindBy(xpath = "//div[@class='pull-left']//a")
	WebElement profileButton;
	@FindBy(xpath = "//span[@class='pull-right-container']")
	WebElement mainDropDown;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	//@FindBy(xpath = "//span[normalize-space()='Users']")
	WebElement userDropdown;
	@FindBy(xpath = "//a[@class='btn btn-default btn-flat'and contains(text(),'Sign Out' )]")
	WebElement logout;
	@FindBy(xpath = "//i[@class='fa fa-dashboard']")
	WebElement homeIcon;
	@FindBy(xpath = "//section[@class='content-header']")
	WebElement loggeduserData;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
	WebElement loginDate;
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactMenu;
	@FindBy(xpath = "//a[text()=' Import Contacts']")
	WebElement importMenu;

	public String getLoginText() {
		String logName = loginName.getText();
		return logName;

	}

	public void clickTourButton() {
		clickTourButton.click();

	}

	public void clickAdmin() {
		adminButton.click();
	}

	public UserProfilePage clickProfileButton() {
		profileButton.click();
		return new UserProfilePage(driver);

	}

	public void clickMainDropDown() {
		mainDropDown.click();

	}

	public void clickUserDropdown() {
		userDropdown.click();
	}

	public void clickContactMenu() {
		contactMenu.click();

	}

	public LoginPage clickLogOut() {
		logout.click();
		return new LoginPage(driver);

	}

	public void clickHomeIcon() {
		homeIcon.click();
	}

	public String WelcomemessageForUserLogin() {
		String actualMessage = loggeduserData.getText();
		return actualMessage;

	}

	public UploadContactsPage clickImportMenu() {

		wait.until(ExpectedConditions.elementToBeClickable(importMenu)).click();
		return new UploadContactsPage();
	}

	public String getLoginDate() {
		return loginDate.getText();

	}

	public String getCurrentDate() {
		return DateUtility.getUserLoginDate("dd-MM-YYYY");
	}

}