package marathon_3;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Account_Creating extends BaseClass{
	
	@BeforeTest
	public void fileCall() {
		excelName = "accountcreate";
	}

	@Test(dataProvider = "integrate")
	public void runAccount_Creating(String fname, String lname, String email) {
				
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contacts");
		driver.findElement(By.xpath("//mark[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Salutation']")).click();
		driver.findElement(By.xpath("//span[text()='Mr.']")).click();
		driver.findElement(By.xpath("//label[text()='First Name']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//label[text()='Last Name']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
		
		driver.findElement(By.xpath("//label[text()='Account Name']")).click();
		driver.findElement(By.xpath("//span[text()='Credits']")).click();
		
		driver.findElement(By.xpath("//label[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String name = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//div")).getText();
		name = "Contact "+name+" was Created";
		
		System.out.println(name);	

	}

}
