package practicePageModule;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticePage_002
{
	public WebDriver driver;

	
	@BeforeClass
	public void LaunchingBrowser()
	{
		System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("	https://rahulshettyacademy.com/AutomationPractice/");	
		driver.manage().window().maximize();
		String expectedValue = "Practice Page";
		String ActualValue = driver.getTitle();
		Assert.assertEquals(expectedValue, ActualValue);
	}

	
	@Test(groups={"smoke"})
	public void test_003()
	{
		System.out.println("Smoke2");
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));	
		s.selectByValue("option3");
	}

	@Test
	public void test_004()
	{
		Assert.assertFalse(	driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertTrue(	driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
	}


	@Test
	public void test_005()
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("button[onclick='openWindow()']")).click();

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
}
