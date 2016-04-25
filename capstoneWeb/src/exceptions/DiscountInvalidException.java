/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class DiscountInvalidException extends Exception 
{
	private static final long serialVersionUID = 9190094124464903933L;

	/**
	 * Initializes Exception
	 */
	public DiscountInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public DiscountInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public DiscountInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public DiscountInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
