package problemDomain;

public class Phone {
	private PhoneType type;
	private int areacode;
	private int number;

	/**
	 * @param type
	 * @param areacode
	 * @param number
	 */
	public Phone(PhoneType type, int areacode, int number) {
		this.type = type;
		this.areacode = areacode;
		this.number = number;
	}

	/**
	 * @return the type
	 */
	public PhoneType getType() {
		return type;
	}

	/**
	 * @return the areacode
	 */
	public int getAreacode() {
		return areacode;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(PhoneType type) {
		this.type = type;
	}

	/**
	 * @param areacode
	 *            the areacode to set
	 */
	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	public enum PhoneType {
		Cell, Home, Business;
	}
}
