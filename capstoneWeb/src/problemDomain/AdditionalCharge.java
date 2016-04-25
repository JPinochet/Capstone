package problemDomain;

import java.io.Serializable;

public class AdditionalCharge implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1612778720556565956L;
	/**
	 * Initializes variable
	 */
	private int id = 0;
	private String name;
	private double cost;

	/**
	 * Initializes AdditionalCharge
	 */
	public AdditionalCharge(){}
	
	/**
	 * @param id - id of additional charges
	 * @param name - name of additional charge
	 * @param cost - amount being charged
	 */
	public AdditionalCharge(int id, String name, double cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @param name - name of additional charge
	 * @param cost - amount being charged
	 */
	public AdditionalCharge(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @return the id - id of additional charge
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name - name of additional charge
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cost - amount of charge
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * The name to set
	 * @param name - name of additional charge 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The cost to set
	 * @param cost - cost of additional charge
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * The id to set
	 * @param id - id of additional charge
	 */
	public void setId(int id) {
		this.id = id;
	}

}
