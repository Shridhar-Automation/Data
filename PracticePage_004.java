package practicePageModule;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticePage_004
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

	@Test
	public void test_009()
	{
		WebElement table = driver.findElement(By.cssSelector("table[id='product'] tbody"));

		List<WebElement> s = table.findElements(By.xpath("//td[text()='Rahul Shetty']/following-sibling::td[2]"));
		int count =0;
		for(int i=0;i<s.size();i++)
		{
			String data = table.findElements(By.xpath("//td[text()='Rahul Shetty']/following-sibling::td[2]")).get(i).getText();
			int total = Integer.parseInt(data);
			count = count+total;
		}
		System.out.println("The total price of course is : "+count);	
	}

	@Test
	public void test_010()
	{

		Actions act = new Actions(driver);

		WebElement target = driver.findElement(By.cssSelector(".mouse-hover"));
		String before = driver.getCurrentUrl();

		WebElement target1 = driver.findElement(By.cssSelector("div[class='mouse-hover-content'] a:nth-child(1)"));

		act.moveToElement(target).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.click(target1).build().perform();

		String after = driver.getCurrentUrl();
		Assert.assertNotEquals(before, after);

		driver.navigate().back();

	}
}
