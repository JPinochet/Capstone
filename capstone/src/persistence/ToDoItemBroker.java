/**
 * 
 */
package persistence;

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
public class ToDoItemBroker implements Broker {

	private Database db = new Database();
	private static ToDoItemBroker broker;

	/**
	 * @throws DatabaseConnectionException 
	 * 
	 */
	private ToDoItemBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
	}

	public void close() {
		db.close();
		broker = null;
	}

	public List<ToDoItem> getAll() {
		String query = "SELECT * FROM toDoItem";
		ResultSet result = db.select(query);
		ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
		try {
			while (result.next()) {

				ToDoItem toDoItem = new ToDoItem(result.getDate("date"), result.getString("name"), result.getString("description"));

				toDoItems.add(toDoItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toDoItems;
	}

	public boolean persist(Object o) {
		ToDoItem toDoItem = (ToDoItem) o;
		String query;

		if (toDoItem.getId() != -1) {
			query = "UPDATE toDoItem SET date='" + toDoItem.getDate() + "'name='" + toDoItem.getName() + "',description='" + toDoItem.getDescription() + "'";
			db.update(query);

		} else {
			query = "INSERT INTO toDoItem VALUES('" + 0 + "', '" + toDoItem.getDate() + "', '" + toDoItem.getName() + "', '" + toDoItem.getDescription() + "')";
			db.update(query);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		ToDoItem toDoItem = (ToDoItem) o;
		String query;

		query = "DELETE FROM toDoItem WHERE toDoItem_id='" + toDoItem.getId() + "'";
		db.update(query);
		return true;
	}

	public static ToDoItemBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new ToDoItemBroker();
		}
		return broker;
	}

	public ToDoItem getToDoItemInformation(int id) {
		String query = "SELECT * FROM toDoItem WHERE toDoItem_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		ToDoItem tdi = null;

		try {
			while (result.next()) {

				String name = result.getString("name");
				Date date = result.getDate("date");
				String description = result.getString("description");

				tdi = new ToDoItem(id, date, name, description);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tdi;
	}

}
