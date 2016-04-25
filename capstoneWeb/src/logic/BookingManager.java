package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.AddressInvalidException;
import exceptions.CellPhoneInvalidException;
import exceptions.CityInvalidException;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientNameNotUniqueException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DiscountInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.HomePhoneInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.TearDownTimeInvalidException;
import exceptions.WorkPhoneInvalidException;

import persistence.BookingBroker;
import persistence.FacilityBroker;
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
import logic.InvoiceManager;

/**
 * Servlet implementation class BookingManager
 */
public class BookingManager extends HttpServlet
{
	private static final long serialVersionUID = -494051965047791874L;
	BookingBroker bb; 
	
	/**
	 * Processes all GET and POST requests to the HttpServlet
	 * @param request
	 * @param response
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("f") != null && request.getParameter("date") != null && request.getParameter("view") != null) {
			try {
				PrintWriter out = response.getWriter();
				try {
					FacilityBroker fb = FacilityBroker.getBroker();
					Facility facility = fb.getFacilityInformation(Integer.parseInt(request.getParameter("f")));
					fb.close();
					
					Calendar start = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");
					start.setTime(sdf.parse(request.getParameter("date") + " 00:00:00"));					

					Calendar end = Calendar.getInstance();
					end.setTime(start.getTime());
					
					switch(Integer.parseInt(request.getParameter("view"))) {
					case 1:
						end.add(Calendar.DATE, 1);
						break;
					case 2:
						end.add(Calendar.WEEK_OF_YEAR, 1);
						break;
					case 3:
						end.add(Calendar.MONTH, 1);
						break;
					}
					
					//System.out.println("generating a schedule for facility: " + facility.getName() + " from " + start.getTime() + " to " + end.getTime());
					HttpSession session = request.getSession();
					List<Booking> bookings = new ArrayList<Booking>();
					//if(session.getAttribute("searchResults") == null) {
						bookings = bb.getBookingsForFacility(facility, start.getTime(), end.getTime());
					/*}else {
						bookings = (List<Booking>)session.getAttribute("searchResults");
					}*/
					
