/**


 * Feb 18, 2010
 * BookingBroker.java
 */
package persistence;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.BookingManager;
import logic.ClientManager;
import logic.InvoiceManager;

import exceptions.DatabaseConnectionException;
import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Invoice;
import problemDomain.Payment;

/**
 * @author cantleyc
 * 
 */
public class InvoiceBroker {
	
	private static InvoiceBroker broker;

	private InvoiceBroker() {
		
	}

	/**
	 * Gets the broker instance. Method used for the implementation of a singleton.
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public static InvoiceBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new InvoiceBroker();
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
	 * If id exists information in invoice table is updated
	 * If id != exist information is inserted into invoice table
	 * 
	 * This method utilizes a database connection
	 * 
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Invoice invoice = (Invoice) o;
		String query;

		Connection con = Database.connect();
		if (invoice.getId() != 0) {
			for(Booking b : invoice.getBookings()) {
				query = "UPDATE booking SET invoice_no='" + invoice.getId() + "' WHERE booking_id='" + b.getId() + "'";
				Database.update(query, con);
			}
			query = "UPDATE invoice SET description='" + invoice.getDescription() + "' WHERE invoice_no='" + invoice.getId() + "'";
			Database.update(query, con);
		} else {
			query = "INSERT INTO invoice VALUES('0', '" + invoice.getClient().getId() + 
												"', '" + Database.DATE_FORMAT.format(new Date()) + 
												"', '" + invoice.getDescription() + 
												"', '3')";
			int invoice_no = Database.update(query, con);
			for(Booking b : invoice.getBookings()) {
				query = "UPDATE booking SET invoice_no='" + invoice_no + "' WHERE booking_id='" + b.getId() + "'";
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
	
	public void payInvoice(Invoice i, Payment p) {
		try {
			Connection con = Database.connect();
			String query = "INSERT INTO payment VALUES('0', '" + i.getId() + "', '" + Database.DATE_FORMAT.format(p.getDate()) + "', '" + p.getAmount() + "', '" + p.getType() + "');";
			Database.update(query, con);
			con.close();
		} catch (DatabaseConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes information from rate table where invoice_id = invoice.getId
	 * If id does not exist a exception will be thrown.
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Invoice invoice = (Invoice) o;
		String query;

		query = "DELETE FROM invoice WHERE invoice_no='" + invoice.getId() + "'";
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
	 * Gets all required information adds to resultSet
	 * @return updated result set, returns invoices for clients where client_id = c.getId
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException is thrown if the sql is not working properly
	 */
	public List<Invoice> getInvoicesForClient(Client c) throws DatabaseConnectionException, SQLException {
		ClientBroker cb = ClientBroker.getBroker();
		BookingBroker bb = BookingBroker.getBroker();
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();

		String query = "SELECT * FROM invoice WHERE client_id='" + c.getId() + "' ORDER BY date DESC";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		try {
			Invoice invoice = null;
			while (result.next()) {
				int id = result.getInt("invoice_no");
				int client_id = result.getInt("client_id");
				Date date = result.getDate("date");
				boolean paid = this.isPaid(new Invoice(id));
				double paymentDue = this.getPaymentOwed(new Invoice(id));
				String desc = result.getString("description");
				Date dueDate = this.getDueDate(id);

				ArrayList<Payment> payments = new ArrayList<Payment>();
				query = "SELECT * FROM payment WHERE invoice_no='" + id + "'";
				ResultSet pResult = Database.select(query, con);
				while (pResult.next()) {
					Payment p = new Payment(pResult.getInt("payment_id"), pResult.getDate("paymentDate"), pResult.getDouble("paymentAmount"), pResult.getString("payment_type"));
					p.setId(id);
					payments.add(p);
				}
				pResult.close();

				invoice = new Invoice(id, date, cb.getClientInformation(client_id), (ArrayList<Booking>) bb.getBookingsForInvoice(id), paid, paymentDue, desc, dueDate, payments);
				invoice.setSubtotal(this.getSubtotal(invoice));
				invoices.add(invoice);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * Closes broker instances
		 */
		cb.close();
		bb.close();
		return invoices;
	}
	
	/**
	 * Gets all required information and adds it to resultSet
	 * @param id is the id for the invoice
	 * @return the resultSet for requested invoice
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException is thrown if the sql is not working properly
	 */
	public Invoice getInvoiceInformation(int id) throws DatabaseConnectionException, SQLException {
		ClientBroker cb = ClientBroker.getBroker();
		BookingBroker bb = BookingBroker.getBroker();

		String query = "SELECT * FROM invoice WHERE invoice_no='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		Invoice invoice = null;
		try {
			while (result.next()) {
				int client_id = result.getInt("client_id");
				Date date = result.getDate("date");
				boolean paid = this.isPaid(new Invoice(id));
				double paymentDue = this.getPaymentOwed(new Invoice(id));
				String desc = result.getString("description");
				Date dueDate = this.getDueDate(id);

				ArrayList<Payment> payments = new ArrayList<Payment>();
				query = "SELECT * FROM payment WHERE invoice_no='" + id + "'";
				ResultSet pResult = Database.select(query, con);
				while (pResult.next()) {
					Payment p = new Payment(pResult.getInt("payment_id"), pResult.getDate("paymentDate"), pResult.getDouble("paymentAmount"), pResult.getString("payment_type"));
					p.setId(id);
					payments.add(p);
				}
				pResult.close();

				invoice = new Invoice(id, date, cb.getClientInformation(client_id), (ArrayList<Booking>) bb.getBookingsForInvoice(id), paid, paymentDue, desc, dueDate, payments);
				invoice.setSubtotal(this.getSubtotal(invoice));
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cb.close();
		bb.close();		
		return invoice;
	}
	
	/**
	 * @param invoice contains all needed information
	 * @return double for the actual cost owed
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public double getACCost(Invoice invoice) throws DatabaseConnectionException
	{
		double total = 0;
		
		String query = "SELECT SUM(ac.cost) "
			+ "FROM additional_charge ac, booking_additional_charges bac, booking b " 
			+ "WHERE ac.additional_charge_id = bac.additional_charge_id "
			+ "AND bac.booking_id = b.booking_id "
			+ "AND b.invoice_no = '" + invoice.getId() + "' ";
	
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		try
		{
			if(result != null) {
				while(result.next())
				{
					total += result.getDouble(1);
				}
				result.close();
				con.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return total;
	}
	
	public double getSubtotal(Invoice invoice) throws DatabaseConnectionException {
		double total = 0;
		//ear 'r.rate_id = b.rate AND b.client_id = c.client_id AND b.catering = ca.catering_id' at 
		String query = "SELECT TIME_TO_SEC(TIMEDIFF(b.endTime, b.startTime))/3600, r.rate, c.discount, r.damageDeposit, r.bookingDeposit, r.isHourly, b.client_id " +
				"FROM booking b, rate r, CLIENT c " +
				"WHERE r.rate_id = b.rate " +
				"AND b.client_id = c.client_id " +
				"AND b.invoice_no = '" + invoice.getId() + "'";

		Connection con = Database.connect();
		ResultSet result1 = Database.select(query, con);
		
		try
		{
			if(result1 != null) {
				while(result1.next())
				{ 
					double tempTotal = 0;
					if(result1.getInt(6) == 1)
						tempTotal += ((((result1.getDouble(1) * result1.getDouble(2)) + result1.getDouble(4) + result1.getDouble(5) + this.getACCost(invoice))) *  1.05);
					else
						tempTotal += ((((1 * result1.getDouble(2)) + result1.getDouble(4) + result1.getDouble(5) + this.getACCost(invoice))) *  1.05);
					total += tempTotal;
					total -= ((result1.getDouble(3)/100) * tempTotal);
				}
				result1.close();
				con.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
	    BigDecimal bd = new BigDecimal(total);
	    bd = bd.setScale(2,BigDecimal.ROUND_UP);
	    
		return bd.doubleValue();
	}
	
	/**
	 * @param invoice contains all needed information
	 * @return a double for the payment owed that is inputted
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public double getPaymentOwed(Invoice invoice) throws DatabaseConnectionException
	{	
		
		double total = getSubtotal(invoice);
		
		String query = "SELECT SUM(paymentAmount) " 
			+ "FROM payment " 
			+ "WHERE invoice_no = '" + invoice.getId() + "' ";
		
		Connection con = Database.connect();
		ResultSet result2 = Database.select(query, con);
		double payments = 0;
		try
		{
			if(result2 != null) {
				while(result2.next())
				{
					payments += result2.getDouble(1);
				}
				result2.close();
			}
			con.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		

		if(total == 0 && payments == 0)
			return -1;
		else
			return total - payments;
	}
	
	/**
	 * @param invoice contains all needed information
	 * @return all requested payments in a list format
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Payment> getPayments(Invoice invoice) throws DatabaseConnectionException 
	{
		Payment payment = new Payment();
		ArrayList<Payment> payments = new ArrayList<Payment>();
		
		String query = "SELECT * " 
			+ "FROM payment " 
			+ "WHERE invoice_no = '" + invoice.getId() + "' ";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		
		try
		{
			while(result.next())
			{
				payment.setId(result.getInt("payment_id"));
				payment.setDate(result.getDate("paymentDate"));
				payment.setAmount(result.getDouble("paymentAmount"));
				payment.setType(result.getString("payment_type"));
				payments.add(payment);
			}
			result.close();
			con.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		return payments;
	}
	
	/**
	 * @return all unPaidInvoices in a list format
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException is thrown if the sql is not working properly
	 */
	public List<Invoice> getAllUnPaidInvoices() throws DatabaseConnectionException, SQLException
	{
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		ClientManager cm = new ClientManager();
		BookingManager bm = new BookingManager();
		
		String query = "SELECT * FROM invoice i, client c WHERE i.client_id = c.client_id";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		try
		{
			if(result != null) {
				while(result.next())
				{				
					 Invoice invoice = new Invoice(result.getInt("invoice_no"), result.getDate("date"), cm.getClientInfo(result.getInt("client_id")), bm.getAllBookingsForClient(result.getInt("client_id")) , this.isPaid(this.getInvoiceInformation(result.getInt("invoice_no"))), this.getPaymentOwed(new Invoice(result.getInt("invoice_no"))), result.getString("description"), this.getDueDate(result.getInt("invoice_no")), this.getPayments(new Invoice(result.getInt("invoice_no"))));
					 invoice.setSubtotal(this.getSubtotal(invoice));
					 if(!invoice.getPaid())
						 invoices.add(invoice);
				}
				result.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cm.close();
		bm.close();
		
		return invoices;
	}

	/**
	 * @param invoice contains all needed invoice information
	 * @return boolean for isPaid
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean isPaid(Invoice invoice) throws DatabaseConnectionException
	{
		return this.getPaymentOwed(invoice) == 0;
	}

	public Date getDueDate(int invoice_no) throws DatabaseConnectionException 
	{
		Date date = new Date();
		
		String query = "SELECT MIN(startTime) " 
						+ "FROM booking " 
						+ "WHERE invoice_no = '" + invoice_no + "'";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		if(result != null)
		{
			try
			{
				result.next();
				date = Database.DATETIME_FORMAT.parse(result.getString(1));
				result.close();
				con.close();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return date;
	}
	
	public List<Invoice> getAllInvoicesForClient(Client client) throws DatabaseConnectionException
	{
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		
		BookingManager bm = new BookingManager();
		InvoiceManager im = new InvoiceManager();
		
		String query = "SELECT * " +
							"FROM clients c, invoice i "+
							"WHERE i.client_id = c.client_id " +
							"AND c.client_id = '"+ client.getId() + "'";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		try
		{
			if(result != null) {
				ClientManager cm = new ClientManager();
				while(result.next())
				{																																		//int id, Date date, Client client, List<Booking> bookings, Boolean paid, double paymentDue, String description, Date dueDate, List<Payment> payments
					 Invoice invoice = new Invoice (result.getInt("invoice_no"), result.getDate("date"), cm.getClientInfo(client.getId()), bm.getAllBookingsForClient(client.getId()) , im.isPaid(result.getInt("invoice_no")), im.paymentOwed(result.getInt("invoice_no")), result.getString("description"), this.getDueDate(result.getInt("invoice_no")), im.getPayments(result.getInt("invoice_no")));
					 invoices.add(invoice);
				}
				result.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bm.close();
		im.close();
		
		
		return invoices;
	}
}
