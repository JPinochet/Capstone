/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class OpenTimeInvalidException extends Exception {
	private static final long serialVersionUID = -3089538351490410720L;

	public OpenTimeInvalidException()
	{
		
	}
	
	public OpenTimeInvalidException(String message)
	{
		super(message);
	}
	
	public OpenTimeInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	public OpenTimeInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
