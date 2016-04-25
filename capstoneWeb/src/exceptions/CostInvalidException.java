/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class CostInvalidException extends Exception {
	private static final long serialVersionUID = -6948495911866831377L;
	
	/**
	 * Initializes Exception
	 */
	public CostInvalidException()
	{
		
	}
	
	/**
	 * Gets the specific message for the exception
	 * @param message is the message that is thrown for the exception
	 */
	public CostInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * Gets the specific cause for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public CostInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Gets the specific message and cause for the exception that is thrown
	 * @param message is the message that is thrown for the exception
	 * @param cause is the cause for the reason an exception is thrown
	 */
	public CostInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
