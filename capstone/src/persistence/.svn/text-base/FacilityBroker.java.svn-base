/**
 * 
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseConnectionException;
import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.Facility;
import problemDomain.Rate;

/**
 * @author Administrator
 * 
 */
public class FacilityBroker implements Broker {

	private Database db = new Database();
	private static FacilityBroker broker;

	/**
	 * Default constructor, creates connection to the database.
	 * @throws DatabaseConnectionException 
	 */
	private FacilityBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#getAll()
	 */
	public List<Facility> getAll() {
		String query = "SELECT * FROM facility";
		ResultSet result = db.select(query);

		ArrayList<Facility> facilities = new ArrayList<Facility>();
		try {
			while (result.next()) {
				ArrayList<Booking> bookings = new ArrayList<Booking>();
				ArrayList<Rate> rates = new ArrayList<Rate>();
				ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();

				query = "SELECT booking_id, eventTitle, startTime, endTime FROM booking, facility f, facility_rates fr WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fr.facility_id AND fr.rate_id = r.rate_id";
				ResultSet bookingResult = db.select(query);
				while (bookingResult.next()) {
					Booking booking = new Booking(bookingResult.getInt("booking_id"), bookingResult.getString("eventTitle"), null, bookingResult.getDate("startTime"),
							bookingResult.getDate("endTime"), 0, 0, null, null, null, 0, null, null, null, 0);
					bookings.add(booking);
				}

				query = "SELECT * FROM rate r, facility f, facility_rates fr WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fr.facility_id AND fr.rate_id = r.rate_id";
				ResultSet rateResult = db.select(query);
				while (rateResult.next()) {
					Rate rate = new Rate(rateResult.getInt("rate_id"), rateResult.getString("name"), rateResult.getString("description"), rateResult.getDouble("rate"), rateResult
							.getDouble("damageDeposit"), rateResult.getDouble("bookingDeposit"));
					rates.add(rate);
				}

				query = "SELECT * FROM additional_charge ac, facility f, facility_additional_charges fac WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fac.facility_id AND fac.additional_charge_id = ac.additional_charge_id";
				ResultSet acResult = db.select(query);
				while (acResult.next()) {
					AdditionalCharge ac = new AdditionalCharge(acResult.getInt("additional_charge_id"), acResult.getString("name"), acResult.getDouble("cost"));
					acs.add(ac);
				}

				Facility facility = new Facility(result.getInt("facility_id"), result.getInt("openTime"), result.getInt("closeTime"), result.getInt("setupTime"), result
						.getInt("tearDown"), result.getString("name"), rates, acs, result.getInt("maxCapacity"), result.getInt("minBookingInterval"), result
						.getInt("minBookingTime"));
				facilities.add(facility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#persist(java.lang.Object)
	 */
	public boolean persist(Object o) {
		Facility facility = (Facility) o;
		String query;

		if (facility.getId() != -1) {
			query = "UPDATE facility SET openTime='" + facility.getOpenTime() + "', closeTime='" + facility.getCloseTime() + "', setupTime='" + facility.getSetupTime()
					+ "', teardownTime='" + facility.getTearDownTime() + "', name='" + facility.getName() + "', maxCapacity='" + facility.getMaxCapacity()
					+ "', minBookingInterval='" + facility.getMinBookingInterval() + "', minBookingTime='" + facility.getMinBookingTime() + "' WHERE facility_id='"
					+ facility.getId() + "'";
			db.update(query);

			ArrayList<Rate> rates = facility.getRates();
			for (int i = 0; i < rates.size(); i++) {
				query = "INSERT INTO facility_rates VALUES('" + rates.get(i).getId() + "', '" + facility.getId() + "')";
				db.update(query);
			}
		} else {
			query = "INSERT INTO facility VALUES('" + 0 + "', '" + facility.getOpenTime() + "', '" + facility.getCloseTime() + "', '" + facility.getSetupTime() + "', '"
					+ facility.getTearDownTime() + "', '" + facility.getName() + "', '" + facility.getMaxCapacity() + "', '" + facility.getMinBookingInterval() + "', '"
					+ facility.getMinBookingTime() + "')";
			int id = db.update(query);

			ArrayList<Rate> rates = facility.getRates();
			for (int i = 0; i < rates.size(); i++) {
				query = "INSERT INTO facility_rates VALUES('" + rates.get(i).getId() + "', '" + id + "')";
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
		Facility facility = (Facility) o;
		String query;

		query = "DELETE FROM facility WHERE facility_id='" + facility.getId() + "'";
		db.update(query);
		return true;
	}

	public void close() {
		db.close();
		broker = null;
	}

	public static FacilityBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new FacilityBroker();
		}
		return broker;
	}

	public Facility getFacilityInformation(int id) {
		String query = "SELECT * FROM facility WHERE facility_id = " + id;
		ResultSet result = db.select(query);
		Facility facility = null;
		try {
			while (result.next()) {
				ArrayList<Booking> bookings = new ArrayList<Booking>();
				ArrayList<Rate> rates = new ArrayList<Rate>();
				ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();

				query = "SELECT booking_id, eventTitle, startTime, endTime FROM booking, facility f, facility_rates fr WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fr.facility_id AND fr.rate_id = r.rate_id";
				ResultSet bookingResult = db.select(query);
				while (bookingResult.next()) {
					Booking booking = new Booking(bookingResult.getInt("booking_id"), bookingResult.getString("eventTitle"), null, bookingResult.getDate("startTime"),
							bookingResult.getDate("endTime"), 0, 0, null, null, null, 0, null, null, null, 0);
					bookings.add(booking);
				}

				query = "SELECT * FROM rate r, facility f, facility_rates fr WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fr.facility_id AND fr.rate_id = r.rate_id";
				ResultSet rateResult = db.select(query);
				while (rateResult.next()) {
					Rate rate = new Rate(rateResult.getInt("rate_id"), rateResult.getString("name"), rateResult.getString("description"), rateResult.getDouble("rate"), rateResult
							.getDouble("damageDeposit"), rateResult.getDouble("bookingDeposit"));
					rates.add(rate);
				}

				query = "SELECT * FROM additional_charge ac, facility f, facility_additional_charges fac WHERE f.facility_id = '" + result.getInt("facility_id")
						+ "' AND f.facility_id = fac.facility_id AND fac.additional_charge_id = ac.additional_charge_id";
				ResultSet acResult = db.select(query);
				while (acResult.next()) {
					AdditionalCharge ac = new AdditionalCharge(acResult.getInt("additional_charge_id"), acResult.getString("name"), acResult.getDouble("cost"));
					acs.add(ac);
				}

				facility = new Facility(result.getInt("facility_id"), result.getInt("openTime"), result.getInt("closeTime"), result.getInt("setupTime"), result.getInt("tearDown"),
						result.getString("name"), rates, acs, result.getInt("maxCapacity"), result.getInt("minBookingInterval"), result.getInt("minBookingTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return facility;
	}

}
