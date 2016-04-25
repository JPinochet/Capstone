package problemDomain;

import java.util.ArrayList;
import java.util.Date;

public class Booking {
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
	 * @param id
	 * @param eventTitle
	 * @param eventType
	 * @param startTime
	 * @param endTime
	 * @param setupTime
	 * @param tearDownTime
	 * @param client
	 * @param catering
	 * @param creator
	 * @param numberOfPeople
	 * @param rate
	 * @param additionalCharges
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
	 * @param eventTitle
	 * @param eventType
	 * @param startTime
	 * @param endTime
	 * @param setupTime
	 * @param tearDownTime
	 * @param client
	 * @param creator
	 * @param rate
	 * @param additionalCharges
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
	 * @return the invoice_no
	 */
	public int getInvoice_no() {
		return invoice_no;
	}

	/**
	 * @param invoiceNo
	 *            the invoice_no to set
	 */
	public void setInvoice_no(int invoiceNo) {
		invoice_no = invoiceNo;
	}

	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * @param facility
	 *            the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}

	/**
	 * @return the eventType
	 */
	public BookingType getEventType() {
		return eventType;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @return the setupTime
	 */
	public int getSetupTime() {
		return setupTime;
	}

	/**
	 * @return the tearDownTime
	 */
	public int getTearDownTime() {
		return tearDownTime;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the catering
	 */
	public Catering getCatering() {
		return catering;
	}

	/**
	 * @return the creator
	 */
	public Employee getCreator() {
		return creator;
	}

	/**
	 * @return the numberOfPeople
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * @return the rate
	 */
	public Rate getRate() {
		return rate;
	}

	/**
	 * @return the additionalCharges
	 */
	public ArrayList<AdditionalCharge> getAdditionalCharges() {
		return additionalCharges;
	}

	/**
	 * @param eventTitle
	 *            the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(BookingType eventType) {
		this.eventType = eventType;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @param setupTime
	 *            the setupTime to set
	 */
	public void setSetupTime(int setupTime) {
		this.setupTime = setupTime;
	}

	/**
	 * @param tearDownTime
	 *            the tearDownTime to set
	 */
	public void setTearDownTime(int tearDownTime) {
		this.tearDownTime = tearDownTime;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param catering
	 *            the catering to set
	 */
	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	/**
	 * @param numberOfPeople
	 *            the numberOfPeople to set
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(Rate rate) {
		this.rate = rate;
	}

	/**
	 * @param additionalCharges
	 *            the additionalCharges to set
	 */
	public void setAdditionalCharges(ArrayList<AdditionalCharge> additionalCharges) {
		this.additionalCharges = additionalCharges;
	}
}
