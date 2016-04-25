package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.Rate;

/**
 * @author kerri
 * 
 */
public class RateBroker implements Broker {
	private Database db = new Database();
	private static RateBroker broker;

	private RateBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException 
	 */
	public static RateBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new RateBroker();
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
	public List<Rate> getAll() {
		String query = "SELECT * FROM rate";
		ResultSet result = db.select(query);

		ArrayList<Rate> rates = new ArrayList<Rate>();

		try {
			while (result.next()) {
				int id = result.getInt("rate_id");
				String name = result.getString("name");
				String description = result.getString("description");
				double rate = result.getDouble("rate");
				double damageDeposit = result.getDouble("damageDeposit");
				double bookingDeposit = result.getDouble("bookingDeposit");

				Rate r = new Rate(id, name, description, rate, damageDeposit, bookingDeposit);

				rates.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rates;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#persist(java.lang.Object)
	 */
	public boolean persist(Object o) {
		Rate rate = (Rate) o;

		String query;

		if (rate.getId() != -1) {
			query = "UPDATE rate SET name='" + rate.getName() + "', description='" + rate.getDescription() + "', rate='" + rate.getRate() + "', damageDeposit='"
					+ rate.getDamageDeposit() + "', bookingDeposit='" + rate.getBookingDeposit() + "' WHERE rate_id='" + rate.getId() + "'";
			db.update(query);
		} else {
			query = "INSERT INTO rate VALUES('0', '" + rate.getName() + "', '" + rate.getDescription() + "', '" + rate.getRate() + "', '" + rate.getDamageDeposit() + "', '"
					+ rate.getBookingDeposit() + "')";
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		Rate rate = (Rate) o;
		String query;

		query = "DELETE FROM rate WHERE rate_id='" + rate.getId() + "'";
		db.update(query);
		return true;
	}

	public Rate getRateInformation(int id) {
		String query = "SELECT * FROM rate WHERE rate_id = '" + id + "' LIMIT 1";
		ResultSet result = db.select(query);
		Rate r = null;

		try {
			while (result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				double rate = result.getDouble("rate");
				double damageDeposit = result.getDouble("damageDeposit");
				double bookingDeposit = result.getDouble("bookingDeposit");

				r = new Rate(id, name, description, rate, damageDeposit, bookingDeposit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public Rate getRatesInformation(int id) {
		Rate rate = null;

		String query = "SELECT * FROM rate WHERE rate_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		try {
			while (result.next()) {

				String name = result.getString("name");
				String description = result.getString("description");
				double rates = result.getDouble("rate");
				double damageDeposit = result.getDouble("damageDeposit");
				double bookingDeposit = result.getDouble("bookingDepostit");

				rate = new Rate(id, name, description, rates, damageDeposit, bookingDeposit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rate;
	}
}
