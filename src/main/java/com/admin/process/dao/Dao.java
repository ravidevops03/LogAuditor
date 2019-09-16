package com.admin.process.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * 
 * @author Ravi
 * This class performs database 
 *
 */
public class Dao {
	
	final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Dao.class);
	
	/***
	 * 
	 * @param eventid
	 * @param eventduration
	 * @param alert
	 * @throws SQLException
	 * This method inserts data into logauditor table
	 */
	public static void insertLogAuditor(String eventid, String eventduration, boolean alert)
			throws SQLException {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con
					.prepareStatement("INSERT INTO logauditor(eventid,eventduration,alert) VALUES(?,?,?)");
			pst.clearParameters();
			pst.setString(1, eventid);
			pst.setString(2, eventduration);
			pst.setBoolean(3, alert);
			pst.executeUpdate();
		} catch (SQLException sqlex) {
			logger.debug(sqlex.getMessage());
			throw sqlex;
		}
	}	
	
	/***
	 * 
	 * @throws SQLException
	 * This method fetches the records logauditor from and logs them.
	 * 
	 */
	
	public static void fetchLogAuditor() throws SQLException {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con
					.prepareStatement("SELECT * FROM logauditor ");
			pst.clearParameters();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				logger.info("event id :: " + rs.getString(2) +" event duration :: " + rs.getString(3) + " Alert :: " + rs.getBoolean(4));
			}
		} catch (SQLException sqlex) {
			logger.debug(sqlex.getMessage());
			throw sqlex;
		}
	}
}
