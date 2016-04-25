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
	 * Initializes Exception
	 */
	public SurnameInvalidException() {
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public SurnameInvalidException(String message) {
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public SurnameInvalidException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public SurnameInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
