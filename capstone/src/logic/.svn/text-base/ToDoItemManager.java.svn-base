/**
 * 
 */
package logic;

import java.util.Date;
import java.util.List;

import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;

import persistence.ToDoItemBroker;
import problemDomain.ToDoItem;

/**
 * @author 432873
 * 
 */
public class ToDoItemManager 
{
	//Instance of the singleton broker
	ToDoItemBroker tb;
	
	
	/**
	 * @throws DatabaseConnectionException
	 */
	public ToDoItemManager () throws DatabaseConnectionException
	{
		tb = ToDoItemBroker.getBroker();
	}
	
	/**
	 * @param ToDoName
	 * @param ToDoDescription
	 * @param ToDoDate
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException 
	 */
	public boolean validate(String ToDoName, String ToDoDescription, Date ToDoDate) throws NameInvalidException, DescriptionInvalidException
	{
		if(ToDoName == null)
			throw new NameInvalidException("An Additional Charge must have a name to identify it.");
		if(ToDoName.length() > 30)
			throw new NameInvalidException("Additional Charge name cannot excede 30 characters.");
		if(ToDoDescription != null)
			if(ToDoDescription.length() > 400)
				throw new DescriptionInvalidException("An additional charge description cannot excede 400 characters.");
		
		return true;
	}
	
	/**
	 * @param todo
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException 
	 */
	public boolean validate(ToDoItem todo) throws NameInvalidException, DescriptionInvalidException
	{
		if(todo.getName() == null)
			throw new NameInvalidException("An Additional Charge must have a name to identify it.");
		if(todo.getName().length() > 30)
			throw new NameInvalidException("Additional Charge name cannot excede 30 characters.");
		if(todo.getDescription() != null)
			if(todo.getDescription().length() > 400)
				throw new DescriptionInvalidException("An additional charge description cannot excede 400 characters.");
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<ToDoItem> search(String query)
	{
		
		return null;
	}

	/**
	 * @param ToDoName
	 * @param ToDoDescription
	 * @param ToDoDate
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException 
	 */
	public boolean save(String ToDoName, String ToDoDescription, Date ToDoDate) throws NameInvalidException, DescriptionInvalidException
	{
		ToDoItem tdi = null;
		
		if(this.validate(ToDoName, ToDoDescription, ToDoDate))
			tdi = new ToDoItem(ToDoDate, ToDoName, ToDoDescription);
			
		return tb.persist(tdi);
	}
	
	/**
	 * @param todo
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException 
	 */
	public boolean save(ToDoItem todo) throws NameInvalidException, DescriptionInvalidException
	{
		if(this.validate(todo))
			return tb.persist(todo);
		
		return false;
	}

	/**
	 * @param todo
	 * @return
	 */
	public boolean remove(ToDoItem todo)
	{
		return tb.remove(todo);
	}
	
	/**
	 * 
	 */
	public void close() {
		tb.close();
	}
	
	/**
	 * @return
	 */
	private List<ToDoItem> getAll()
	{
		return null;
	}
}
