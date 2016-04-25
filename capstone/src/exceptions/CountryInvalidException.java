/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class CountryInvalidException extends Exception {
	private static final long serialVersionUID = -3248072190289301486L;
	
	/**
	 * 
	 */
	public CountryInvalidException()
	{
		
	}

	/**
	 * @param message
	 */
	public CountryInvalidException(String message)
	{
		super(message);
	}
	
	/**
	 * @param cause
	 */
	public CountryInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public CountryInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
