/**
 * 
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;

import problemDomain.Organization;

/**
 * @author 457330
 * 
 */
public class OrganizationBroker implements Broker {
	private Database db = new Database();
	private static OrganizationBroker broker;

	/**
	 * @throws DatabaseConnectionException 
	 * 
	 */
	private OrganizationBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	public void close() {
		broker = null;
	}

	public List<Organization> getAll() throws DatabaseConnectionException {
		ClientBroker cb = ClientBroker.getBroker();
		String query = "SELECT * FROM organization";
		ResultSet result = db.select(query);
		ArrayList<Organization> organizations = new ArrayList<Organization>();
		try {
			while (result.next()) {

				Organization organization = new Organization(result.getInt("Organization_id"), result.getString("name"), result.getDouble("discount"), cb
						.getClientInformation(result.getInt("client_contact")), result.getString("Description"));

				organizations.add(organization);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cb.close();
		return organizations;
	}

	public boolean persist(Object o) {
		Organization organization = (Organization) o;
		String query;

		if (organization.getId() != -1) {
			query = "UPDATE organization SET name='" + organization.getName() + "',discount='" + organization.getDiscount() + "', contact='" + organization.getContact()
					+ "', description='" + organization.getDescription() + "'";
			db.update(query);

		} else {
			query = "INSERT INTO organization VALUES('" + 0 + "', '" + organization.getName() + "', '" + organization.getDiscount() + "', '" + organization.getContact() + "', '"
					+ organization.getDescription() + "')";
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
		Organization organization = (Organization) o;
		String query;

		query = "DELETE FROM organization WHERE organization_id='" + organization.getId() + "'";
		db.update(query);
		return true;
	}

	public static OrganizationBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new OrganizationBroker();
		}
		return broker;// *
	}

	public Organization getOrganizationInformation(int id) throws DatabaseConnectionException {
		ClientBroker cb = ClientBroker.getBroker();
		String query = "SELECT * FROM organization WHERE organization_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);
		Organization org = null;
		try {
			while (result.next()) {

				org = new Organization(result.getInt("Organization_id"), result.getString("name"), result.getDouble("discount"), cb.getClientInformation(result
						.getInt("client_contact")), result.getString("Description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cb.close();
		return org;
	}

}
