package logic;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.AddressInvalidException;
import exceptions.BooleanInvalidException;
import exceptions.CityInvalidException;
import exceptions.CostInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DescriptionInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.TearDownTimeInvalidException;

import persistence.ClientBroker;
import persistence.InvoiceBroker;
import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Invoice;
import problemDomain.Payment;

/**
 * Servlet implementation class InvoiceManager
 */
public class InvoiceManager extends HttpServlet {
	private static final long serialVersionUID = 6823539644247710434L;
	
	/**
	 * Initializes InvoiceBroker instance and set it to null
	 */
	InvoiceBroker ib = null;
	
	/**
	 * Initializes Client instance and set it to null
	 */
	Client c = null;
	
	/**
	 * Calls HttpServletRequest and HttpServletResponse
	 * Iterates through Invoice
	 * If an error occurs the appropriate exception will be thrown
	 * @param request is the request that is called
	 * @param response is the response that is returned
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("email")!=null) {
			try {
				Invoice i = this.getInvoiceInfo(Integer.parseInt(request.getParameter("email")));
				URL url = new URL("http://localhost:8080/capstoneWeb/invoice.jsp?invoice=" + request.getParameter("email"));
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String inputLine;
				String messageBody="";

				while ((inputLine = in.readLine()) != null) 
					messageBody += inputLine;
				in.close();


				
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				Session session = (Session) envCtx.lookup("mail/Session");

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("capstoneindus@gmail.com"));
				InternetAddress to[] = new InternetAddress[1];
				//to[0] = new InternetAddress(i.getClient().getEmail());
				to[0] = new InternetAddress("cantleyc@gmail.com");
				message.setRecipients(Message.RecipientType.TO, to);
				message.setSubject("Indus Rec Center Invoice " + i.getId());
				message.setContent(i.getDescription() + "<br />Invoice Below<br />===================================<br />" + messageBody, "text/html");
				Transport.send(message);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (DatabaseConnectionException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		HttpSession session = request.getSession();
		String doRequest = request.getParameter("do");
		if(doRequest != null) {
			String error = "";
			if(doRequest.equals("search")){
				if(request.getParameter("search") != null) {
					try {
						session.setAttribute("searchResults", search(request.getParameter("searchText")));
					} catch (DatabaseConnectionException e) {
						error = "?error=main&message="+e.getMessage();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(request.getParameter("reset") != null) {
					session.setAttribute("searchResults", null);
				}
			} else if(doRequest.equals("manage")) {
				String desc = request.getParameter("desc");
				String client = request.getParameter("client");
				String invoice = request.getParameter("invoice");
				ArrayList<Booking> bookings = new ArrayList<Booking>();
				if(request.getParameter("bookings") != null) {
					for(int i=0; i < request.getParameterValues("bookings").length; i++) {
						Booking b = new Booking();
						b.setId(Integer.parseInt(request.getParameterValues("bookings")[i]));
						bookings.add(b);
					}
				}
				
				if(request.getParameter("delete") != null && invoice != null) {
					try {
						Invoice i = new Invoice();
						i.setId(Integer.parseInt(invoice));
						if(!this.remove(i)) {
							error = "?client=" + client + "&error=main&message=Could not remove invoice";
						}
					} catch (DatabaseConnectionException e) {
						error = "?client=" + client + "&error=main&message="+e.getMessage();
					}
				} else if(request.getParameter("save") != null) { 
					try {
						this.save(Integer.parseInt(invoice), new Date() , new Client(Integer.parseInt(client)), bookings, desc);
						error = "?client=" + client;
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (DescriptionInvalidException e) {
						e.printStackTrace();
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();
					} catch (DateInvalidException e) {
						e.printStackTrace();
					}
				}
			} else if(doRequest.equals("pay")) {
				try {
					Payment p = new Payment();
					p.setAmount(Double.parseDouble(request.getParameter("amount")));
					p.setType(request.getParameter("type"));
					p.setDate(new Date());
					Invoice i = getInvoiceInfo(Integer.parseInt(request.getParameter("invoice")));
					this.payInvoice(i, p);
					error="?client="+i.getClient().getId();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (DatabaseConnectionException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			try {
				response.sendRedirect("InvoiceWindow.jsp"+error);
			} catch (IOException e) {}
		}
	}
	
	/**
	 * Validates all fields of an facility object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * If a field is null a appropriate exception will be thrown
	 * @param date is the date for the invoice
	 * @param client is the client for the invoice
	 * @param bookings is the bookings for the invoice
	 * @param description is the description for the invoice
	 * @return true/false if the object is valid.
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws DateInvalidException is thrown if date is null or the invoice date is before current date
	 */
	public boolean validate(Date date, Client client, ArrayList<Booking> bookings, String description) throws DescriptionInvalidException, DatabaseConnectionException, DateInvalidException 
	{	
		if(description != null && !description.equals(""))
			if(description.length() > 400)
				throw new DescriptionInvalidException("An invoice's description cannot excede 400 characters.");
		
		return true;
	}
	
