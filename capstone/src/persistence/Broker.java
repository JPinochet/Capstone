/**
 * 
 */
package persistence;

import java.util.List;

import exceptions.DatabaseConnectionException;

/**
 * @author cantleyc
 * 
 */
public interface Broker {

	/**
	 * Closes the broker and any open database connection
	 */
	public abstract void close();

	/**
	 * Removes the supplied object from the database
	 * 
	 * @param o
	 *            the object to be removed
	 * @return True or false if object is removed
	 */
	public abstract boolean remove(Object o);

	/**
	 * Persists the supplied object to the Database
	 * 
	 * @param o
	 *            the object to be persisted
	 * @return True or false if object is persisted
	 */
	public abstract boolean persist(Object o);

	/**
	 * Returns an ArrayList of all objects in the database
	 * 
	 * @return an ArrayList of all objects in the database
	 * @throws DatabaseConnectionException 
	 */
	public abstract List getAll() throws DatabaseConnectionException;
}
