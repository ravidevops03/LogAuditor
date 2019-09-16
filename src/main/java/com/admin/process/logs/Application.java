package com.admin.process.logs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.admin.process.pojo.LogHolder;
import com.admin.process.service.LogProcessingHelper;

/**
 * 
 * @author Ravi
 * This class holds the main method to start the process.
 */
public class Application {
//	private static final String path = "F:\\logs\\logfile.txt";
	final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Application.class);
	
	/**
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		
		System.out.print("Enter the File location and press ENTER button : ");
		
		// create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
	    
	    // get their input as a String
	    String path = scanner.next();
	    
	    if (path != null) {
	    	LogHolder holder = new LogHolder();
			try {
				holder = LogProcessingHelper.separateStartAndFinishLogs(holder, path);
			} catch (IOException e) {
				logger.info(" Exception while doing IO opertion : " + e.getMessage());
				throw new IOException();
			}		
				
			LogProcessingHelper.identifyAlertCriteria(holder);
			logger.info(" Below are the logs count which tells their counter parts are missing in file ");
			logger.info("size of start log =>  " + holder.getStartMap().toString());
			logger.info("size of finish log =>  " + holder.getFinishMap().toString());
	    }else {
	    	logger.info(" File location hasn't provided. Please try it Again with File location"); 
	    }
				
		
	}

}
