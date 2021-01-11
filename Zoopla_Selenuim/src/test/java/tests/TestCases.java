package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ReusableMethods;
import pages.PropertyPage;
import pages.AgentPage;
import pages.AgentPropertyPage;
import pages.HomePage;
import pages.ListingPage;
import testBase.TestBase;

public class TestCases extends TestBase {
	//String expectedListPageTitle="Property for Sale in London";
	//String expectedHomeTitle="Zoopla > Search Property to Buy";
	String city="london";
	String sortType="Highest price";
	ReusableMethods reuse= new ReusableMethods();
	HomePage homepage;
	ListingPage listingpage;
	PropertyPage propertypage;
	AgentPage agentpage;
	AgentPropertyPage agentpropertypage;
	
	/*@Test(priority=1,enabled=false)
	public  void setReportAndDriver() {
		
	
	//InitializeExtentReport();
	logger=report.startTest("setReportAndDriver");
	}*/
	@Test(priority=1)
	public void handleCookiesPopUp() throws Exception {
		logger=report.startTest("handleCookiesPopUp");
		homepage= new HomePage();
		homepage.CookiePopUp();
		
	}
	@Test(priority=2)
	public  void validateHomePages() throws Exception {
	logger=report.startTest("validateHomePages");
    homepage.validateHomePage();
    
	}
	@Test(priority=3)
	public  void enterCityNameClickSearch() throws Exception {
		logger=report.startTest("enterCityNameClickSearch");
		homepage.enterTextSearchBox(city);
		listingpage=homepage.clickOnSearch();
	}
	
	@Test(priority=4)
	public  void validateListingPages() throws Exception {
		logger=report.startTest("validateListingPages");
		
        listingpage.validateListingpage();
    
	}
    
	@Test(priority=5)
		public void sortProperty() throws InterruptedException {
		logger=report.startTest("sortProperty");
		
	     listingpage.highestPriceSort(sortType);
			   }
	
	@Test(priority=6)
	
	public void getPropertyList() {
		logger=report.startTest("getPropertyList");
	listingpage.propertyFromList();
	}
	
	@Test(priority=7)
	public void findProperty() throws Exception {
		logger=report.startTest("findProperty");
     propertypage=listingpage.findProperty() ;
     propertypage. validatePropertypage() ;
	}
	@Test(priority=8)
	public void AgentDetails() throws Exception {
		logger=report.startTest("AgentDetails");
     propertypage.logoPresent();
     propertypage.contactPresent();
    agentpage= propertypage.namePresent();
    
	}
	@Test(priority=9)
	public void verifyAgent() throws Exception {
		logger=report.startTest("verifyAgent");
		agentpage.validateAgentpage();
		agentpage.listingListOfAgent();
		
    }
	
@Test(priority=10)
public void tearDown() {
	
		driver.close();
		report.endTest(logger);
		report.flush();
	}
}
	
	