	/**
	 * Validates all fields of an facility object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param invoice
	 * @return true/false if the object is valid.
	 * @throws CostInvalidException is thrown if it not a number or !=double
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws BooleanInvalidException is thrown if boolean not true/false
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 * @throws AddressInvalidException is thrown if it is null or has >75 characters
	 * @throws SurnameInvalidException is thrown if it is null or has >63 characters
	 * @throws GivenNameInvalidException is thrown if it is null or has >65 characters
	 * @throws ProvinceInvalidException is thrown if it is null or has >2 characters
	 * @throws PostalCodeInvalidException is thrown if >6 characters, ==6 & !valid or ==5 digits
	 * @throws CountryInvalidException is thrown if it is null or has >25 characters
	 * @throws CityInvalidException is thrown if it is null or has >75 characters
	 * @throws EmailInvalidException is thrown if it is null or has >50 characters
	 * @throws NumberInvalidException is thrown if setupTime or tearDownTime are not in 
	 * a numerical format
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws ScheduleInvalidException Checks Schedule to see if it exists, that time is free,and
	 *  that it is not to big. if any of these are not true than the exception is thrown.
	 * @throws NameInvalidException is thrown if name is null or >25 characters
	 * @throws DateInvalidException is thrown if date is null or the invoice date is before current date
	 */
	public boolean validate(Invoice invoice) throws CostInvalidException, DescriptionInvalidException, BooleanInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException, DateInvalidException
	{
			return this.validate(invoice.getDate(), invoice.getClient(), invoice.getBookings(),  
					invoice.getDescription());
	}

	/**
	 * Searches the Database for matching Invoices
	 * @param search searches database based on query and returns specified information
	 * @return a List containing all 
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException 
	 */
	public List<Client> search(String search) throws DatabaseConnectionException, SQLException {
		ClientBroker cb = ClientBroker.getBroker();
		List<Client> results = cb.search(search);
		cb.close();
		return results;
	}

	/**
	 * Validates all fields for date, client, bookings, paid, paymentDue, description
	 * dueDate and payments to ensure that all fields are not null.
	 * If a field is null a appropriate exception will be thrown
	 * If id exists, invoice table is updated, if id != exist than information is 
	 * inserted into Invoice table
	 * @param date is the date for the invoice
	 * @param client is the client for the invoice
	 * @param bookings is the bookings for the invoice
	 * @param description is the description for the invoice
	 * @return true/false if the object is valid.
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 * @throws DateInvalidException is thrown if date is null or the invoice date is before current date
	 */
	public boolean save(int id, Date date, Client client, ArrayList<Booking> bookings, String description) throws DescriptionInvalidException, DatabaseConnectionException, DateInvalidException
	{
		Invoice invoice = null;
		
		if(validate(date, client, bookings, description))
			invoice = new Invoice(id, date, client, bookings, description);
		
		return ib.persist(invoice);
	}
	
