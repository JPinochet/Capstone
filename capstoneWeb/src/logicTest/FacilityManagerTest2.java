package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.FacilityManager;
import exceptions.CloseTimeInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.MaxCapacityInvalidException;
import exceptions.MinBookingIntervalInvalidException;
import exceptions.MinBookingTimeInvalidException;
import exceptions.NameInvalidException;
import exceptions.OpenTimeInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

/**
 * Servlet implementation class FacilityManagerTest2
 */
public class FacilityManagerTest2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityManagerTest2() 
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
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "18", "15",
					"15", rates, additionalCharges, "60", 
					"15", "15");
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			out.println("Name is not valid");
		} 
		catch (OpenTimeInvalidException e)
		{
			out.println("Open Time is not valid");
		}
		catch (CloseTimeInvalidException e) 
		{
			out.println("Close Time is not valid");
		}
		catch (SetupTimeInvalidException e)
		{
			out.println("Setup Time is not valid");
		}
		catch (TearDownTimeInvalidException e) 
		{
			out.println("Tear Down Time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			out.println("Max Capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			out.println("Min Booking Interval is not valid");
		}
		catch (MinBookingTimeInvalidException e)
		{
			out.println("Min Booking Time is not valid");
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
