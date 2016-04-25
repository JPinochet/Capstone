package problemDomain;

public class AdditionalCharge {
	private int id = 0;
	private String name;
	private double cost;

	/**
	 * @param id
	 * @param name
	 * @param cost
	 */
	public AdditionalCharge(int id, String name, double cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	/**
	 * @param name
	 * @param cost
	 */
	public AdditionalCharge(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setId(int id) {
		this.id = id;
	}

}
