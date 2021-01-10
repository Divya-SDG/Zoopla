package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ReusableMethods;
import testBase.TestBase;

public class ListingPage extends TestBase {
	ReusableMethods reuse= new ReusableMethods();
	String expectedListPageTitle="Property for Sale in London";
	String sortType="Highest price";
  int	PropertyNoFromList= 5;
	 @FindBy(xpath="//select[@id='sort-order-dropdown']")
	    WebElement highestPrice;
	 
	 @FindBy(xpath="//p[@class='css-18tfumg-Text eczcs4p0' ]")
	    List<WebElement> prop_listPrice ;
	 @FindBy(xpath="//div[@class='earci3d1 css-tk5q7b-Wrapper-ListingCard-StyledListingCard e2uk8e10' ]")
	    List<WebElement> prop_list ;
	 @FindBy(xpath="//h2[@class='css-c7hd0c-Heading2-StyledAddress e2uk8e14' ]")
	    List<WebElement> prop_listDetails ;
	 @FindBy(xpath="//p[@class='css-wfe1rf-Text eczcs4p0' ]")
	    List<WebElement> prop_listLocation ;
	 
	 
	 public ListingPage() throws Exception{
    	 PageFactory.initElements(driver, this);
     }
	  public void validateListingpage() {
		  String listpagetitle= driver.getTitle();
		  Boolean result= reuse.verifyText(listpagetitle,expectedListPageTitle,"HomePage");
			Assert.assertTrue(result);
			logger.log(LogStatus.PASS, "The list page is validated");
	  }
	    
	 public void highestPriceSort(String sortType) throws InterruptedException {
		 
		 Select dropDown= new Select(highestPrice);
		 dropDown.selectByVisibleText(sortType);
			 Thread.sleep(5000);
			
			 String val=highestPrice.getAttribute("value"); 
			 System.out.println(val);
			 System.out.println(sortType);
			 String s[]=sortType.split(" ");     
			    Assert.assertTrue(val.startsWith(s[0].toLowerCase()));
			    logger.log(LogStatus.PASS, "The sortDropDown is validated");
	 }
	  public void propertyFromList() {
		  
		   Assert.assertTrue(prop_listPrice.size()>0);
		  logger.log(LogStatus.PASS, "The listing page is contains list of elements");
		  logger.log(LogStatus.INFO, "prooperty list is " + prop_listPrice.toString());
		  System.out.println(prop_listPrice.size());
		  Iterator it= prop_listPrice.iterator();
		 		  while(it.hasNext()) {
			  WebElement w= (WebElement)it.next();
			  System.out.println(w.getText());
			 
		  }
	  }
		  
		  public PropertyPage findProperty() throws Exception {
			  
			  Assert.assertTrue(prop_listPrice.size()>0);
			  logger.log(LogStatus.PASS, "The listing page is contains list of elements");
			  
			   String price= prop_listPrice.get(PropertyNoFromList-1).getText();
			   String  details= prop_listDetails.get(PropertyNoFromList-1).getText();
			   //String area =prop_listLocation.get(PropertyNoFromList-1).getText(); 
			   System.out.println(details); 
		logger.log(LogStatus.PASS, "The selected "+ PropertyNoFromList+ "property price  is " + price  );
		 System.out.println("The selected " + PropertyNoFromList + "  property price  is " + price  );
		 prop_list.get(PropertyNoFromList-1).click();
			return new  PropertyPage(details);   
		   }
	  
	 
	     

}
