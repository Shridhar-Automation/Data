package practicePageModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticePage_001
{
		
public WebDriver driver;

@BeforeTest
public void btest()
{
	System.out.println("before test");
}


@BeforeClass
public void LaunchingBrowser()
{
	System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
	driver.manage().window().maximize();
	String expectedValue = "Practice Page";
	String ActualValue = driver.getTitle();
	Assert.assertEquals(expectedValue, ActualValue);
}

@Test(groups={"smoke"})	
	public void test_001()
	{
	System.out.println("smoke1");
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();	
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
	}

	@Test
	public void test_002()
	{		
		WebElement auto = driver.findElement(By.id("autocomplete"));
		auto.sendKeys("India");	
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.elementToBeClickable(auto));
		int i=0;
		while(i<2)
		{
			wait.until(ExpectedConditions.elementToBeClickable(auto));
			auto.sendKeys(Keys.ARROW_DOWN);
			i++;
		}
		auto.sendKeys(Keys.ENTER);
	}


}
