/**
 * 
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.BookingType;

/**
 * @author 432873
 * 
 */
public class BookingTypeBroker implements Broker {
	private Database db = new Database();
	private static BookingTypeBroker broker;

	private BookingTypeBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException 
	 */
	public static BookingTypeBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new BookingTypeBroker();
		}
		return broker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#close()
	 */
	public void close() {
		db.close();
		broker = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#getAll()
	 */
	public List<BookingType> getAll() {
		String query = "SELECT * FROM booking_type";
		ResultSet result = db.select(query);
		ArrayList<BookingType> bts = new ArrayList<BookingType>();

		try {
			while (result.next()) {
				BookingType bt = new BookingType(result.getInt("booking_type_id"), result.getString("name"), result.getInt("setupTime"), result.getInt("teardownTime"));
				bts.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#persist(java.lang.Object)
	 */
	
	public boolean persist(Object o) {
		BookingType bt = (BookingType) o;
		String query;

		if (bt.getId() != -1) {
			query = "UPDATE booking_type SET name='" + bt.getName() + "', setupTime='" + bt.getSetupTime() + "', teardownTime='" + bt.getTearDownTime()
					+ "' WHERE booking_type_id='" + bt.getId() + "'";
			db.update(query);
		} else {
			query = "INSERT INTO booking_type VALUES ('0', '" + bt.getName() + "', '" + bt.getSetupTime() + "', '" + bt.getTearDownTime() + "')";
			db.update(query);
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#remove(java.lang.Object)
	 */
	
	public boolean remove(Object o) {
		BookingType bt = (BookingType) o;
		String query;

		query = "DELETE FROM booking_type WHERE booking_type_id='" + bt.getId() + "'";
		db.update(query);
		return true;
	}

	public BookingType getBookingTypeInformation(int id) {
		BookingType bt = null;
		String query = "SELECT * FROM booking_type WHERE booking_type_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		try {
			while (result.next()) {
				bt = new BookingType(result.getInt("booking_type_id"), result.getString("name"), result.getInt("setupTime"), result.getInt("teardownTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bt;
	}

}
