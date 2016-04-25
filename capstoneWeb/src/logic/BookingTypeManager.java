package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

import persistence.BookingTypeBroker;
import problemDomain.BookingType;
import problemDomain.Employee;
import problemDomain.Facility;

/**
 * Servlet implementation class BookingTypeManager
 */
public class BookingTypeManager extends HttpServlet {
	private static final long serialVersionUID = 3516549617631231591L;
	
	/**
	 * Initializes BookingTypeBroker instance 
	 */
	BookingTypeBroker btb;
	
	
	/**
	 * Calls HttpServletRequest and HttpServletResponse
	 * Iterates through bookingType
	 * If an error occurs the appropriate exception will be thrown
	 * @param request is the request that is called
	 * @param response is the response that is returned
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("q") != null) {
			try {
				PrintWriter out = response.getWriter();
				List<BookingType> bookingTypes = search(request.getParameter("q"));
			 
			    Iterator<BookingType> iterator = bookingTypes.iterator();
			    while(iterator.hasNext()) {
			    	BookingType bookingType = iterator.next();
			        out.println(bookingType.getName());
			    }
			} catch (IOException e1) {
				e1.printStackTrace();//TODO: ERROR MESSAGE
			} catch (DatabaseConnectionException e) {
				e.printStackTrace();//TODO: ERROR MESSAGE
			}
		}
		
		HttpSession session = request.getSession();
		String doRequest = request.getParameter("do");
		if(doRequest != null) 
		{
			if(doRequest.equals("searchBT"))
			{
				if(request.getParameter("search") != null)
				{
					try 
					{
						session.setAttribute("searchResultsBT", search(request.getParameter("searchText")));  //TODO:Need to differentiate between rate, ac, and bt search results
					} 
					catch (DatabaseConnectionException e)
					{
						//TODO: ERROR MESSAGE
						e.printStackTrace();
					}
				}
				else if(request.getParameter("reset") != null) 
				{
					session.setAttribute("searchResultsBT", null);//TODO:Need to differentiate between rate, ac, and bt search results
				}
			}
			else if(doRequest.equals("manage")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String setupTime = request.getParameter("setupTime");
				String tearDownTime = request.getParameter("tearDownTime");
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						BookingType bookingType = new BookingType();
						bookingType.setId(id);					
						if(!this.remove(bookingType)) {
							//TODO: Error message
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();
					}
				} else if(request.getParameter("save") != null) { //We are saving an existing booking type or creating a new one
					try {					
						if(!this.save(id, name, setupTime, tearDownTime)) {
							System.out.println("not saved?");//TODO: ERROR MESSAGE
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();//TODO: ERROR MESSAGE
					}  catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TearDownTimeInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SetupTimeInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NameInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}try {
				response.sendRedirect("ManagementWindow.jsp");
			} catch (IOException e) {
				e.printStackTrace();//TODO: ERROR MESSAGE
			}
		}
	}
	
	/**
	 * Validates all fields of an bookingType object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param bt BookingType that is validated
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or >45 characters
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 */
	public boolean validate(BookingType bt) throws NameInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException 
	{
		return this.validate(bt.getName(), new Integer(bt.getSetupTime()).toString(), new Integer(bt.getTearDownTime()).toString());
	}
	
	/**
	 * Validates all fields of an bookingType object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param name for the bookingType
	 * @param setupTime for the bookingType
	 * @param tearDownTime for the bookingType
	 * @return true/false if the object is valid.
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws NameInvalidException is thrown if it is null or >45 characters
	 */
	public boolean validate(String name, String setupTime, String tearDownTime) throws TearDownTimeInvalidException, SetupTimeInvalidException, NameInvalidException
	{
		if(name == null || name.equals(""))
			throw new NameInvalidException("A booking type requires a name.");
		if(name.length() > 25)
			throw new NameInvalidException("A booking type name cannot excede 25 characters.");
		
		if(setupTime != null && !setupTime.equals(""))
		{
			try
			{
				int SetupTime = Integer.parseInt(setupTime);
				if(SetupTime < 0)
					throw new SetupTimeInvalidException("The setup time of a booking type must be entered in a minute format.");
			}
			catch(NumberFormatException nfe)
			{
				throw new SetupTimeInvalidException("A setup time must be in a numeric format.");
			}
		}
		
		if(tearDownTime != null && !tearDownTime.equals(""))
		{
			try
			{
				int TearDownTime = Integer.parseInt(tearDownTime);
				if(TearDownTime < 0)
					throw new TearDownTimeInvalidException("A teardown time of a booking type must be enetered in a minute format.");
			}
			catch(NumberFormatException nfe)
			{
				throw new TearDownTimeInvalidException("A booking type teardown time must be in a numeric format.");
			}
		}
		
		return true;
	}

	/**
	 * Sends a message to the database to search for requested information based on query
	 * and returns information in a list format.
	 * @param query is the query used to select proper information from requested table
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 */
	public List<BookingType> search(String query) throws DatabaseConnectionException {
		return btb.search(query);
	}

	/**
	 * Validates all fields for bt to ensure that all fields are valid.
	 * If a field is not valid a appropriate exception will be thrown
	 * If name exists, information in bookingType table is updated, otherwise 
	 * information is inserted into table
	 * @param bt bookingType contains all information for a bookingType
	 * @return boolean
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws NameInvalidException is thrown if it is null or >45 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 */
	public boolean save(BookingType bt) throws NameInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, DatabaseConnectionException {
		if(this.validate(bt))
			return btb.persist(bt);
		return false;
	}
	
	/**
	 * @param name for bookingType
	 * @param setupTime for bookingType
	 * @param tearDownTime for bookingType
	 * @return updated list for bookingType
	 * @throws NameInvalidException is thrown if it is null or >45 characters
	 * @throws SetupTimeInvalidException is thrown if it is <0 minutes
	 * @throws TearDownTimeInvalidException is thrown if it is <0 minutes
	 * @throws NumberFormatException is thrown if setupTime or tearDownTime are in a non-numeric
	 * format
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 */
	public boolean save(int id, String name, String setupTime, String tearDownTime) throws NumberFormatException, TearDownTimeInvalidException, SetupTimeInvalidException, NameInvalidException, DatabaseConnectionException
	{
		BookingType bt = null;
		
		if(this.validate(name, setupTime, tearDownTime))
			bt = new BookingType(id, name, Integer.parseInt(setupTime), Integer.parseInt(tearDownTime));
		
		return btb.persist(bt);
	}

	/**
	 * Removes the supplied object from the database
	 * @param bt bookingType contains all information for a bookingType
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 */
	public boolean remove(BookingType bt) throws DatabaseConnectionException {
		return btb.remove(bt);
	}
	
	/**
	 * Closes database connection
	 */
	public void close() {
		btb.close();
	}
	
	/**
	 * Searches Database for required information and returns it in a list format
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails 
	 */
	public List<BookingType> getBookingTypeList() throws DatabaseConnectionException
	{
		return btb.getBookingTypeList();
	}

	/**
	 * Gets the broker instance
     * @throws DatabaseConnectionException is thrown if DB connection fails 
	 * @see HttpServlet#HttpServlet()
     */
    public BookingTypeManager() throws DatabaseConnectionException {
		btb = BookingTypeBroker.getBroker();
    }

    /**
	 * @param bookingType_id
	 * @return bookingType
	 * @throws DatabaseConnectionException 
	 */
    public BookingType getBookingTypeInfo(int bookingType_id) throws DatabaseConnectionException 
	{
		return (BookingType) btb.getBookingTypeInformation(bookingType_id);
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
