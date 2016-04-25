/**
 * Feb 18, 2010
 * BookingBroker.java
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.BookingTypeManager;

import exceptions.DatabaseConnectionException;

import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.BookingType;
import problemDomain.Catering;
import problemDomain.Client;
import problemDomain.Employee;
import problemDomain.Facility;
import problemDomain.Invoice;
import problemDomain.Organization;
import problemDomain.Rate;

/**
 * @author cantleyc
 * 
 */
public class BookingBroker {
	private static BookingBroker broker;

	/**
	 * Connects to the database
	 * @throws DatabaseConnectionException - is thrown if database connection fails
	 */
	private BookingBroker() {
		
	}

	/**
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	public static BookingBroker getBroker() {
		if (broker == null) {
			broker = new BookingBroker();
		}
		return broker;
	}

	
	/**
	 * Closes the database connection
	 */
	public void close() {
		
		broker = null;
	}

	
	
	/**
	 * If the id for catering exists in the database the data is updated with the new user input data
	 * If the id does not exist an new catering object is created and stored in the database
	 * @param o - catering object being searched for
	 * @return true/false - if the object is valid
	 * @throws DatabaseConnectionException - is thrown if the connection to the database fails
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		Booking booking = (Booking) o;
		String query;

		Connection con = Database.connect();
		if (booking.getId() != 0) {
			int catering_id = booking.getCatering().getId();
			if (catering_id != -1) {
				query = "UPDATE catering SET chargeName='" + booking.getCatering().getChargeName() + "', charge='" + booking.getCatering().getCharge() + "' WHERE catering_id='"
						+ catering_id + "'";
				Database.update(query, con);
			} else {
				query = "INSERT INTO catering VALUES('0','" + booking.getCatering().getChargeName() + "','" + booking.getCatering().getCharge() + "','" + booking.getCatering().getDescription() + "')";
				catering_id = Database.update(query, con);
			}

			query = "UPDATE booking SET facility_id='" + booking.getFacility().getId() 
					+ "', client_id='" + booking.getClient().getId() 
					+ "', employee_id='"+ booking.getCreator().getId() 
					+ "', booking_type='" + booking.getEventType().getId() 
					+ "', invoice_no=" + ((booking.getInvoice_no()==0)?"NULL":booking.getInvoice_no())
					+ ", catering='" + catering_id 
					+ "', rate='" + booking.getRate().getId() 
					+ "', eventTitle='" + booking.getEventTitle() 
					+ "', startTime='" + Database.DATETIME_FORMAT.format(booking.getStartTime()) 
					+ "', endTime='" + Database.DATETIME_FORMAT.format(booking.getEndTime())
					+ "', setupTime='" + booking.getSetupTime() 
					+ "', tearDownTime='" + booking.getTearDownTime() 
					+ "', numberOfPeople='" + booking.getNumberOfPeople() 
					+ "' WHERE booking_id='" + booking.getId() + "'";
			Database.update(query, con);
		} else {
			query = "INSERT INTO catering VALUES('0','" + booking.getCatering().getChargeName() + "','" + booking.getCatering().getCharge() + "','" + booking.getCatering().getDescription() + "')";
			int catering_id = Database.update(query, con);

			query = "INSERT INTO booking VALUES('0', '" + booking.getFacility().getId() 
									+ "','" + booking.getClient().getId() 
									+ "','" + booking.getCreator().getId() 
									+ "','"	+ booking.getEventType().getId() 
									+ "'," + ((booking.getInvoice_no()==0)?"NULL":booking.getInvoice_no()) 
									+ ",'" + catering_id 
									+ "','" + booking.getRate().getId() 
									+ "','" + booking.getEventTitle()
									+ "','" + Database.DATETIME_FORMAT.format(booking.getStartTime()) 
									+ "','" + Database.DATETIME_FORMAT.format(booking.getEndTime())
									+ "','" + booking.getSetupTime() 
									+ "','" + booking.getTearDownTime() 
									+ "','"	+ booking.getNumberOfPeople() + "')";
			int booking_id = Database.update(query, con);

			ArrayList<AdditionalCharge> additionalCharges = booking.getAdditionalCharges();
			for (int i = 0; i < additionalCharges.size(); i++) {
				query = "INSERT INTO booking_additional_charges VALUES('" + additionalCharges.get(i).getId() + "', '" + booking_id + "')";
				Database.update(query, con);
			}

		}
		return true;
	}

	
	/**
	 * Removes the supplied object from the database
	 * @param o - is the booking object being removed
	 * @return true/false - if the object is valid
	 * @throws DatabaseConnectionException - is thrown if database connection fails
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Booking booking = (Booking) o;
		String query;

		query = "DELETE FROM booking WHERE booking_id='" + booking.getId() + "'";
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
	 * Returns all bookings for a facility during a specified time frame
	 * @param f - the facility to get bookings for
	 * @param start - the date to start looking for bookings (Non-inclusive)
	 * @param end - the date to stop looking for bookings (Non-inclusive)
	 * @return a list containing all bookings between the specified start
	 * and end dates for the chosen facility
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	
	public List<Booking> getBookingsForFacility(Facility f, Date start, Date end) throws DatabaseConnectionException {
		String query = "SELECT * FROM booking WHERE facility_id='" + f.getId() + "' AND startTime BETWEEN '" + Database.DATETIME_FORMAT.format(start) + "' AND '" + Database.DATETIME_FORMAT.format(end) + "' ORDER BY startTime";

		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		List<Booking> b = getBookingsFromResultSet(result);
		try {
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Returns all bookings that are associated with a particular invoice
	 * @param invoice_no - the invoice number of the invoice to find bookings for
	 * @return A list containing all booking related to the requested invoice number
	 * @throws DatabaseConnectionException - is thrown if DB connection fails
	 */
	
