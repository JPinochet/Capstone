package logicTest;

import java.text.ParseException;
import java.util.ArrayList;

import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Organization;
import problemDomain.Payment;
import problemDomain.Rate;
import exceptions.BookingDepositInvalidException;
import exceptions.CostInvalidException;
import exceptions.DamageDepositInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;
import junit.framework.TestCase;
import logic.InvoiceManager;
import logic.OrganizationManager;
import logic.RateManager;

public class rateManagerTest extends TestCase 
{

	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testShouldBeAbleToCreateARate()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "5.0", "5.0", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		} 
		catch (ParseException e) 
		{
			fail("Was not parced correctly");
		}
	}
	public void testShouldNotBeAbleToCreateARateWithInvalidId()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-5, "test", "test", "15.0", "5.0",
					"5.0", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		} 
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	
	public void testShouldNotBeAbleToCreateARateWithInvalidName()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "", "test", "15.0", "5.0",
					"5.0", " is hourly true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		} 
		catch (ParseException e)
		{
			fail("Error while parsing");
		}
	}
	
	public void testShouldNotBeAbleToCreateARateWithInvalidDescription()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "", "15.0", "5.0",
					"5.0", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	
	public void testShouldNotBeAbleToCreateARateWithInvalidRate()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "", "5.0",
					"5.0", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	
	public void testShouldNotBeAbleToCreateARateWithInvalidDamageDeposit()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "",
					"5.0", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	public void testShouldNotBeAbleToCreateARateWithInvalidBookingDeposit()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "5.0",
					"", "true", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	public void testShouldNotBeAbleToCreateARateWithInvalidIsHourly()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "5.0",
					"5.0", "", "1/1/2010",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	public void testShouldNotBeAbleToCreateARateWithInvalidStartTime()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "5.0",
					"5.0", "true", "",
					"1/1/2010", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	public void testShouldNotBeAbleToCreateARateWithInvalidEndTime()
	{
		try 
		{
			RateManager rm = new RateManager();
			rm.save(-1, "john", "test", "15.0", "5.0",
					"5.0", "true", "1/1/2010",
					"", "monday", "tuesday", "wednesday", "thursday",
					"friday", "saturday", "sunday");
			fail("Rate created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e) 
		{
			fail("Name is not valid");
		} 
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		} 
		catch (CostInvalidException e) 
		{
			fail("Cost is not valid");
		}
		catch (DamageDepositInvalidException e)
		{
			fail("Damage deposit is not valid");
		} 
		catch (BookingDepositInvalidException e)
		{
			fail("Booking deposit is not valid");
		}
		catch (ParseException e) 
		{
			fail("Error while parsing");
		}
	}
	public void testShouldBeAbleToDeleteRate()
	{
		try {
			RateManager rm = new RateManager();
			Rate r = new Rate(0, "test", "test", 15, 15, 15);
			r.setId(16);
			rm.remove(r);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}
