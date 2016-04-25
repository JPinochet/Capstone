package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.AdditionalCharge;

/**
 * @author kerri
 * 
 */
public class AdditionalChargeBroker {
	private static AdditionalChargeBroker broker;

	/**
	 * Initializes AdditionChargeBroker
	 */
	private AdditionalChargeBroker() {
		
	}

	/**
	 * Gets the broker instance
	 *
	 * @return the current broker instance
	 * @throws DatabaseConnectionException - is thrown if Database connection fails 
	 */
	public static AdditionalChargeBroker getBroker() {
		if (broker == null) {
			broker = new AdditionalChargeBroker();
		}
		return broker;
	}

	/**
	 * Closes broker and any open Database connections
	 * 
	 */
	public void close() {
		broker = null;
	}

	/**
	 * Searches Database for id, name and cost in additional_charges
	 * @return a list of additional charges
	 * @throws DatabaseConnectionException  - is thrown if Database connection fails
	 * 
	 */
	public List<AdditionalCharge> getAdditionalChargeList() throws DatabaseConnectionException {
		String query = "SELECT * FROM additional_charge";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		ArrayList<AdditionalCharge> additionalCharges = new ArrayList<AdditionalCharge>();
		try {
			while (result.next()) {
				int id = result.getInt("additional_charge_id");
				String name = result.getString("name");
				double cost = result.getDouble("cost");

				AdditionalCharge ac = new AdditionalCharge(id, name, cost);

				additionalCharges.add(ac);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return additionalCharges;

	}

	
	/**
	 * If the id for additional_charge exists it is updated with the new values
	 * If the id does not exist, a new additional_charge is created and stored in the additional_charge table in the database
	 * @param o - the additional_charge to search for 
	 * @return true/false - if object is valid
	 * @throws DatabaseConnectionException - is thrown if Database connection fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		AdditionalCharge ac = (AdditionalCharge) o;

		String query;

		Connection con = Database.connect();
		if (ac.getId() != 0) {
			query = "UPDATE additional_charge SET cost='" + ac.getCost() + "', name='" + ac.getName() + "' WHERE additional_charge_id='" + ac.getId() + "'";
			Database.update(query, con);
		} else {
			query = "INSERT INTO additional_charge VALUES('"+ac.getId()+"', '" + ac.getName() + "', '" + ac.getCost() + "')";
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
	 * Removes the requested additional charge from the database
	 * @param o - the additional charge to be removed 
	 * @return true/false - if the object is valid
	 * @throws DatabaseConnectionException - is thrown if Database connection fails
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		AdditionalCharge ac = (AdditionalCharge) o;
		String query;

		query = "DELETE FROM additional_charge WHERE additional_charge_id='" + ac.getId() + "'";
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
	 * Selects all data from the additional charge table
	 * As long as the additional charge is not empty it creates a new entry in the table with all
	 * user input data
	 * @param id - is the id of the additionalCharge
	 * @return the search result for requested additional charge
	 * @throws DatabaseConnectionException - is thrown if Database connection fails 
	 * @throws SQLException - is thrown if their is a problem connection to sql
	 */
	public AdditionalCharge getAdditionalChargeInformation(int id) throws DatabaseConnectionException {
		String query = "SELECT * FROM additional_charge WHERE additional_charge_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		AdditionalCharge additionalCharge = null;

		try {
			while (result.next()) {
				String name = result.getString("name");
				double cost = result.getDouble("cost");

				additionalCharge = new AdditionalCharge(id, name, cost);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return additionalCharge;
	}
	
	/**
	 * Searches database for requested additional charge
	 * @param searchText - the additional_charges that are to being searched for
	 * @return the requested additional charge(s) from database
	 * @throws DatabaseConnectionException - is thrown if Database connection fails 
	 */
	
	public ArrayList<AdditionalCharge> search(String searchText) throws DatabaseConnectionException
	{
		String query = "SELECT additional_charge_id, name, cost " +
						"FROM additional_charge " +
						"WHERE name LIKE '%"+ searchText +"%' " +
						"OR cost='" + searchText +"'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();
		if(result != null){
			try {
				while (result.next()) {
					AdditionalCharge ac = new AdditionalCharge(result.getInt("additional_charge_id"), result.getString("name"), result.getDouble("cost"));
					acs.add(ac);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return acs;	
	}
}
