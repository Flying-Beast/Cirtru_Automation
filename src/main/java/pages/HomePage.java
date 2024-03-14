package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commons.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//div[@id='home-page-header']")
	public WebElement header;

	@FindBy(xpath = "//div[@id='searchArea']//input")
	public WebElement searchInputField;

	@FindBy(xpath = "//li//div[text()='San Jose']")
	public WebElement searchResult;
	
	@FindBy(xpath = "(//button[@class='availability-btn-gray center']//span[text()='Check availability'])[1]")
	public   WebElement sectionHeading;
	
	@FindBy(xpath = "(//button[text()='Not now'])[3]")
	public WebElement notNowButton;

	@FindBy(xpath = "(//div[text()='Contact similar listings'])[3]")
	public WebElement inqueryAlertPopup;
	
	@FindBy(xpath = "//li[@class='hidden-xs']//span[text()='My Account']")
	public WebElement myAccountHeader;
	
	@FindBy(xpath = "//span[@class='profile-heading']")
	public WebElement profileHeading;
	
	@FindBy(xpath = "//div[@id='log-out']//a[text()='Proceed']")
	public WebElement logoutProceed;
	
	@FindBy(xpath = "//div[@id='log-out']//button[text()='Logout']")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Yes']")
	public WebElement modalAlertLogout;

	private static final Logger lOGGER = LogManager.getLogger(HomePage.class.getName());

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void searchRoomOnPlace(String place) {
		wait.forElementToBeVisible(header);
		System.out.println(header.getText());
		assertTrue(header.getText().contains("Rent Houses & Rooms Smartly"));
		click(searchInputField);
		sendKeys(searchInputField,place);
		wait.forElementToBeVisible(searchInputField);
		Actions act=new Actions(driver);
		wait.forElementToBeVisible(searchResult);
		act.click(searchResult).build().perform();
		lOGGER.info("perform sarch place of"+place);
	}

   public void checkAvailabilityRoom() { 
	   wait.forElementToBeVisible(sectionHeading);
	   js.scrollIntoView(sectionHeading);
	   js.clickElement(sectionHeading);
	   wait.forElementToBeVisible(notNowButton);
	   click(notNowButton);
	   wait.forElementToBeVisible(inqueryAlertPopup);
	   click(notNowButton);
	   
	   
   }
   
   public void logout() {
	   wait.forElementToBeVisible(myAccountHeader);
	   js.scrollIntoView(myAccountHeader);
	   click(myAccountHeader);
	   wait.forElementToBeVisible(profileHeading);
	   System.out.println(profileHeading.getText());
	   //assertTrue(header.getText().contains("Rent Houses & Rooms Smartly"));
	   wait.forElementToBeVisible(logoutProceed);
	   scrollDown(logoutProceed);
	   click(logoutProceed);
	   wait.forElementToBeVisible(logoutButton);
	   click(logoutButton);
	   wait.forElementToBeClickable(modalAlertLogout);
	   click(modalAlertLogout);
   }
	
}