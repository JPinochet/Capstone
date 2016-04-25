/**
 * 
 */
package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;

import persistence.ToDoItemBroker;
import problemDomain.ToDoItem;

/**
 * @author 432873
 * 
 */
public class ToDoItemManager extends HttpServlet {
	private static final long serialVersionUID = -5195542824086927738L;
	
	/**
	 * Initializes ToDoItemBroker instance
	 */
	ToDoItemBroker tb;
	
	/**
	 * Calls HttpServletRequest and HttpServletResponse
	 * Iterates through ToDoItem
	 * If an error occurs the appropriate exception will be thrown
	 * @param request is the request that is called
	 * @param response is the response that is returned
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("q") != null) {
			try {
				PrintWriter out = response.getWriter();
				List<ToDoItem> todoItems = search(request.getParameter("q"));
			 
			    Iterator<ToDoItem> iterator = todoItems.iterator();
			    while(iterator.hasNext()) {
			    	ToDoItem todoItem = iterator.next();
			        out.println(todoItem.getName() + " " + todoItem.getDescription());
			    }
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (DatabaseConnectionException e) {
				e.printStackTrace();
			}
		}
		
		HttpSession session = request.getSession();
		String doRequest = request.getParameter("do");
		if(doRequest != null) {
			if(doRequest.equals("search")){
				if(request.getParameter("search") != null) {
					try {
						session.setAttribute("searchResults", search(request.getParameter("searchText")));
					} catch (DatabaseConnectionException e) {
						//TODO: ERROR MESSAGE
						e.printStackTrace();
					}
				}else if(request.getParameter("reset") != null) {
					session.setAttribute("searchResults", null);
				}
			} else if(doRequest.equals("manage")) {
				int id = Integer.parseInt(request.getParameter("todoitem_id"));
				String name = request.getParameter("name");
				String description = request.getParameter("description");
				String date = request.getParameter("date");
				
				if(request.getParameter("delete") != null && id != 0) {
					try {
						ToDoItem todoItem = new ToDoItem();
						todoItem.setId(id);					
						if(!this.remove(todoItem)) {
							//TODO: Error message
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();//TODO: ERROR MESSAGE
					}
				} else if(request.getParameter("save") != null) { //We are saving an existing client or creating a new one
					try {					
						if(!this.save(id, name, description, date)) {
							System.out.println("not saved?");//TODO: ERROR MESSAGE
						}
					} catch (DatabaseConnectionException e) {
						e.printStackTrace();//TODO: ERROR MESSAGE
					} catch (NameInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DescriptionInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DateInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Validates all fields of an toDoItem object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param ToDoName is the toDoName for the ToDoItem
	 * @param ToDoDescription is the toDoDescription for the ToDoItem
	 * @param ToDoDate is the ToDoDate for the ToDoItem
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DateInvalidException is thrown if date is null or is in the past
	 */
	public boolean validate(String ToDoName, String ToDoDescription, String ToDoDate) throws NameInvalidException, DescriptionInvalidException, DateInvalidException
	{
		if(ToDoName == null || ToDoName.equals(""))
			throw new NameInvalidException("An Additional Charge must have a name to identify it.");
		if(ToDoName.length() > 30)
			throw new NameInvalidException("Additional Charge name cannot excede 30 characters.");
		if(ToDoDescription != null && !ToDoDescription.equals(""))
			if(ToDoDescription.length() > 400)
				throw new DescriptionInvalidException("An additional charge description cannot excede 400 characters.");
		if(ToDoDate != null && !ToDoDate.equals(""))
			if(new Date(ToDoDate).before(new Date()))
				throw new DateInvalidException("A new item cannot be listed for a past date/time.");
		return true;
	}
	
	/**
	 * Validates all fields of an toDoitem object to ensure that the fields can be committed
	 * to the database without error and users correctly inputed information for each field.
	 * If a field is not valid a appropriate exception will be thrown
	 * @param todo holds all information required by the toDo
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DateInvalidException is thrown if date is null or is in the past
	 */
	public boolean validate(ToDoItem todo) throws NameInvalidException, DescriptionInvalidException, DateInvalidException
	{
		return this.validate(todo.getName(), todo.getDescription(), todo.getDate().toString());
	}

	/**
	 * Searches the DB for matching toDoItems
	 * @param query searches database based on query and returns specified information
	 * @return a List of facility objects that contain the search string. 
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<ToDoItem> search(String query) throws DatabaseConnectionException
	{
		return tb.search(query);
	}

	/**
	 * Validates toDoName, toDoDescription to ensure they meet all criteria
	 * Checks toDoDate to ensure that it is not null, if it is a exception will be thrown
	 * Persist: will persist the supplied item into the DB
	 * @param ToDoName is the toDoName for the ToDoItem
	 * @param ToDoDescription is the toDoDescription for the ToDoItem
	 * @param ToDoDate is the ToDoDate for the ToDoItem
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DateInvalidException is thrown if date is null or is in the past
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean save(int id, String ToDoName, String ToDoDescription, String ToDoDate) throws NameInvalidException, DescriptionInvalidException, DatabaseConnectionException, DateInvalidException
	{
		ToDoItem tdi = null;
		
		if(this.validate(ToDoName, ToDoDescription, ToDoDate))
			tdi = new ToDoItem(id, new Date(ToDoDate), ToDoName, ToDoDescription);
			
		return tb.persist(tdi);
	}
	
	/**
	 * HttpServletRequest and HttpServletResponse checks toDoName and toDoDescription
	 * to ensure they meet all criteria, checks toDoDate to ensure it is not null. 
	 * If toDoDate is null a exception will be thrown.
	 * persists the supplied object into the DB
	 * @param todo holds all information required by the toDo
	 * @return true/false if the object is valid.
	 * @throws NameInvalidException is thrown if it is null or has >30 characters
	 * @throws DescriptionInvalidException is thrown if it is null or has >400 characters
	 * @throws DateInvalidException is thrown if date is null or is in the past
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean save(ToDoItem todo) throws NameInvalidException, DescriptionInvalidException, DatabaseConnectionException, DateInvalidException
	{
		if(this.validate(todo))
			return tb.persist(todo);
		
		return false;
	}

	/**
	 * Deletes information from toDoItem table where toDoItem_id = toDoItem_getId
	 * If id does not exist a exception will be thrown
	 * @param todo holds all information required by the toDo
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public boolean remove(ToDoItem todo) throws DatabaseConnectionException
	{
		return tb.remove(todo);
	}
	
	/**
	 * Closes the database connection
	 */
	public void close() {
		tb.close();
	}
	
	/**
	 * Gets all information from toDoItem table in database
	 * @return all information for toDoItem table in a list format
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<ToDoItem> getAll() throws DatabaseConnectionException
	{
		return tb.getToDoItemList();
	}
	
	
	/**
	 * Gets toDoItemBroker instance, if an occurs exception will be thrown.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public ToDoItemManager () throws DatabaseConnectionException
	{
		super();
		tb = ToDoItemBroker.getBroker();
	}
	
	/**
	 * Gets HttpServletRequest and HttpServletResponse, throws exceptions if error 
	 * occurs
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Posts HttpServletRequest and HttpServletResponse, throws
	 * exceptions if error 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
