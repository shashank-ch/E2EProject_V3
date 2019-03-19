package CodeAcademy;

import java.io.IOException;
import pageObjects.LandingPage;
import pageObjects.SignInPage;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class HelpValidation extends Base_Main {
	
	//public static WebDriver driver;
	//gave it recently
	public static Logger log = LogManager.getLogger(Base_Main.class.getName());
	
	@BeforeTest
	public void browserSetup() throws IOException
	{
		driver = initilaiseDriver();
		driver.get(url);
		log.info("Help Validation is Open");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		log.info("Help Validation is closed");
	}


	@Test
	public void helpButton() throws InterruptedException
	{
		// TODO Auto-generated constructor stub
		
		LandingPage lp=new LandingPage(driver);
		lp.signInButton().click();
		SignInPage sp=new SignInPage(driver);
		
		
		Assert.assertTrue(sp.helpButton().isDisplayed(), "is not displayed");
		log.info("Help Validation is successful");
		
				
	}
	
	
	

	

}
