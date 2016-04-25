/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class MinBookingTimeInvalidException extends Exception {
	private static final long serialVersionUID = -7176960923827395397L;
	
	/**
	 * Initializes Exception
	 */
	public MinBookingTimeInvalidException()
	{
		
	}

	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public MinBookingTimeInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public MinBookingTimeInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public MinBookingTimeInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
