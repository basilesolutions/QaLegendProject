package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	private static final long IMPLICITLYWAIT = 10;
	private static final long EXPLICITYWAIT = 10;
	public static void waitForanElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLYWAIT));
		
		
	}

	public static void waitForElementToBeClickabale(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITYWAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
