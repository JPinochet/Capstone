package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.ClientDoesNotExistException;
import exceptions.ClientNameNotUniqueException;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

import logic.BookingManager;
import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.BookingType;
import problemDomain.Catering;
import problemDomain.Employee;
import problemDomain.Facility;
import problemDomain.Rate;

/**
 * Servlet implementation class bookingManagerTest2
 */
public class bookingManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookingManagerTest2()
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
        	BookingType bookingType = new BookingType();
			Catering Catering = new Catering();
			Employee Creator = new Employee();
			Rate Rate = new Rate();
			ArrayList<AdditionalCharge> additionalCharge = new ArrayList<AdditionalCharge>();
			Facility Facility = new Facility();
			BookingManager bm = new BookingManager();
			Booking b = new Booking(0,"HockeyAfterParty","party", new Date(),
			new Date(), "test" ); 
			bm.save(0,"HockeyAfterParty", bookingType, new Date(), new Date(),
					"test", "test", "test", Catering, Creator, "60", Rate, 
					additionalCharge, Facility, "1");
        }
        catch (DatabaseConnectionException e) 
		{
        	out.println("failed to connect to Database");
		} 
        catch (NumberFormatException e)
        {
        	out.println("Is thrown if Numbers are not in the proper format");
		}
        catch (NameInvalidException e)
        {
        	out.println("Name is not valid");
		} 
        catch (ScheduleInvalidException e)
        {
        	out.println("Schedule is not valid");
		} 
        catch (SetupTimeInvalidException e) 
        {
        	out.println("Setup time is not valid");
		}
        catch (TearDownTimeInvalidException e)
        {
        	out.println("Tear down time is not valid");
		} 
        catch (NumberInvalidException e) 
        {
        	out.println("Number is not valid");
		}
        catch (DateInvalidException e) 
        {
        	out.println("Date is not valid");
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
        	out.println("Is thrown if a error in the sql occurs");
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
