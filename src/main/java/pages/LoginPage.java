package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commons.BasePage;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//ul[@id='nav-main']//a[contains(text(),'My Account')]")
	public WebElement myAccount;

	@FindBy(xpath = "//input[@id='Email-modal']")
	public WebElement emailField;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='loginPassword-modal']")
	public WebElement passwordField;
	
	@FindBy(xpath = "(//button[contains(text(),'Log in')])[1]")
	public WebElement loginButton;

	@FindBy(id = "alert1")
	public WebElement alert;

	private static final Logger lOGGER = LogManager.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	public void loginToTheApplication(String userName, String passWord) {
		wait.forElementToBeVisible(myAccount);
		click(myAccount);
		wait.forElementToBeVisible(emailField);
		click(emailField);
		sendKeys(emailField, userName);
		click(continueButton);
		wait.forElementToBeVisible(passwordField);
		click(passwordField);
		sendKeys(passwordField, passWord);
		click(loginButton);
		lOGGER.info("User clicked on Login button.");
			
	//	lOGGER.info("Checking whether alert is popping-up upon succesfull login");
	}
	
	public void verifySuccesfullLogin() {

		wait.forElementToBeVisible(alert);
		Assert.assertTrue(alert.isDisplayed());
		lOGGER.info("Checking whether alert is popping-up upon succesfull login");
		
	}

}