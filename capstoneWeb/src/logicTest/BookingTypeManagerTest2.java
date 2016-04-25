package logicTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

import logic.BookingTypeManager;

/**
 * Servlet implementation class BookingTypeManagerTest2
 */
public class BookingTypeManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingTypeManagerTest2() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			btm.save(0, "Test", "15", "15");
		}
		catch (DatabaseConnectionException e) 
		{
        	out.println("failed to connect to Database");
		} 
		catch (NumberFormatException e)
		{
			out.println("This exception is thrown if Numbers are not in the correct format");
		}
		catch (TearDownTimeInvalidException e)
		{
			out.println("Tear down time is not valid");
		} 
		catch (SetupTimeInvalidException e)
		{
			out.println("Setup time is not valid");
		}
		catch (NameInvalidException e)
		{
			out.println("Name is not valid");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
