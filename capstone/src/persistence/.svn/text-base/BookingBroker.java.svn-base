/**
 * Feb 18, 2010
 * BookingBroker.java
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.DatabaseConnectionException;

import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.Catering;
import problemDomain.Client;
import problemDomain.Facility;

/**
 * @author cantleyc
 * 
 */
public class BookingBroker implements Broker {
	private Database db = new Database();
	private static BookingBroker broker;

	/**
	 * Connects to the database
	 * @throws DatabaseConnectionException 
	 */
	private BookingBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/**
	 * Gets the broker instance
	 * 
	 * @return The current broker instance
	 * @throws DatabaseConnectionException 
	 */
	public static BookingBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new BookingBroker();
		}
		return broker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#close()
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
	@Deprecated
	public List<Booking> getAll() {
		System.err.println("Use getBookingsForFacility, getBookingForClient or getBookingsForInvoice. We will never get ALL the bookings in the database");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#persist(java.lang.Object)
	 */
	public boolean persist(Object o) {
		Booking booking = (Booking) o;
		String query;

		if (booking.getId() != -1) {
			int catering_id = booking.getCatering().getId();
			if (catering_id != -1) {
				query = "UPDATE catering SET chargeName='" + booking.getCatering().getChargeName() + "', charge='" + booking.getCatering().getCharge() + "' WHERE catering_id='"
						+ catering_id + "'";
				db.update(query);
			} else {
				query = "INSERT INTO catering VALUES('0'," + booking.getCatering().getChargeName() + "','" + booking.getCatering().getCharge() + ",NULL')";
				catering_id = db.update(query);
			}

			query = "UPDATE booking SET facility_id='" + booking.getFacility().getId() + "', client_id='" + booking.getClient().getId() + "', employee_id='"
					+ booking.getCreator().getId() + "', booking_type='" + booking.getEventType().getId() + "', invoice_no='" + booking.getInvoice_no() + "', catering='"
					+ catering_id + "', rate='" + booking.getRate().getId() + "', eventTitle='" + booking.getEventTitle() + "', startTime='" + booking.getStartTime()
					+ "', endTime='" + booking.getEndTime() + "', setupTime='" + booking.getSetupTime() + "', tearDownTime='" + booking.getTearDownTime() + "', numberOfPeople='"
					+ booking.getNumberOfPeople() + "' WHERE booking_id='" + booking.getId() + "'";
			db.update(query);
		} else {
			query = "INSERT INTO catering VALUES('0'," + booking.getCatering().getChargeName() + "','" + booking.getCatering().getCharge() + ",NULL')";
			int catering_id = db.update(query);

			query = "INSERT INTO booking VALUES('0', " + booking.getFacility().getId() + "','" + booking.getClient().getId() + "','" + booking.getCreator().getId() + "','"
					+ booking.getEventType().getId() + "','" + booking.getInvoice_no() + "','" + catering_id + "','" + booking.getRate().getId() + "','" + booking.getEventTitle()
					+ "','" + booking.getStartTime() + "','" + booking.getEndTime() + "','" + booking.getSetupTime() + "','" + booking.getTearDownTime() + "','"
					+ booking.getNumberOfPeople() + "')";
			int booking_id = db.update(query);

			ArrayList<AdditionalCharge> additionalCharges = booking.getAdditionalCharges();
			for (int i = 0; i < additionalCharges.size(); i++) {
				query = "INSERT INTO booking_additional_charges VALUES('" + additionalCharges.get(i).getId() + "', '" + booking_id + "')";
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
		Booking booking = (Booking) o;
		String query;

		query = "DELETE FROM booking WHERE booking_id='" + booking.getId() + "'";
		db.update(query);
		return true;
	}

	/**
	 * Returns all bookings for a facility during a specified time frame
	 * 
	 * @param f
	 *            The facility to get bookings for
	 * @param start
	 *            The date to start looking for bookings (Non-inclusive)
	 * @param end
	 *            The date to stop looking for bookings (Non-inclusive)
	 * @return An ArrayList containing all bookings between the specified start
	 *         and end dates for the chosen facility
	 * @throws DatabaseConnectionException 
	 */
	public List<Booking> getBookingsForFacility(Facility f, Date start, Date end) throws DatabaseConnectionException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String query = "SELECT * FROM booking WHERE facility_id='" + f.getId() + "' AND startTime BETWEEN '" + dateFormat.format(start) + "' AND '" + dateFormat.format(end) + "'";
		ResultSet result = db.select(query);
		return getBookingsFromResultSet(result);
	}

	/**
	 * Returns all bookings that are associated with a particular invoice
	 * 
	 * @param invoice_no
	 *            The invoice number of the invoice to find bookings for
	 * @return An ArrayList containing all booking related to the specified
	 *         invoice number
	 * @throws DatabaseConnectionException 
	 */
	public List<Booking> getBookingsForInvoice(int invoice_no) throws DatabaseConnectionException {
		String query = "SELECT * FROM booking WHERE invoice_no='" + invoice_no + "'";
		ResultSet result = db.select(query);
		return getBookingsFromResultSet(result);
	}

	/**
	 * Returns all bookings for a client, during a specifed time frame
	 * 
	 * @param c
	 *            The client to find bookings for
	 * @param start
	 *            The date to start looking for bookings (Non-inclusive)
	 * @param end
	 *            The date to stop looking for bookings (Non-inclusive)
	 * @return An ArrayList containing all bookings between the specified start
	 *         and end dates for the chosen client
	 * @throws DatabaseConnectionException 
	 */
	public List<Booking> getBookingsForClient(Client c, Date start, Date end) throws DatabaseConnectionException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String query = "SELECT * FROM booking WHERE client_id='" + c.getId() + "' AND startTime BETWEEN '" + dateFormat.format(start) + "' AND '" + dateFormat.format(end) + "'";
		ResultSet result = db.select(query);
		return getBookingsFromResultSet(result);
	}

	/**
	 * Formats a ResultSet containing the results from a select on the booking
	 * table into an ArrayList of Bookings
	 * 
	 * @param result
	 *            The ResultSet to format
	 * @return An ArrayList containing all bookings from the inputed ResultSet
	 * @throws DatabaseConnectionException 
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
				Date startTime = result.getDate("startTime");
				Date endTime = result.getDate("endTime");
				int setupTime = result.getInt("setupTime");
				int tearDownTime = result.getInt("tearDownTime");
				int numberOfPeople = result.getInt("numberOfPeople");

				ArrayList<AdditionalCharge> additionalCharges = new ArrayList<AdditionalCharge>();
				query = "SELECT * FROM booking_additional_charges WHERE booking_id='" + booking_id + "'";
				ResultSet acResult = db.select(query);
				while (acResult.next()) {
					additionalCharges.add(acb.getAdditionalChargeInformation(acResult.getInt("additional_charge_id")));
				}

				Catering catering = null;
				query = "SELECT * FROM catering WHERE catering_id='" + catering_id + "' LIMIT 1";
				ResultSet cResult = db.select(query);
				while (cResult.next()) {
					catering = new Catering(cResult.getInt("catering_id"), cResult.getString("chargeName"), cResult.getDouble("charge"));
				}

				Booking booking = new Booking(booking_id, eventTitle, btb.getBookingTypeInformation(booking_type), startTime, endTime, setupTime, tearDownTime, cb
						.getClientInformation(client_id), catering, eb.getEmployeeInformation(employee_id), numberOfPeople, rb.getRateInformation(rate_id), additionalCharges, fb
						.getFacilityInformation(facility_id), invoice_no);
				bookings.add(booking);
			}

			cb.close();
			rb.close();
			acb.close();
			btb.close();
			eb.close();
			fb.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
}
