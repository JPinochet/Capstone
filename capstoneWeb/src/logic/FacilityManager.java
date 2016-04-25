package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.FacilityBroker;
import problemDomain.AdditionalCharge;
import problemDomain.Facility;
import problemDomain.Rate;
import exceptions.CloseTimeInvalidException;
import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.MaxCapacityInvalidException;
import exceptions.MinBookingIntervalInvalidException;
import exceptions.MinBookingTimeInvalidException;
import exceptions.NameInvalidException;
import exceptions.OpenTimeInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

/**
 * Servlet implementation class FacilityManager
 */
public class FacilityManager extends HttpServlet {
	private static final long serialVersionUID = -8311804124741426611L;
	
	/**
	 * Initializes FacilityBroker instance
	 */
	FacilityBroker fb;
	
	/**
	 * Calls HttpServletRequest and HttpServletResponse
	 * Iterates through facility
	 * If an error occurs the appropriate exception will be thrown
	 * @param request is the request that is called
	 * @param response is the response that is returned
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("q") != null) {
			try {
				PrintWriter out = response.getWriter();
				try {
					List<Facility> facilities = search(request.getParameter("q"));
				 
				    Iterator<Facility> iterator = facilities.iterator();
				    while(iterator.hasNext()) {
				    	Facility facility = iterator.next();
				        out.println(facility.getName());
				    }
				} catch (DatabaseConnectionException e) {
					out.println("Could not connect to database");
				}
			} catch (IOException e1) {} 
			
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
					}
				}else if(request.getParameter("reset") != null) {
					session.setAttribute("searchResults", null);
				}
			} else if(doRequest.equals("manage")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String openTime = request.getParameter("open");
				String closeTime = request.getParameter("close");
				String setupTime = request.getParameter("setup");
				String teardownTime = request.getParameter("teardown");
				String maxCapacity = request.getParameter("capacity");
				String minBookingTime = request.getParameter("length");
				String minInterval = request.getParameter("minInterval");
				ArrayList<Rate> rates = new ArrayList<Rate>();
				if(request.getParameter("rates") != null) {
					for(int i=0; i < request.getParameterValues("rates").length; i++) {
						Rate rate = new Rate(Integer.parseInt(request.getParameterValues("rates")[i]), "", "", 0, 0, 0);
						rates.add(rate);
					}
				}
				ArrayList<AdditionalCharge> acs = new ArrayList<AdditionalCharge>();
				if(request.getParameter("addCharges") != null) {
					for(int i=0; i < request.getParameterValues("addCharges").length; i++) {
						AdditionalCharge ac = new AdditionalCharge(Integer.parseInt(request.getParameterValues("addCharges")[i]), "", 0);
						acs.add(ac);
					}
				}
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						Facility facility = new Facility();
						facility.setId(id);					
						if(!this.remove(facility)) {
							error = "?error=main&message=Could not remove facility";
						}
					} catch (DatabaseConnectionException e) {
						error = "?error=main&message="+e.getMessage();
					}
				} else if(request.getParameter("save") != null) { //We are saving an existing client or creating a new one
					ArrayList<String> errorText = new ArrayList<String>();
					errorText.add(id+"");
					errorText.add(openTime);
					errorText.add(closeTime);
					errorText.add(setupTime);
					errorText.add(teardownTime);
					errorText.add(name);
					errorText.add(maxCapacity);
					errorText.add(minInterval);
					errorText.add(minBookingTime);
					try {
						this.save(id, openTime, closeTime, setupTime, teardownTime, name, rates, acs, maxCapacity, minInterval, minBookingTime);
					} catch (DatabaseConnectionException e) {
						error = "?error=main&message="+e.getMessage();
					} catch (NameInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "name");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (OpenTimeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "open");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (CloseTimeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "close");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (SetupTimeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "setup");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (TearDownTimeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "teardown");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (MaxCapacityInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "capacity");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (MinBookingIntervalInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "minInterval");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					} catch (MinBookingTimeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "length");
						session.setAttribute("errorText", errorText);
						session.setAttribute("rates", rates);
						session.setAttribute("acs", acs);
					}
				}
			}try {
				response.sendRedirect("FacilityWindow.jsp"+error);
			} catch (IOException e) {}
		}
		
	}
	
	/**
	 * Validates all fields of an facility object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param openTime is the openTime for the facility
	 * @param closeTime is the closeTime for the facility
	 * @param setupTime is the setupTime for the facility
	 * @param tearDownTime is the tearDownTime for the facility
	 * @param name is the name for the facility
	 * @param rates is the rates for the facility
	 * @param additionalCharges is the additionalCharges for the facility
	 * @param maxCapacity is the maxCapacity for the facility
	 * @param minBookingInterval is the minBookingInterval for the facility
	 * @param minBookingTime is the minBookingTime for the facility
	 * @return true/false if the object is valid.
	 * @throws CostInvalidException is thrown if it not a number,or != double
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws MinBookingTimeInvalidException  is thrown if it is null or is not in a minute format
	 * @throws MinBookingIntervalInvalidException is thrown if it is not in the proper number format
	 * @throws MaxCapacityInvalidException is thrown if it is null or if it is not a positive number
	 * @throws TearDownTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws SetupTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws CloseTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 * @throws OpenTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 */
	public boolean validate(String openTime, String closeTime, String setupTime, String tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			String maxCapacity, String minBookingInterval, String minBookingTime) throws NameInvalidException, DatabaseConnectionException, OpenTimeInvalidException, CloseTimeInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, MaxCapacityInvalidException, MinBookingIntervalInvalidException, MinBookingTimeInvalidException 
	{
		if(openTime == null || openTime.equals(""))
			throw new OpenTimeInvalidException("A facility must have an opening time.");
		try
		{
			int OpenTime = Integer.parseInt(openTime);
			if(OpenTime < 0)
				throw new OpenTimeInvalidException("Time is calculated on a 24 clock and one hour intervals.<br />Therefore this field must contain an number between 0 and 24 (0 and 24 both being 12am).");
			if(OpenTime > 24)
				throw new OpenTimeInvalidException("Time is calculated on a 24 clock and one hour intervals.<br />Therefore this field must contain an number between 0 and 24 (0 and 24 both being 12am).");
		}
		catch(NumberFormatException nfe)
		{
			throw new OpenTimeInvalidException("A facilities opening time must be in an number format.");
		}
		
		if(closeTime == null || closeTime.equals(""))
			throw new CloseTimeInvalidException("A facility must have a closing time.");
		try
		{
			int CloseTime = Integer.parseInt(closeTime);
			if(CloseTime < 0)
				throw new CloseTimeInvalidException("Time is calculated on a 24 clock and one hour intervals.<br />Therefore this field must contain an number between 0 and 24 (0 and 24 both being 12am).");
			if(CloseTime > 24)
				throw new CloseTimeInvalidException("Time is calculated on a 24 clock and one hour intervals.<br />Therefore this field must contain an number between 0 and 24 (0 and 24 both being 12am).");
		}
		catch(NumberFormatException nfe)
		{
			throw new SetupTimeInvalidException("A facilities closing time must be in an number format.");
		}
		
		if(setupTime != null && !setupTime.equals(""))
		{
			try
			{
				int SetupTime = Integer.parseInt(setupTime);
				if(SetupTime < 0)
					throw new SetupTimeInvalidException("A facilities setup time is entered as a minute value.<br />Therefore cannot be a negative number.");
			}
			catch(NumberFormatException nfe)
			{
				throw new SetupTimeInvalidException("A facilities setup time must be in an number format.");
			}
		}
		
		
		if(tearDownTime != null && !tearDownTime.equals(""))
		{
			try
			{
				int TearDownTime = Integer.parseInt(tearDownTime);
				if(TearDownTime < 0)
					throw new TearDownTimeInvalidException("A facilities teardown time cannot be a negative number.<br />Must be in a minute format.");
			}
			catch(NumberFormatException nfe)
			{
				throw new TearDownTimeInvalidException("A facilities teardown time must be entered in a numeric format.");
			}
		}
		
		if(name == null || name.equals(""))
			throw new NameInvalidException("A facility requires a name to identify it.");
		if(name.length() > 25)
			throw new NameInvalidException("A facility's name cannot excede 25 characters.");
		
		
		if(maxCapacity != null && !maxCapacity.equals(""))
		{
			try
			{
				int MaxCapacity = Integer.parseInt(maxCapacity);
				if(MaxCapacity < 0)
				{
					throw new MaxCapacityInvalidException("A facilities max capacity must be a positive number as you cannot have a negative amount of people.");
				}
			}
			catch(NumberFormatException nfe)
			{
				throw new MaxCapacityInvalidException("A facilities max capacity must be entered in a numeric format.");
			}
		}
		
		if(minBookingInterval != null && !minBookingInterval.equals(""))
		{
			try
			{
				int MinBookingInterval = Integer.parseInt(minBookingInterval);
				if(MinBookingInterval < 0)
				{
					throw new MinBookingIntervalInvalidException("A facilities minimum booking interval must be entered in minute format.<br />Therefore they cannot be a negative numbers.");
				}
			}
			catch(NumberFormatException nfe)
			{
				throw new MinBookingIntervalInvalidException("A facilities minimum booking interval must be in an number format.");
			}
		}
		
		if(minBookingTime != null && !minBookingTime.equals(""))
		{
			try
			{
				int MinBookingTime = Integer.parseInt(minBookingTime);
				if(MinBookingTime < 0)
				{
					throw new MinBookingTimeInvalidException("A facilities minimum booking time must be enetered in minute format.<br />Therefore they must not be a negative numbers.");
				}
			}
			catch(NumberFormatException nfe)
			{
				throw new MinBookingTimeInvalidException("A facilities minimum booking time must be in an number format.");
			}
		}
		
		return true;
	}
	
