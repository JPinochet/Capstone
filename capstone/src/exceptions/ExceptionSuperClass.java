/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
public class ExceptionSuperClass extends Exception {
	private static final long serialVersionUID = -4464006715843414147L;
	
	private int id;
	private String className;
	private String method;
	private String message;
	private ExceptionSuperClass previous = null;
	private String separator = "\n";
	
	public ExceptionSuperClass(int id, String className, String method, 
		    String message, ExceptionSuperClass previous) {
		    this.id        = id;
		    this.className = className;
		    this.method    = method;
		    this.message   = message;
		    this.previous  = previous;
		  }  
	
	public String traceBack() {
	    return traceBack("\n");
	  }
	
	public String traceBack(String sep) {
	    this.separator = sep;
	    int level = 0;
	    ExceptionSuperClass e = this;
	    String text = line("Calling sequence (top to bottom)");
	    while (e != null) {
	      level++;
	      text += line("--level " + level + "--------------------------------------");
	      text += line("Class/Method: " + e.className + "/" + e.method);
	      text += line("Id          : " + e.id);
	      text += line("Message     : " + e.message);
	      e = e.previous;
	    }  
	    return text;
	  }  

	  private String line(String s) {
	    return s + separator;
	  } 
}
