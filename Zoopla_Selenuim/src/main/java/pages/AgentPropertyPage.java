package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ReusableMethods;
import testBase.TestBase;

public class AgentPropertyPage extends TestBase {
	ReusableMethods reuse= new ReusableMethods();
	String ExpectedAgentContact;
	String expectedagentPropertyPageTitle="Block of flats for sale ";
	
	@FindBy(xpath="//a[@href='tel:02081152521']")
    List<WebElement> agentContactList;
 
	
	 public AgentPropertyPage(String contactNo) throws Exception{
    	 PageFactory.initElements(driver, this);
    	 this.ExpectedAgentContact=contactNo;
     }
	  public void validateAgentPropertypage() {
		  String agentpropertypagetitle= driver.getTitle();
		  System.out.println(agentpropertypagetitle);
		  Boolean result= reuse.verifyText(agentpropertypagetitle,expectedagentPropertyPageTitle,"	AgentPropertyPage");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "The Agent Property page is validated");
	  }
	  public void verifyContactAgent() throws InterruptedException {
		  Thread.sleep(3000);
		  System.out.println(agentContactList.size());
		  String actualAgentContact= agentContactList.get(0).getText();
		  System.out.println(actualAgentContact);
		  reuse.verifyText(ExpectedAgentContact, actualAgentContact, "AgentContact");
	  }

}
