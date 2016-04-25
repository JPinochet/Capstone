/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class ScheduleInvalidException extends Exception {
	private static final long serialVersionUID = 2816095353245658772L;

	/**
	 * Initializes Exception
	 */
	public ScheduleInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public ScheduleInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public ScheduleInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public ScheduleInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	
}
