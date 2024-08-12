package org.seleneium.testNgCommands;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.automationcore.Baseclass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands  extends Baseclass{
	
	@Test
	
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com/");
		String title = driver.getTitle();
		System.out.println("Title is;"+""+ title);
		String expectedTitle="Demo Web Shop. Login";
		Assert.assertEquals(title, expectedTitle,"Title Mismatch");
		
		
	}
	
	
	
	@Test
	public void VerifyLogin() {
		driver.get("https://demowebshop.tricentis.com/login");
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("basil@ariesesolutions.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("123456");
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='RememberMe']"));
		boolean ischeckboxselected=checkBox.isSelected();
		System.out.println("check box before selected"+ischeckboxselected);
		checkBox.click();
		ischeckboxselected =checkBox.isSelected();
		System.out.println("checkbx after click" + ischeckboxselected);
		WebElement loginButtton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButtton.click();
		
		String expectedMail ="basil@ariesesolutions.com";
		WebElement mailid=driver.findElement(By.xpath("//a[text()='basil@ariesesolutions.com']"));
		String actualEmailId = mailid.getText();
		Assert.assertEquals(actualEmailId, expectedMail,"login failed");
		
		
		
	}
	
	@Test
	
	public void verifyRadioButton ()
	{
		boolean isButtonSelected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radioButtonFeMale = driver.findElement(By.xpath("//input[@id='gender-female']"));
		isButtonSelected = radioButtonFeMale.isSelected();
		Assert.assertFalse(isButtonSelected,"Female is selected");
		radioButtonFeMale.click();
		isButtonSelected = radioButtonFeMale.isSelected();
		Assert.assertTrue(isButtonSelected,"Female is not selected");
		
	}
	
	 @Test
	public void verifySwagLabsLogin() {
		driver.get("https://www.saucedemo.com/");
		WebElement  usernamefield = driver.findElement(By.xpath("//input[@id='user-name']"));
		usernamefield.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
		WebElement pageHeading = driver.findElement(By.xpath("//div[@class='app_logo']"));
		Assert.assertEquals(pageHeading.getText(), "Swag Labs","Login is not successful");
		
		
	}
	@Test
	public void verifyJavaScriptExecutorSendKeysandClick() {
//		driver.get("https://demowebshop.tricentis.com/");
//		JavascriptExecutor javascriptexecutor=(JavascriptExecutor) driver;
//		javascriptexecutor.executeScript("document.getElementById(\"newsletter-email\").value='basil@gmail.com'");
//		javascriptexecutor.executeAsyncScript("document.getElementById(\"newsletter-subscribe-button\").click()");

		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver; // another way of creating reference
		javascriptexecutor.executeScript("document.getElementById(\"newsletter-email\").value='test@gmail.com'");
		javascriptexecutor.executeScript("document.getElementById(\"newsletter-subscribe-button\").click()");
		
	}
	
	@Test
	public void verifyJavaScriptScoll() {
		
		driver.get("https://demoqa.com/forms");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		//javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		javascriptexecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		javascriptexecutor.executeScript("window.scrollBy(0,1000)");
		
		
		
	}
	
	@Test
	public void verifyWaitCommands() {
		driver.get("https://demoqa.com/alerts");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement click = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		click.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert =driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void verifyFluentWait() {
		
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement click = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        FluentWait fluentwait = new FluentWait(driver);
        fluentwait.withTimeout(Duration.ofSeconds(20));
        fluentwait.pollingEvery(Duration.ofSeconds(2));
        fluentwait.ignoring(NoSuchElementException.class);
        click.click();
        fluentwait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();


	}


}
