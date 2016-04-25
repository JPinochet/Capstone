package problemDomain;

import java.io.Serializable;
import java.util.Date;

public class ToDoItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 410518794341414059L;
	/**
	 * Initializes variables
	 */
	private Date date;
	private String name;
	private String description;
	private int id = -1;

	/**
	 * Initializes ToDoItem
	 */
	public ToDoItem(){}
	
	/**
	 * @param date - date that the ToDoItem needs to be done
	 * @param name - name of the task in the ToDoItem 
	 * @param description - description of what needs to be done in the ToDoItem 
	 */
	public ToDoItem(Date date, String name, String description) {
		this.date = date;
		this.name = name;
		this.description = description;
	}

	/**
	 * @param date - date that the ToDoItem needs to be done
	 * @param name - name of the task in the ToDoItem 
	 * @param description - description of what needs to be done in the ToDoItem 
	 * @param id - Unique identifier for the ToDoItem
	 */
	public ToDoItem(int id, Date date, String name, String description) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id of the ToDoItem
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the date of the ToDoItem
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the name of the ToDoItem
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description of the task that needs to be done in the ToDoItem
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The id to set
	 * @param id - id of ToDoItem
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * The date to set
	 * @param date - date of ToDoItem
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * The name to set
	 * @param name - name of ToDoItem
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The description to set
	 * @param description - description of ToDoItem
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
