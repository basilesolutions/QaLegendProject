package testScripts;

import java.io.IOException;
import java.util.List;

import org.automationcore.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;
import utilities.ExcelUtility;

public class HomePageTest extends Baseclass {
	
	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Test(groups ="smoke" )
	public void verifyHomePageTitle()  {
		
		driver.get("https://demowebshop.tricentis.com/");
		String titleTag=ExcelUtility.getStringData(0, 0, "HomePage");
		String title = driver.getTitle();
		System.out.println("Title is;"+""+ title);
		String expectedTitle="test";
		Assert.assertEquals(title, expectedTitle,"Title Mismatch");
		
		
		
		
	}
	@Test(groups = "sanity")
	public void verifyCommunityPollSelection()  {
		driver.get("https://demowebshop.tricentis.com/");
		String selection=ExcelUtility.getStringData(1, 0, "HomePage");
		List<WebElement> polllist=driver.findElements(By.xpath("//li[@class='answer']"));
		String pollSelection=selection;
		
		for(int i=0;i<polllist.size();i++)
		{
			
			if (polllist.get(i).getText().equals(pollSelection))
					{
				    WebElement radioButton=polllist.get(i).findElement(By.tagName("input"));
				    radioButton.click();
				    boolean isRadioButtonSelected = radioButton.isSelected();
				    Assert.assertTrue(isRadioButtonSelected,"Button is not selected");
				    break;
					}
		}
		
		
		
		
		
	}
	
	

}
