package problemDomain;

import java.util.ArrayList;

public class Client {
	private int id = -1;
	private String givenName;
	private String surname;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String country;
	private String email;
	private ArrayList<Phone> phoneNumbers;
	private double discount;
	private ArrayList<Organization> Organizations;
	private String password;

	/**
	 * @param id
	 * @param givenName
	 * @param surname
	 * @param address
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param country
	 * @param email
	 * @param phoneNumbers
	 * @param discount
	 * @param organizations
	 * @param password
	 */
	public Client(int id, String givenName, String surname, String address, String city, String province, String postalCode, String country, String email,
			ArrayList<Phone> phoneNumbers, double discount, ArrayList<Organization> organizations, String password) {
		this.id = id;
		this.givenName = givenName;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.discount = discount;
		Organizations = organizations;
		this.password = password;
	}

	/**
	 * @param givenName
	 * @param surname
	 * @param address
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param country
	 * @param email
	 * @param phoneNumbers
	 * @param discount
	 * @param organizations
	 * @param password
	 */
	public Client(String givenName, String surname, String address, String city, String province, String postalCode, String country, String email, ArrayList<Phone> phoneNumbers,
			double discount, ArrayList<Organization> organizations, String password) {
		this.givenName = givenName;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.discount = discount;
		this.Organizations = organizations;
		this.password = password;
	}

	/**
	 * @param givenName
	 * @param surname
	 * @param address
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param country
	 * @param email
	 * @param phoneNumbers
	 */
	public Client(String givenName, String surname, String address, String city, String province, String postalCode, String country, String email, ArrayList<Phone> phoneNumbers,
			String password) {
		this.givenName = givenName;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.password = password;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phoneNumbers
	 */
	public ArrayList<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @return the organizations
	 */
	public ArrayList<Organization> getOrganizations() {
		return Organizations;
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

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phoneNumbers
	 *            the phoneNumbers to set
	 */
	public void setPhoneNumbers(ArrayList<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @param organizations
	 *            the organizations to set
	 */
	public void setOrganizations(ArrayList<Organization> organizations) {
		Organizations = organizations;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

}
