package logicTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.EmployeeManager;
import exceptions.DatabaseConnectionException;
import exceptions.GivenNameInvalidException;
import exceptions.PasswordInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.UsernameInvalidException;

/**
 * Servlet implementation class employeeManagerTest2
 */
public class employeeManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeManagerTest2() 
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
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "test", "john", "stuby", "1");
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		} 
		catch (PasswordInvalidException e)
		{
			out.println("Password is not valid");
		}
		catch (GivenNameInvalidException e)
		{
			out.println("Given Name is not valid");
		}
		catch (SurnameInvalidException e)
		{
			out.println("Surname is not valid");
		}
		catch (UsernameInvalidException e) 
		{
			out.println("Username is not valid");
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
