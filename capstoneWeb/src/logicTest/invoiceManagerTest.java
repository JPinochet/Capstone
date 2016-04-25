package logicTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;

import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Employee;
import problemDomain.Invoice;
import problemDomain.Payment;
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
import junit.framework.TestCase;
import logic.EmployeeManager;
import logic.InvoiceManager;

public class invoiceManagerTest extends TestCase 
{
	Connection conn;
	protected void setUp() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		 conn=DriverManager.getConnection("jdbc:mysql://localhost/indusdb"
			    ,"root","password");
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
		conn.close();
		
	}
	
	public void testShouldBeAbleToSaveInoviceInformation()
	{
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
			fail("Could not connect to database");
		} 
		catch (DescriptionInvalidException e)
		{
			fail("Description is not valid");
		}
		catch (DateInvalidException e)
		{
			fail("Date is not valid");
		}
	}
	public void testShouldNotBeAbleToCreateAInvoiceWithInvalidId()
	{
		try 
		{
			//create a transaction (from connection)
			//get count of how many invoices currently in DB
			InvoiceManager im = new InvoiceManager();
			ArrayList<Booking> bookings = new ArrayList<Booking>();
//			bookings.add(new Booking(5456));
			ArrayList<Payment> payments = new ArrayList<Payment>();
//			payments.add(payments);
			im.save(-5, new Date(), new Client(7), bookings, "test");
			fail("Booking created");
			//get current count of number of invoices
			//assert 1 invoice was added (current # - previous #)
			//rollback the transaction
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (DescriptionInvalidException e)
		{
			fail("Description is not valid");
		}
		catch (DateInvalidException e)
		{
			fail("Date is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAInvoiceWithInvalidDate()
	{
		try 
		{
			//create a transaction (from connection)
			//get count of how many invoices currently in DB
			InvoiceManager im = new InvoiceManager();
			ArrayList<Booking> bookings = new ArrayList<Booking>();
//			bookings.add(new Booking(5456));
			ArrayList<Payment> payments = new ArrayList<Payment>();
//			payments.add(payments);
			im.save(-1, new Date(1999), new Client(7), bookings, "Description");
			fail("Booking created");
			//get current count of number of invoices
			//assert 1 invoice was added (current # - previous #)
			//rollback the transaction
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (DescriptionInvalidException e)
		{
			fail("Description is not valid");
		}
		catch (DateInvalidException e)
		{
			fail("Date is not valid");
		}
	}
	
	public void testShouldNotBeAbleToCreateAInvoiceWithInvalidDescription()
	{
		try 
		{
			//create a transaction (from connection)
			//get count of how many invoices currently in DB
			InvoiceManager im = new InvoiceManager();
			ArrayList<Booking> bookings = new ArrayList<Booking>();
//			bookings.add(new Booking(5456));
			ArrayList<Payment> payments = new ArrayList<Payment>();
//			payments.add(payments);
			im.save(-1, new Date(), new Client(7), bookings, "");
			fail("Booking created");
			//get current count of number of invoices
			//assert 1 invoice was added (current # - previous #)
			//rollback the transaction
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (DescriptionInvalidException e)
		{
			fail("Description is not valid");
		}
		catch (DateInvalidException e)
		{
			fail("Date is not valid");
		}
	}
	
	
}
