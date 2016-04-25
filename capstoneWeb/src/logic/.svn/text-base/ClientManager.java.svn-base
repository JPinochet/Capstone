package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.ClientBroker;
import problemDomain.Client;
import problemDomain.Organization;
import exceptions.*;

/**
 * Servlet implementation class ClientManager
 */
public class ClientManager extends HttpServlet {
	private static final long serialVersionUID = 6657441942826379517L;
	
	/**
	 * Initializes ClientBroker instance
	 */
	ClientBroker clb;

	/**
	 * Calls HttpServletRequest and HttpServletResponse
	 * Iterates through Client
	 * If an error occurs the appropriate exception will be thrown
	 * @param request is the request that is called
	 * @param response is the response that is returned
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("q") != null) {
			try {
				PrintWriter out = response.getWriter();
				List<Client> clients;
				try {
					clients = search(request.getParameter("q"));
					 
				    Iterator<Client> iterator = clients.iterator();
				    while(iterator.hasNext()) {
				    	Client client = iterator.next();
				        out.println(client.getGivenName() + " " + client.getSurname());
				    }
				} catch (DatabaseConnectionException e) {
					out.println("Could not connect to database");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(request.getParameter("reset") != null) {
					session.setAttribute("searchResults", null);
				}
			} else if(doRequest.equals("manage")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String givenName = request.getParameter("givenName");
				String surname = request.getParameter("surname");
				String email = request.getParameter("email");
				String address = request.getParameter("street");
				String city = request.getParameter("city");
				String province = request.getParameter("prov");
				String postalCode = request.getParameter("postalCode");
				String country = request.getParameter("country");
				String discount = request.getParameter("discount");
				String password = "";
				String homePhone = request.getParameter("homePhone");
				String cellPhone = request.getParameter("cellPhone");
				String workPhone = request.getParameter("workPhone");
				ArrayList<Organization> organizations = new ArrayList<Organization>();
				if(request.getParameter("orgs") != null) {
					for(int i=0; i < request.getParameterValues("orgs").length; i++) {
						Organization org = new Organization(Integer.parseInt(request.getParameterValues("orgs")[i]), "");
						organizations.add(org);
					}
				}
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						Client client = new Client();
						client.setId(id);					
						if(!this.remove(client)) {
							error = "?error=main&message=Could not remove client";
						}
					} catch (DatabaseConnectionException e) {
						error = "?error=main&message="+e.getMessage();
					}
				} else if(request.getParameter("save") != null) { 
					//We are saving an existing client or creating a new one
					ArrayList<String> errorText = new ArrayList<String>();
					errorText.add(id+"");
					errorText.add(givenName);
					errorText.add(surname);
					errorText.add(email);
					errorText.add(address);
					errorText.add(city);
					errorText.add(province);
					errorText.add(country);
					errorText.add(postalCode);
					errorText.add(discount);
					errorText.add(password);
					errorText.add(homePhone);
					errorText.add(workPhone);
					errorText.add(cellPhone);
					try {					
						this.save(id, givenName, surname, email, address, city, province, country, postalCode, discount, password, homePhone, workPhone, cellPhone, organizations);
					} catch (DatabaseConnectionException e) {
						error = "?error=main&message="+e.getMessage();
					} catch (PostalCodeInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "postalCode");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (GivenNameInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "givenName");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (SurnameInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "surname");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (AddressInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "street");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (EmailInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "email");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (CityInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "city");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (CountryInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "country");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (ProvinceInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "prov");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (DiscountInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "discount");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (HomePhoneInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "homePhone");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (WorkPhoneInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "workPhone");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					} catch (CellPhoneInvalidException e) {
						error = "?error=info";
						session.setAttribute("errorMessage", e.getMessage());
						session.setAttribute("errorField", "cellPhone");
						session.setAttribute("errorText", errorText);
						session.setAttribute("orgs", organizations);
					}
				}
			}try {
				response.sendRedirect("ClientWindow.jsp"+error);
			} catch (IOException e) {}
		}
	}
	
	/**
	 * Validates all fields of an client object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param c client this is a client to validate
	 * @return true/false if the object is valid.
	 * @throws PostalCodeInvalidException is thrown if >6 characters, ==6 & !valid or ==5 digits 
	 * @throws GivenNameInvalidException is thrown if it is null or has >65 characters
	 * @throws SurnameInvalidException is thrown if it is null or has >63 characters
	 * @throws AddressInvalidException is thrown if it is null or has >75 characters
	 * @throws EmailInvalidException is thrown if it is null or has >50 characters
	 * @throws CityInvalidException is thrown if it is null or has >75 characters
	 * @throws CountryInvalidException is thrown if it is null or has >25 characters
	 * @throws ProvinceInvalidException is thrown if it is null or has >2 characters
	 * @throws DiscountInvalidException is thrown if it is null, >3 characters, > 100% 
	 * discount or <0% discount
	 * @throws HomePhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws WorkPhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws CellPhoneInvalidException is thrown if it is null or has >10 characters
	 */
	public boolean validate(Client c) throws PostalCodeInvalidException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, ProvinceInvalidException, DiscountInvalidException, HomePhoneInvalidException, WorkPhoneInvalidException, CellPhoneInvalidException {
		return validate(c.getGivenName(), c.getSurname(), c.getEmail(), c.getAddress(), c.getCity(), c.getProvince(),
						c.getCountry(), c.getPostalCode(), new Integer(c.getDiscount()).toString(), c.getPassword(), c.getHomePhone(),
						c.getWorkPhone(), c.getCellPhone(), c.getOrganization());						
	}
	
