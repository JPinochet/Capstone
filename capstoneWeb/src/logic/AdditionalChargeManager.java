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

import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;

import persistence.AdditionalChargeBroker;
import problemDomain.AdditionalCharge;

/**
 * AdditionalChargeManager provides an interface for the GUI to interact with 
 * the AdditionalChargeBroker.  It is also an implementation of a HttpServlet
 * that will process any get and post requests from the GUI.
 */
public class AdditionalChargeManager extends HttpServlet {
	private static final long serialVersionUID = -8375755279208459370L;
	
	AdditionalChargeBroker acb;
	
	/**
	 * Processes all GET and POST requests to the HttpServlet
	 * @param request
	 * @param response
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("q") != null) {
			try {
				PrintWriter out = response.getWriter();
				List<AdditionalCharge> acs = search(request.getParameter("q"));
			 
			    Iterator<AdditionalCharge> iterator = acs.iterator();
			    while(iterator.hasNext()) {
			    	AdditionalCharge ac = iterator.next();
			        out.println(ac.getName());
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
			if(doRequest.equals("searchAC"))
			{
				if(request.getParameter("search") != null) 
				{
					try 
					{
						session.setAttribute("searchResultsAC", search(request.getParameter("searchText")));  //TODO:Need to differentiate between rate, ac, and bt search results
					} 
					catch (DatabaseConnectionException e) 
					{
						//TODO: ERROR MESSAGE
						e.printStackTrace();
					}
				}
				else if(request.getParameter("reset") != null) 
				{
					session.setAttribute("searchResultsAC", null);//TODO:Need to differentiate between rate, ac, and bt search results
				}
			} 
			else if(doRequest.equals("manage")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String cost = request.getParameter("cost");
				
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						AdditionalCharge ac = new AdditionalCharge();
						ac.setId(id);					
						if(!this.remove(ac)) {
							//TODO: Error message
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();//TODO: Error message
					}
				} else if(request.getParameter("save") != null) { //We are saving an existing client or creating a new one
					try {					
						if(!this.save(id, name, cost)) {
							System.out.println("not saved?"); //TODO: Error message
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();//TODO: Error message
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CostInvalidException e) {
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
				e.printStackTrace();//TODO: Error message
			}
		}
	}
	
	
	/**
	 * Validates all information contained passed to the method to ensure it properly conforms with all business requirements
	 * and database storage limitations. 
	 * @param acName - the name of the AdditionalCharge to validate
	 * @param cost - the cost of the AddtionalCharge to validate
	 * @return true if validation is successful. An appropriate exception is thrown otherwise
	 * @throws CostInvalidException - when the provided AddtionalCharges cost cannot be parsed to a double, is 
	 * 			less than 0.0, or is not specified.
	 * @throws NameInvalidException - when the provided AddtionalCharges name is longer than 25 characters, 
	 * 			or is not provided
	 */
	public boolean validate(String acName, String cost) throws CostInvalidException, NameInvalidException {
		if (acName == null || acName.equals(""))
			throw new NameInvalidException("An Additional Charge must have a name to identify it.");
		if (acName.length() > 25)
			throw new NameInvalidException("Additional Charge name cannot excede 25 characters.");

		if (cost == null || cost.equals(""))
			throw new CostInvalidException("An additional charge must have a cost.");
		
		try {
			Double acCost = Double.parseDouble(cost);

			if (acCost < 0)
				throw new CostInvalidException("Cost cannot be negative.");
		} catch (NumberFormatException nfe) {
			throw new CostInvalidException("The additional charge cost must be a number.");
		}

		return true;
	}
	
	
	/**
	 * Validates all information contained in an AdditionalCharge to ensure it properly conforms with all business requirements
	 * and database storage limitations. 
	 * @param ac - the AdditionalCharge containing the information to validate.
	 * @return true if validation is successful. An appropriate exception is thrown otherwise
	 * @throws CostInvalidException - when the provided AddtionalCharges cost cannot be parsed to a double, is 
	 * 			less than 0.0, or is not specified.
	 * @throws NameInvalidException - when the provided AddtionalCharges name is longer than 25 characters, 
	 * 			or is not provided
	 */
	public boolean validate(AdditionalCharge ac) throws CostInvalidException, NameInvalidException {
		return validate(ac.getName(), new Double(ac.getCost()).toString());
	}
	
