package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

	WebDriver driver;

	 public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	// @FindBy(xpath = "//span[@class='pull-right-container']")
	 //WebElement userManagementdropdown;
	 //@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	 //WebElement userDropDown;

	/*
	 * @FindBy(id = "username") WebElement usernamefield;
	 * 
	 * @FindBy(id = "password") WebElement passwordfield;
	 * 
	 * @FindBy(xpath = "//button[@type='submit']") WebElement submitButton;
	 */
	@FindBy(xpath = "//span[@class='pull-right-container']")
	WebElement mainDropDown;
	@FindBy(xpath = "//span[@class='title' and contains(text(),'Users')]")  
	WebElement userDropdown;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addUserButton;
	@FindBy(xpath = "//input[@id='surname']")
	WebElement prefixfield;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//span[@id='select2-role-container']") 
	WebElement roleDropDown;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameForLogin;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordForLogin;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPassword;
	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement commision;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement submitClick;
	
	
	
	/*
	 * public void enterUsername(String userName) {
	 * usernamefield.sendKeys(userName);
	 * 
	 * }
	 * 
	 * public void enterPassword(String password) {
	 * passwordfield.sendKeys(password);
	 * 
	 * }
	 * 
	 * public void clickSubmitButton() { submitButton.click();
	 * 
	 * }
	 */

	public void clickMainDropDown() {
		mainDropDown.click();

	}

	public void clickUserDropdown() {
		userDropdown.click();
	}

	public void clickAdduserButton() {
     addUserButton.click();
	}

	public void enterPrefix(String prefix) {
		prefixfield.sendKeys(prefix);
		
	}
	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
		
	}
	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
		
	}
	public void enterEmail(String Email) {
		email.sendKeys(Email);
		
	}
	public void selectRoleDropDown(String role) {
		roleDropDown.sendKeys(role);
		
	}
	public void enterUserName(String username) {
		usernameForLogin.sendKeys(username);
		
	}
	public void enterPasswordForLogin(String password) {
		passwordForLogin.sendKeys(password);
		
		
	}
	public void enterConfirmPassword(String password) {
		confirmPassword.sendKeys(password);
		
		
	}
	public void enterCommision(String commission) {
		commision.sendKeys(commission);
			
	}
	public void clickSubmit() {
		submitClick.click();
	}
}
