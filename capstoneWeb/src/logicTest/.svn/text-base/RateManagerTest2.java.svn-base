package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.RateManager;
import exceptions.BookingDepositInvalidException;
import exceptions.CostInvalidException;
import exceptions.DamageDepositInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;

/**
 * Servlet implementation class RateManagerTest2
 */
public class RateManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateManagerTest2()
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
			RateManager rm = new RateManager();
			rm.save(0, "john", "test", "1.5", "10", "5", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		} 
		catch (CostInvalidException e) 
		{
			out.println("Cost is not valid");
		}
		catch (NameInvalidException e) 
		{
			out.println("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			out.println("Description is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			out.println("Damage Deposist is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			out.println("Booking deposit is not valid");
		} 
		catch (ParseException e) 
		{
			out.println("Parsing error has occured");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);doGet(request, response);
	}

}
