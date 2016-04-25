package problemDomain;

import java.io.Serializable;
import java.util.ArrayList;

public class Facility implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8167661491529751369L;
	/**
	 * Initializes variables
	 */
	private int id;
	private int openTime;
	private int closeTime;
	private int setupTime;
	private int tearDownTime;
	private String name;
	private ArrayList<Rate> rates;
	private ArrayList<AdditionalCharge> additionalCharges;
	private int maxCapacity;
	private int minBookingInterval;
	private int minBookingTime;
	
	/**
	 * Initializes facility
	 */
	public Facility() {
		
	}
	
	/**
	 * Initializes facility
	 */
	public Facility(int id) {
		this.id = id;
	}
	
	/**
	 * @param id - id of facility
	 * @param name - name of facility
	 */
	public Facility(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @param id - facility id
	 * @param openTime - time facility is open
	 * @param closeTime - time facility is closed
	 * @param setupTime - amount of time needed to setup
	 * @param tearDownTime - amount of time needed to tear down
	 * @param name - name of facility
	 * @param rates - rates applicable to this facility
	 * @param additionalCharges - any additional charges applicable to that facility
	 * @param maxCapacity - maximum number of people allowed in facility
	 * @param minBookingInterval - minimum amount of time between bookings
	 * @param minBookingTime - minimum amount of time that can be booked for facility
	 */
	public Facility(int id, int openTime, int closeTime, int setupTime, int tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			int maxCapacity, int minBookingInterval, int minBookingTime) {
		this.id = id;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
		this.name = name;
		this.rates = rates;
		this.additionalCharges = additionalCharges;
		this.maxCapacity = maxCapacity;
		this.minBookingInterval = minBookingInterval;
		this.minBookingTime = minBookingTime;
	}

	/**
	 * @param openTime - time facility is open
	 * @param closeTime - time facility is closed
	 * @param setupTime - amount of time needed to tear down
	 * @param tearDownTime - amount of the time needed to tear down
	 * @param name - name of facility
	 * @param rates - rates applicable to this facility
	 * @param additionalCharges - any additional charges applicable to that facility
	 * @param maxCapacity - maximum number of people allowed in facility
	 * @param minBookingInterval - minimum amount of time between bookings
	 * @param minBookingTime - minimum amount of time that can be booked for facility
	 */
	public Facility(int openTime, int closeTime, int setupTime, int tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			int maxCapacity, int minBookingInterval, int minBookingTime) {
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
		this.name = name;
		this.rates = rates;
		this.additionalCharges = additionalCharges;
		this.maxCapacity = maxCapacity;
		this.minBookingInterval = minBookingInterval;
		this.minBookingTime = minBookingTime;
	}

	/**
	 * @return the id of the facility
	 */
	public int getId() {
		return id;
	}

	/**
	 * The id to set
	 * @param id - id of facility
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the openTime - open time of the facility
	 */
	public int getOpenTime() {
		return openTime;
	}

	/**
	 * @return the closeTime - close time of the facility
	 */
	public int getCloseTime() {
		return closeTime;
	}

	/**
	 * @return the setupTime - amount of setup time needed for facility
	 */
	public int getSetupTime() {
		return setupTime;
	}

	/**
	 * @return the tearDownTime - amount of time needed to tear down in facility
	 */
	public int getTearDownTime() {
		return tearDownTime;
	}

	/**
	 * @return the name of facility
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rates - rate amounts applicable to the facility
	 */
	public ArrayList<Rate> getRates() {
		return rates;
	}

	/**
	 * @return the additionalCharges - additional charges applicable to facility
	 */
	public ArrayList<AdditionalCharge> getAdditionalCharges() {
		return additionalCharges;
	}

	/**
	 * @return the maxCapacity - maximum number of people allowed in facility
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @return the minBookingInterval - minimum amount of time between bookings
	 */
	public int getMinBookingInterval() {
		return minBookingInterval;
	}

	/**
	 * @return the minBookingTime - minimum amount of time facility can be booked for
	 */
	public int getMinBookingTime() {
		return minBookingTime;
	}

	/**
	 * The openTime to set
	 * @param openTime - open time of facility
	 */
	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}

	/**
	 * The closeTime to set
	 * @param closeTime - closing time of facility
	 */
	public void setCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}

	/**
	 * The setupTime to set
	 * @param setupTime - amount of setup time needed for facility
	 */
	public void setSetupTime(int setupTime) {
		this.setupTime = setupTime;
	}

	/**
	 * The tearDownTime to set
	 * @param tearDownTime - amount of tear down time needed for facility
	 */
	public void setTearDownTime(int tearDownTime) {
		this.tearDownTime = tearDownTime;
	}

	/**
	 * The name to set
	 * @param name - name of facility
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The rates to set
	 * @param rates - rates applicable to facility
	 */
	public void setRates(ArrayList<Rate> rates) {
		this.rates = rates;
	}

	/**
	 * The additionalCharges to set
	 * @param additionalCharges - additional charges applicable to facility
	 */
	public void setAdditionalCharges(ArrayList<AdditionalCharge> additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

	/**
	 * The maxCapacity to set
	 * @param maxCapacity - maximum number of people allowed in facility
	 */
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * The minBookingInterval to set
	 * @param minBookingInterval - minimum amount of time between bookings in facility
	 */
	public void setMinBookingInterval(int minBookingInterval) {
		this.minBookingInterval = minBookingInterval;
	}

	/**
	 * The minBookingTime to set
	 * @param minBookingTime - minimum amount of time for a booking in facility
	 */
	public void setMinBookingTime(int minBookingTime) {
		this.minBookingTime = minBookingTime;
	}

}
