package problemDomain;

public class Rate {
	private int id = 0;
	private String name;
	private String description;
	private double rate;
	private double damageDeposit;
	private double bookingDeposit;

	/**
	 * @param name
	 * @param description
	 * @param rate
	 * @param damageDeposit
	 * @param bookingDeposit
	 */
	public Rate(int id, String name, String description, double rate, double damageDeposit, double bookingDeposit) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.damageDeposit = damageDeposit;
		this.bookingDeposit = bookingDeposit;
	}

	public Rate(String name, String description, double rate, double damageDeposit, double bookingDeposit) {
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.damageDeposit = damageDeposit;
		this.bookingDeposit = bookingDeposit;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @return the damageDeposit
	 */
	public double getDamageDeposit() {
		return damageDeposit;
	}

	/**
	 * @return the bookingDeposit
	 */
	public double getBookingDeposit() {
		return bookingDeposit;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * @param damageDeposit
	 *            the damageDeposit to set
	 */
	public void setDamageDeposit(double damageDeposit) {
		this.damageDeposit = damageDeposit;
	}

	/**
	 * @param bookingDeposit
	 *            the bookingDeposit to set
	 */
	public void setBookingDeposit(double bookingDeposit) {
		this.bookingDeposit = bookingDeposit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
