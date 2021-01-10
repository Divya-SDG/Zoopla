package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
		
		protected static WebDriver driver= null;
		protected static ExtentTest logger;
		protected static ExtentReports report;
		public static Properties prop;
		
		public static void 	InitializeExtentReport() {
			String filename= new SimpleDateFormat("'ZooplaReport_'yyyyMMddHHmm'.html'").format(new Date());
			
			String path= System.getProperty("user.dir")+ "src\\test\\resources\\Reports\\"+ filename;
		     report= new ExtentReports(path);
			}
		
		
		public static void 	DataFromPropertiesFile() throws IOException {
		
					prop = new Properties();
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\config.properties");
					prop.load(file);
			
			
		}
		
		public void driverSetUp() {
			//String browserName = prop.getProperty("browsername");
			String browserName= "chrome"; 

			if (browserName.equals("chrome")) {
				
				String chromepath="C:\\Users\\divya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver",chromepath );
			     driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				// initiate firefox webdriver.gecko.driver new FirefoxDriver
			} else {
				System.out.println("invalid browser name");
			}
			//driver.get(prop.getProperty("url"));
			driver.get("https://www.zoopla.co.uk/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		
		


}
