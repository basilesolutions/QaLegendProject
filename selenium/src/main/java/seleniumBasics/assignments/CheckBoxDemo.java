package seleniumBasics.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {
	
	public void verifySingleCheckboxDemo() {
		boolean ischeckboxSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		WebElement singlecheckbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		ischeckboxSelected = singlecheckbox.isSelected();
		System.out.println("check box before selection :"+ischeckboxSelected);
		singlecheckbox.click();
		ischeckboxSelected=singlecheckbox.isSelected();
		System.out.println("checkbox after selection :" +ischeckboxSelected);
		driver.close();
	}
	
	public void verifyMutipleCheckBoxDemo() {
		
		boolean isCheckBoxSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		WebElement checkboxThree = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		isCheckBoxSelected=checkboxThree.isSelected();
		System.out.println("Checkbox before selection:"+isCheckBoxSelected);
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='button-two']"));
		selectAllButton.click();
		isCheckBoxSelected=checkboxThree.isSelected();
		System.out.println("Checkbox after selection:"+isCheckBoxSelected);
		driver.close();
	}
	public static void main(String[] args) {
		
		CheckBoxDemo checkboxdemo= new CheckBoxDemo();
		//checkboxdemo.verifySingleCheckboxDemo();
		checkboxdemo.verifyMutipleCheckBoxDemo();

	}

}
