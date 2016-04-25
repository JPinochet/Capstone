/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class CloseTimeInvalidException extends Exception {
	private static final long serialVersionUID = 1762700160709225427L;

	public CloseTimeInvalidException()
	{
		
	}
	public CloseTimeInvalidException(String message)
	{
		super(message);
	}
	public CloseTimeInvalidException(Throwable cause)
	{
		super(cause);
	}
	public CloseTimeInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
