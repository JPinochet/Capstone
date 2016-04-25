package logicTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import logic.BookingManager;
import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.BookingType;
import problemDomain.Catering;
import problemDomain.Employee;
import problemDomain.Facility;
import problemDomain.Rate;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientNameNotUniqueException;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;

public class bookingManagerTest extends TestCase
{
	

	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testShouldBeAbleToCreateABooking()
	{
		
		try 
		{
			BookingType bookingType = new BookingType();
			Catering Catering = new Catering();
			Employee Creator = new Employee();
			Rate Rate = new Rate();
			ArrayList<AdditionalCharge> additionalCharge = new ArrayList<AdditionalCharge>();
			Facility Facility = new Facility();
			BookingManager bm = new BookingManager();
			bm.save(0,"HockeyAfterParty", bookingType, new Date(), new Date(),
					"test", "test", "test", Catering, Creator, "60", Rate, 
					additionalCharge, Facility, "1");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (ScheduleInvalidException e) 
		{
			assertTrue("Schedule was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
		catch (NumberInvalidException e)
		{
			assertTrue("Number was not valid", true);
		} 
		catch (DateInvalidException e) 
		{
			assertTrue("Date was not valid", true);
		} 
		catch (ClientNameNotUniqueException e)
		{
			assertTrue("Client name was not unique", true);
		} 
		catch (ClientDoesNotExistException e)
		{
			assertTrue("Client does not exist", true);
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	
	public void testShouldNotBeAbleToCreateABookingWithInvalidName()
	{
		try 
		{
			BookingType eventType = new BookingType();
			Catering catering = new Catering();
			Employee creator = new Employee();
			Rate rate = new Rate();
			ArrayList<AdditionalCharge> additionalCharge = new ArrayList<AdditionalCharge>();
			Facility facility = new Facility();
			
			BookingManager bm = new BookingManager();
			Booking b = new Booking(0,"","test", new Date(), new Date(), "test" );
			bm.save(0,"", eventType, new Date(), new Date(), "15", "15", "walter adolph"
					, catering, creator, "60", rate,  additionalCharge, facility,
					"-1");
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
		catch (ScheduleInvalidException e) 
		{
			assertTrue("Schedule was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
		catch (NumberInvalidException e)
		{
			assertTrue("Number was not valid", true);
		} 
		catch (DateInvalidException e) 
		{
			assertTrue("Date was not valid", true);
		}
		catch (ClientNameNotUniqueException e)
		{
			assertTrue("Client name was not unique", true);
		} 
		catch (ClientDoesNotExistException e)
		{
			assertTrue("Client does not exist", true);
		}
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}

	public void testShouldNotBeAbleToCreateABookingWithInvalidClient()
	{
		try 
		{
			BookingManager bm = new BookingManager();
			Booking b = new Booking(0,"test","", new Date(), new Date(), "test" );
			bm.validate(b);
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
		catch (ScheduleInvalidException e) 
		{
			assertTrue("Schedule was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
		catch (NumberInvalidException e)
		{
			assertTrue("Number was not valid", true);
		} 
		catch (DateInvalidException e) 
		{
			assertTrue("Date was not valid", true);
		}
		catch (ClientNameNotUniqueException e)
		{
			assertTrue("Client name was not unique", true);
		} 
		catch (ClientDoesNotExistException e)
		{
			assertTrue("Client does not exist", true);
		}
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	public void testShouldNotBeAbleToCreateABookingWithInvalidBookingName()
	{
		try 
		{
			BookingManager bm = new BookingManager();
			Booking b = new Booking(0,"test","test", new Date(), new Date(), "");
			bm.validate(b);
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
		catch (ScheduleInvalidException e) 
		{
			assertTrue("Schedule was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
		catch (NumberInvalidException e)
		{
			assertTrue("Number was not valid", true);
		} 
		catch (DateInvalidException e) 
		{
			assertTrue("Date was not valid", true);
		}
		catch (ClientNameNotUniqueException e)
		{
			assertTrue("Client name was not unique", true);
		} 
		catch (ClientDoesNotExistException e)
		{
			assertTrue("Client does not exist", true);
		}
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	@SuppressWarnings("deprecation")
	public void testShouldNotBeCreatedIfEndDateAfterStartDate()
	{
		try 
		{
			BookingManager bm = new BookingManager();
			Date startDate =new Date(4,4,2010);
			Date endDate = new Date(4,1,2010);
			Booking b = new Booking(0,"Testing","Testing",startDate, endDate, "Test" );
			bm.validate(b);
			fail("booking created"); 
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (NameInvalidException e)
		{
			assertTrue("Name was not valid", true);
		}
		catch (ScheduleInvalidException e) 
		{
			assertTrue("Schedule was not valid", true);
		}
		catch (SetupTimeInvalidException e)
		{
			assertTrue("Setup Time was not valid", true);
		}
		catch (TearDownTimeInvalidException e)
		{
			assertTrue("TearDownTime was not valid", true);
		}
		catch (NumberInvalidException e)
		{
			assertTrue("Number was not valid", true);
		} 
		catch (DateInvalidException e) 
		{
			assertTrue("Date was not valid", true);
		} 
		catch (ClientNameNotUniqueException e)
		{
			assertTrue("Client name was not unique", true);
		} 
		catch (ClientDoesNotExistException e)
		{
			assertTrue("Client does not exist", true);
		}
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}

	public void testShouldBeAbleToDeleteBooking()
	{
		try
		{
			BookingManager bm = new BookingManager();
			Booking b = new Booking();
			b.setId(55556);
			bm.remove(b);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
	
	public void testShouldAddBookingToSchedule()
	{
		
	}
	
	public void testShouldNotToAddBookingToScheduleIfBookingExistsInSpecifiedTimeFrame()
	{
		
	}
	

}
