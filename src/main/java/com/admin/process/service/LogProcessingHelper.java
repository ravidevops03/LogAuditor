package com.admin.process.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import com.admin.process.constants.LogConstants;
import com.admin.process.dao.Dao;
import com.admin.process.pojo.Log;
import com.admin.process.pojo.LogHolder;
import com.google.gson.Gson;

/***
 * 
 * @author Ravi
 * This is utility class for Logs processing  
 *
 */

public class LogProcessingHelper {
	final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogProcessingHelper.class);
	
	
	/***
	 * 
	 * @param logHolder
	 * @param path
	 * @return
	 * @throws IOException
	 * 
	 * This method reads log from the Path and 
	 * separate them into Start and Finish Maps in the Log hold Object
	 * 
	 */
	public static LogHolder separateStartAndFinishLogs(LogHolder logHolder, String path) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		Log log = null;
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			
			/**
			 * Scan each line from the log file and checks if it's a starter or finisher log 
			 ** and puts them in the corresponding map
			 ***/
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				log = new Gson().fromJson(line, Log.class);
				if (LogConstants.STARTED.equalsIgnoreCase(log.getState())) {
					logHolder.getStartMap().put(log.getId(), log);
				} else {
					logHolder.getFinishMap().put(log.getId(), log);
				}
			}			
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
		return logHolder;
	}
	
	/**
	 * 
	 * @param logHolder
	 * @throws SQLException
	 * 
	 * This method identifies the alert criteria and inserts into database.
	 */
	public static void identifyAlertCriteria(LogHolder logHolder) throws SQLException {
		Set<String> keySet = clone(logHolder.getStartMap().keySet());
		for (String key : keySet) {
			Log finishLog = logHolder.getFinishMap().remove(key);
			Log startLog = logHolder.getStartMap().remove(key);
			if (startLog != null && finishLog != null) {
				long time = finishLog.getTimestamp() - startLog.getTimestamp();
				boolean alert = false;
				if (time > 4) {
					logger.info("Alert raised... For =>  " + startLog.getId());
					alert = true;
				} else {
					logger.info("All good....  " + startLog.getId());
					alert = false;
				}
				Dao.insertLogAuditor(startLog.getId(), String.valueOf(time), alert);
			} else {
				logger.info("======================================================>>>> found an orphan log");
			}
		}
		logger.info("=====================Fetching detail from HSQLDB File STARTED=====================");
		Dao.fetchLogAuditor();
		logger.info("=====================Fetching detail from HSQLDB File ENDED=======================");
	}
	
	/**
	 * @param <T>
	 * @param original
	 * @return
	 * This method clones a set.
	 */
	public static <T> Set<T> clone(Set<T> original) {
		Set<T> copy = new HashSet<>();
		copy.addAll(original);
		return copy;
	}

}
