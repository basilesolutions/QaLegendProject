package seleniumBasics;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Commands {
	
	
	public void verifySwagLabsLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		System.out.println("End of the code");
		driver.close();

	}

	public void verifyIsselected()
	{
		boolean isButtonSelected;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radioButtonMale=driver.findElement(By.xpath("//input[@id='gender-male']"));
		isButtonSelected = radioButtonMale.isSelected();
		System.out.println("male element before selection"+isButtonSelected);
		radioButtonMale.click();
		isButtonSelected = radioButtonMale.isSelected();
		System.out.println("male element after selection"+isButtonSelected);
		driver.close();
	}

	public void verifyIsEnabled() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		WebElement suscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isButtonEnabled = suscribeButton.isEnabled();
		System.out.println("Button is Enabled" +isButtonEnabled);
		driver.close();
		
		
	}
	public void verifyIsDisplayed() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
	    boolean isButtonDisplayed=voteButton.isDisplayed();
	    System.out.println("Button is displayed :"+isButtonDisplayed);    
	}

	public void verifyValuesFromDropdown()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText("ANTARCTICA");
		//select.selectByValue("AMERICAN SAMOA");
		//select.selectByIndex(6);
		WebElement getCountryName=select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());
		driver.close();
		
	}
	
	public void getTotalDropDownValues()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countrydropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(countrydropdown);
		List<WebElement> dropdownlist= select.getAllSelectedOptions(); 
		System.out.println("Total number of values in drodownlist "+dropdownlist.size());
		driver.close();
	}
	
	public void verifySimpleAlert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickbutton =driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickbutton.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//driver.close();
	}
	
	
	public void verifyConfirmAlert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickbutton =driver.findElement(By.xpath("//button[@id='confirmButton']"));
		clickbutton.click();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		//driver.close();
	}
	
	public void verifyPromptAlert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickbutton =driver.findElement(By.xpath("//button[@id='promtButton']"));
		clickbutton.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("basil");
		alert.dismiss();
		//driver.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Commands cmd = new Commands();
		//cmd.verifySwagLabsLogin();
		//cmd.verifyIsSelected();
		//cmd.verifyIsEnabled();
		//cmd.verifyIsDisplayed();
		
		//cmd.getTotalDropDownValues();
		//cmd.verifySimpleAlert();
		cmd.verifyConfirmAlert();
		cmd.verifyPromptAlert();

	}

}
