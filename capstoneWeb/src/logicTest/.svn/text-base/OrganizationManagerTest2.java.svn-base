package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.OrganizationManager;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientNameNotUniqueException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.DiscountInvalidException;
import exceptions.NameInvalidException;

/**
 * Servlet implementation class OrganizationManagerTest2
 */
public class OrganizationManagerTest2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationManagerTest2()
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
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "john", "10%", "jorge", "test");
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			out.println("Name is not valid");
		} 
		catch (DiscountInvalidException e) 
		{
			out.println("Discount is not valid");
		} 
		catch (DescriptionInvalidException e)
		{
			out.println("Description is not valid");
		} 
		catch (ClientNameNotUniqueException e) 
		{
			out.println("Client Name is not valid");
		} 
		catch (ClientDoesNotExistException e)
		{
			out.println("Client is not valid");
		} 
		catch (SQLException e)
		{
			out.println("SQL is not working");
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
