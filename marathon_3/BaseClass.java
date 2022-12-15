package marathon_3;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week7.day1.Data_Provider;

public class BaseClass {
	
	public RemoteWebDriver driver;
	String excelName;
	
	@Parameters({"browser"})
	@BeforeMethod()
	public void preCondition(String Browser) {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch=new ChromeOptions();
			ch.addArguments("--disable-notifications");
			driver = new ChromeDriver(ch);
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fx=new FirefoxOptions();
			fx.addArguments("--disable-notifications");
			driver = new FirefoxDriver(fx);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name = "integrate")
	public String[][] getData() throws IOException {
		String[][] data = Data_Provider.readData(excelName);
		return data;
		
	}
}
