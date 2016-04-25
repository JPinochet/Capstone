package problemDomain;

public class BookingType {
	private int id;
	private String name;
	private int setupTime;
	private int tearDownTime;

	/**
	 * @param id
	 * @param name
	 * @param setupTime
	 * @param tearDownTime
	 */
	public BookingType(int id, String name, int setupTime, int tearDownTime) {
		this.id = id;
		this.name = name;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
	}

	/**
	 * @param name
	 * @param setupTime
	 * @param tearDownTime
	 */
	public BookingType(String name, int setupTime, int tearDownTime) {
		this.name = name;
		this.setupTime = setupTime;
		this.tearDownTime = tearDownTime;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the setupTime
	 */
	public int getSetupTime() {
		return setupTime;
	}

	/**
	 * @return the tearDownTime
	 */
	public int getTearDownTime() {
		return tearDownTime;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param setupTime
	 *            the setupTime to set
	 */
	public void setSetupTime(int setupTime) {
		this.setupTime = setupTime;
	}

	/**
	 * @param tearDownTime
	 *            the tearDownTime to set
	 */
	public void setTearDownTime(int tearDownTime) {
		this.tearDownTime = tearDownTime;
	}
}
