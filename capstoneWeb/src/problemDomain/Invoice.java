package problemDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1417072999364212538L;
	/**
	 * Initializes variable 
	 */
	private int id;
	private Date date;
	private Client client;
	private ArrayList<Booking> bookings;
	private Boolean paid;
	private double paymentDue;
	private String description;
	private Date dueDate;
	private ArrayList<Payment> payments;
	private double subtotal;
	
	/**
	 * Initializes invoice
	 */
	public Invoice(){}
	
	public Invoice(int id){
		this.id = id;
	}

	/**
	 * @param id - id of invoice
	 * @param date - invoice date
	 * @param client - client being invoiced
	 * @param bookings - bookings included in invoice
	 * @param paid - invoice has been paid
	 * @param paymentDue - how much client owes
	 * @param description - description of service that client is paying for
	 * @param dueDate - date the payment needs to be paid by
	 * @param payments - Any payments made on this invoice
	 */
	public Invoice(int id, Date date, Client client, List<Booking> bookings, Boolean paid, double paymentDue, String description, Date dueDate, List<Payment> payments) {
		this.id = id;
		this.date = date;
		this.client = client;
		this.bookings = (ArrayList<Booking>) bookings;
		this.paid = paid;
		this.paymentDue = paymentDue;
		this.description = description;
		this.dueDate = dueDate;
		this.payments = (ArrayList<Payment>) payments;
	}

	/**
	 * @param id - id of invoice
	 * @param date - invoice date
	 * @param client - client being invoiced
	 * @param bookings - bookings included in invoice
	 * @param description - description of service that client is paying for
	 */
	public Invoice(int id, Date date, Client client, List<Booking> bookings, String description) {
		this.id = id;
		this.date = date;
		this.client = client;
		this.bookings = (ArrayList<Booking>) bookings;
		this.description = description;
	}

	/**
	 @param date - invoice date
	 * @param client - client being invoiced
	 * @param bookings - bookings included in invoice
	 * @param paid - invoice has been paid
	 * @param paymentDue - how much client owes
	 * @param description - description of service that client is paying for
	 * @param dueDate - date the payment needs to be paid by
	 * @param payments - any payments made on this invoice
	 */
	public Invoice(Date date, Client client, ArrayList<Booking> bookings, Boolean paid, double paymentDue, String description, Date dueDate, ArrayList<Payment> payments) {
		this.date = date;
		this.client = client;
		this.bookings = bookings;
		this.paid = paid;
		this.paymentDue = paymentDue;
		this.description = description;
		this.dueDate = dueDate;
		this.payments = payments;
	}

	/**
	 * @return the id of the invoice
	 */
	public int getId() {
		return id;
	}

	/**
	 * The id to set
	 * @param id - id of invoice
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the date of the invoice
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the client who is being billed
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the bookings that are being added to the invoice
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @return the paid - invoice is paid
	 */
	public Boolean getPaid() {
		return paid;
	}

	/**
	 * @return the paymentDue - amount that is due
	 */
	public double getPaymentDue() {
		return paymentDue;
	}

	/**
	 * @return the description - description of service
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the dueDate - date payment is due by
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @return the paymentDate - date payment is made
	 */
	public ArrayList<Payment> getPayments() {
		return payments;
	}

	/**
	 * The date to set
	 * @param date - date of invoice
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * The client to set
	 * @param client - client being invoiced
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * The bookings to set
	 * @param bookings - bookings being added to invoice
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * The paid to set
	 * @param paid - invoice is paid
	 */
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	/**
	 * The paymentDue to set
	 * @param paymentDue - amount due 
	 */
	public void setPaymentDue(double paymentDue) {
		this.paymentDue = paymentDue;
	}

	/**
	 * The description to set
	 * @param description - description of service
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The dueDate to set
	 * @param dueDate - date amount to be paid by
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * The payments to set
	 * @param payments - set any payments made to the invoice
	 */
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
}
