package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Log;
import Utilities.ReusableMethods;
import testBase.TestBase;

public class AgentPage extends TestBase{
	
	 @FindBy(xpath="//a[@href='tel:+442081152521']")
	    List<WebElement> agentDetails;
	 
	 @FindBy(xpath="//h2[@class='listing-results-attr']")
	   List<WebElement> AgentPropertiesList;
	 
	String expectedAgentPageTitle="Panther International Properties, SW3 - Estate and Letting Agents ";
	ReusableMethods reuse= new ReusableMethods();
	public AgentPage() throws Exception{
   	 PageFactory.initElements(driver, this);
    }
	  public void validateAgentpage() {
		  String agentpagetitle= driver.getTitle();
		  System.out.println(agentpagetitle);
		  Boolean result= reuse.verifyText(agentpagetitle,expectedAgentPageTitle,"AgentPage");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "The Agent page is validated");
			Log.info("The Agent page is validated");
	  }
	   public  void listingListOfAgent() throws Exception {
		  System.out.println(agentDetails.get(0).getText());
		  String agentCallNo=agentDetails.get(0).getText();
		   logger.log(LogStatus.INFO, "The Agent Details are" + agentDetails.get(0).getText());
		   Thread.sleep(3000);
		  System.out.println( AgentPropertiesList.size());
		  System.out.println( AgentPropertiesList.get(0).getText());
		   WebElement w=AgentPropertiesList.get(1);
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", w);
		   
	      
	      System.out.println(driver.getTitle());
	      Log.info("List of agents"); 
	   Thread.sleep(3000);
	   
	 //  return new AgentPropertyPage(agentCallNo);
		  
		  
		   
	   }
	  

}
