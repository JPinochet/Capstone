/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class AddressInvalidException extends Exception {
	private static final long serialVersionUID = -1126353131106361549L;

	/**
	 * 
	 */
	public AddressInvalidException()
	{
		
	}
	
	/**
	 * @param message
	 */
	public AddressInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * @param cause
	 */
	public AddressInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public AddressInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	
}
