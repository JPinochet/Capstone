/**
 * 
 */
package logic;

import java.util.List;

import exceptions.DatabaseConnectionException;
import exceptions.GivenNameInvalidException;
import exceptions.PasswordInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.UsernameInvalidException;

import persistence.EmployeeBroker;
import problemDomain.Employee;
import problemDomain.Organization;

/**
 * @author 432873
 * 
 */
public class EmployeeManager {
	EmployeeBroker eb = null;
	
	/**
	 * @throws DatabaseConnectionException
	 */
	public EmployeeManager() throws DatabaseConnectionException {
		eb = EmployeeBroker.getBroker();
	}
	
	/**
	 * Method validates an employee object to verify that the information can be
	 * commited to the database.
	 * 
	 * @param emp
	 *            the employee object to validate.
	 * @return true/false if the object is valid.
	 */
	/**
	 * @param emp
	 * @return
	 * @throws GivenNameInvalidException
	 * @throws PasswordInvalidException
	 * @throws SurnameInvalidException
	 * @throws UsernameInvalidException
	 */
	public boolean validate(Employee emp) throws GivenNameInvalidException, PasswordInvalidException, SurnameInvalidException, UsernameInvalidException {
		if(emp.getGivenName() == null)
			throw new GivenNameInvalidException("Given Name cannot be left blank.");
		if(emp.getGivenName().length() > 25)
			throw new GivenNameInvalidException("Given Name cannot be longer than 25 characters.");

		if(emp.getSurname() == null)
			throw new SurnameInvalidException("Surname cannot be left blank.");
		if(emp.getSurname().length() > 25)
			throw new SurnameInvalidException("Surname cannot be longer than 25 characters.");

		if(emp.getUsername() == null)
			throw new UsernameInvalidException("Username cannot be left blank.");
		if(emp.getUsername().length() > 25)
			throw new UsernameInvalidException("Username cannot be longer than 25 characters.");
		
		//If password is null and the employee exists it will not be changed
		if(emp.getPassword() != null && emp.getId() != 0) {
			if(emp.getUsername().length() < 8)
				throw new PasswordInvalidException("Password cannot be shorter than 8 characters.");
		}
		
		return true;
	}
	
	public boolean validate(String username, String password, String givenName, String surname) throws PasswordInvalidException, GivenNameInvalidException, SurnameInvalidException, UsernameInvalidException
	{
		if(givenName == null)
			throw new GivenNameInvalidException("Given Name cannot be left blank.");
		if(givenName.length() > 25)
			throw new GivenNameInvalidException("Given Name cannot be longer than 25 characters.");

		if(surname == null)
			throw new SurnameInvalidException("Surname cannot be left blank.");
		if(surname.length() > 25)
			throw new SurnameInvalidException("Surname cannot be longer than 25 characters.");

		if(username == null)
			throw new UsernameInvalidException("Username cannot be left blank.");
		if(username.length() > 25)
			throw new UsernameInvalidException("Username cannot be longer than 25 characters.");
		
		if(password != null) 
		{
			if(password.length() < 8)
				throw new PasswordInvalidException("Password cannot be shorter than 8 characters.");
		}
		
		return true;
	}

	/**
	 * Creates a list of employee objects that matched the string passed in.
	 * Searches through all employee in the database for any matches found.
	 * 
	 * @param search
	 *            string containing the information to look for.
	 * @return a List of employee objects that contain the search string.
	 */
	public List<Employee> search(String query) {
		return null;
	}

	/**
	 * Saves/Updates an employee object if valid.
	 * 
	 * @param emp
	 *            employee object to commit.
	 * @return true/false if the object was saved.
	 */
	public boolean save(Employee emp) {
		return eb.persist(emp);
	}
	
	/**
	 * @param username
	 * @param password
	 * @param givenName
	 * @param surname
	 * @return
	 * @throws UsernameInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws PasswordInvalidException 
	 */
	public boolean save(String username, String password, String givenName, String surname) throws PasswordInvalidException, GivenNameInvalidException, SurnameInvalidException, UsernameInvalidException
	{
		Employee emp = null;
		
		if(this.validate(username, password, givenName, surname))
			return eb.persist(emp);
		
		return false;
	}

	/**
	 * Removes an employee object.
	 * 
	 * @param emp
	 *            the employee object to commit.
	 * @return true/flase if the object was removed.
	 */
	public boolean remove(Employee emp) {
		return eb.remove(emp);
	}
	
	/**
	 * 
	 */
	public void close() {
		eb.close();
	}
	
	/**
	 * @return
	 */
	private List<Employee> getAll()
	{
		return null;
	}
}
