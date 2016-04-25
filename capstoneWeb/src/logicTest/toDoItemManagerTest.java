package logicTest;

import java.util.Date;

import problemDomain.Booking;
import problemDomain.Rate;
import problemDomain.ToDoItem;
import exceptions.DatabaseConnectionException;
import exceptions.DateInvalidException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;
import junit.framework.TestCase;
import logic.BookingManager;
import logic.RateManager;
import logic.ToDoItemManager;

public class toDoItemManagerTest extends TestCase
{

	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testShouldBeAbleToCreateAToDoItem()
	{
		try 
		{
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(-1, "john", "test", "05/09/2010");
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
		catch (DateInvalidException e) 
		{
			fail("Date is not valid");
		}
	}
	public void testShouldNotBeAbleToCreateAToDoItemWithInvalidId()
	{
		try 
		{
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(-5, "john", "test", "05/09/2010");
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
		catch (DateInvalidException e) 
		{
			fail("Date is not valid");
		}
	}
	
	public void testShouldNotBeAbleToCreateAToDoItemWithInvalidName()
	{
		try 
		{
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(-1, "", "test", "05/09/2010");
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
		catch (DateInvalidException e) 
		{
			fail("Date is not valid");
		}
	}
	
	public void testShouldNotBeAbleToCreateAToDoItemWithInvalidDescription()
	{
		try 
		{
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(-1, "john", "", "05/09/2010");
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
		catch (DateInvalidException e) 
		{
			fail("Date is not valid");
		}
	}
	public void testShouldNotBeAbleToCreateAToDoItemWithInvalidDate()
	{
		try 
		{
			ToDoItemManager tdim = new ToDoItemManager();
			tdim.save(-1, "john", "test", "");
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
		catch (DateInvalidException e) 
		{
			fail("Date is not valid");
		}
	}
	public void testShouldBeAbleToDeleteToDoItem()
	{
		try {
			ToDoItemManager tdim = new ToDoItemManager();
			ToDoItem tdi = new ToDoItem(0, new Date(), "john", "test");
			tdi.setId(1);
			tdim.remove(tdi);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}
