package logicTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ToDoItemManager;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;

/**
 * Servlet implementation class ToDoItemManagerTest2
 */
public class ToDoItemManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoItemManagerTest2() 
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
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(0, "john", "test", "05/09/2010");
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		} 
		catch (NameInvalidException e) 
		{
			out.println("Name is not valid");
		} 
		catch (DescriptionInvalidException e)
		{
			out.println("Description is not valid");
		}
		catch (DateInvalidException e) 
		{
			out.println("Date is not valid");
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
