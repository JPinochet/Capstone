/**
 * Mar 2, 2010
 * PasswordInvalidException.java
 */
package exceptions;

/**
 * @author cantleyc
 *
 */
public class PasswordInvalidException extends Exception {
	private static final long serialVersionUID = 7728077084167184913L;

	/**
	 * 
	 */
	public PasswordInvalidException() {
	}
	
	/**
	 * @param message
	 */
	public PasswordInvalidException(String message) {
		super(message);
	}
	
	/**
	 * @param cause
	 */
	public PasswordInvalidException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public PasswordInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
