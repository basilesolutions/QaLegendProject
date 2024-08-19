package org.automationcore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baseclass {
	public WebDriver driver;
	public void intializeBrowser(String browser) {
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equals("Edge")) {
			driver=new EdgeDriver();
			
		}
		else
		{
			throw new RuntimeException("Invalid Browser");
			
		}
		driver.manage().window().maximize();
		//driver.get("");
	}
	@BeforeMethod
	@Parameters("browser")
	
	public void setBrowser(String browserName) {
		
		intializeBrowser(browserName);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus() ==ITestResult.FAILURE)
		{
			takeScreenshot(result);
			
		}
		
			
		driver.close();
		
	}
	public void takeScreenshot(ITestResult result) throws IOException {
		TakesScreenshot takescreenshot =(TakesScreenshot) driver; //taking reference of the interface
		File screenshot =takescreenshot.getScreenshotAs(OutputType.FILE); //save file
		FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png")); //folder creation and file saving with png format
	}
	

}
