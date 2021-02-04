//This is to trigger jenkins
package tests;

import java.util.List;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Log;
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
		Log.startTestCase("handleCookiesPopUp");
		logger=report.startTest("handleCookiesPopUp");
		homepage= new HomePage();
		homepage.CookiePopUp();
		Log.endTestCase("handleCookiesPopUp");
		
	}
	@Test(priority=2)
	public  void validateHomePages() throws Exception {
		Log.startTestCase("validateHomePages");
	logger=report.startTest("validateHomePages");
    homepage.validateHomePage();
    Log.endTestCase("validateHomePages");
    
	}
	@Test(priority=3)
	public  void enterCityNameClickSearch() throws Exception {
		Log.startTestCase("validateHomePages");
		logger=report.startTest("enterCityNameClickSearch");
		homepage.enterTextSearchBox(city);
		listingpage=homepage.clickOnSearch();
		Log.endTestCase("validateHomePages");
	}
	
	@Test(priority=4)
	public  void validateListingPages() throws Exception {
		Log.startTestCase("validateListingPages");
		logger=report.startTest("validateListingPages");
		
        listingpage.validateListingpage();
        Log.endTestCase("validateListingPages");
	}
    
	@Test(priority=5)
		public void sortProperty() throws InterruptedException {
		Log.startTestCase("sortProperty");
		logger=report.startTest("sortProperty");
		
	     listingpage.highestPriceSort(sortType);
	     Log.endTestCase("sortProperty");
			   }
	
	@Test(priority=6)
	
	public void getPropertyList() {
		Log.startTestCase("getPropertyList");
		logger=report.startTest("getPropertyList");
	listingpage.propertyFromList();
	Log.endTestCase("getPropertyList");
	}
	
	@Test(priority=7)
	public void findProperty() throws Exception {
		Log.startTestCase("findProperty");
		logger=report.startTest("findProperty");
     propertypage=listingpage.findProperty() ;
     propertypage. validatePropertypage() ;
     Log.endTestCase("findProperty");
	}
	@Test(priority=8)
	public void AgentDetails() throws Exception {
		Log.startTestCase("AgentDetails");
		logger=report.startTest("AgentDetails");
     propertypage.logoPresent();
     propertypage.contactPresent();
    agentpage= propertypage.namePresent();
    Log.endTestCase("AgentDetails");
    
	}
	@Test(priority=9)
	public void verifyAgent() throws Exception {
		Log.startTestCase("verifyAgent");
		logger=report.startTest("verifyAgent");
		agentpage.validateAgentpage();
		agentpage.listingListOfAgent();
		Log.endTestCase("verifyAgent");
		
    }
	
@Test(priority=10)
public void tearDown() {
	Log.startTestCase("tearDown");
		driver.close();
		report.endTest(logger);
		report.flush();
		Log.endTestCase("tearDown");
	}
}
	
	


