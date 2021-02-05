package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.Logs;

public class TestBase {
	
	
		protected static WebDriver driver= null;
		protected static ExtentTest logger;
		protected static ExtentReports report;
		
		 Properties  prop= new Properties();
		
		public  void 	InitializeExtentReport(String browser) {
			String filename= new SimpleDateFormat("'ZooplaReport_'yyyyMMddHHmm'.html'").format(new Date());
			//String path=  "C:\\Users\\divya\\git\\Zoopla1\\Zoopla_Selenuim\\src\\test\\resources\\Reports\\"+ "Zoopla.html";
			String path= System.getProperty("user.dir")+ "\\src\\test\\resources\\Reports\\"+ browser +  "_" +  filename;
			
		     report= new ExtentReports(path);
			}
		
		public  void readProperties() throws IOException {
			
			
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			prop.load(ip);
			System.out.println(prop.getProperty("url"));

		}
		public  void captureScreenShot(String filename) throws IOException {
			TakesScreenshot scrshot = (TakesScreenshot)driver;
		File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		File DestFile= new File("C:\\Users\\divya\\git\\Zoopla1\\Zoopla_Selenuim\\src\\test\\resources\\screenShots" +filename+".jpg");
		FileUtils.copyFile(SrcFile, DestFile);
		}
		
			
	     @BeforeTest
		
		public void driverSetUp() throws IOException {
			readProperties();
			InitializeExtentReport("chrome");
						
			String chromepath=prop.getProperty("chromepath");
			System.setProperty("webdriver.chrome.driver",chromepath );
		     driver = new ChromeDriver();
		     driver.get(prop.getProperty("url"));
		     captureScreenShot("firstScreenshot");
		    // driver.get("https://www.zoopla.co.uk/");
				driver.manage().window().maximize();
		} 
			
		}
		

        /*@Parameters("browserName")
		
		public void driverSetUp(String browserName) {
			
			
			
			if (browserName.equals("chrome")) {
				//InitializeExtentReport("chrome");
				String chromepath="C:\\Users\\divya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver",chromepath );
			     driver = new ChromeDriver();
			} 
			else if (browserName.equals("firefox")) {
				//InitializeExtentReport("firefox");
				String geckopath="C:\\Users\\divya\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", geckopath);
				driver= new FirefoxDriver();
			    
			} else {
				System.out.println("invalid browser name");
			}
			//driver.get(prop.getProperty("url"));
			driver.get("https://www.zoopla.co.uk/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}*/
		
		
		
		



