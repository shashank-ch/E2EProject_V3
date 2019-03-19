package CodeAcademy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SignInPage;


public class TitleValidation extends Base_Main {
	
	public static Logger log = LogManager.getLogger(Base_Main.class.getName());
	
	@BeforeTest
	public void browserSetup() throws IOException
	{
		driver = initilaiseDriver();
		
		log.info("Title Validation is Open");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		log.info("Title Validation is Closed");
	}


	@Test(dataProvider="getData")
	public void homePage(String username, String password) throws InterruptedException
	{
		driver.get(url);//changed it from before test
		LandingPage lp=new LandingPage(driver);
		lp.signInButton().click();
		SignInPage sp=new SignInPage(driver);
		sp.email().sendKeys(username);
		sp.next().click();
		Thread.sleep(4000L);
		if(sp.password().isDisplayed()) {
			sp.password().sendKeys(password);
			sp.next().click();
			Thread.sleep(2000L);
			
			System.out.println("Text is : "+sp.wrongPwd().getText());
			//Assert.assertEquals(sp.wrongPwd().getText(), "ddWrong password. Try again or click Forgot password to reset it.");
			//log.info("Title Validation is Successful");
			//Assert.assertTrue((sp.wrongPwd().getText()).equalsIgnoreCase("ddWrong password. Try again or click Forgot password to reset it."));

			//Assert.assertEquals(sp.wrongPwd().getText(), "ddWrong password. Try again or click Forgot password to reset it.", "Title validation failed");
			//log.info("Title Validation is Successful");
			
			if((sp.wrongPwd().getText()).equalsIgnoreCase("ggWrong password. Try again or click Forgot password to reset it.")){
				
				log.info("Title Validation is Successful");
				Assert.assertTrue(true);
			}
			else
			{
				
				log.error("Title Validation Failed");
				Assert.assertTrue(false);
			}
			
		}
		
						
	}
	
	

	@DataProvider		
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "ThisIsUserName3";
		data[0][1] = "ThisisPassword3";
						
		return data;
		
	}

}
