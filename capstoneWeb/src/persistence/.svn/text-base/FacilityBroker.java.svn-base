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
import problemDomain.AdditionalCharge;
import problemDomain.Facility;
import problemDomain.Rate;

/**
 * @author cantley c
 * 
 */
public class FacilityBroker {

	
	private static FacilityBroker broker;

	/**
	 * Default constructor
	 */
	private FacilityBroker() {
		
	}

	/**
	 * If the id for facility exists facility is updated with new values
	 * If the id does not exist information is inserted into facility table
	 * 
	 * The method first casts the object being passed it as a facility, afterwards it checks if the id of the
	 * facility is 0 or an actual number. If the id is a number then the method opens a connection with the 
	 * mysql database and performs an update on the facility page. Afterwards the rates are updated for the
	 * facility. This is done by opening a connection with the database and deleting all the data from the facility_rates
	 * where the facility_id is the same. Afterwards the method inserts all the new facility/rate association into the 
	 * table to associate the charges related to facility.
	 * 
	 * If the id is 0 than the system performs an insert instead of an update into the facility table.
	 * 
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException - is thrown if DB connection fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Facility facility = (Facility) o;
		String query;
		boolean result = false;
		
		Connection con = Database.connect();
		if (facility.getId() != 0) {
			query = "UPDATE facility SET openTime='" + facility.getOpenTime() + "', closeTime='" + facility.getCloseTime() + "', setupTime='" + facility.getSetupTime()
					+ "', teardownTime='" + facility.getTearDownTime() + "', name='" + facility.getName() + "', maxCapacity='" + facility.getMaxCapacity()
					+ "', minBookingInterval='" + facility.getMinBookingInterval() + "', minBookingTime='" + facility.getMinBookingTime() + "' WHERE facility_id='"
					+ facility.getId() + "'";
			if(Database.update(query, con) == 0)
				result = true;

			ArrayList<Rate> rates = facility.getRates();
			query = "DELETE FROM facility_rates  WHERE facility_id='" + facility.getId() + "'";
			Database.update(query, con);
			for (int i = 0; i < rates.size(); i++) {
				query = "INSERT INTO facility_rates VALUES('" + rates.get(i).getId() + "', '" + facility.getId() + "')";
				Database.update(query, con);
			}
			
			ArrayList<AdditionalCharge> acList = facility.getAdditionalCharges();
			query = "DELETE FROM facility_additional_charges  WHERE facility_id='" + facility.getId() + "'";
			Database.update(query, con);
			for (int i = 0; i < acList.size(); i++) {
				query = "INSERT INTO facility_additional_charges VALUES('" + acList.get(i).getId() + "', '" + facility.getId() + "')";
				Database.update(query, con);
			}
		} else {
			query = "INSERT INTO facility VALUES('" + 0 + "', '" + facility.getOpenTime() + "', '" + facility.getCloseTime() + "', '" + facility.getSetupTime() + "', '"
					+ facility.getTearDownTime() + "', '" + facility.getName() + "', '" + facility.getMaxCapacity() + "', '" + facility.getMinBookingInterval() + "', '"
					+ facility.getMinBookingTime() + "')";
			int id = Database.update(query, con);

			ArrayList<Rate> rates = facility.getRates();
			for (int i = 0; i < rates.size(); i++) {
				query = "INSERT INTO facility_rates VALUES('" + rates.get(i).getId() + "', '" + id + "')";
				Database.update(query, con);
			}
			
			ArrayList<AdditionalCharge> acList = facility.getAdditionalCharges();
			for (int i = 0; i < acList.size(); i++) {
				query = "INSERT INTO facility_additional_charges VALUES('" + acList.get(i).getId() + "', '" + facility.getId() + "')";
				Database.update(query, con);
			}
			result= true;
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Deletes information from rate table where facility_id = facility.getId
	 * If id does not exist a exception will be thrown.
	 * 
	 * This method opens a database connection to the mysql database and deletes all 
	 * facilities with the same id's as the object passed in.
	 * 
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Facility facility = (Facility) o;
		String query;

		query = "DELETE FROM facility WHERE facility_id='" + facility.getId() + "'";
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
	 * Closes Database connection using the singleton method
	 * 
	 */
	public void close() {
		
		broker = null;
	}
	