	/**
	 * Searches the database for any AdditionalCharges that match the query provided. The search is executed 
	 * through the AdditionalChargeBroker 
	 * @param query the string to search all AdditionalCharges for.
	 * @return a List containing all AdditionalCharges that match the search query provided.
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public List<AdditionalCharge> search(String query) throws DatabaseConnectionException {
		return acb.search(query);
	}

	
	/**
	 * Validates, then persists the AdditionalCharge information passed to the database 
	 * through the AdditionalChargeBroker.
	 * @param id - the id of the AdditionalCharge. If creating a new AdditonalCharge this 
	 * 			should be 0, otherwise it is set to the id of the AdditionalCharge to
	 * 			update.
	 * @param acName - the name of the AdditionalCharge
	 * @param acCost - the cost of the AdditionalCharge
	 * @return true if the AddtionCharge is successfully saved to the database. 
	 * 			Throws an appropriate exception otherwise.
	 * @throws CostInvalidException - when the provided acCost cannot be parsed to a double, is 
	 * 			less than 0.0, or is not specified.
	 * @throws NameInvalidException - when the provided acName is longer than 25 characters, 
	 * 			or is not provided
	 * @throws DatabaseConnectionException - if a connection to the database cannot be established 
	 */
	public boolean save(int id, String acName, String acCost) throws CostInvalidException, NameInvalidException, DatabaseConnectionException {
		
		AdditionalCharge ac = null;
		
		if(this.validate(acName, acCost))
			ac = new AdditionalCharge(id, acName, Double.parseDouble(acCost));
		
		return acb.persist(ac);
	}

	
	/**
	 * Removes the AdditionalCharge passed from the database through the AdditionalChargeBroker.
	 * @param ac - the AdditionalCharge that is to be removed from the database. Only the id is needed to be set 
	 * 				in order to perform this operation.
	 * @return true if the AdditionalCharge is successfully removed from the database. If the AdditionalCharge
	 * 			cannot be removed from the database an exception will be thrown.
	 * @throws DatabaseConnectionException - if a connection to the database cannot be established 
	 */
	public boolean remove(AdditionalCharge ac) throws DatabaseConnectionException
	{
		return acb.remove(ac);
	}
	
	/**
	 * Closes the current AdditionalChargeBroker instance
	 */
	public void close() {
		acb.close();
	}
	
	/**
	 * Retrieves all AdditionalCharges that exist in the database through the AdditionalChargeBroker.
	 * @return a list of all AdditionalCharges that exist
	 * @throws DatabaseConnectionException if a connection to the database cannot be established 
	 */
	public List<AdditionalCharge> getAdditionalChargeList() throws DatabaseConnectionException
	{
		return acb.getAdditionalChargeList();
	}
       
	
	/**
	 * Performs a query through the AdditionalChargeBroker to determine all related AdditionalCharge information related
	 * to the passed additional_charge_id. If the passed additional_charge_id does not exist in the database, a null value 
	 * will be returned.
	 * @param additional_charge_id  - The id of the AdditionalCharge to look up
	 * @return an AdditionalCharge containing any information related to the additional_charge_id passed<br />
	 * 			null if no AdditionalCharge exists with the passed additional_charge_id
	 * @throws DatabaseConnectionException - if a connection to the database cannot be established 
	 */
	public AdditionalCharge getAdditionalChargeInfo (int additional_charge_id) throws DatabaseConnectionException
	{
		return (AdditionalCharge) acb.getAdditionalChargeInformation(additional_charge_id);
	}
	
    /**
     * Constructor for the AdditionalChargeManager.
     * Gets the current instance of the AdditionalChargeBroker class for use 
     * in any database interactions.
     */
    public AdditionalChargeManager(){
		acb = AdditionalChargeBroker.getBroker();
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
