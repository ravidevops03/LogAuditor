package com.admin.process;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.admin.process.dao.DBConnection;
import com.admin.process.dao.Dao;
import com.admin.process.pojo.LogHolder;
import com.admin.process.service.LogProcessingHelper;

public class LogAuditorTest {
	
	private static final String path = "F:\\logs\\logfile.txt";
	
	@Before
	public void setUp() throws Exception {
		if (path != null) {
	    	LogHolder holder = new LogHolder();
			try {
				holder = LogProcessingHelper.separateStartAndFinishLogs(holder, path);
			} catch (IOException e) {
				throw new IOException();
			}		
				
			LogProcessingHelper.identifyAlertCriteria(holder);
			
	    }
	}

	@Test
	public void testFileLocation() {
		//fail("Not yet implemented");
		boolean isPathNull = false;
		if (path != null) {
			isPathNull = true;
		}else{
			isPathNull = false;
		}
		
		assertEquals("TRUE", "TRUE", isPathNull);
		
	}
	
	@Test
	public void testHSQLDBUp() {
		//fail("Not yet implemented");		
		Connection conn = DBConnection.getConnection();
		boolean isDBup = false;
		if (conn != null) {
			isDBup = true;
		}else{
			isDBup = false;
		}		
		assertEquals("TRUE", "TRUE", isDBup);
	}
		

}
