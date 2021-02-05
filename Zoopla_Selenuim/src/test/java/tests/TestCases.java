
package tests;

import java.util.List;
//import org.apache.log4j.xml.DOMConfigurator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Logs;
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
		Logs.startTestCase("handleCookiesPopUp");
		
		logger=report.startTest("handleCookiesPopUp");
		homepage= new HomePage();
		homepage.CookiePopUp();
		Logs.endTestCase("handleCookiesPopUp");
		
	}
	@Test(priority=2)
	public  void validateHomePages() throws Exception {
		Logs.startTestCase("validateHomePages");
		//Logs.info("**********************");
	logger=report.startTest("validateHomePages");
    homepage.validateHomePage();
    Logs.endTestCase("validateHomePages");
    
	}
	@Test(priority=3)
	public  void enterCityNameClickSearch() throws Exception {
		Logs.startTestCase("enterCityNameClickSearch");
		//Logs.info("**********************");
		logger=report.startTest("enterCityNameClickSearch");
		homepage.enterTextSearchBox(city);
		listingpage=homepage.clickOnSearch();
		Logs.endTestCase("enterCityNameClickSearch");
	}
	
	@Test(priority=4)
	public  void validateListingPages() throws Exception {
		Logs.startTestCase("validateListingPages");
		logger=report.startTest("validateListingPages");
		//Logs.info("**********************");
		
        listingpage.validateListingpage();
        Logs.endTestCase("validateListingPages");
	}
    
	@Test(priority=5)
		public void sortProperty() throws InterruptedException {
		Logs.startTestCase("sortProperty");
		logger=report.startTest("sortProperty");
		//Logs.info("**********************");
		
	     listingpage.highestPriceSort(sortType);
	     Logs.endTestCase("sortProperty");
			   }
	
	@Test(priority=6)
	
	public void getPropertyList() {
		Logs.startTestCase("getPropertyList");
		logger=report.startTest("getPropertyList");
	listingpage.propertyFromList();
	Logs.endTestCase("getPropertyList");
	}
	
	@Test(priority=7)
	public void findProperty() throws Exception {
		Logs.startTestCase("findProperty");
		//Logs.info("**********************");
		logger=report.startTest("findProperty");
     propertypage=listingpage.findProperty() ;
     propertypage. validatePropertypage() ;
     Logs.endTestCase("findProperty");
	}
	@Test(priority=8)
	public void AgentDetails() throws Exception {
		Logs.startTestCase("AgentDetails");
		logger=report.startTest("AgentDetails");
     propertypage.logoPresent();
     propertypage.contactPresent();
    agentpage= propertypage.namePresent();
    Logs.endTestCase("AgentDetails");
    
	}
	@Test(priority=9)
	public void verifyAgent() throws Exception {
		Logs.startTestCase("verifyAgent");
		logger=report.startTest("verifyAgent");
		agentpage.validateAgentpage();
		agentpage.listingListOfAgent();
		Logs.endTestCase("verifyAgent");
		
    }
	
@Test(priority=10)
public void tearDown() {
	Logs.startTestCase("tearDown");
		driver.close();
		report.endTest(logger);
		report.flush();
		Logs.endTestCase("tearDown");
	}
}
	
	


