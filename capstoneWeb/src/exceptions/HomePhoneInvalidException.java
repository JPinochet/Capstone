/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class HomePhoneInvalidException extends Exception {
	private static final long serialVersionUID = -1126353131106361549L;

	/**
	 * Initializes Exception
	 */
	public HomePhoneInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public HomePhoneInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public HomePhoneInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public HomePhoneInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	
}
