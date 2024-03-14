package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

//import static commons.Configuration.password;
//import static commons.Configuration.url;
//import static commons.Configuration.username;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestRail.APIException;
import commons.TestBase;
import commons.TestRailManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

	@BeforeMethod(alwaysRun = true)
	public void openPage() {
		driver.get(URL);
		Assert.assertEquals(driver.getTitle(),"Find Rooms and Houses for Rent in the USA | Cirtru");
		Reporter.log("User is on Login Page",true);
	}

	@Test(groups = "Test")
	public void verifyLoginWithValidCred() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);		
		loginPage.loginToTheApplication(userName,password);
		homepage.searchRoomOnPlace("san jose california");
		homepage.checkAvailabilityRoom();
		homepage.logout();
	}
			
	
   @AfterMethod(alwaysRun = true)
   public void tearDown() throws Exception {
	
     driver.close();

	}
}