	/**
	 * Validates all fields of an client object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param givenName is a givenName for the client
	 * @param surname is a surname for the client
	 * @param email is a email for the client
	 * @param address is a email for the client
	 * @param city is a id city the client
	 * @param province is a province for the client
	 * @param country is a country for the client
	 * @param postalCode is a postalCode for the client
	 * @param discount is a discount for the client
	 * @param password is a password for the client
	 * @param homePhone is a homePhone for the client
	 * @param workPhone is a workPhone for the client
	 * @param cellPhone is a cellPhone for the client
	 * @param organizations is a organizations for the client
	 * @return true/false if the object is valid.
	 * @throws PostalCodeInvalidException is thrown if >6 characters, ==6 & !valid or ==5 digits 
	 * @throws GivenNameInvalidException is thrown if it is null or has >65 characters
	 * @throws SurnameInvalidException is thrown if it is null or has >63 characters
	 * @throws AddressInvalidException is thrown if it is null or has >75 characters
	 * @throws EmailInvalidException is thrown if it is null or has >50 characters
	 * @throws CityInvalidException is thrown if it is null or has >75 characters
	 * @throws CountryInvalidException is thrown if it is null or has >25 characters
	 * @throws ProvinceInvalidException is thrown if it is null or has >2 characters
	 * @throws DiscountInvalidException is thrown if it is null, >3 characters, > 100% 
	 * discount or <0% discount
	 * @throws HomePhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws WorkPhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws CellPhoneInvalidException is thrown if it is null or has >10 characters
	 */
	public boolean validate(String givenName, String surname, String email,
			String address, String city, String province, String country,
			String postalCode, String discount, String password, String homePhone,
			String workPhone, String cellPhone, ArrayList<Organization> organizations) throws PostalCodeInvalidException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, ProvinceInvalidException, DiscountInvalidException, HomePhoneInvalidException, WorkPhoneInvalidException, CellPhoneInvalidException
	{
		if(givenName == null || givenName.equals(""))
			throw new GivenNameInvalidException("A client must have a given name.");
		if(givenName.length() > 45)
			throw new GivenNameInvalidException("A client's given name cannot excede 45 characters.");
		if(surname == null || surname.equals(""))
			throw new SurnameInvalidException("A client must have a surname.");
		if(surname.length() > 63)
			throw new SurnameInvalidException("A client's surname cannot excede 63 characters.");
		if(address != null && !address.equals(""))
			if(address.length() > 75)
				throw new AddressInvalidException("A client's address cannot excede 75 characters.");
		if(email == null || email.equals(""))
			throw new EmailInvalidException("A client must have an email.<br />This allows them to view their account online.");
		if(email.length() > 50)
			throw new EmailInvalidException("A client's email address cannot excede 50 characters.");
		if(!validateEmail(email))
			throw new EmailInvalidException("The email entered is invalid.<br />The correct format is example@domain.com");
		if(city != null && !city.equals(""))
			if(city.length() > 75)
				throw new CityInvalidException("A client's city name cannot excede 75 characters.");
		if(country != null && !country.equals(""))
			if(country.length() > 25)
				throw new CountryInvalidException("A client's country name cannot excede 25 characters.");
		if(province != null && !province.equals(""))
			if(province.length() > 2)
				throw new ProvinceInvalidException("A client's province name cannot excede 2 characters, remember you abbreiviate it.");
		if(postalCode != null && !postalCode.equals(""))
		{
			if(postalCode.length() > 6)
				throw new PostalCodeInvalidException("A client's postal code cannot excede 6 characters.");
			
			if(postalCode.length() == 6)
				if(!validatePostalCode(postalCode))
					throw new PostalCodeInvalidException("The postal code entered is invalid.<br />Correct Format X1X1X1");
			
			if(postalCode.length() == 5)
			{
				try
				{
					if(!Double.isNaN(Integer.parseInt(postalCode)))
						throw new PostalCodeInvalidException("The zip code entered in is not in the correct format.<br />Correct Format 12345");
				}
				catch(NumberFormatException nfe)
				{
					throw new PostalCodeInvalidException("Invalid Zip Code format or missing a character in Postal Code.");
				}
					
			}
		}
		
		if(discount != null && !discount.equals(""))
		{
			try
			{
				if(discount.length() > 3)
					throw new DiscountInvalidException("A client discount cannot excede 3 characters as a percentage. % symbol not required.");
				
				if(Integer.parseInt(discount) > 100 )
					throw new DiscountInvalidException("A client discount cant exceed 100%.");
				if(Integer.parseInt(discount) < 0 )
					throw new DiscountInvalidException("A client discount cant be below 0%.");
			}
			catch(NumberFormatException nfe)
			{
				throw new DiscountInvalidException("A client discount must be in a number format.");
			}
		}
		
		if(homePhone != null && !homePhone.equals("")) {
			if(homePhone.length() != 10)
				throw new HomePhoneInvalidException("A phone number must be 10 digits long.");
			try {
				Double.parseDouble(homePhone);
			} catch (NumberFormatException e) {
				throw new HomePhoneInvalidException("A phone number must be a number.<br />For example: 1234567890");
			}
		}
		
		if(workPhone != null && !workPhone.equals("")) {
			if(workPhone.length() != 10)
				throw new WorkPhoneInvalidException("A phone number must be 10 digits long.");
			try {
				Double.parseDouble(workPhone);
			} catch (NumberFormatException e) {
				throw new WorkPhoneInvalidException("A phone number must be a number.<br />For example: 1234567890");
			}			
		}
		
		if(cellPhone != null && !cellPhone.equals("")) {
			if(cellPhone.length() != 10)
				throw new CellPhoneInvalidException("A phone number must be 10 digits long.");
			try {
				Double.parseDouble(cellPhone);
			} catch (NumberFormatException e) {
				throw new CellPhoneInvalidException("A phone number must be a number.<br />For example: 1234567890");
			}			
		}
		
		return true;
	}
	
