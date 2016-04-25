/**
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.DatabaseConnectionException;
import problemDomain.ToDoItem;

/**
 * @author John Stuby
 * 
 */
public class ToDoItemBroker {	
	
	private static ToDoItemBroker broker;
	
	private ToDoItemBroker()  {
		
	}
	/**
	 * Closes database connection
	 * 
	 */
	public void close() {
		
		broker = null;
	}
	
	/**
	 * Gets all information from Database for that table
	 * @return list of requested toDoItem
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public List<ToDoItem> getToDoItemList() throws DatabaseConnectionException {
		String query = "SELECT * FROM toDoItem";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		try {
			while (result.next()) {

				ToDoItem toDoItem = new ToDoItem(result.getDate("date"), result.getString("name"), result.getString("description"));

				toDoItems.add(toDoItem);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toDoItems;
	}
	/**
	 * If id exists information in toDoItem table is updated
	 * If id != exist information is inserted into toDoItem table
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean persist(Object o) throws DatabaseConnectionException {
		ToDoItem toDoItem = (ToDoItem) o;
		String query;

		Connection con = Database.connect();
		if (toDoItem.getId() != -1) {
			query = "UPDATE toDoItem SET date='" + toDoItem.getDate() + "'name='" + toDoItem.getName() + "',description='" + toDoItem.getDescription() + "'";
			Database.update(query, con);

		} else {
			query = "INSERT INTO toDoItem VALUES('" + 0 + "', '" + toDoItem.getDate() + "', '" + toDoItem.getName() + "', '" + toDoItem.getDescription() + "')";
			Database.update(query, con);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Deletes information from toDoItem table where toDoItem_id = toDoItem.getId
	 * If id does not exist a exception will be thrown.
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 * 
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		ToDoItem toDoItem = (ToDoItem) o;
		String query;

		query = "DELETE FROM toDoItem WHERE toDoItem_id='" + toDoItem.getId() + "'";
		Connection con = Database.connect();
		Database.update(query, con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Gets the broker instance
	 * @return The current broker instance
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public static ToDoItemBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new ToDoItemBroker();
		}
		return broker;
	}
	/**
	 * Gets all required information and adds it to resultSet
	 * @param id is the id for the toDoItem
	 * @return An resultSet for requested toDoItem
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public ToDoItem getToDoItemInformation(int id) throws DatabaseConnectionException {
		String query = "SELECT * FROM toDoItem WHERE toDoItem_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		ToDoItem tdi = null;

		try {
			while (result.next()) {

				String name = result.getString("name");
				Date date = result.getDate("date");
				String description = result.getString("description");

				tdi = new ToDoItem(id, date, name, description);
			}
			result.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tdi;
	}
	
	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to search than returns a list
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<ToDoItem> search(String searchText) throws DatabaseConnectionException
	{
		String query = "SELECT todoitem_id, name, description, date FROM toDoItem WHERE name LIKE '%" 
			+ searchText +"%' OR date='" + searchText + "'" ;
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		if(result != null){
			try {
				while (result.next()) {
					ToDoItem toDoItem = new ToDoItem(result.getInt("todoitem_id"), result.getDate("date"), result.getString("name"), result.getString("description"));
					toDoItems.add(toDoItem);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return toDoItems;	
	}
	
}
