package logicTest;

import java.util.Date;

import problemDomain.BookingType;
import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;
import junit.framework.TestCase;
import logic.BookingTypeManager;

public class BookingTypeManagerTest extends TestCase 
{
	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}
	
	public void testShouldBeAbleToCreateABookingType()
	{
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			btm.save(0, "Test", "15", "15");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
	}
	
	public void testShouldNotBeAbleToCreateABookingTypeWithInvalidname()
	{
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			btm.save(0, "", "15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
	}
	public void testShouldNotBeAbleToCreateABookingTypeWithInvalidSetupTime()
	{
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			btm.save(-1, "", "-15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
	}
	
	public void testShouldNotBeAbleToCreateABookingTypeWithInvalidTearDownTime()
	{
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			btm.save(-1, "", "15", "-15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
	}
	public void testShouldBeAbleToDeleteBookingType()
	{
		try 
		{
			BookingTypeManager btm = new BookingTypeManager();
			BookingType bt = new BookingType();
			bt.setId(30);
			btm.remove(bt);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}