	/**
	 * Validates all fields of an facility object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param facility the facility object to validate
	 * @return true/false if the object is valid.
	 * @throws CostInvalidException is thrown if it is <0 number
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws MinBookingTimeInvalidException  is thrown if it is null or is not in a minute format
	 * @throws MinBookingIntervalInvalidException is thrown if it is not in the proper number format
	 * @throws MaxCapacityInvalidException is thrown if it is null or if it is not a positive number
	 * @throws TearDownTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws SetupTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws CloseTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 * @throws OpenTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 */
	public boolean validate(Facility facility) throws NameInvalidException, DatabaseConnectionException, OpenTimeInvalidException, CloseTimeInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, MaxCapacityInvalidException, MinBookingIntervalInvalidException, MinBookingTimeInvalidException
	{
		return validate(new Integer(facility.getOpenTime()).toString(), 
				new Integer(facility.getCloseTime()).toString(), 
				new Integer(facility.getSetupTime()).toString(), 
				new Integer(facility.getTearDownTime()).toString(), 
				facility.getName(), facility.getRates(), facility.getAdditionalCharges(), 
				new Integer(facility.getMaxCapacity()).toString(), 
				new Integer(facility.getMinBookingInterval()).toString(), 
				new Integer(facility.getMinBookingTime()).toString());
	}

