package Utilities;
import org.apache.log4j.Logger;
public class Logs {
	
	
		private static Logger Logs = Logger.getLogger(Logs.class.getName());
	 
	 public static void startTestCase(String sTestCaseName){
		 
		 Logs.info("****************************************************************************************");
		 Logs.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		 Logs.info("****************************************************************************************");
		 }
	 public static void endTestCase(String sTestCaseName) {
		 Logs.info("XXXXXXXXXXXXXXXXXXXXXXX             \"+\"-E---N---D-\"+\"             XXXXXXXXXXXXXXXXXXXXXX");
	 }
	 public static void info(String message) {
		 Logs.info(message);
	
	}
	 public static void warn(String message) {
		 Logs.warn(message);
	
	}
	 public static void error(String message) {
		 Logs.error(message);
	
	}
	 public static void debug(String message) {
		 Logs.debug(message);
	
	}
 





	}


