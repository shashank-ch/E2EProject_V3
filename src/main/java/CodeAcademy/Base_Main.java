package CodeAcademy;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


public class Base_Main {
	public static WebDriver driver = null;
	public String url, username, password;
	public static Logger log = LogManager.getLogger(Base_Main.class.getName());
	
	
	
	public  WebDriver initilaiseDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\shashank\\E2EProject\\src\\main\\java\\resources\\InputData.properties");
		//changed the path to resources
		prop.load(fis);
		url = prop.getProperty("url");
		//username = prop.getProperty("username");
		//password = prop.getProperty("password");
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser is Open");
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
		
			System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");
			driver = new FirefoxDriver();	
			log.info("Firefox Browser is Open");
		
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\work\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE Browser is Open");

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
		return driver;

}
	public void getScreenshot(String testName) throws IOException
	{
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr, new File("D:\\test\\"+testName+"_Screenshot.png"));
		
	}
	
	
}
