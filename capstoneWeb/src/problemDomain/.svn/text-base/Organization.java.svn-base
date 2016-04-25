package problemDomain;

import java.io.Serializable;

public class Organization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 304768217350171636L;
	/**
	 * Initializes variables
	 */
	private int id;
	private String name;
	private double discount;
	private Client contact;
	private String description;

	/**
	 * Initializes organization
	 */
	public Organization(){}
	
	/**
	 * @param name - name of organization
	 * @param discount - discount given to organization
	 * @param contact - contact name in organization
	 * @param description - description of organization
	 */
	public Organization(String name, double discount, Client contact, String description) {
		this.name = name;
		this.discount = discount;
		this.contact = contact;
		this.description = description;
	}

	/**
	 * @param id - organization id
	 * @param name - name of the organization
	 * @param discount - discount given to organization
	 * @param contact - contact name in organization
	 * @param description - description of organization
	 */
	public Organization(int id, String name, double discount, Client contact, String description) {
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.contact = contact;
		this.description = description;
	}
	
	/**
	 * @param id - id of organization
	 * @param name - name of organization
	 * @param description - description of organization
	 */
	public Organization(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
		
	
	/**
	 * @param id - id of organization
	 * @param name - name of organization
	 */
	public Organization(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the name - name of the organization
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the discount - discount given to organization
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @return the contact - contact in organization
	 */
	public Client getContact() {
		return contact;
	}

	/**
	 * @return the description - description of organization
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The name to set
	 * @param name - name of organization
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The discount to set
	 * @param discount - discount given to organization 
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * The contact to set
	 * @param contact - contact in organization
	 */
	public void setContact(Client contact) {
		this.contact = contact;
	}

	/**
	 * The description to set
	 * @param description - description of organization
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id of the organization
	 */
	public int getId() {
		return id;
	}

	/**
	 * The id to set
	 * @param id - id of organization 
	 */
	public void setId(int id) {
		this.id = id;
	}
}
