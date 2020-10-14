package practicePageModule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticePage_006
{
	
	@Test(dataProvider= "provideData")
	public void getData(String Username, String Password)
	{
		System.out.println(Username);
	System.out.println(Password);
	}
	
	
	@DataProvider
	@Test()
	public Object[][] provideData()
	{
		Object [][] obj = new Object [3][2];
		obj[0][0]="user1";
		obj[0][1]="pass1";
		
		obj[1][0]="user2";
		obj[1][1]="pass2";

		obj[2][0]="user3";
		obj[2][1]="pass3";

		return obj;		
		
	}
	
	@Test
	public void property() throws IOException
	{
		Properties prop = new Properties();
				FileInputStream fis = new FileInputStream("E:\\Do It\\Practised Data\\Eclipse\\TestNGProject\\Utilities.properties");
				prop.load(fis);
				
System.out.println(prop.getProperty("browser"));	
System.out.println(prop.getProperty("url"));

prop.setProperty("browser", "firefox");
System.out.println(prop.getProperty("browser"));	

FileOutputStream fos = new FileOutputStream("E:\\Do It\\Practised Data\\Eclipse\\TestNGProject\\Utilities.properties");
prop.store(fos, null);


	}
	
	
	
	
}
