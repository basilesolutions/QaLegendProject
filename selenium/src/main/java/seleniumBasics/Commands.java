package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.PublicKey;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	public void verifyRightClick() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclick=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action =new Actions(driver);
		action.contextClick(rightclick).build().perform();
		//driver.close();
		
	}
	 public void verifyDoubleClick() {
		 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclickfield=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions actiondouble=new Actions(driver);
		actiondouble.doubleClick(doubleclickfield).build().perform();
		Alert alertsimple=driver.switchTo().alert();
		alertsimple.accept();
	}
	 
	 public void verifymouseHover() {
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/menu/");
			WebElement mainlistmenu=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
			WebElement submenu=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
			Actions action=new Actions(driver);
			action.moveToElement(mainlistmenu).moveToElement(submenu).build().perform();
			
		 	
	}
	 public void verifyDragandDrop() {
		
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://selenium.qabible.in/drag-drop.php");
		 WebElement dragButton= driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		 WebElement dropSection=driver.findElement(By.xpath("//div[@id='mydropzone']"));
		 Actions act = new Actions(driver);
		 act.moveToElement(dragButton).build().perform();
		 act.contextClick(dragButton).build().perform();
		 act.dragAndDrop(dragButton, dropSection).build().perform();
		 
	}
	 
	 public void verifyDragandDropUsingOffset() {
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/dragabble");
		 WebElement dragButton=driver.findElement(By.xpath("//div[@id='dragBox']"));
		 Actions action= new Actions(driver);
		 action.dragAndDropBy(dragButton, 150, 100).build().perform();
		 
	}
	  public void frames() {
		  
		     WebDriver driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://demo.guru99.com/test/guru99home/");
			 WebElement iframe=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
			 driver.switchTo().frame(iframe);
			 WebElement jmeterImage=driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]"));
			 jmeterImage.click();
	}
	  public void multipleWindowHandling() {
		  WebDriver driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://webdriveruniversity.com/");
			 WebElement contactus = driver.findElement(By.xpath("//h1[text()='CONTACT US']"));
			 contactus.click();
			 WebElement loginbutton = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
			 loginbutton.click();
			 String parent =driver.getWindowHandle();
			 System.out.println("parent window"+parent);
			 Set<String> allWindows=driver.getWindowHandles();
			 for(String temp:allWindows) {
				 if(!temp.equals(parent)) {
				 System.out.println("indows:"+temp);
				 driver.switchTo().window(temp);
				 System.out.println(driver.getTitle());
				 System.out.println(driver.getCurrentUrl());
				 System.out.println("************");
			 }
			 }
		
	}
	  
	  public void verifyDynamicTable() {
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://money.rediff.com/indices/nse");
		  WebElement showMoreLink= driver.findElement(By.xpath("//a[@id='showMoreLess']"));
		  showMoreLink.click();
		  WebElement table= driver.findElement(By.xpath("//table[@id='dataTable']"));
		  //System.out.println(table.getText());
		  WebElement row = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[5]"));
		  System.out.println(row.getText());
		  List<WebElement> rows =table.findElements(By.tagName("tr"));
		  int rowSize =rows.size();
		  for (int i=0;i<rowSize;i++) {
			  List<WebElement> columns =rows.get(i).findElements(By.tagName("td"));
			  int columnSize = columns.size();
			  for(int j=0;j<columnSize;j++) {
				  String cellData=columns.get(j).getText();
				  if(cellData.equals("NIFTY BANK")) {
					  System.out.println("Previous close value is "+columns.get(1).getText());
				  }
			  }
		  }
		  driver.close();
		  
		 
	}
	  
	  public void verifyFileupload() {
		  
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement uploader=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		uploader.sendKeys("C:\\Users\\Basil\\git\\Selenium_Learning\\selenium\\src\\main\\resources\\File upload\\Daily status.txt");
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='terms']"));
		checkbox.click();
		WebElement submitbutton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitbutton.click();
		//driver.close();
	}
	  
	  public void verifyKeyBoardEvents() throws AWTException {
		  
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://demo.guru99.com/");
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_T);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_T);
		
	}
	  
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		Commands cmd = new Commands();
		//cmd.verifySwagLabsLogin();
		//cmd.verifyIsSelected();
		//cmd.verifyIsEnabled();
		//cmd.verifyIsDisplayed();
		
		//cmd.getTotalDropDownValues();
		//cmd.verifySimpleAlert();
		//cmd.verifyConfirmAlert();
		//cmd.verifyPromptAlert();
		//cmd.verifyRightClick();
		//cmd.verifyDoubleClick();
		//cmd.verifymouseHover();
		//cmd.verifyDragandDrop();
		//cmd.frames();
		//cmd.multipleWindowHandling();
		//cmd.verifyDynamicTable();
		//cmd.verifyFileupload();
		//cmd.verifyKeyBoardEvents();
		cmd.verifyDragandDropUsingOffset();

	}

}
