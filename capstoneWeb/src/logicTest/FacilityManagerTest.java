package logicTest;

import java.util.ArrayList;
import java.util.List;

import problemDomain.AdditionalCharge;
import problemDomain.Employee;
import problemDomain.Facility;
import problemDomain.Rate;
import exceptions.CloseTimeInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.MaxCapacityInvalidException;
import exceptions.MinBookingIntervalInvalidException;
import exceptions.MinBookingTimeInvalidException;
import exceptions.NameInvalidException;
import exceptions.OpenTimeInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;
import junit.framework.TestCase;
import logic.EmployeeManager;
import logic.FacilityManager;

public class FacilityManagerTest extends TestCase 
{

	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testShouldBeAbleToCreateAFacility()
	{
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
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidName()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "", "8", "16", "15",
					"15", rates, additionalCharges, "60", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidOpenTime()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "", "16", "15",
					"15", rates, additionalCharges, "60", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidCloseTime()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "", "15",
					"15", rates, additionalCharges, "60", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidSetupTime()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "16", "",
					"15", rates, additionalCharges, "60", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidTearDownTime()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "16", "15",
					"", rates, additionalCharges, "60", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidMaxCapacity()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "16", "15",
					"15", rates, additionalCharges, "", 
					"15", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidBookingInterval()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "16", "15",
					"15", rates, additionalCharges, "60", 
					"", "15");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAFacilityWithInvalidBookingTime()
	{
		try 
		{
			FacilityManager fm = new FacilityManager();
			ArrayList rates = new ArrayList();
			rates.add(rates);
			ArrayList additionalCharges = new ArrayList();
			additionalCharges.add(additionalCharges);
			fm.save(-1, "john", "8", "16", "15",
					"15", rates, additionalCharges, "60", 
					"15", "");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (OpenTimeInvalidException e)
		{
			fail("Open time is not valid");
		} 
		catch (CloseTimeInvalidException e)
		{
			fail("Close time is not valid");
		}
		catch (SetupTimeInvalidException e) 
		{
			fail("Set up time is not valid");
		} 
		catch (TearDownTimeInvalidException e)
		{
			fail("Tear down time is not valid");
		} 
		catch (MaxCapacityInvalidException e) 
		{
			fail("Max capacity is not valid");
		}
		catch (MinBookingIntervalInvalidException e)
		{
			fail("Min booking interval is not valid");
		} 
		catch (MinBookingTimeInvalidException e) 
		{
			fail("Min booking time is not valid");
		} 
	}
	public void testShouldBeAbleToDeleteFacility()
	{
		try 
		{
			
			FacilityManager fm = new FacilityManager();
			fm.remove(null);
			
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
	
}
