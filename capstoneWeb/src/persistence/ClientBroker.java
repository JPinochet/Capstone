/**
 * Feb 16, 2010
 * ClientBroker.java
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.BookingManager;
import logic.InvoiceManager;

import exceptions.DatabaseConnectionException;

import problemDomain.Client;
import problemDomain.Invoice;
import problemDomain.Organization;

/**
 * @author Corey Cantley
 * @version 1.0
 */
public class ClientBroker {
	
	private static ClientBroker broker = null;

	private ClientBroker() throws DatabaseConnectionException {
	}

	/**
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException - is thrown if database connection fails 
	 */
	public static ClientBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new ClientBroker();
		}
		return broker;
	}

	/**
	 * closes the broker
	 * @throws SQLException - if the query is invalid
	 */
	public void close() throws SQLException {
		broker = null;
	}
	
	/**
	 * Gets all client information and the organizations that they are affiliated with from the database
	 * @return client information in a list format
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	public List<Client> getClientList() throws DatabaseConnectionException {
		Connection con = Database.connect();
		String query = "SELECT client_id, givenName, surname, email, homePhone, workPhone, cellPhone FROM client";
		ResultSet result = Database.select(query, con);
		ArrayList<Client> clients = new ArrayList<Client>();
		if(result != null) {
			try {
				while (result.next()) {
					Client client = new Client(result.getInt("client_id"), result.getString("givenName"), result.getString("surname"), result.getString("email"), result.getString("workPhone"), result.getString("homePhone"), result.getString("cellPhone"));
					
					OrganizationBroker ob = OrganizationBroker.getBroker();
					ArrayList<Organization> orgs = (ArrayList<Organization>) ob.getOrgsForClientID(result.getInt("client_id"));
					client.setOrganizations(orgs);
					
					clients.add(client);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clients;
	}


	/**
	 * If the id for client exists client is updated with new values.
	 * If the id does not exist, information is inserted into client table
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Client client = (Client) o;
		String query;

		Connection con = Database.connect();
		if (client.getId() != 0) {
			query = "UPDATE client SET givenName='" + client.getGivenName() + "', surname='" + client.getSurname() + "', address='" + client.getAddress() + "', city='"
					+ client.getCity() + "', province='" + client.getProvince() + "', postalcode='" + client.getPostalCode() + "', country='" + client.getCountry() + "', email='"
					+ client.getEmail() + "', discount='" + client.getDiscount() + "', password='" + client.getPassword() + "', homePhone='" + client.getHomePhone()
					 + "', workPhone='" + client.getWorkPhone() + "', cellPhone='" + client.getCellPhone() + "' WHERE client_id='" + client.getId() + "'";
			Database.update(query, con);

			ArrayList<Organization> orgs = client.getOrganization();
			query = "DELETE FROM organization_clients  WHERE client_id='" + client.getId() + "'";
			Database.update(query, con);
			for (int i = 0; i < orgs.size(); i++) {
				query = "INSERT INTO organization_clients VALUES('" + orgs.get(i).getId() + "', '" + client.getId() + "')";
				Database.update(query, con);
			}
		} else {
			query = "INSERT INTO client VALUES('0', '" + client.getGivenName() + "', '" + client.getSurname() + "', '" + client.getAddress() + "', '" + client.getCity() + "', '"
					+ client.getProvince() + "', '" + client.getPostalCode() + "', '" + client.getCountry() + "', '" + client.getEmail() + "', '" + client.getDiscount() + "', '"
					+ client.getPassword() + "', '" + client.getHomePhone()+ "', '" + client.getWorkPhone() + "', '" + client.getCellPhone() + "')";
			int id = Database.update(query, con);
			client.setId(id);

			ArrayList<Organization> orgs = client.getOrganization();
			for (int i = 0; i < orgs.size(); i++) {
				query = "INSERT INTO organization_clients VALUES('" + orgs.get(i).getId() + "', '" + id + "')";
				Database.update(query, con);
			}
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
	 * @param o - object to be removed
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	
	public boolean remove(Object o) throws DatabaseConnectionException {
		Client client = (Client) o;
		String query;

		query = "DELETE FROM client WHERE client_id='" + client.getId() + "'";
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
	 * Performs a set of queries on the database to retrieve all information that related to a Client with
	 * the id specified
	 * @param id is the id of the Client that information will be retrieved for
	 * @return A Client object that contains all information retrieved from the database
	 * @throws DatabaseConnectionException is thrown if the database connection fails
	 */
	public Client getClientInformation(int id) throws DatabaseConnectionException {
		Client client = null;
		String query = "SELECT * FROM client WHERE client_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		try {
			while (result.next()) {

				ArrayList<Organization> orgs = new ArrayList<Organization>();

				query = "SELECT organization_id FROM organization_clients WHERE client_id = '" + id + "'";
				ResultSet orgResult = Database.select(query, con);
				while (orgResult.next()) {
					Organization org = new Organization();
					org.setId(orgResult.getInt("organization_id"));
					orgs.add(org);
				}

				client = new Client(result.getInt("client_id"), result.getString("givenName"), result.getString("surname"), result.getString("email"), result.getString("address"), result.getString("city"),
						result.getString("province"), result.getString("country"), result.getString("postalcode"), result.getInt("discount"), result.getString("password"), result.getString("homePhone"), 
						result.getString("workPhone"), result.getString("cellPhone"), orgs);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to find requested data than returns a list
	 * @return an ArrayList of all requested information from database
	 * @throws DatabaseConnectionException is thrown if the database connection fails
	 * @throws SQLException is thrown if the query is invalid
	 */
	public List<Client> search(String searchText) throws DatabaseConnectionException, SQLException {
		OrganizationBroker ob = OrganizationBroker.getBroker();
		String query = "SELECT client_id, givenName, surname, email, homePhone, workPhone, cellPhone " +
						"FROM client " +
						"WHERE givenName LIKE '%" + searchText +"%' " +
						"OR surname LIKE '%" + searchText + "%' " +
						"OR email LIKE '%" + searchText + "%' " +
						"OR homePhone LIKE '%" + searchText + "%' " +
						"OR workPhone LIKE '%" + searchText + "%' " +
						"OR cellPhone LIKE '%" + searchText + "%' " +
						"OR CONCAT_WS(' ',givenName, surname) LIKE '%" + searchText +"%'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Client> clients = new ArrayList<Client>();
		if(result != null){
			try {
				while (result.next()) {
					Client client = new Client(result.getInt("client_id"), result.getString("givenName"), result.getString("surname"), result.getString("email"), result.getString("workPhone"), result.getString("homePhone"), result.getString("cellPhone"));
					
					client.setOrganizations( (ArrayList) ob.getOrgsForClientID(result.getInt("client_id")));
					
					clients.add(client);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		result.close();
		ob.close();
		
		return clients;		
	}
	
	/**
	 * @param email - the client email used to login 
	 * @param password - the clients password used to login
	 * @return - returns the clients id
	 * @throws DatabaseConnectionException
	 */
	public int validateLogin(String email, String password) throws DatabaseConnectionException
	{
		int client = 0;

		String query="SELECT client_id " +
		"FROM client " +
		"WHERE email='" + email + "' " +
		"AND password='" + password + "'";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		try
		{
			if(result != null) {
				while(result.next())
				{
					client = result.getInt("client_id");
				}
				result.close();
				con.close();
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
}
