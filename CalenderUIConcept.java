package AutomationConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderUIConcept {


	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.spicejet.com/default.aspx");
		driver.manage().window().maximize();

		String month= "November 2020";
		String month1 = "January 2021";
		String day = "27";
		String day1 = "07";



		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);


		WebDriverWait wait = new WebDriverWait(driver,5);


		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))));

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		driver.findElement(By.xpath("//a[@value='GOI']")).click();

		driver.findElement(By.xpath("//div[@class='right1'] //a[@value='BLR']")).click();

		while(true)
		{
			String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//div[@class='ui-datepicker-title']")).getText();

			if(text.contains(month))
			{
				break;
			}
			else	
			{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}

		}

		List<WebElement> expDay = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		for(int i=0;i<expDay.size();i++)
		{
			String date = 	expDay.get(i).getText();

			if(date.contains(day))
			{
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
			}

		}

	}


}
