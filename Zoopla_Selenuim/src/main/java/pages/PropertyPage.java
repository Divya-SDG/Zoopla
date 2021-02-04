package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ReusableMethods;
import testBase.TestBase;

public class PropertyPage  extends TestBase{
	ReusableMethods reuse= new ReusableMethods();
	String expectedPropertyPageTitle;
	 @FindBy(xpath="//img[@alt='Panther International Properties']")
	   List< WebElement> logolist;
	 @FindBy(xpath="//h4[@class='ui-agent__name']")
	   List <WebElement> namelist;
	 @FindBy(xpath="//a[@class='ui-link'][@data-track-label='Agent phone number 1']")
	    WebElement contact;
	 public PropertyPage(String expectedPropertyPageTitle) throws Exception{
    	 PageFactory.initElements(driver, this);
    	 this.expectedPropertyPageTitle=expectedPropertyPageTitle;
     }
	  public void validatePropertypage() {
		  String propertypagetitle= driver.getTitle();
		  System.out.println(propertypagetitle);
		  Boolean result= reuse.verifyText(propertypagetitle,expectedPropertyPageTitle,"	PropertyPage");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "The Property page is validated");
			
	  }
	   
	  public void logoPresent() {
		  
		Boolean result=  reuse.isPresent(logolist.get(0), "logo");
		Assert.assertTrue(result);
		logger.log(LogStatus.PASS, "logo on selected properrty page is present");

}
	  
	  public void contactPresent() {
		  Boolean result=  reuse.isPresent(contact, "contact");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "contact on selected properrty page is present");
	  }
	  public  AgentPage namePresent() throws Exception {
		  Boolean result=  reuse.isPresent(namelist.get(0), "name");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "logo on selected properrty page is present");
	namelist.get(0).click();
	return new AgentPage();
			
			
	  }
}
