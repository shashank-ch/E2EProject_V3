package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#identifierId")
	WebElement email;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement next;
	
	@FindBy(css="#profileIdentifier")
	WebElement profileId;
	
	@FindBy(css="input[type*='password']")
	WebElement password;
	
	@FindBy(xpath="//content[contains(text(),'Wrong password. Try again or click Forgot password')]")
	WebElement wrongPwd;
	
	@FindBy(xpath="//a[contains(text(),'Help')]")
	WebElement helpButton;
	
	public WebElement helpButton()
	{
		return helpButton;
	}
	
	public WebElement wrongPwd()
	{
		return wrongPwd;
	}
	
	public WebElement email()
	{
		return email;
	}
	
	public WebElement next()
	{
		return next;
	}
	
	public WebElement profileId()
	{
		return profileId;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	
	
	

}
