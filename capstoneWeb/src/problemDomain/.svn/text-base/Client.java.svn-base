package problemDomain;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -288656533851435630L;
	/**
	 * Initializes variables
	 */
	private int id = 0;
	private String givenName;
	private String surname;
	private String email;
	private String address;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	private int discount;
	private String password;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private ArrayList<Organization> organizations;
	
	/**
	 * Initializes client
	 */
	public Client() {
	}
	
	/**
	 * @param id
	 */
	public Client(int id)
	{
		this.id = id;
	}

	/**
	 * @param id - client id
	 * @param givenName - client given name
	 * @param surname - client surname
	 * @param email - client email
	 * @param workPhone - client work phone number
	 * @param homePhone - client home phone number
	 * @param cellPhone - client cell phone number
	 */
	public Client(int id, String givenName, String surname, String email, String workPhone, String homePhone, String cellPhone) {
		this.id = id;
		this.givenName = givenName;
		this.surname = surname;
		this.email = email;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.cellPhone = cellPhone;
	}

	/**
	 * @param givenName - client given name
	 * @param surname - client surname
	 * @param email - client email
	 * @param address - client address
	 * @param city - client city
	 * @param province - client province
	 * @param country - client country
	 * @param postalCode - client postalCode
	 * @param discount - discount been given to client
	 * @param password - client password for online access
	 * @param homePhone - client home phone
	 * @param workPhone - client work phone
	 * @param cellPhone - client cell phone
	 * @param organizations - client organizations
	 */
	public Client(String givenName, String surname, String email,
			String address, String city, String province, String country,
			String postalCode, int discount, String password, String homePhone,
			String workPhone, String cellPhone, ArrayList<Organization> organizations) {
		this.givenName = givenName;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.discount = discount;
		this.password = password;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.cellPhone = cellPhone;
		this.organizations = organizations;
	}

	/**
	 * @param id - client id
	 * @param givenName - client given name
	 * @param surname - client surname
	 * @param email - client email
	 * @param address - client address
	 * @param city - client city
	 * @param province - client province
	 * @param country - client country
	 * @param postalCode - client postalCode
	 * @param discount - discount been given to client
	 * @param password - client password for online access
	 * @param homePhone - client home phone
	 * @param workPhone - client work phone
	 * @param cellPhone - client cell phone
	 * @param organizations - client organizations
	 */
	public Client(int id, String givenName, String surname, String email,
			String address, String city, String province, String country,
			String postalCode, int discount, String password, String homePhone,
			String workPhone, String cellPhone, ArrayList<Organization> organizations) {
		this.id = id;
		this.givenName = givenName;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.discount = discount;
		this.password = password;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.cellPhone = cellPhone;
		this.organizations = organizations;
	}

	/**
	 * @return the id - client id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the givenName - client given name
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @return the surname - client surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return the email - client email 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the address - client address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the city - client city 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the province - client province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @return the country - client country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the postalCode - client postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the discount - discount given to client
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @return the password - clients online password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the homePhone - clients home phone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @return the workPhone - clients work phone
	 */
	public String getWorkPhone() {
		return workPhone;
	}

	/**
	 * @return the cellPhone - client cell phones
	 */
	public String getCellPhone() {
		return cellPhone;
	}

//	/**
//	 * @return the organizations - organization(s) client belongs to 
//	 */
//	public ArrayList<Organization> getOrganization() {
//		ArrayList<Organization> orgs=null;
//		try
//		{
//			OrganizationBroker ob = OrganizationBroker.getBroker();
//			orgs = (ArrayList<Organization>) ob.getOrgsForClientID(id);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		return orgs;
//	}

	/**
	 * Organizations to get
	 * @return the Clients Organizations
	 */
	public ArrayList<Organization> getOrganization()
	{
		return this.organizations;
	}
	
	/**
	 * The id to set
	 * @param id - id of client
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * The givenName to set
	 * @param givenName - given name of client
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * The surname to set
	 * @param surname - surname of client
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * The email to set
	 * @param email - email of client
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * The address to set
	 * @param address - address of client 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * The city to set
	 * @param city - city of client 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * The province to set 
	 * @param province - province of client 
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * The country to set 
	 * @param country - country of client 
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * The postalCode to set 
	 * @param postalCode - postalcode of client 
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * The discount to set 
	 * @param discount - discount given to client
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * The password to set 
	 * @param password - online password for client
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * The homePhone to set 
	 * @param homePhone - home phone of client
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * The workPhone to set
	 * @param workPhone - work phone of client
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * The cellPhone to set
	 * @param cellPhone - cell phone of client
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * The organizations to set
	 * @param organizations - organization of client
	 */
	public void setOrganizations(ArrayList<Organization> organizations) {
		this.organizations = organizations;
	}
	
	
}
