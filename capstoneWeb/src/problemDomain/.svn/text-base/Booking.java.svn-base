package problemDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Booking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6429855949202255872L;
	/**
	 * Initializes variable
	 */
	private int id;
	private String eventTitle;
	private BookingType eventType;
	private Date startTime;
	private Date endTime;
	private int setupTime;
	private int tearDownTime;
	private Client client;
	private Catering catering;
	private Employee creator;
	private int numberOfPeople;
	private Rate rate;
	private ArrayList<AdditionalCharge> additionalCharges;
	private Facility facility;
	private int invoice_no;

	/**
	 * @param id - id of booking
	 * @param eventTitle - name of event
	 * @param eventType - what type of event it is
	 * @param startTime - time event starts at
	 * @param endTime - time event ends at
	 * @param setupTime - time needed to setup the facility for event
	 * @param tearDownTime - time needed to clean up after event
	 * @param client - name of client who is booking event
	 * @param catering - catering orders
	 * @param creator - name of employee who creates event
	 * @param numberOfPeople - number of people attending
	 * @param rate - rate being charged for booking of facility for the event
	 * @param additionalCharges - charges for additional extras 
	 */
	public Booking(int id, String eventTitle, BookingType eventType, Date startTime, Date endTime, int setupTime, int tearDownTime, Client client, Catering catering,
			Employee creator, int numberOfPeople, Rate rate, ArrayList<AdditionalCharge> additionalCharges, Facility facility, int invoice_no) {
		this.id = id;
		this.eventTitle = eventTitle;
		this.eventType = eventType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
		this.client = client;
		this.catering = catering;
		this.creator = creator;
		this.numberOfPeople = numberOfPeople;
		this.rate = rate;
		this.additionalCharges = additionalCharges;
		this.facility = facility;
		this.invoice_no = invoice_no;
	}
	
	/**
	 * @param id the id of the booking
	 * @param eventTitle the title of the booking
	 * @param clientName the name of the client
	 * @param startTime the time the booking starts at
	 * @param endTime the time the booking ends at
	 */
	public Booking(int id, String eventTitle, String clientName, Date startTime, Date endTime)
	{
		this.id = id;
		this.eventTitle = eventTitle;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @param eventTitle - name of the event
	 * @param eventType - type of event being booked
	 * @param startTime - time the event starts
	 * @param endTime - time the event ends
	 * @param setupTime - time needed to setup facility before event
	 * @param tearDownTime - time needed to clean up facility after event
	 * @param client - client booking event
	 * @param creator - employee making booking
	 * @param rate - amount being charged for facility
	 * @param additionalCharges - amount due for any additional extras added 
	 */
	public Booking(String eventTitle, BookingType eventType, Date startTime, Date endTime, int setupTime, int tearDownTime, Client client, Employee creator, int numberOfPeople, Rate rate,
			ArrayList<AdditionalCharge> additionalCharges, Facility facility, int invoice_no) {
		this.eventTitle = eventTitle;
		this.eventType = eventType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
		this.client = client;
		this.creator = creator;
		this.numberOfPeople = numberOfPeople;
		this.rate = rate;
		this.additionalCharges = additionalCharges;
		this.facility = facility;
		this.invoice_no = invoice_no;
	}
	
	/**
	 * Initializes booking
	 */
	public Booking(){}

	/**
	 * @return the invoice_no 
	 */
	public int getInvoice_no() {
		return invoice_no;
	}

	/**
	 * The invoice_no to set
	 * @param invoiceNo - invoiceNo for booking
	 */
	public void setInvoice_no(int invoiceNo) {
		invoice_no = invoiceNo;
	}

	/**
	 * @return the facility - which is being booked
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * The facility to set
	 * @param facility - facility of booking 
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/**
	 * @return the id - of the booking
	 */
	public int getId() {
		return id;
	}

	/**
	 * The id to set
	 * @param id - id of booking 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the eventTitle - name of the booking
	 */
	public String getEventTitle() {
		return eventTitle;
	}

	/**
	 * @return the eventType - type of booking
	 */
	public BookingType getEventType() {
		return eventType;
	}

	/**
	 * @return the startTime - time event starts
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime - time event ends
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * The setupTime to set
	 * @return the setupTime - time needed to setup facility before event
	 */
	public int getSetupTime() {
		return setupTime;
	}

	/**
	 * @return the tearDownTime - time needed to clean up facility after event
	 */
	public int getTearDownTime() {
		return tearDownTime;
	}

	/**
	 * @return the client - client making booking
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the catering - catering orders
	 */
	public Catering getCatering() {
		return catering;
	}

	/**
	 * @return the creator - employee making the booking
	 */
	public Employee getCreator() {
		return creator;
	}

	/**
	 * @return the numberOfPeople - number of people attending event
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * @return the rate - amount being charged for renting facility
	 */
	public Rate getRate() {
		return rate;
	}

	/**
	 * @return the additionalCharges - extra charges incurred
	 */
	public ArrayList<AdditionalCharge> getAdditionalCharges() {
		return additionalCharges;
	}

	/**
	 * The eventTitle to set
	 * @param eventTitle - eventTitle of booking
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	/**
	 * The eventType to set
	 * @param eventType - type of event
	 */
	public void setEventType(BookingType eventType) {
		this.eventType = eventType;
	}

	/**
	 * The startTime to set
	 * @param startTime - time event starts
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * The endTime to set
	 * @param endTime - time event ends
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * The setupTime to set
	 * @param setupTime - time needed to setup facility
	 */
	public void setSetupTime(int setupTime) {
		this.setupTime = setupTime;
	}

	/**
	 * The tearDownTime to set
	 * @param tearDownTime - time needed to clean up facility
	 */
	public void setTearDownTime(int tearDownTime) {
		this.tearDownTime = tearDownTime;
	}

	/**
	 * The client to set
	 * @param client - client making booking
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * The catering to set
	 * @param catering - catering orders
	 */
	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	/**
	 * The creator to set
	 * @param creator - employee making booking
	 */
	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	/**
	 * The numberOfPeople to set
	 * @param numberOfPeople - number of people at event
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * The rate to set
	 * @param rate - amount being charged for facility
	 */
	public void setRate(Rate rate) {
		this.rate = rate;
	}

	/**
	 * The additionalCharges to set
	 * @param additionalCharges - extra charges incurred 
	 */
	public void setAdditionalCharges(ArrayList<AdditionalCharge> additionalCharges) {
		this.additionalCharges = additionalCharges;
	}

	/**
	 * @return length - length of time booked
	 */
	public int getLength() {
		long length = 0;
		Calendar start = Calendar.getInstance();
		start.setTime(startTime);
		
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		
		
		length =  (end.getTimeInMillis() - start.getTimeInMillis()) / (60 * 1000);
		return (int) length;
	}
}
