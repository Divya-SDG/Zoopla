package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ReusableMethods;
import testBase.TestBase;

public class HomePage  extends TestBase{
	@FindBy(id="search-input-location")
	WebElement Cityinputsearch;

    @FindBy(xpath="//button[@class='ui-button-secondary']")
    WebElement popup_Cookie;
    
      @FindBy(id="search-submit")
      WebElement searchButton;
      String expectedHomeTitle="Zoopla > Search Property to Buy";
      String city="london";
      ReusableMethods reuse= new ReusableMethods();  
     public HomePage() throws Exception{
    	 PageFactory.initElements(driver, this);
     }
     public  void CookiePopUp() {
    	 popup_Cookie.click();
     }
     
     public void  validateHomePage() {
    String title=  driver.getTitle();
    System.out.println(title);
    if(title.contains(expectedHomeTitle)){
    	System.out.println("........");
    }
	Boolean result= reuse.verifyText(title,expectedHomeTitle,"HomePage");
	Assert.assertTrue(result);
	logger.log(LogStatus.PASS, "The home page is validated");
    
    
     }
     public  void enterTextSearchBox(String text) {
    	 Cityinputsearch.sendKeys(text);
     }
     public ListingPage  clickOnSearch() throws Exception{
    	 searchButton.click();
    	 return new ListingPage();
     }
}