					out.print(generateSchedule(facility, start, end, bookings));
					out.close();
					return;
				} catch (DatabaseConnectionException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {} 
		}//else if(request.getParameter("q") != null) {
		//	try {
		//		PrintWriter out = response.getWriter();
		//		List<Booking> bookings;
		//		try {
		//			bookings = search(request.getParameter("q"));
		//			 
		//		    Iterator<Client> iterator = clients.iterator();
		//		    while(iterator.hasNext()) {
		//		    	Client client = iterator.next();
		//		        out.println(client.getGivenName() + " " + client.getSurname());
		//		    }
		//		} catch (DatabaseConnectionException e) {
		//			out.println("Could not connect to database");
		//		}
		//	} catch (IOException e1) {}
		//}
		
		HttpSession session = request.getSession();
		String doRequest = request.getParameter("do");
		if(doRequest != null) {
			String error = "";
			if(doRequest.equals("search")){
				if(request.getParameter("search") != null) {
					try {
						Calendar start = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss");
						start.setTime(sdf.parse(request.getParameter("date") + " 00:00:00"));					
	
						Calendar end = Calendar.getInstance();
						end.setTime(start.getTime());
						
						switch(Integer.parseInt(request.getParameter("view"))) {
						case 1:
							end.add(Calendar.DATE, 1);
							break;
						case 2:
							end.add(Calendar.WEEK_OF_YEAR, 1);
							break;
						case 3:
							end.add(Calendar.MONTH, 1);
							break;
						}
						//DOESNT WORKsession.setAttribute("searchResults", search(request.getParameter("searchText"), start.getTime(), end.getTime(), new Facility(Integer.parseInt(request.getParameter("facility")))));
						
					} catch (ParseException e) {
						e.printStackTrace();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}else if(request.getParameter("reset") != null) {
					session.setAttribute("searchResults", null);
				}
			} else if(doRequest.equals("manage")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String eventName = request.getParameter("eventName");
				String client = request.getParameter("client");
				String bookingType = request.getParameter("bookingType");
				String rate = request.getParameter("rate");
				String people = request.getParameter("people")!=null?request.getParameter("people"):"0";
				String start = request.getParameter("start");
				String length = request.getParameter("length");
				String setup = request.getParameter("setup");
				String teardown = request.getParameter("teardown");
				String date = request.getParameter("date");
				String creator = request.getParameter("creator");
				String facility = request.getParameter("facility");
				
				Calendar startDate = Calendar.getInstance();
				try {
					startDate.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date + " " + start));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Calendar endDate = Calendar.getInstance();
				endDate.setTime(startDate.getTime());
				endDate.add(Calendar.MINUTE, Integer.parseInt(length));
				
				ArrayList<AdditionalCharge> adcs = new ArrayList<AdditionalCharge>();
				if(request.getParameter("additionalCharges") != null) {
					for(int i=0; i < request.getParameterValues("additionalCharges").length; i++) {
						AdditionalCharge adc = new AdditionalCharge();
						adc.setId(Integer.parseInt(request.getParameterValues("additionalCharges")[i]));
						adcs.add(adc);
					}
				}
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						Booking booking = new Booking();
						booking.setId(id);					
						if(!this.remove(booking)) {
							error = "?facility=" + facility + "&time=" + startDate.getTime() + "&view=1&error=main&message=Could not remove booking";
						}
					} catch (DatabaseConnectionException e) {
						error = "?facility=" + facility + "&time=" + startDate.getTime() + "&view=1&error=main&message="+e.getMessage();
					}
				} else if(request.getParameter("save") != null) { 
					//We are saving an existing client or creating a new one
					ArrayList<String> errorText = new ArrayList<String>();
					errorText.add(id+"");
					errorText.add(eventName);
					errorText.add(client);
					errorText.add(bookingType);
					errorText.add(rate);
					errorText.add(people);
					errorText.add(start);
					errorText.add(length);
					errorText.add(setup);
					errorText.add(teardown);
					errorText.add(facility);
					try {
						BookingType bt = new BookingType();
						bt.setId(Integer.parseInt(bookingType));
						
						Employee em = new Employee();
						em.setId(Integer.parseInt(creator));
						
						Rate r = new Rate();
						r.setId(Integer.parseInt(rate));
						
						Facility f = new Facility();
						f.setId(Integer.parseInt(facility));
						
						Catering ca = new Catering("", 0.0, "");
						
						this.save(id, 
								eventName, 
								bt, 
								startDate.getTime(), 
								endDate.getTime(), 
								setup, 
								teardown, 
								client, 
								ca, 
								em, 
								people, 
								r, 
								adcs, 
								f, 
								"0");
						error = "?facility=" + facility + "&time=" + startDate.getTime() + "&view=1";
					} catch (DatabaseConnectionException e) {
						error = "?facility=" + facility + "&time=" + startDate.getTime() + "&view=1&error=main&message="+e.getMessage();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (NameInvalidException e) {
						e.printStackTrace();
					} catch (ScheduleInvalidException e) {
						e.printStackTrace();
					} catch (SetupTimeInvalidException e) {
						e.printStackTrace();
					} catch (TearDownTimeInvalidException e) {
						e.printStackTrace();
					} catch (NumberInvalidException e) {
						e.printStackTrace();
					} catch (DateInvalidException e) {
						e.printStackTrace();
					} catch (ClientNameNotUniqueException e) {
						e.printStackTrace();
					} catch (ClientDoesNotExistException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}try {
				response.sendRedirect("BookingWindow.jsp"+error);
			} catch (IOException e) {}
		}
	}
	
	/**
	 * Generates a series of HTML tables to represent a number of Bookings on a schedule.
	 * @param facility The facility to generate a schedule for.
	 * @param start the date to Start generating a schedule for
	 * @param end the date to finish generating the schedule on
	 * @param bookings the bookings to include on the schedule
	 * @return a String containing HTML to display the schedule
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public String generateSchedule(Facility facility, Calendar start, Calendar end, List<Booking> bookings) throws DatabaseConnectionException {
		String schedule = "";
		
		for(;start.before(end);start.add(Calendar.DATE, 1)) {
			SimpleDateFormat df = new SimpleDateFormat("EEE, MMMMM d yyyy");
			Calendar current = Calendar.getInstance();
			current.setTime(start.getTime());
			current.set(Calendar.HOUR_OF_DAY, facility.getOpenTime());
			current.set(Calendar.MINUTE, 0);
			current.set(Calendar.SECOND, 0);
			current.set(Calendar.MILLISECOND, 0);
			//System.out.println("Schedule for: " + df.format(current.getTime()));//TODO
			schedule += "<h2>" + df.format(current.getTime()) + "</h2>";
			
			//AM/PM Header
			int amColspan = (12-facility.getOpenTime()) * 4;
			int pmColspan = (12-(24-facility.getCloseTime())) * 4;
			String header = "<table>" +
							"	<tr>" +
							"		<th colspan=\"" + amColspan + "\" class=\"am\">AM</th><th colspan=\"" + pmColspan + "\" class=\"pm\">PM</th>" +
							"	</tr>";
			
			//show time header
			String timeHeader = "<tr class=\"time\">";
			for(int i=facility.getOpenTime(); i < facility.getCloseTime(); i++) {
				int time = (i-12 <= 0)?i:i-12;
				timeHeader += "<td class=\"hourBorder\">" + time + "</td><td>&nbsp;</td><td class=\"halfHourBorder\">&nbsp;</td><td>&nbsp;</td>";
			}
			timeHeader += "</tr>";
			
			//Fill in bookings
			String bookingRow = "<tr>";
			Calendar bookingTime = Calendar.getInstance();
			InvoiceManager im = new InvoiceManager();
			for(int i=0; i< amColspan + pmColspan; i++) {
				boolean booked = false;
				for (Booking booking : bookings) {
					bookingTime.setTime(booking.getStartTime());
					bookingTime.set(Calendar.SECOND, 0);
					bookingTime.set(Calendar.MILLISECOND, 0);
					
					//System.out.println("Checking booking at " + bookingTime.getTime() + " with " + current.getTime());//TODO
					if( current.equals(bookingTime) && (booking.getFacility().getId() == facility.getId()) ) {
						//System.out.println("booking matches"); //TODO
						DateFormat dateFormat = new SimpleDateFormat("h:mm a");
						booked = true;
						int colspan = booking.getLength() / 15;
						
						String style = (im.isPaid(booking.getInvoice_no()))?"paidBooking":"unpaidBooking";
						
						String title = booking.getEventTitle() + " -- " 
									+ dateFormat.format(booking.getStartTime()) + " - " + dateFormat.format(booking.getEndTime())
									+ "<br /><strong>Booking Type: </strong>" + booking.getEventType().getName()
									+ "<br /><strong>Client: </strong>" + booking.getClient().getGivenName() + " " + booking.getClient().getSurname()
									+ "<br /><strong>Rate: </strong>" + booking.getRate().getName();
						
						String onclick = "jQuery.facebox({ ajax: 'BookingInfo.jsp?booking=" + booking.getId() + "' });";
						
						bookingRow += "<td class=\"" + style + "\" colspan=\"" + colspan + "\"" +
									" title=\"" + title + "\"" +
									" onclick=\"" + onclick + "\">" + booking.getEventTitle() + "</td>";
						//System.out.println("Increasing time by " + booking.getLength());//TODO
						current.add(Calendar.MINUTE, booking.getLength());
						i += colspan-1;
						bookings.remove(booking);
						break;
					}
				}
				if(!booked) {
					String onclick = "jQuery.facebox({ ajax: 'BookingInfo.jsp?facility=" + facility.getId() + "&time=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(current.getTime()) + "' });";
				
					current.add(Calendar.MINUTE,15);
					bookingRow += "<td class=\"open\" onclick=\"" + onclick + "\">&nbsp;</td>";
				}
			}
			bookingRow += "</tr>";
			schedule += header + timeHeader + bookingRow + "</table>";
		}
		return schedule;
	}

	/**
	 * Validates all fields of an booking object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param booking contains all information for booking
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or <30 characters
	 * @throws ScheduleInvalidException is thrown if a booking already exists for that specific
	 * time frame in the schedule
	 * @throws SetupTimeInvalidException is thrown if it is  <0 minutes
	 * @throws TearDownTimeInvalidException is thrown if it is  <0 minutes
	 * @throws NumberInvalidException is thrown if setupTime or tearDownTime are not in 
	 * a numerical format
	 * @throws DateInvalidException is thrown if it is null,end time before start time
	 * or end time == start time.
	 * @throws ClientDoesNotExistException 
	 * @throws ClientNameNotUniqueException 
	 * @throws DatabaseConnectionException 
	 * @throws SQLException 
	 */
	public boolean validate(Booking booking) throws NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException, DateInvalidException, DatabaseConnectionException, ClientNameNotUniqueException, ClientDoesNotExistException, SQLException 
	{
		return this.validate(booking.getEventTitle(), booking.getEventType(), booking.getStartTime(), 
				booking.getEndTime(), new Integer(booking.getSetupTime()).toString(), 
				new Integer(booking.getTearDownTime()).toString(), booking.getClient().getGivenName() + " " + booking.getClient().getSurname(), booking.getCatering(), 
				booking.getCreator(), new Integer(booking.getNumberOfPeople()).toString(), 
				booking.getRate(), booking.getAdditionalCharges(),	booking.getFacility(), 
				new Integer(booking.getInvoice_no()).toString());
	}
	
	/**
	 * Validates all fields of an booking object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * 
	 * @param eventTitle for the booking
	 * @param eventType for the booking
	 * @param startTime for the booking
	 * @param endTime for the booking
	 * @param setupTime for the booking
	 * @param tearDownTime for the booking
	 * @param client for the booking
	 * @param creator for the booking
	 * @param rate for the booking
	 * @param additionalCharges for the booking
	 * @param facility for the booking
	 * @param invoice_no for the booking
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or <30 characters
	 * @throws ScheduleInvalidException is thrown if a booking already exists for that specific time
	 * frame in the schedule
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws NumberInvalidException is thrown if setupTime or tearDownTime are not in a numerical
	 * format
	 * @throws DateInvalidException is thrown if it is null,end time before start time
	 * or end time == start time.
	 * @throws DatabaseConnectionException 
	 * @throws ClientNameNotUniqueException 
	 * @throws ClientDoesNotExistException 
	 * @throws SQLException 
	 */
	public boolean validate(String eventTitle, BookingType eventType, Date startTime, Date endTime, String setupTime, String tearDownTime, String client, Catering catering, Employee creator,
			String numberOfPeople, Rate rate, ArrayList<AdditionalCharge> additionalCharges, Facility facility, String invoice_no) throws NameInvalidException,
			ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException, DateInvalidException, DatabaseConnectionException, ClientNameNotUniqueException, ClientDoesNotExistException, SQLException {
		
		if (eventTitle == null || eventTitle.equals(""))
			throw new NameInvalidException("A booking requires a title to identify it.");
		if (eventTitle.length() > 25)
			throw new NameInvalidException("A booking title cannot exceed 25 characters.");
		
		if(endTime == null)
			throw new DateInvalidException("An event must have an end.");
		
		if(endTime.before(new Date()))
			throw new DateInvalidException("An event cannot be ended in the past.");
		
		if(endTime.equals(startTime))
			throw new DateInvalidException("An event cannot be ended at the same time it has begun.");
		
		if (this.search(startTime, endTime) != null)
			throw new ScheduleInvalidException("A booking is already scheduled for this time.");

		if(setupTime != null && !setupTime.equals(""))
		try {
			int setUpTime = Integer.parseInt(setupTime);
			if (setUpTime < 0)
				throw new SetupTimeInvalidException("A setup time must entered as minutes.");
		} catch (NumberFormatException nfe) {
			throw new SetupTimeInvalidException("The setup time must be in a  numerical format.");
		}

		if(tearDownTime != null && !tearDownTime.equals(""))
		{
			try {
				int teardownTime = Integer.parseInt(tearDownTime);
				if (teardownTime < 0)
					throw new TearDownTimeInvalidException("A teardown time must be entered as minutes.");
			} catch (NumberFormatException nfe) {
				throw new TearDownTimeInvalidException("The teardown time must be in a  numerical format.");
			}
		}

		if(numberOfPeople != null && !numberOfPeople.equals(""))
		{
			try {
				int NumberOfPeople = Integer.parseInt(numberOfPeople);
				if (NumberOfPeople < 0)
					throw new NumberInvalidException("The number of people at an event must be a positive, whole number.");
			} catch (NumberFormatException nfe) {
				throw new NumberInvalidException("The number of people for a booking must be in a  numerical format.");
			}
		}
		
		ClientManager cm;
		ArrayList<Client> clients = new ArrayList<Client>();
		cm = new ClientManager();
		clients = (ArrayList<Client>) cm.search(client);
		cm.close();
			
		if (clients.size() >1)
		{
			throw new ClientNameNotUniqueException("Client name must be unique. Use the dropdown to select a uniqe client name.");
		}
		else if (clients.size() <= 0)
		{
			throw new ClientDoesNotExistException("There is no client by this name in the system. Use the dropdown to select a client that exists.");
		}

		return true;
	}

	/**
	 * Sends a message to the database to search for requested information, and returns
	 * information in a list format.
	 * @param search passes message along to database to search than returns a list
	 * @return List with all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Booking> search(String search, Facility facility, Date startTime, Date endTime) throws DatabaseConnectionException {
		return bb.search(search, startTime, endTime, facility);
	}

	/**
	 * Finds all bookings for a specified faciltiy during a specifed timeframe that 
	 * matches the specified search string
	 * @param search String to search booking for
	 * @param start The date to begin including Bookings, non-Inclusive
	 * @param end The date to end including bookings, non-Inclusive
	 * @return  a List containing all Bookings between the start and end dates provided for the specified facility, non-Inclusive
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public List<Booking> search(String search, Date start, Date end, Facility facility) throws DatabaseConnectionException {
		return bb.search(search, start, end, facility);
	}
	
	/**
	 * Finds all Bookings during the specified time period
	 * @param start The date to begin including Bookings, non-Inclusive
	 * @param end The date to end including bookings, non-Inclusive
	 * @return a List containing all Bookings between the start and end dates provided, non-Inclusive
	 */
	public List<Booking> search(Date start, Date end)
	{
		return null;
	}

	/**
	 * Persists a booking into the database
	 * @param booking the Booking to save in the database
	 * @return true if the Booking is sucsessfully persisted into the database
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public boolean save(Booking booking) throws DatabaseConnectionException {
		return bb.persist(booking);
	}
	
	/**
	 * Validates, then persists the Booking information passed to the database 
	 * through the Booking.
	 * @param id the id of the Booking to persist. If creating a new Booking this 
	 * 			should be 0, otherwise it is set to the id of the Booking to
	 * 			update.
	 * @param eventTitle the title of the booking
	 * @param eventType the BookingType of the Booking.
	 * @param startTime the time the Booking starts at.
	 * @param endTime the time the Booking ends at.
	 * @param setupTime the amount of time in minutes that is needed for setup.
	 * @param tearDownTime the amoun of time in minutes that is needed for teardown.
	 * @param client the Client name that the booking is made for.
	 * @param catering the Catering object related to this Booking
	 * @param creator the Employee that created this Booking
	 * @param numberOfPeople the number of people that are attending this Booking
	 * @param rate the Rate that this event is being charged at
	 * @param additionalCharges A List of any AdditionalCharges that are charged for this Booking
	 * @param facility the Facility this booking is booked for
	 * @param invoice_no the number of the Invoice this booking is included on
	 * @return true if Booking infomation is valid and saved to the database. Throws an appropriate exception otherwise.
	 * @throws NameInvalidException if eventTitle is null or longer than 25 characters
	 * @throws ScheduleInvalidException if a Booking is previously booked in the same timeframe
	 * @throws SetupTimeInvalidException if setupTime is not a number or is less than 0
	 * @throws TearDownTimeInvalidException if tearDownTime is not a number or is less than 0
	 * @throws NumberInvalidException if numberOfPeople is not a number or is less than 0
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 * @throws DateInvalidException if the start or end date provided is not a date
	 * @throws ClientNameNotUniqueException if the Client name provided is not unique
	 * @throws ClientDoesNotExistException if the Client name provided does not exist in the database
	 * @throws SQLException if there is an sql error
	 */
	public boolean save(int id, String eventTitle, BookingType eventType, Date startTime, Date endTime, String setupTime, String tearDownTime, String client, Catering catering, Employee creator, String numberOfPeople, Rate rate,
			ArrayList<AdditionalCharge> additionalCharges, Facility facility, String invoice_no) throws NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException, DatabaseConnectionException, ClientNameNotUniqueException, ClientDoesNotExistException, SQLException, DateInvalidException
	{
		Booking booking = null;
		
		if(this.validate(eventTitle, eventType, startTime, endTime, setupTime, tearDownTime, client, catering, creator,  numberOfPeople, rate, additionalCharges, facility, invoice_no)) {
			ClientManager cm = new ClientManager();
			ArrayList<Client> clients = new ArrayList<Client>();
			clients = (ArrayList<Client>) cm.search(client);
			cm.close();
			booking = new Booking(id, eventTitle, eventType, startTime, endTime, Integer.parseInt(setupTime), Integer.parseInt(tearDownTime), clients.get(0), catering, creator, Integer.parseInt(numberOfPeople), rate,
			additionalCharges, facility, Integer.parseInt(invoice_no));
		}
		return bb.persist(booking);
	}

	/**
	 * Removed the passed Booking from the database through the BookingBroker
	 * @param booking the Booking that is to be removed from the database. Only the id is needed to be set 
	 * 				in order to perform this operation.
	 * @return true if the Booking is succsesfully removed from the database. If the Booking
	 * 			cannot be removed from the database an exception will be thrown.
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public boolean remove(Booking booking) throws DatabaseConnectionException {
		return bb.remove(booking);
	}
	
	/**
	 * Gets a List of all Bookings in the database that have been made for the Client specified by the 
	 * passed client_id
	 * @param client_id the id of the Client that related bookings will be found for
	 * @return a List containing all Booking that are associated with the Client specifed by the passed client id
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public List<Booking> getAllBookingsForClient(int client_id) throws DatabaseConnectionException
	{
		Client client = new Client(client_id);
		return bb.getBookingsForClient(client, new Date(1L), new Date(5000, 0, 1));
	}
	
	/**
	 * Gets a List of all Bookings in the database that are included on an Invoice with the specified invoice_no
	 * @param invoice_no the invoice number that related bookings will be found for
	 * @return a List containing all Bookings that are associated with the passed invoice_no
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public List<Booking> getAllBookingsForInvoice(int invoice_no) throws DatabaseConnectionException
	{
		return bb.getBookingsForInvoice(invoice_no);
	}
	
	/**
	 * Performs a query through the BookingBroker to determine all related Booking information related
	 * to the passed id. If the passed id does not exist in the database, a null value 
	 * will be returned.
	 * @param id the id of the Booking to look up
	 * @return a Booking containing any information related to the id passed<br />
	 * 			null if no Booking exists with the passed id
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public Booking getBookingInformation(int id) throws DatabaseConnectionException {
		return bb.getBookingInformation(id);
	}
	
	/**
	 * Closes the current BookingBroker instance
	 */
	public void close() {
		bb.close();
	}
       
    /**
     * Constructor for the BookingManager.
     * Gets the current instance of the BookingBroker class for use 
     * in any database interactions.
     */
    public BookingManager() {
		bb = BookingBroker.getBroker();
    }

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
