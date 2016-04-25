/**
 * Feb 16, 2010
 * Database.java
 */
package persistence;

import java.sql.*;

import exceptions.DatabaseConnectionException;

/**
 * @author Corey Cantley
 * @version 1.0
 */
class Database {
	private static Connection con = null;

	/**
	 * Connects to a database using parameters supplied
	 * 
	 * @param driver
	 *            The database driver class to use
	 * @param URL
	 *            The url of the database to connect to
	 * @param user
	 *            The user to connect as
	 * @param password
	 *            The password for the connecting user
	 * @return
	 */
	boolean connect(String driver, String URL, String user, String password) throws DatabaseConnectionException {
		if(con == null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(URL, user, password);
			} catch (ClassNotFoundException cExp) {
				throw new DatabaseConnectionException("Cannot connect to the database: Unable to find driver");
			} catch (SQLException sExp) {
				throw new DatabaseConnectionException("Cannot connect to the database: " + sExp.getMessage());
			}
		}
		return true;
	}

	/**
	 * Performs a select query on the database
	 * 
	 * @param query
	 *            The query to perform
	 * @return A ResultSet containing any results from a the query performed.
	 *         Null if no results are obtained
	 */
	ResultSet select(String query) {
		Statement stmt = null;
		ResultSet result = null;

		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException sExp) {
			System.out.println("sql error: " + sExp.getMessage());
		}
		return result;
	}

	/**
	 * Performs an an update, insert, or delete on the database
	 * 
	 * @param query
	 *            The query to perform
	 * @return If inserting- the id of the last inserted row, otherwise the
	 *         number of rows affected by the query
	 */
	int update(String query) {
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
					// throw an exception from here
				}

				rs.close();
			}
			stmt.close();

		} catch (SQLException sExp) {
			System.out.println("sql error: " + sExp.getMessage());
		}
		return rv;
	}

	/**
	 * Closes the connection to the database
	 */
	void close() {
		try {
			if(con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException sExp) {
			System.out.println(sExp);
		}
	}
}
