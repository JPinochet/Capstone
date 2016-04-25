package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.AddressInvalidException;
import exceptions.BooleanInvalidException;
import exceptions.CityInvalidException;
import exceptions.CostInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DescriptionInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.TearDownTimeInvalidException;

import logic.InvoiceManager;
import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Payment;

/**
 * Servlet implementation class InvoiceManagerTest2
 */
public class InvoiceManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceManagerTest2()
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
			//create a transaction (from connection)
			//get count of how many invoices currently in DB
			InvoiceManager im = new InvoiceManager();
			ArrayList<Booking> bookings = new ArrayList<Booking>();
//			bookings.add(new Booking(5456));
			ArrayList<Payment> payments = new ArrayList<Payment>();
//			payments.add(payments);
			im.save(-1, new Date(), new Client(7), bookings, "test");
			
			//get current count of number of invoices
			//assert 1 invoice was added (current # - previous #)
			//rollback the transaction
		}
		catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
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
