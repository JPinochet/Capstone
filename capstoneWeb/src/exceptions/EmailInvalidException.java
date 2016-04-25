/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class EmailInvalidException extends Exception {
	private static final long serialVersionUID = -2765548556854748225L;
	
	/**
	 * Initializes Exception
	 */
	public EmailInvalidException()
	{
		
	}

	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public EmailInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public EmailInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public EmailInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
