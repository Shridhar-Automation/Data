package practicePageModule;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticePage_003 
{
	
	public WebDriver driver;

	
	
	@BeforeClass
	public void launchingBrowser()
	{
		System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		driver.manage().window().maximize();
		String expectedValue = "Practice Page";
		String ActualValue = driver.getTitle();
		Assert.assertEquals(expectedValue, ActualValue);
	}
	
	@Test
	public void test_006()
	{
		driver.findElement(By.cssSelector("#opentab")).click();

		String parentWindow	=	driver.getWindowHandle();
		String parent = driver.getTitle();
		Set<String> wh =	driver.getWindowHandles();
		Iterator<String> it = 	wh.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window((String) it.next());
		}
		Assert.assertNotEquals(driver.getTitle(), parent);
		driver.close();
		driver.switchTo().window(parentWindow);
		Assert.assertEquals(parent, driver.getTitle());

	}

@Parameters({"name"})
	@Test
	public void test_007(String name)
	{
		driver.findElement(By.cssSelector("#name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.cssSelector("#confirmbtn")).click();
		driver.switchTo().alert().dismiss();
	}

	@Test(groups={"smoke"})
	public void test_008()
	{	
		System.out.println("Smoke3");
		driver.findElement(By.cssSelector("#hide-textbox")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("#displayed-text")).isDisplayed());

		driver.findElement(By.cssSelector("#show-textbox")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#displayed-text")).isDisplayed());
	}
}
