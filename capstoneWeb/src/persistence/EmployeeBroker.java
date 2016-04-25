/**
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exceptions.DatabaseConnectionException;
import problemDomain.Employee;

/**
 * @author John Stuby
 * 
 */
public class EmployeeBroker {
	
	private static EmployeeBroker broker;

	/**
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 * 
	 */
	private EmployeeBroker() {
		
	}

	/**
	 * Closes Database connection
	 * 
	 */
	public void close() {
		
		broker = null;
	}
	
	
	/**
	 * Gets all employee information in the database
	 * @return a list of employees 
	 * @throws DatabaseConnectionException is thrown if database connection fails
	 */
	public List<Employee> getEmployeeList() throws DatabaseConnectionException {
		String query = "SELECT * FROM employee";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			while (result.next()) {
				Employee employee = new Employee(result.getInt("employee_id"), result.getString("username"), result.getString("password"), result.getString("givenName"), result
						.getString("surname"), result.getInt("employeeLevel"));
				employees.add(employee);
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	/**
	 * If the id for employee exists employee is updated with new values.
	 * If the id does not exist, information is inserted into employee table
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException - is thrown if the database connection fails
	 */
	
	public boolean persist(Object o) throws DatabaseConnectionException {
		Employee employee = (Employee) o;
		String query;

		Connection con = Database.connect();
		if (employee.getId() != 0) {
			query = "UPDATE employee SET username='" + employee.getUsername() + "',givenName='" + employee.getGivenName() + "', surname='" + employee.getSurname()
					+ "', password='" + employee.getPassword() + "', employeeLevel='" + employee.getEmployeeLevel() + "' WHERE employee_id='" + employee.getId() + "'";
			Database.update(query, con);

		} else {
			query = "INSERT INTO employee VALUES('" + 0 + "', '" + employee.getPassword() + "', '" + employee.getUsername() + "', '" + employee.getGivenName() + "', '"
					+ employee.getSurname() + "', '" + employee.getEmployeeLevel() + "')";
			Database.update(query, con);// is this correct?
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Removes the supplied object from the database
	 * @param o - the object to be removed 
	 * @return true/false if the object is valid.
	 * @throws DatabaseConnectionException - is thrown if the database connection fails)
	 */
	public boolean remove(Object o) throws DatabaseConnectionException {
		Employee employee = (Employee) o;
		String query;

		query = "DELETE FROM employee WHERE employee_id='" + employee.getId() + "'";
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
	 * @throws DatabaseConnectionException is thrown if the database connection fails
	 */
	public static EmployeeBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new EmployeeBroker();
		}
		return broker;
	}

	/**
	 * Performs a set of queries on the database to retrieve all information that related to a Employee with
	 * the id specified
	 * @param id is the id for the employee that the information will be retrieved for 
	 * @return an Employee object with all the information retrieved from the database
	 * @throws DatabaseConnectionException is thrown if the database connection fails
	 */
	public Employee getEmployeeInformation(int id) throws DatabaseConnectionException {
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE employee_id='" + id + "' LIMIT 1";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);

		try {
			if(result != null){
				while (result.next()) {
					emp = new Employee(result.getInt("employee_id"), result.getString("username"), result.getString("password"), result.getString("givenName"), result.getString("surname"), result.getInt("employeeLevel"));
				}
			}
			result.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;// *
	}

	/**
	 * Searches Database for required information and returns it in a list format
	 * @param searchText passes message along to database to search than returns a list
	 * @return list of all requested information from database
	 * @throws DatabaseConnectionException is thrown if DB connection fails
	 */
	public List<Employee> search(String searchText) throws DatabaseConnectionException
	{
		String query = "SELECT employee_id, username, givenName, surname, employeeLevel " +
						"FROM employee " +
						"WHERE givenName LIKE '%" + searchText + "%' " +
						"OR surname LIKE '%" + searchText + "%' " +
						"OR username LIKE '%" + searchText + "%' "+
						"OR CONCAT_WS(' ', username, givenName, surname) LIKE '%" + searchText + "%' " +
						"OR CONCAT_WS(' ', givenName, surname) LIKE '%" + searchText + "%'";
		Connection con = Database.connect();
		ResultSet result = Database.select(query, con);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		if(result != null){
			try {
				while (result.next()) { 
					Employee employee = new Employee(result.getInt("employee_id"), result.getString("username"), result.getString("givenName"), result.getString("surname"), result.getInt("employeeLevel"));
					employees.add(employee);
				}
				result.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return employees;		
	}
	
	public int validateLogin(String username, String password) throws DatabaseConnectionException
	{
		int employee = 0;

		String sql="SELECT employee_id " +
		"FROM employee " +
		"WHERE username='" + username + "' " +
		"AND password='" + password + "'";
		
		Connection con = Database.connect();
		ResultSet result = Database.select(sql, con);
		try
		{
			if(result != null) {
				while(result.next())
				{
					employee = result.getInt("employee_id");
				}
				result.close();
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
}
