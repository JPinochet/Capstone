package problemDomain;

public class Employee {
	private int id = 0;
	private String username;
	private String password;
	private String givenName;
	private String surname;

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param givenName
	 * @param surname
	 */
	public Employee(int id, String username, String password, String givenName, String surname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.givenName = givenName;
		this.surname = surname;
	}
	
	/**
	 * @param username
	 * @param password
	 * @param givenName
	 * @param surname
	 */
	public Employee(String username, String password, String givenName, String surname)
	{
		this.id = 0;
		this.username = username;
		this.password = password;
		this.givenName = givenName;
		this.surname = surname;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
