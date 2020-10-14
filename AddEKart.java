package AutomationConcepts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddEKart {

	public WebDriver driver;

	AddEKart()
	{			
		System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
		driver = new ChromeDriver();	
	}


	public void test1()
	{

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String expectedValue = "GreenKart - veg and fruits kart";
		String ActualValue = driver.getTitle();
		Assert.assertEquals(expectedValue, ActualValue);
	}


	public void test2()
{

		int j=0;

		String[] neededProducts = {"Brocolli", "Cucumber", "Beetroot"};	

		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));

		
		for(int i=0;i<products.size();i++)
		{

			String[] productsName=	products.get(i).getText().split("-");
			String actualItem = productsName[0].trim();

			List listedItems = Arrays.asList(neededProducts);
			
			if(listedItems.contains(actualItem))
			{		
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		
					
			if(j==3)
			{
				break;
			}
	
			}
	
		}
	}


	public static void main(String[] args) {
		AddEKart add = new AddEKart();
		add.test1();
		add.test2();
	}


}
