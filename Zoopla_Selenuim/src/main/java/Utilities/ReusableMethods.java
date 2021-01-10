package Utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import testBase.TestBase;

public class ReusableMethods  extends TestBase{
	public boolean click(WebElement webelement, String webelementName ) throws Exception{
		if(isPresent(webelement, webelementName)) {
			webelement.click();
			logger.log(LogStatus.PASS, webelementName + " is clicked successfully");
			return true;
		} else {
			logger.log(LogStatus.FAIL, webelementName + " is not clicked");
			return false;
		}
		}
	
public boolean isPresent(WebElement webelement, String elementName) {

	if (webelement.isDisplayed()&& webelement.isEnabled()) {
		logger.log(LogStatus.PASS, elementName + " is present");
		return true;
	} else {
		logger.log(LogStatus.FAIL, elementName + " is not displayed or enabled");
		return false;
	}
}

public boolean enterText(WebElement webelement, String elementName, String text) {
	if(isPresent(webelement,elementName)) {
		webelement.sendKeys(text);
		logger.log(LogStatus.INFO, "Text is entered in" + elementName);
		Assert.assertEquals(text, verifyText(text, webelement.getAttribute("value"),elementName));
		logger.log(LogStatus.PASS, "Text entered is verified " + elementName);
		return true;
	}
	else {
		logger.log(LogStatus.FAIL, "Text is not entered in" + elementName);
		return false;
	}
}

public boolean verifyText(String actual, String expected, String elementName) {
	
	
	if(actual.contains(expected)) {
		
		logger.log(LogStatus.PASS, "Text is validated " + elementName);
		return true;
	}
	else {
		logger.log(LogStatus.FAIL, "Text is validated " + elementName);
		return false;
	}
	
}


}
