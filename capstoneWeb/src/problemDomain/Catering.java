package problemDomain;

import java.io.Serializable;

public class Catering implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1819026148523505040L;
	/**
	 * Initializes variables
	 */
	private int id = 0;
	private String chargeName;
	private double charge;
	private String description;
	
	public Catering(){}

	/**
	 * @param id - catering id
	 * @param chargeName - a quick reference for searching purposes
	 * @param charge - amount being charged
	 * @param description - description of catering order
	 */
	public Catering(int id, String chargeName, double charge, String description) {
		this.id = id;
		this.chargeName = chargeName;
		this.charge = charge;
		this.description = description;
	}

	/**
	 * @param chargeName - a quick reference for searching purposes
	 * @param charge - amount being charged
	 * @param description - description of catering order
	 */
	public Catering(String chargeName, double charge, String description) {
		this.chargeName = chargeName;
		this.charge = charge;
		this.description = description;
	}

	/**
	 * @return the chargeName - quick reference for searching purposes
	 */
	public String getChargeName() {
		return chargeName;
	}

	/**
	 * @return the charge - amount being charged
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * The chargeName to set
	 * @param chargeName - quick reference for searching purposes
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	/**
	 * The charge to set
	 * @param charge - amount being charged
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}

	/**
	 * @return description of catering
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description of catering
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the id - id of charge
	 */
	public int getId() {
		return id;
	}

	/**
	 * The id to set
	 * @param id - id of charge
	 */
	public void setId(int id) {
		this.id = id;
	}
}
