/**
 * Feb 16, 2010
 * ClientBroker.java
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;

import problemDomain.Client;
import problemDomain.Organization;
import problemDomain.Phone;

/**
 * @author Corey Cantley
 * @version 1.0
 */
public class ClientBroker implements Broker {
	private Database db = new Database();
	private static ClientBroker broker;

	private ClientBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException 
	 */
	public static ClientBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new ClientBroker();
		}
		return broker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#closeBroker()
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
	public List<Client> getAll() throws DatabaseConnectionException {
		OrganizationBroker ob = OrganizationBroker.getBroker();
		String query = "SELECT * FROM client";
		ResultSet result = db.select(query);
		ArrayList<Client> clients = new ArrayList<Client>();
		try {
			while (result.next()) {
				ArrayList<Phone> phones = new ArrayList<Phone>();
				ArrayList<Organization> orgs = new ArrayList<Organization>();
				query = "SELECT * FROM phone_number WHERE client_id = '" + result.getInt("client_id") + "'";
				ResultSet phoneResult = db.select(query);
				while (phoneResult.next()) {
					Phone phone = new Phone(Enum.valueOf(Phone.PhoneType.class, phoneResult.getString("type")), phoneResult.getInt("area_code"), phoneResult.getInt("number"));
					phones.add(phone);
				}

				query = "SELECT * FROM organization_clients WHERE client_id = '" + result.getInt("client_id") + "'";
				ResultSet orgResult = db.select(query);
				while (orgResult.next()) {
					orgs.add(ob.getOrganizationInformation(orgResult.getInt("organization_id")));
				}

				Client client = new Client(result.getInt("client_id"), result.getString("givenName"), result.getString("surname"), result.getString("address"), result
						.getString("city"), result.getString("province"), result.getString("postalcode"), result.getString("country"), result.getString("email"), phones, result
						.getDouble("discount"), orgs, result.getString("password"));
				clients.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ob.close();
		return clients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#persist(java.lang.Object)
	 */
	public boolean persist(Object o) {
		Client client = (Client) o;
		String query;

		if (client.getId() != -1) {
			query = "UPDATE client SET givenName='" + client.getGivenName() + "', surname='" + client.getSurname() + "', address='" + client.getAddress() + "', city='"
					+ client.getCity() + "', province='" + client.getProvince() + "', postalcode='" + client.getPostalCode() + "', country='" + client.getCountry() + "', email='"
					+ client.getEmail() + "', discount='" + client.getDiscount() + "', password='" + client.getPassword() + "' WHERE client_id='" + client.getId() + "'";
			db.update(query);

			ArrayList<Phone> phones = client.getPhoneNumbers();
			for (int i = 0; i < phones.size(); i++) {
				query = "INSERT INTO phone_number VALUES('" + phones.get(i).getAreacode() + "', '" + phones.get(i).getNumber() + "', '" + phones.get(i).getType().toString()
						+ "', '" + client.getId() + "')";
				db.update(query);
			}

			ArrayList<Organization> orgs = client.getOrganizations();
			for (int i = 0; i < orgs.size(); i++) {
				query = "INSERT INTO organization_clients VALUES('" + orgs.get(i).getId() + "', '" + client.getId() + "')";
				db.update(query);
			}
		} else {
			query = "INSERT INTO client VALUES('0', '" + client.getGivenName() + "', '" + client.getSurname() + "', '" + client.getAddress() + "', '" + client.getCity() + "', '"
					+ client.getProvince() + "', '" + client.getPostalCode() + "', '" + client.getCountry() + "', '" + client.getEmail() + "', '" + client.getDiscount() + "', '"
					+ client.getPassword() + "')";
			int id = db.update(query);
			client.setId(id);

			ArrayList<Phone> phones = client.getPhoneNumbers();
			for (int i = 0; i < phones.size(); i++) {
				query = "INSERT INTO phone_number VALUES('" + phones.get(i).getAreacode() + "', '" + phones.get(i).getNumber() + "', '" + phones.get(i).getType().toString()
						+ "', '" + id + "')";
				db.update(query);
			}

			ArrayList<Organization> orgs = client.getOrganizations();
			for (int i = 0; i < orgs.size(); i++) {
				query = "INSERT INTO organization_clients VALUES('" + orgs.get(i).getId() + "', '" + id + "')";
				db.update(query);
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		Client client = (Client) o;
		String query;

		query = "DELETE FROM client WHERE client_id='" + client.getId() + "'";
		db.update(query);
		return true;
	}

	public Client getClientInformation(int id) {
		Client client = null;
		String query = "SELECT * FROM client WHERE client_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		try {
			while (result.next()) {
				ArrayList<Phone> phones = new ArrayList<Phone>();
				ArrayList<Organization> orgs = new ArrayList<Organization>();
				query = "SELECT * FROM phone_number WHERE client_id = '" + result.getInt("client_id") + "'";
				ResultSet phoneResult = db.select(query);
				while (phoneResult.next()) {
					Phone phone = new Phone(Enum.valueOf(Phone.PhoneType.class, phoneResult.getString("type")), phoneResult.getInt("area_code"), phoneResult.getInt("number"));
					phones.add(phone);
				}

				query = "SELECT * FROM organization org, organization_clients oc WHERE oc.client_id = '" + result.getInt("client_id")
						+ "' AND org.organization_id = oc.organization_id";
				ResultSet orgResult = db.select(query);
				while (orgResult.next()) {
					Organization org = new Organization(orgResult.getString("name"), orgResult.getDouble("discount"), null, orgResult.getString("description"));
					orgs.add(org);
				}

				client = new Client(result.getInt("client_id"), result.getString("givenName"), result.getString("surname"), result.getString("address"), result.getString("city"),
						result.getString("province"), result.getString("postalcode"), result.getString("country"), result.getString("email"), phones, result.getDouble("discount"),
						orgs, result.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
}