	public List<Booking> getBookingsForInvoice(int invoice_no) throws DatabaseConnectionException {
		String query = "SELECT * FROM booking WHERE invoice_no='" + invoice_no + "' ORDER BY startTime";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		List<Booking> b = getBookingsFromResultSet(result);
		try {
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Returns all bookings for a client, during a specified time frame
	 * @param c - the client to find bookings for
	 * @param start - the date to start looking for bookings (Non-inclusive)
	 * @param end - the date to stop looking for bookings (Non-inclusive)
	 * @return a list containing all bookings between the specified start
	 * and end dates for the chosen client
	 * @throws DatabaseConnectionException - is thrown if DB connection fails
	 */
	public List<Booking> getBookingsForClient(Client c, Date start, Date end) throws DatabaseConnectionException {
		String query = "SELECT * FROM booking WHERE client_id='" + c.getId() + "' AND startTime BETWEEN '" + Database.DATETIME_FORMAT.format(start) + "' AND '" + Database.DATETIME_FORMAT.format(end) + "'";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		List<Booking> b = getBookingsFromResultSet(result);
		try {
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Formats a ResultSet containing the results from a select on the booking
	 * table into an ArrayList of Bookings
	 * @param result - the ResultSet to format
	 * @return a list containing all bookings from the inputed ResultSet
	 * @throws DatabaseConnectionException - is thrown if DB connection fails
	 */
	private ArrayList<Booking> getBookingsFromResultSet(ResultSet result) throws DatabaseConnectionException {
		ClientBroker cb = ClientBroker.getBroker();
		RateBroker rb = RateBroker.getBroker();
		AdditionalChargeBroker acb = AdditionalChargeBroker.getBroker();
		BookingTypeBroker btb = BookingTypeBroker.getBroker();
		EmployeeBroker eb = EmployeeBroker.getBroker();
		FacilityBroker fb = FacilityBroker.getBroker();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		String query;

		try {
			while (result.next()) {
				int booking_id = result.getInt("booking_id");
				int facility_id = result.getInt("facility_id");
				int client_id = result.getInt("client_id");
				int employee_id = result.getInt("employee_id");
				int booking_type = result.getInt("booking_type");
				int catering_id = result.getInt("catering");
				int rate_id = result.getInt("rate");
				int invoice_no = result.getInt("invoice_no");
				String eventTitle = result.getString("eventTitle");
				Date startTime = Database.DATETIME_FORMAT.parse(result.getString("startTime"));
				Date endTime = Database.DATETIME_FORMAT.parse(result.getString("endTime"));
				int setupTime = result.getInt("setupTime");
				int tearDownTime = result.getInt("tearDownTime");
				int numberOfPeople = result.getInt("numberOfPeople");

				ArrayList<AdditionalCharge> additionalCharges = new ArrayList<AdditionalCharge>();
				query = "SELECT * FROM booking_additional_charges WHERE booking_id='" + booking_id + "'";
				Connection con = Database.connect();
				ResultSet acResult = Database.select(query, con);
				while (acResult.next()) {
					additionalCharges.add(acb.getAdditionalChargeInformation(acResult.getInt("additional_charge_id")));
				}
				acResult.close();

				Catering catering = null;
				query = "SELECT * FROM catering WHERE catering_id='" + catering_id + "' LIMIT 1";
				ResultSet cResult = Database.select(query, con);
				while (cResult.next()) {
					catering = new Catering(cResult.getInt("catering_id"), cResult.getString("chargeName"), cResult.getDouble("charge"), cResult.getString("description"));
				}
				cResult.close();

				Booking booking = new Booking(booking_id, eventTitle, btb.getBookingTypeInformation(booking_type), startTime, endTime, setupTime, tearDownTime, cb
						.getClientInformation(client_id), catering, eb.getEmployeeInformation(employee_id), numberOfPeople, rb.getRateInformation(rate_id), additionalCharges, fb
						.getFacilityInformation(facility_id), invoice_no);
				
				bookings.add(booking);
				con.close();
			}

			cb.close();
			rb.close();
			acb.close();
			btb.close();
			eb.close();
			fb.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bookings;
	}
	
	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText - passes message along to database to search than returns a list
	 * @return a list of all requested information from database
	 * @throws DatabaseConnectionException - is thrown if DB connection fails
	 */
	public List<Booking> search(String searchText, Date startTime, Date endTime, Facility facility) throws DatabaseConnectionException
	{
		String query = "SELECT b.booking_id, b.eventTitle, c.givenName, c.surname, b.startTime, b.endTime, bt.name " +
							"FROM booking b, client c, booking_type bt, facility f " +
							"WHERE f.facility_id='" + facility.getId() +"' " +
							"AND b.facility_id=f.facility_id "+
							"AND b.client_id = c.client_id "  +
							"AND b.booking_type = bt.booking_type_id " +
							"AND b.startTime BETWEEN '" + Database.DATETIME_FORMAT.format(startTime) + "' " +
							"AND '" + Database.DATETIME_FORMAT.format(endTime) + "' " +
							"OR b.eventTitle LIKE '%" + searchText + "%'" +
							"OR c.givenName LIKE '%" + searchText + "%'" +
							"OR c.surname LIKE '%" + searchText + "%'" +
							"OR CONCAT_WS(' ',c.givenName, c.surname) LIKE '%" + searchText + "%'" + 
							"OR bt.name LIKE '%" + searchText + "%'";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		if(result != null){
			try {
				while (result.next()) {
					//Booking booking = new Booking(result.getInt("b.booking_id"), result.getString("b.eventTitle"), result.getString("c.givenname") + " " + result.getString("c.surname"), result.getDate("b.startTime"), result.getDate("b.endTime"), result.getString("bt.name"));
					//bookings.add(booking);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return bookings;
	}
	
	public Booking getBookingInformation(int id) throws DatabaseConnectionException {
		Booking booking = null;
		
		String query = "SELECT * FROM `booking` WHERE `booking_id`='" + id + "';";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		try {
			while (result.next()) {
				ArrayList<AdditionalCharge> adc = new ArrayList<AdditionalCharge>();

				query = "SELECT additional_charge_id FROM booking_additional_charges WHERE booking_id = '" + id + "'";

				ResultSet acResult = Database.select(query, con);
				if(acResult != null) {
					while (acResult.next()) {
						AdditionalCharge ac = new AdditionalCharge();
						ac.setId(acResult.getInt("additional_charge_id"));
						adc.add(ac);
					}
					acResult.close();
				}
				
				BookingType bt = new BookingType();
				bt.setId(result.getInt("booking_type"));
				
				Date startTime = Database.DATETIME_FORMAT.parse(result.getString("startTime"));
				Date endTime = Database.DATETIME_FORMAT.parse(result.getString("endTime"));
				
				Client c = new Client();
				c.setId(result.getInt("client_id"));
				
				Catering ca = null;
				if(result.getString("catering") != null) {
					ca = new Catering();
					ca.setId(result.getInt("catering"));
				}
				
				Employee em = new Employee();
				em.setId(result.getInt("employee_id"));
				
				Rate r = new Rate();
				r.setId(result.getInt("rate"));
				
				Facility f = new Facility();
				f.setId(result.getInt("facility_id"));
				
				booking = new Booking(result.getInt("booking_id"),
									result.getString("eventTitle"), 
									bt,
									startTime,
									endTime,
									result.getInt("setupTime"),
									result.getInt("tearDownTime"),
									c,
									ca, 
									em,
									result.getInt("numberOfPeople"),
									r, 
									adc,
									f,
									result.getInt("invoice_no"));
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return booking;
	}
}