	/**
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public static FacilityBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new FacilityBroker();
		}
		return broker;
	}
	
	/**
	 * This method retrieves the facility details using the id of the facility.
	 * 
	 * The method open a connection with the mysql database and queries the database 
	 * for the facility information based on the facility id. 
	 * 
	 * The method queries the rates and additional charges related to the facility and afterwards finds 
	 * the remaining information from the facility table.
	 * 
	 * From the results the method constructs a facility object and returns it.
	 * 
	 * @param id is the id for the facility
	 * @return the resultSet for requested facility
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public Facility getFacilityInformation(int id) throws DatabaseConnectionException {
		String query = "SELECT * FROM facility WHERE facility_id = " + id;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		Facility facility = null;
		try {
			while (result.next()) {
				ArrayList<Rate> rates = new ArrayList<Rate>();
				ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();

				query = "SELECT * FROM rate r, facility f, facility_rates fr WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fr.facility_id AND fr.rate_id = r.rate_id";
				ResultSet rateResult = Database.select(query, con);
				while (rateResult.next()) {
					Rate rate = new Rate(rateResult.getInt("rate_id"), rateResult.getString("name"), rateResult.getString("description"), rateResult.getDouble("rate"), rateResult
							.getDouble("damageDeposit"), rateResult.getDouble("bookingDeposit"));
					rates.add(rate);
				}
				rateResult.close();

				query = "SELECT * FROM additional_charge ac, facility f, facility_additional_charges fac WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fac.facility_id AND fac.additional_charge_id = ac.additional_charge_id";
				ResultSet acResult = Database.select(query, con);
				while (acResult.next()) {
					AdditionalCharge ac = new AdditionalCharge(acResult.getInt("additional_charge_id"), acResult.getString("name"), acResult.getDouble("cost"));
					acs.add(ac);
				}
				acResult.close();

				facility = new Facility(result.getInt("facility_id"), result.getInt("openTime"), result.getInt("closeTime"), result.getInt("setupTime"), result.getInt("teardownTime"),
						result.getString("name"), rates, acs, result.getInt("maxCapacity"), result.getInt("minBookingInterval"), result.getInt("minBookingTime"));
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return facility;
	}
	
	/**
	 * The method retrieves all the facility objects stored in the database.
	 * 
	 * The method creates an ArrayList of facilities. 
	 * 
	 * The method open a connection with the mysql database and queries the database 
	 * for the facility information. 
	 * 
	 * 
	 * For every facility found in the database the following takes place:
	 *		The method queries the rates and additional charges related to the facility and afterwards finds 
	 * 		the remaining information from the facility table.
	 * 
	 * From the results the method constructs a facility object and adds it to the facilities ArrayList.
	 * 
	 * The method returns the facilities ArrayList.
	 * 
	 * @return updated result set, returns facilities
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Facility> getFacilityList() throws DatabaseConnectionException {
		String query = "SELECT facility_id, name, openTime, closeTime, setupTime, teardownTime, maxCapacity, minBookingInterval, minBookingTime FROM facility";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		ArrayList<Facility> facilities = new ArrayList<Facility>();
		try {
			while (result.next()) {
				Facility facility = new Facility(result.getInt("facility_id"), result.getInt("openTime"), result.getInt("closeTime"), result.getInt("setupTime"), result.getInt("teardownTime"), result.getString("name"), null, null, result.getInt("maxCapacity"), result.getInt("minBookingInterval"), result.getInt("minBookingTime"));
				facilities.add(facility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilities;
	}
	
	/**
	 * Searches for facilities containing some form of the search string passed to the method.
	 * 
	 * A database connection is created with the mysql database. Afterwards it is queried for 
	 * all facilities with a name that is similar to the name of the facilities in the database.
	 * The ResultSet received is then looped through afterwards and the results are created into
	 * generic facility object, meaning they do not contain any rates or additional charges. 
	 * They are than added to an ArrayList of facilities which is returned later on.
	 * 
	 * @return information requested in a list format
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Facility> search(String searchText) throws DatabaseConnectionException {
		String query = "SELECT * FROM facility WHERE name LIKE '%" + searchText +"%'";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Facility> facilities = new ArrayList<Facility>();
		if(result != null){
			try {
				while (result.next()) {
					Facility facility = new Facility(result.getInt("facility_id"), result.getInt("openTime"), result.getInt("closeTime"), result.getInt("setupTime"), result.getInt("teardownTime"), result.getString("name"), null, null, result.getInt("maxCapacity"), result.getInt("minBookingInterval"), result.getInt("minBookingTime"));
					facilities.add(facility);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return facilities;		
	}
}
