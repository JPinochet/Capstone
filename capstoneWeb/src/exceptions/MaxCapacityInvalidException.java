/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class MaxCapacityInvalidException extends Exception {
	private static final long serialVersionUID = 4551801712884851415L;

	/**
	 * Initializes Exception
	 */
	public MaxCapacityInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public MaxCapacityInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public MaxCapacityInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public MaxCapacityInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
