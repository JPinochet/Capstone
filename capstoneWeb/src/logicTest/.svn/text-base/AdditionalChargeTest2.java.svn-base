package logicTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;

import logic.AdditionalChargeManager;

/**
 * Servlet implementation class AdditionalChargeTest2
 */
public class AdditionalChargeTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionalChargeTest2() 
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
			AdditionalChargeManager acm = new AdditionalChargeManager();
			acm.save(9,"test", "20");
		}
		catch (DatabaseConnectionException e)
		{
			out.println("failed to connect to Database");
		}
		catch (CostInvalidException e)
		{
			out.println("Cost is not valid");
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
