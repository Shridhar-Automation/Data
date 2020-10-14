package practicePageModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticePage_005
{
	public WebDriver driver;
	
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
	
	
	@Test(enabled = false)
	public void test_010()
	{

		int count = 	driver.findElements(By.tagName("iframe")).size();
		System.out.println("No. of frames in the page : " +count);

		try
		{
			WebElement frame  =	driver.findElement(By.cssSelector("iframe#courses-iframe"));

			driver.switchTo().frame(frame);

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/courses']"))));
			driver.findElement(By.xpath("//a[@href='https://courses.rahulshettyacademy.com/courses']")).click();
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			System.out.println("Exception catched - Synchronization issue");
		}
	}

	@Test
	public void test_011()
	{

		String beforeClick = driver.getTitle();
		WebElement footer	=	driver.findElement(By.cssSelector("#gf-BIG"));
		WebElement secondColumn = 		footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]"));
		//CSS for SecondColumn- #gf-BIG > table > tbody > tr > td:nth-child(2)

		secondColumn.findElement(By.xpath("//a[@href='https://www.imbrokenlink.com']")).click();
		String AfterClick = driver.getTitle();
		Assert.assertNotEquals(beforeClick, AfterClick);
	}
	
}