	/**
	 * Searches for specific information and returns facilities
	 * @param query searches database based on query and returns specified information
	 * @return a List of facility objects that contain the search string.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Facility> search(String query) throws DatabaseConnectionException {
		return fb.search(query);
	}

	/**
	 * Validates all fields for facility to ensure that all fields are not null.
	 * If a field is null a appropriate exception will be thrown
	 * If id exists, invoice table is updated, if id != exist than information is 
	 * inserted into Invoice table
	 * @return true/false if the object was saved.
	 * @throws CostInvalidException is thrown if it is <0 number
	 * @throws NumberFormatException is thrown if it is not in the proper numberFormat
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws MinBookingTimeInvalidException  is thrown if it is null or is not in a minute format
	 * @throws MinBookingIntervalInvalidException is thrown if it is not in the proper number format
	 * @throws MaxCapacityInvalidException is thrown if it is null or if it is not a positive number
	 * @throws TearDownTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws SetupTimeInvalidException is thrown if it is null, is a negative number or is not in the proper
	 * number format
	 * @throws CloseTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 * @throws OpenTimeInvalidException is thrown if it is null, is <0, >24 or not in the proper
	 * number format
	 */
	public boolean save(int id, String openTime, String closeTime, String setupTime, String tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			String maxCapacity, String minBookingInterval, String minBookingTime) throws NameInvalidException, DatabaseConnectionException, OpenTimeInvalidException, CloseTimeInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, MaxCapacityInvalidException, MinBookingIntervalInvalidException, MinBookingTimeInvalidException 
	{
		Facility facility = null;
		
		if(this.validate(openTime, closeTime, setupTime, tearDownTime, name, rates, additionalCharges, maxCapacity, minBookingInterval, minBookingTime))
			facility = new Facility(id, Integer.parseInt(openTime), Integer.parseInt(closeTime), Integer.parseInt(setupTime), Integer.parseInt(tearDownTime), name, rates, additionalCharges, Integer.parseInt(maxCapacity), Integer.parseInt(minBookingInterval), Integer.parseInt(minBookingTime));
		
		return fb.persist(facility);
	}

	/**
	 * Deletes information from facility table where facility_id = facility_getId
	 * If Id does not exist a exception will be thrown
	 * @param facility the facility object to validate and remove from database
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean remove(Facility facility) throws DatabaseConnectionException
	{
		return fb.remove(facility);
	}
	
	/**
	 * Closes Database connection
	 */
	public void close() {
		fb.close();
	}
	
	/**
	 * Updates resultSet, returns facilities
	 * @return updated resultSet
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Facility> getFacilityList() throws DatabaseConnectionException
	{
		return fb.getFacilityList();
	}
	
	/**
	 * Gets all information related to the passed facility id
	 * @param facility_id the id of the facility to retrieve information for
	 * @return a Facility containing all information found
	 * @throws DatabaseConnectionException
	 */
	public Facility getFacilityInfo(int facility_id) throws DatabaseConnectionException
	{
		return fb.getFacilityInformation(facility_id);
	}

	/**
	 * Gets the current Broker instance
	 * Throws appropriate exception if a error occurs
     * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @see HttpServlet#HttpServlet()
     */
    public FacilityManager() throws DatabaseConnectionException {
		fb = FacilityBroker.getBroker();
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
