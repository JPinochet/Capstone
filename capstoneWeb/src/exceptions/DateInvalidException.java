/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class DateInvalidException extends Exception {
	private static final long serialVersionUID = 6886947599715479306L;

	/**
	 * Initializes Exception
	 */
	public DateInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public DateInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public DateInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public DateInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
}
