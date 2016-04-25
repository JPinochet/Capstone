/**


 * Feb 18, 2010
 * BookingBroker.java
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Invoice;
import problemDomain.Payment;

/**
 * @author cantleyc
 * 
 */
public class InvoiceBroker implements Broker {
	private Database db = new Database();
	private static InvoiceBroker broker;

	private InvoiceBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException 
	 */
	public static InvoiceBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new InvoiceBroker();
		}
		return broker;
	}

	public void close() {
		db.close();
		broker = null;
	}

	@Deprecated
	public List<Invoice> getAll() {
		System.err.println("Use getInvoicesForClient. We will never get ALL the invoices in the database");
		return null;
	}

	public boolean persist(Object o) {
		Invoice invoice = (Invoice) o;
		String query;

		if (invoice.getId() != -1) {
			query = "";
			db.update(query);
		} else {
			query = "";
			db.update(query);
		}
		return true;
	}

	public boolean remove(Object o) {
		Invoice invoice = (Invoice) o;
		String query;

		query = "DELETE FROM invoice WHERE invoice_no='" + invoice.getId() + "'";
		db.update(query);
		return true;
	}

	public List<Invoice> getInvoicesForClient(Client c) throws DatabaseConnectionException {
		ClientBroker cb = ClientBroker.getBroker();
		BookingBroker bb = BookingBroker.getBroker();
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();

		String query = "SELECT * FROM invoice WHERE client_id='" + c.getId() + "'";
		ResultSet result = db.select(query);

		try {
			while (result.next()) {
				int invoice_no = result.getInt("invoice_no");
				int client_id = result.getInt("client_id");
				Date date = result.getDate("date");
				boolean paid = result.getBoolean("paid");
				double paymentDue = result.getDouble("paymentDue");
				String desc = result.getString("description");
				Date dueDate = result.getDate("dueDate");

				ArrayList<Payment> payments = new ArrayList<Payment>();
				query = "SELECT * FROM payment WHERE invoice_no='" + invoice_no + "'";
				ResultSet pResult = db.select(query);
				while (pResult.next()) {
					payments.add(new Payment(pResult.getInt("payment_id"), pResult.getDate("paymentDate"), pResult.getDouble("paymentAmount")));
				}

				Invoice invoice = new Invoice(invoice_no, date, cb.getClientInformation(client_id), (ArrayList<Booking>) bb.getBookingsForInvoice(invoice_no), paid, paymentDue,
						desc, dueDate, payments);
				invoices.add(invoice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cb.close();
		bb.close();
		return invoices;
	}

	public Invoice getInvoiceInformation(int id) throws DatabaseConnectionException {
		ClientBroker cb = ClientBroker.getBroker();
		BookingBroker bb = BookingBroker.getBroker();

		String query = "SELECT * FROM invoice WHERE invoice_no='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		Invoice invoice = null;
		try {
			while (result.next()) {
				int client_id = result.getInt("client_id");
				Date date = result.getDate("date");
				boolean paid = result.getBoolean("paid");
				double paymentDue = result.getDouble("paymentDue");
				String desc = result.getString("description");
				Date dueDate = result.getDate("dueDate");

				ArrayList<Payment> payments = new ArrayList<Payment>();
				query = "SELECT * FROM payment WHERE invoice_no='" + id + "'";
				ResultSet pResult = db.select(query);
				while (pResult.next()) {
					payments.add(new Payment(pResult.getInt("payment_id"), pResult.getDate("paymentDate"), pResult.getDouble("paymentAmount")));
				}

				invoice = new Invoice(id, date, cb.getClientInformation(client_id), (ArrayList<Booking>) bb.getBookingsForInvoice(id), paid, paymentDue, desc, dueDate, payments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cb.close();
		bb.close();		
		return invoice;
	}

}
