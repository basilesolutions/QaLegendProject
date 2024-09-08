package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class BaseClass {
	
	public WebDriver driver;
	public FileInputStream file;
	public Properties property;
	
	public void intializeBrowser(String browser) {
		try {
			file=new FileInputStream(Constants.CONFIG_FILE);
			property = new Properties();
			try {
				property.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		//driver.get("https://qalegend.com/billing/public/login");
		driver.get(property.getProperty("url"));
		
	}
	@BeforeMethod
	public void setBrowser() {
		
		intializeBrowser("Chrome");
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus() ==ITestResult.FAILURE)
		{
			takeScreenshot(result);
			
		}
		
			
		//driver.close();
		
	}
	public void takeScreenshot(ITestResult result) throws IOException {
		TakesScreenshot takescreenshot =(TakesScreenshot) driver; //taking reference of the interface
		File screenshot =takescreenshot.getScreenshotAs(OutputType.FILE); //save file
		FileUtils.copyFile(screenshot, new File("./Screenshots/"+result.getName()+".png")); //folder creation and file saving with png format
	}

}
