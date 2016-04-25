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
import problemDomain.Organization;

/**
 * @author John Stuby
 * 
 */
public class OrganizationBroker {
	
	private static OrganizationBroker broker;

	/**
	 * initializes organizationBroker instance
	 */
	private OrganizationBroker() {
		
	}
	
	/**
	 * Closes Database connection
	 * 
	 */
	public void close() {
		
		broker = null;
	}
	
	/**
	 * Retrieves a list of all Organizations that the client belongs to
	 * @param clientID the id of the Client to find organizations for 
	 * @return a List containing all Organizations that the client with the specified id belongs to
	 * @throws DatabaseConnectionException
	 * @throws SQLException
	 */
	public List<Organization> getOrgsForClientID(int clientID) throws DatabaseConnectionException, SQLException
	{
		ClientBroker cb=ClientBroker.getBroker();
		
		String query = "SELECT organization.* FROM organization,organization_clients WHERE organization.organization_id=organization_clients.organization_id AND organization_clients.client_id="+clientID+";";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Organization> organizations = new ArrayList<Organization>();
		try {
			while (result.next()) {

				Organization organization = new Organization(result.getInt("Organization_id"), result.getString("name"), result.getDouble("discount"), cb
						.getClientInformation(result.getInt("client_contact")), result.getString("Description"));

				organizations.add(organization);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cb.close();
		return organizations;
	}
	
	/**
	 * Gets needed information from clientTable in database and creates a new organization to
	 * add to organization table
	 * @return list of requested organizations
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException 
	 */
	public List<Organization> getOrgList() throws DatabaseConnectionException, SQLException {
		ClientBroker cb = ClientBroker.getBroker();
		String query = "SELECT organization_id, name, description, discount, client_contact " +
						"FROM organization";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Organization> organizations = new ArrayList<Organization>();
		try {
			while (result.next()) {
				Organization organization = new Organization(result.getInt("Organization_id"), 
																result.getString("name"), 
																result.getDouble("discount"), 
																cb.getClientInformation(result.getInt("client_contact")), 
																result.getString("description"));
				organizations.add(organization);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cb.close();
		
		return organizations;
	}
	/**
	 * If id exists information in organization table is updated
	 * If id != exist information is inserted into organization table
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Organization organization = (Organization) o;
		String query;

		Connection con = Database.connect();
		if (organization.getId() != 0) {
			query = "UPDATE organization " +
					"SET name='" + organization.getName() + 
					"', discount=" + organization.getDiscount() + 
					", client_contact=" + organization.getContact().getId()+ 
					", description='" + organization.getDescription() + "' " +
					"WHERE organization_id=" + organization.getId() + " ";
			Database.update(query, con);

		} else {
			query = "INSERT INTO organization VALUES('" + 0 + "', '" + organization.getName() + "', '" + organization.getDiscount() + "', '" + organization.getDescription() + "', '"
					+ organization.getContact().getId() + "')";
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
	 * Deletes information from rate table where organization_id = organization.getId
	 * If id does not exist a exception will be thrown.
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Organization organization = (Organization) o;
		String query;

		query = "DELETE FROM organization WHERE organization_id='" + organization.getId() + "'";
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
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public static OrganizationBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new OrganizationBroker();
		}
		return broker;
	}
	
	/**
	 * Gets all required information and adds it to resultSet
	 * @param id is the id for the organization
	 * @return An resultSet for requested organization
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException 
	 */
	public Organization getOrganizationInformation(int id) throws DatabaseConnectionException, SQLException {
		ClientBroker cb = ClientBroker.getBroker();
		String query = "SELECT * FROM organization WHERE organization_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		Organization org = null;
		try {
			while (result.next()) {

				org = new Organization(result.getInt("Organization_id"), result.getString("name"), result.getDouble("discount"), cb.getClientInformation(result.getInt("client_contact")), result.getString("Description"));
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cb.close();
		return org;
	}

	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to search than returns a list
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException 
	 */
	public List<Organization> search(String searchText) throws DatabaseConnectionException, SQLException
	{
		ClientBroker cb = ClientBroker.getBroker();
		String query = "SELECT organization_id, name, discount, client_contact, description " +
						"FROM organization " +
						"WHERE name LIKE '%" + searchText + "%'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Organization> organizations = new ArrayList<Organization>();
		if(result != null){
			try {
				while (result.next()) {
					Organization organization = new Organization(result.getInt("organization_id"), result.getString("name"), result.getDouble("discount"), cb.getClientInformation(result.getInt("client_contact")), result.getString("description"));
					organizations.add(organization);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		cb.close();
		
		return organizations;		
	}
}
