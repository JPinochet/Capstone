/**
 * 
 */
package persistence;

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
public class EmployeeBroker implements Broker {
	private Database db = new Database();
	private static EmployeeBroker broker;

	/**
	 * @throws DatabaseConnectionException 
	 * 
	 */
	private EmployeeBroker() throws DatabaseConnectionException {
		db.connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/indusdb", "indusdb", "DrqTAhbG9HaVzL64");
		// TODO Auto-generated constructor stub
	}

	public void close() {
		db.close();
		broker = null;
	}

	public List<Employee> getAll() {
		String query = "SELECT * FROM employee";
		ResultSet result = db.select(query);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			while (result.next()) {

				Employee employee = new Employee(result.getInt("employee_id"), result.getString("surname"), result.getString("username"), result.getString("password"), result
						.getString("givenName"));
				// should'nt id be at the top in front of surname?
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	public boolean persist(Object o) {
		Employee employee = (Employee) o;
		String query;

		if (employee.getId() != -1) {
			query = "UPDATE employee SET username='" + employee.getUsername() + "',givenName='" + employee.getGivenName() + "', surname='" + employee.getSurname()
					+ "', password='" + employee.getPassword() + "'";
			db.update(query);

		} else {
			query = "INSERT INTO employee VALUES('" + 0 + "', '" + employee.getUsername() + "', '" + employee.getGivenName() + "', '" + employee.getSurname() + "', '"
					+ employee.getPassword() + "')";
			db.update(query);// is this correct?
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see persistence.Broker#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		Employee employee = (Employee) o;
		String query;

		query = "DELETE FROM employee WHERE employee_id='" + employee.getId() + "'";
		db.update(query);
		return true;
	}

	public static EmployeeBroker getBroker() throws DatabaseConnectionException {
		if (broker == null) {
			broker = new EmployeeBroker();
		}
		return broker;
	}

	public Employee getEmployeeInformation(int id) {
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE employee_id='" + id + "' LIMIT 1";
		ResultSet result = db.select(query);

		try {
			while (result.next()) {
				emp = new Employee(result.getInt("employee_id"), result.getString("name"), result.getString("password"), result.getString("givenName"), result.getString("surname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;// *
	}

	//
}
