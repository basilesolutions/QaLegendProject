package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	
	public static boolean isEelementDisplayed(WebElement element) {
		
		boolean status=element.isDisplayed();
		return status;
	}
	
	

}
