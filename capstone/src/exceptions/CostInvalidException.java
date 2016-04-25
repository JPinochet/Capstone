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
	
	public CostInvalidException()
	{
		
	}
	
	public CostInvalidException(String message)
	{
		super(message);
	}
	
	public CostInvalidException(Throwable cause)
	{
		super(cause);
	}
	
	public CostInvalidException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
