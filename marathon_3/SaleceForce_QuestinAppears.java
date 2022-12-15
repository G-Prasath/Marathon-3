package marathon_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaleceForce_QuestinAppears extends BaseClass {
	
	@BeforeTest
	public void fileCall() {
		excelName = "salceforce";
	}
	
	@Test(dataProvider = "integrate")
	public void runSaleceForce_QuestinAppears(String question, String description) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		
		WebElement Chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click()", Chatter);
		System.out.println("Title of the Page : "+driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@data-placeholder,'If you have more to say, add details here...')]")).sendKeys(description);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		
		String Result = driver.findElement(By.xpath("(//div[@data-aura-class='forceChatterFeedBodyQuestionWithoutAnswer'])[1]//span[text()='"+question+"']")).getText();
		System.out.println(Result);
		
		if(question.contains(Result)) {
			System.out.println("Question Is Appear");
		}
		else {
			System.out.println("No question Appear");
		}

	}

}
