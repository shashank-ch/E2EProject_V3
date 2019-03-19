package CodeAcademy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.SignInPage;



public class HomePage extends Base_Main {
	int count = 0;
	public static Logger log = LogManager.getLogger(Base_Main.class.getName());
	
	@BeforeTest
	public void browserSetup() throws IOException
	{
		driver = initilaiseDriver();
		//driver.get(url);
		log.info("HomePage Validation is Open");
	}
	
		
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String trial) throws InterruptedException, IOException {
				
		/*if(count>0)
		{
		 browserSetup();
		}*/
		driver.get(url);
		LandingPage lp=new LandingPage(driver);
		
		lp.searchBar().sendKeys(trial);
		lp.searchButton().click();
		//Thread.sleep(4000L);
		lp.signInButton().click();
		System.out.println(trial);
		SignInPage sp=new SignInPage(driver);
		sp.email().sendKeys(username);
		sp.next().click();
		Thread.sleep(4000L);
		if(sp.password().isDisplayed()) {
			sp.password().sendKeys(password);
			sp.next().click();
			Thread.sleep(2000L);
		}
		log.info("HomePage Validation is Successful for "+trial);
		//driver.close();
		//count++;
		
		
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver = null;
		log.info("HomePage Validation is closed");
	}
	
	
	@DataProvider		
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "ThisIsUserName1";
		data[0][1] = "ThisisPassword1";
		data[0][2] = "Trial-1";
		
		data[1][0] = "ThisIsUserName2";
		data[1][1] = "ThisisPassword2";
		data[1][2] = "Trial-2";
		
		return data;
		
	}
	
}