/**
 * Mar 2, 2010
 * SurnameNullException.java
 */
package exceptions;

/**
 * @author cantleyc
 *
 */
public class SurnameInvalidException extends Exception {
	private static final long serialVersionUID = 1207922718566410850L;

	/**
	 * 
	 */
	public SurnameInvalidException() {
	}
	
	/**
	 * @param message
	 */
	public SurnameInvalidException(String message) {
		super(message);
	}
	
	/**
	 * @param cause
	 */
	public SurnameInvalidException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public SurnameInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
