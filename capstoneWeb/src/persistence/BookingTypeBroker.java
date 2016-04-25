/**
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.BookingType;
import problemDomain.Facility;

/**
 * @author 432873
 * 
 */
public class BookingTypeBroker {
	private static BookingTypeBroker broker;

	private BookingTypeBroker() {
		
	}

	/**
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException if connection to database fails
	 */
	public static BookingTypeBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new BookingTypeBroker();
		}
		return broker;
	}

	/**
	 * Closes database connection
	 */
	public void close() {
		
		broker = null;
	}

	/**
	 * Searches Database for required information and returns it in a list format
	 * @return a list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if database connection fails
	 */
	
	public List<BookingType> getBookingTypeList() throws DatabaseConnectionException {
		String query = "SELECT * FROM booking_type";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<BookingType> bts = new ArrayList<BookingType>();

		try {
			while (result.next()) {
				BookingType bt = new BookingType(result.getInt("booking_type_id"), result.getString("name"), result.getInt("setupTime"), result.getInt("teardownTime"));
				bts.add(bt);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bts;
	}

	
	/**
	 * If the id for booking_type exists, booking_type is updated with new values.
	 * If the id does not exist, information is inserted into booking type table
	 * @param o - booking type object being searched for
	 * @return true/false if object is valid
	 * @throws DatabaseConnectionException is thrown if database connection fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		BookingType bt = (BookingType) o;
		String query;

		Connection con = Database.connect();
		if (bt.getId() != 0) {
			query = "UPDATE booking_type SET name='" + bt.getName() + "', setupTime='" + bt.getSetupTime() + "', teardownTime='" + bt.getTearDownTime()
					+ "' WHERE booking_type_id='" + bt.getId() + "'";
			Database.update(query, con);
		} else {
			query = "INSERT INTO booking_type VALUES ('0', '" + bt.getName() + "', '" + bt.getSetupTime() + "', '" + bt.getTearDownTime() + "')";
			Database.update(query, con);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	
	/**
	 * Removes the supplied object from the database
	 * @param o - booking type object to be removed
	 * @return - true/false if the object is valid
	 * @throws DatabaseConnectionException is thrown if the database connection fails
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		BookingType bt = (BookingType) o;
		String query;

		Connection con = Database.connect();
		query = "DELETE FROM booking_type WHERE booking_type_id='" + bt.getId() + "'";
		Database.update(query, con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * While booking type is not null, the query connects to the database
	 * And the try catch adds a new booking type to the table with all required fields.
	 * @param id is the id for the bookingType
	 * @return a Booking Type object with all the information retrieved from the database
	 * @throws DatabaseConnectionException is thrown if database connection fails
	 */
	public BookingType getBookingTypeInformation(int id) throws DatabaseConnectionException {
		BookingType bt = null;
		String query = "SELECT * FROM booking_type WHERE booking_type_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		try {
			while (result.next()) {
				bt = new BookingType(result.getInt("booking_type_id"), result.getString("name"), result.getInt("setupTime"), result.getInt("teardownTime"));
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bt;
	}

	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to search than returns a list
	 * @return a list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<BookingType> search(String searchText) throws DatabaseConnectionException
	{
		String query = "SELECT booking_type_id, name, setupTime, teardownTime " +
						"FROM booking_type " +
						"WHERE name LIKE '%" + searchText +"%' " +
						"OR setupTime LIKE '%" + searchText + "%' " +
						"OR teardownTime LIKE '%" + searchText + "%'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<BookingType> bts = new ArrayList<BookingType>();
		if(result != null){
			try {
				while (result.next()) {
					BookingType bt = new BookingType(result.getInt("booking_type_id"), result.getString("name"), result.getInt("setupTime"), result.getInt("teardownTime"));
					bts.add(bt);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return bts;	
	}
}
