package AutomationConcepts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Automation {

	public WebDriver driver;

	Automation()
	{			
		System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
		driver = new ChromeDriver();	

		//	System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");	
		//driver = new FirefoxDriver();

	}


	public void test1()
	{

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		String expectedValue = "Practice Page";
		String ActualValue = driver.getTitle();
		Assert.assertEquals(expectedValue, ActualValue);
	}

	public void test2()
	{
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();	
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
	}

	public void test3()
	{		
		WebElement auto = driver.findElement(By.id("autocomplete"));
		auto.sendKeys("India");	
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		int i=0;
		while(i<2)
		{
			wait.until(ExpectedConditions.elementToBeClickable(auto));
			auto.sendKeys(Keys.ARROW_DOWN);
			i++;
		}
		auto.sendKeys(Keys.ENTER);
	}

	public void test4()
	{
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));	
		s.selectByValue("option3");
	}

	public void test5()
	{
		Assert.assertFalse(	driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertTrue(	driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
	}

	public void test6()
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("button[onclick='openWindow()']")).click();

		String parentWindow	=	driver.getWindowHandle();
		String parent = driver.getTitle();

		Set<String> wh =	driver.getWindowHandles();
		Iterator<String> it = 	wh.iterator();

		/*String parentPage = (String) it.next();
		String childPage = (String) it.next();
		Assert.assertNotEquals(parentPage, childPage);
		driver.switchTo().window(parentPage);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childPage);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentPage);*/

		while(it.hasNext())
		{
			driver.switchTo().window((String) it.next());
		}
		Assert.assertNotEquals(driver.getTitle(), parent);
		driver.close();
		driver.switchTo().window(parentWindow);
		Assert.assertEquals(parent, driver.getTitle());

	}

	public void test7()
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

	public void test8()
	{
		driver.findElement(By.cssSelector("#name")).sendKeys("Shridhar");
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.cssSelector("#confirmbtn")).click();
		driver.switchTo().alert().dismiss();
	}

	public void test9()
	{	
		driver.findElement(By.cssSelector("#hide-textbox")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("#displayed-text")).isDisplayed());

		driver.findElement(By.cssSelector("#show-textbox")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#displayed-text")).isDisplayed());
	}


	public void test10()
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


/*	public void test11()
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

	}*/

	public void test12()
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
			driver.switchTo().defaultContent();
			System.out.println("Exception catched - Synchronization issue");
		}
	}

	public void test13()
	{

		String beforeClick = driver.getTitle();
		WebElement footer	=	driver.findElement(By.cssSelector("#gf-BIG"));
		WebElement secondColumn = 		footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]"));
		//CSS for SecondColumn- #gf-BIG > table > tbody > tr > td:nth-child(2)

		secondColumn.findElement(By.xpath("//a[@href='https://www.imbrokenlink.com']")).click();
		String AfterClick = driver.getTitle();
		Assert.assertNotEquals(beforeClick, AfterClick);
	}
	
	public void test14()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	

	public static void main(String[] args)
	{

		Automation a = new Automation();
		a.test1();

		a.test3();
	a.test2();
		a.test4();
		a.test5();
		a.test6();
		a.test7();
		a.test8();
		a.test9();
		a.test10();
//		a.test11();
		a.test12();
		a.test13();
		a.test14();
	}


}	
