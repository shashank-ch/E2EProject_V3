package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
			
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@title='Search']")
	WebElement searchBar;
	
	@FindBy(xpath="//*[text()='Sign in']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[contains(text(),'Gmail')]")
	WebElement gmail;
	
	@FindBy(xpath="//input[@value='Google Search']")
	WebElement searchButton;
	
	
	public WebElement searchBar()
	{
		return searchBar;
	}
	
	public WebElement signInButton()
	{
		return signInButton;
	}
	
	public WebElement gmail()
	{
		return gmail;
	}
	
	public WebElement searchButton()
	{
		return searchButton;
	}
	
}