	/**
	 * Validates all fields for invoice to ensure that all fields are not null.
	 * If a field is null a appropriate exception will be thrown
	 * If id exists, invoice table is updated, if id != exist than information is 
	 * inserted into Invoice table
	 * @param invoice the invoice object to validate and persist
	 * @return true/false if the object was saved.
	 * @throws CostInvalidException is thrown if it not a number or !=double
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws BooleanInvalidException is thrown if boolean not true/false
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 * @throws AddressInvalidException is thrown if it is null or has >75 characters
	 * @throws SurnameInvalidException is thrown if it is null or has >63 characters
	 * @throws GivenNameInvalidException is thrown if it is null or has >65 characters
	 * @throws ProvinceInvalidException is thrown if it is null or has >2 characters
	 * @throws PostalCodeInvalidException is thrown if >6 characters, ==6 & !valid or ==5 digits 
	 * @throws CountryInvalidException is thrown if it is null or has >25 characters
	 * @throws CityInvalidException is thrown if it is null or has >75 characters
	 * @throws EmailInvalidException is thrown if it is null or has >50 characters
	 * @throws NumberInvalidException is thrown if setupTime or tearDownTime are not in 
	 * a numerical format
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes 
	 * @throws ScheduleInvalidException Checks Schedule to see if it exists, that time is free,and
	 *  that it is not to big. if any of these are not true than the exception is thrown.
	 * @throws NameInvalidException is thrown if name is null or >25 characters
	 * @throws DateInvalidException is thrown if date is null or the invoice date is before current date
	 */
	public boolean save(Invoice invoice) throws CostInvalidException, DescriptionInvalidException, BooleanInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException, DateInvalidException
	{
		if(this.validate(invoice))
			return ib.persist(invoice);
		
		return false;
	}

	/**
	 * Deletes information from invoice table where invoice_id = invoice_getId
	 * If Id does not exist a exception will be thrown
	 * @param invoice the invoice object to remove 
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean remove(Invoice invoice) throws DatabaseConnectionException 
	{
		return ib.remove(invoice);
	}
	
	/**
	 * @param invoice_id is id for specific id
	 * @return boolean for ispaid
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean isPaid(int invoice_id) throws DatabaseConnectionException
	{
		Invoice invoice = new Invoice(invoice_id);
		return ib.isPaid(invoice);
	}
	
	public double paymentOwed(int invoice_id) throws DatabaseConnectionException
	{
		Invoice invoice = new Invoice(invoice_id);
		return ib.getPaymentOwed(invoice);
	}
	
	public List<Payment> getPayments(int invoice_id) throws DatabaseConnectionException
	{
		Invoice invoice = new Invoice(invoice_id);
		return ib.getPayments(invoice);
	}
	
	public Invoice getInvoiceInfo(int invoice_no) throws DatabaseConnectionException, SQLException {
		return ib.getInvoiceInformation(invoice_no);
	}
	
	public List<Invoice> getInvoicesForClient(int client_id) throws DatabaseConnectionException, SQLException {
		return ib.getInvoicesForClient(new Client(client_id));
	}
	
	/**
	 * Closes Database connection
	 */
	public void close() {
		ib.close();
	}
	
	public void payInvoice(Invoice i, Payment p) {
		ib.payInvoice(i,p);
	}
	
	public List<Invoice> getAllUnPaidInvoices() throws DatabaseConnectionException, SQLException {
		return ib.getAllUnPaidInvoices();
	}

	/**
	 * Gets the broker instance
     * @throws DatabaseConnectionException is thrown if DB connection fails 
	 * @see HttpServlet#HttpServlet()
     */
    public InvoiceManager() throws DatabaseConnectionException {
		ib = InvoiceBroker.getBroker();
    }

	/**
	 * Gets request and response for HttpServletRequest and HttpServletResponse, throws
	 * exceptions if error 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Posts request and response for HttpServletRequest and HttpServletResponse, throws
	 * exceptions if error 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
