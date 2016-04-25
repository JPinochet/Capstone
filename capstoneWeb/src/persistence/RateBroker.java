package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.DatabaseConnectionException;
import problemDomain.Rate;

/**
 * @author kerri
 * 
 */
public class RateBroker {
	
	private static RateBroker broker;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	private RateBroker() throws DatabaseConnectionException {
		
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException  is thrown if DB connection fails
	 */
	public static RateBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new RateBroker();
		}
		return broker;
	}

	/**
	 * Closes Database connection
	 * 
	 */
	public void close() {
		
		broker = null;
	}

	/**
	 * Gets all information from Database for that table
	 * @return list of requested rates
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public List<Rate> getRateList() throws DatabaseConnectionException {
		String query = "SELECT * FROM rate";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		ArrayList<Rate> rates = new ArrayList<Rate>();

		try {
			while (result.next()) {
				int id = result.getInt("rate_id");
				String name = result.getString("name");
				String description = result.getString("description");
				double rate = result.getDouble("rate");
				double damageDeposit = result.getDouble("damageDeposit");
				double bookingDeposit = result.getDouble("bookingDeposit");
				boolean isHourly = result.getBoolean("isHourly");
				Date validStartTime = sdf.parse(result.getString("validStartTime"));
				Date validEndTime = sdf.parse(result.getString("validEndTime"));
				boolean sunday = result.getBoolean("sunday");
				boolean monday = result.getBoolean("monday");
				boolean tuesday = result.getBoolean("tuesday");
				boolean wednesday = result.getBoolean("wednesday");
				boolean thursday = result.getBoolean("thursday");
				boolean friday = result.getBoolean("friday");
				boolean saturday = result.getBoolean("saturday");

				Rate r = new Rate(id, name, description, rate, damageDeposit, bookingDeposit, isHourly, validStartTime, validEndTime, sunday, monday, tuesday, wednesday, thursday, friday, saturday);

				rates.add(r);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rates;

	}

	/**
	 * If id exists information in rate table is updated
	 * If id != exist information is inserted into rate table
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Rate rate = (Rate) o;
		
		int timeFormat = (rate.isHourly()?1:0);
		int sunday = (rate.isSunday()?1:0);
		int monday = (rate.isMonday()?1:0);
		int tuesday = (rate.isTuesday()?1:0);
		int wednesday = (rate.isTuesday()?1:0);
		int thursday = (rate.isThursday()?1:0);
		int friday = (rate.isFriday()?1:0);
		int saturday = (rate.isSaturday()?1:0);
			
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		String query;

		Connection con = Database.connect();
		if (rate.getId() != 0) {
			query = "UPDATE rate SET name='" + rate.getName() + "', description='" + rate.getDescription() + "', rate='" + rate.getRate() + "', damageDeposit='"
						+ rate.getDamageDeposit() + "', bookingDeposit='" + rate.getBookingDeposit() + "', isHourly='" + timeFormat + "', "
						+ "validStartTime='" + sdf.format(rate.getValidStartTime()) + "', validEndTime='" + sdf.format(rate.getValidEndTime()) + "', "
						+ "sunday='" + sunday + "', monday='" + monday + "', tuesday='" + tuesday + "', "
						+ "wednesday='" + wednesday + "', thursday='" + thursday + "', friday='" + friday + "', "
						+ "saturday='" + saturday + "' WHERE rate_id='" + rate.getId() + "'";
			Database.update(query, con);
		} else {
			query = "INSERT INTO rate VALUES('0', '" + rate.getName() + "', '" + rate.getDescription() + "', '" + rate.getRate() + "', '" + rate.getDamageDeposit() + "', '"
					+ rate.getBookingDeposit() +"', '" + timeFormat + "', '" + sdf.format(rate.getValidStartTime()) + "', '" + sdf.format(rate.getValidEndTime()) + "', '" + sunday + "', '" + 
					monday + "', '" + tuesday + "', '" + wednesday + "', '" + thursday + "', '" + friday + "', '" + saturday + "')";
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
	 * Deletes information from rate table where rate_id = rate.getId
	 * If id does not exist a exception will be thrown.
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Rate rate = (Rate) o;
		String query;

		query = "DELETE FROM rate WHERE rate_id='" + rate.getId() + "'";
		Connection con = Database.connect();
		Database.update(query, con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets all required information and adds it to resultSet
	 * @param id is the id for the rate
	 * @return An resultSet for requested rate
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public Rate getRateInformation(int id) throws DatabaseConnectionException {
		String query = "SELECT * FROM rate WHERE rate_id = '" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		Rate r = null;

		try {
			while (result.next()) {
				String name = result.getString("name");
				String description = result.getString("description");
				double rate = result.getDouble("rate");
				double damageDeposit = result.getDouble("damageDeposit");
				double bookingDeposit = result.getDouble("bookingDeposit");
				boolean isHourly = result.getBoolean("isHourly");
				Date validStartTime = sdf.parse(result.getString("validStartTime"));
				Date validEndTime = sdf.parse(result.getString("validEndTime"));
				boolean sunday = result.getBoolean("sunday");
				boolean monday = result.getBoolean("monday");
				boolean tuesday = result.getBoolean("tuesday");
				boolean wednesday = result.getBoolean("wednesday");
				boolean thursday = result.getBoolean("thursday");
				boolean friday = result.getBoolean("friday");
				boolean saturday = result.getBoolean("saturday");

				r = new Rate(id, name, description, rate, damageDeposit, bookingDeposit, isHourly, validStartTime, validEndTime, sunday, monday, tuesday, wednesday, thursday, friday, saturday);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}
	
	
	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to search than returns a list
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Rate> search(String searchText) throws DatabaseConnectionException
	{
		String query = "SELECT * " +
						"FROM rate " +
						"WHERE name LIKE '%" + searchText +"%' " +
						"OR rate='" + searchText +"'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Rate> rates = new ArrayList<Rate>();
		if(result != null){
			try {
				while (result.next()) {
					Rate rate = new Rate(result.getInt("rate_id"), result.getString("name"), result.getString("name"), result.getDouble("rate"));
					rates.add(rate);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return rates;	
	}
}