	/**
	 * Checks email to ensure that it is in the proper format
	 * @param email that is validated
	 * @return
	 */
	private boolean validateEmail(String email)
	{
		//Set the email pattern string
		

	      Pattern p = Pattern.compile("^[^@]+@[^@]+$");

	      //Match the given string with the pattern
	      Matcher m = p.matcher(email);

	      //check whether match is found 
	      return m.matches();
	      
	}
	
	/**
	 * Checks postalCode and ensures that it is in the proper postalCode format
	 * @param postalCode this is postalCode to validate
	 * @return boolean
	 */
	private boolean validatePostalCode(String postalCode)
	{
		Pattern p = Pattern.compile("^([A-Z][0-9][A-Z])([0-9][A-Z][0-9])$");
		
		Matcher m = p.matcher(postalCode);
		
		return m.matches();
	}
	
	/**
	 * Gets needed information from Client table in Database and creates a new client
	 * to add to a client table
	 * @return ClientList returns selected clientList
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Client> getClientList() throws DatabaseConnectionException {
		return clb.getClientList();		
	}
	
	/**
	 * Closes Database connection
	 * @throws SQLException 
	 */
	public void close() throws SQLException {
		clb.close();
	}
	
	/**
	 * Validates all fields for id, givenName, surname, email, address, city, province,
	 * country, postalCode, discount, password, homePhone, workPhone, cellPhone, 
	 * organizations to ensure that all fields are valid.
	 * If a field is not valid a appropriate exception will be thrown
	 * If id exists, Client table is updated, if id != exist than information is 
	 * inserted into Client table
	 * @param id is the id for the client
	 * @param givenName is the givenName for the client
	 * @param surname is the surname for the client
	 * @param email is the email for the client
	 * @param address is the email for the client
	 * @param city is the city for the client
	 * @param province is the province for the client
	 * @param country is the country for the client
	 * @param postalCode is the postalCode for the client
	 * @param discount is the discount for the client
	 * @param password is the password for the client
	 * @param homePhone is the homePhone for the client
	 * @param workPhone is the workPhone for the client
	 * @param cellPhone is the cellPhone for the client
	 * @param organizations is the organizations for the client
	 * @return updated list for client
	 * @throws PostalCodeInvalidException is thrown if >6 characters, ==6 & !valid or ==5 digits 
	 * @throws GivenNameInvalidException is thrown if it is null or has >65 characters
	 * @throws SurnameInvalidException is thrown if it is null or has >63 characters
	 * @throws AddressInvalidException is thrown if it is null or has >75 characters
	 * @throws EmailInvalidException is thrown if it is null or has >50 characters
	 * @throws CityInvalidException is thrown if it is null or has >75 characters
	 * @throws CountryInvalidException is thrown if it is null or has >25 characters
	 * @throws ProvinceInvalidException is thrown if it is null or has >2 characters
	 * @throws DiscountInvalidException is thrown if it is null, >3 characters, > 100% 
	 * discount or <0% discount
	 * @throws HomePhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws WorkPhoneInvalidException is thrown if it is null or has >10 characters
	 * @throws CellPhoneInvalidException is thrown if it is null or has >10 characters
	 */
	public boolean save(int id, String givenName, String surname, String email,
			String address, String city, String province, String country,
			String postalCode, String discount, String password, String homePhone,
			String workPhone, String cellPhone, ArrayList<Organization> organizations) throws PostalCodeInvalidException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, ProvinceInvalidException, DiscountInvalidException, DatabaseConnectionException, HomePhoneInvalidException, WorkPhoneInvalidException, CellPhoneInvalidException {
		Client client = null;
		
		if(this.validate(givenName, surname, email, address, city, province, country, postalCode, discount, password, homePhone, workPhone, cellPhone, organizations)) {
			client = new Client(id, givenName, surname, email, address, city, province, country, postalCode, Integer.parseInt(discount), password, homePhone, workPhone, cellPhone, organizations);
			return clb.persist(client);
		}
		return false;
	}

	/**
	 * Removes the supplied object from the database
	 * @param client this is a variable that holds client information to remove from the
	 * database
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean remove(Client client) throws DatabaseConnectionException 
	{
		return clb.remove(client);
	}
	
	/**
	 * Gets organization broker and adds a new client to organization
	 * @param id is a id for the client
	 * @return clientInformation based on id
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public Client getClientInfo(int id) throws DatabaseConnectionException {
		return clb.getClientInformation(id);
	}
	
	/**
	 * Sends a message to the database to search for requested information, and returns
	 * information in a list format.
	 * @param query passes message along to database to search than returns a list
	 * @return List with all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * @throws SQLException 
	 */
	public List<Client> search(String query) throws DatabaseConnectionException, SQLException {
		return clb.search(query);
	}
	
	//SERVLET METHODS BELOW- SHOULD NEVER NEED TO EDIT THESE
       
    /**
     * Gets the broker instance
     * @throws DatabaseConnectionException  is thrown if DB connection fails
     * @see HttpServlet#HttpServlet()
     */
    public ClientManager() throws DatabaseConnectionException {
		clb = ClientBroker.getBroker();
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
