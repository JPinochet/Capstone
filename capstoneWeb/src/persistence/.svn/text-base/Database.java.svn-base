/**
 * Feb 16, 2010
 * Database.java
 */
package persistence;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exceptions.DatabaseConnectionException;

/**
 * @author Corey Cantley
 * @version 1.0
 */
class Database {
	public static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	static Connection connect() throws DatabaseConnectionException {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/indusdb");
			return ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new DatabaseConnectionException("Cannot connect to the database.<br />Please contact your system administrator.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseConnectionException("Cannot connect to the database.<br />Please contact your system administrator.");
		}
	}

	
	/**
	 * Performs a select query on the database
	 * @param query - the query to perform
	 * @param con - database connection
	 * @return - result containing any result from a the query performed.
	 * Null if no results are obtained.
	 * @throws DatabaseConnectionException - is thrown if the database fails
	 */
	static ResultSet select(String query, Connection con) throws DatabaseConnectionException {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * Performs an update, insert, or delete on the database
	 * @param query - the query to perform
	 * @param con - database connection
	 * @return - If inserting it returns the id of the last inserted row, otherwise the number of 
	 * rows affected by the query.
	 * @throws DatabaseConnectionException
	 */
	static int update(String query, Connection con) throws DatabaseConnectionException {
		Statement stmt = null;
		int rv = 0;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);

			if (query.startsWith("INSERT")) {
				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

				if (rs.next()) {
					rv = rs.getInt(1);
				} else {
					//TODO: throw an exception from here
				}

				rs.close();
			}
			stmt.close();
		} catch (SQLException sExp) {
			//TODO: throw an exception from here
			System.out.println("sql error: " + sExp.getMessage());
		}
		return rv;
	}
}
