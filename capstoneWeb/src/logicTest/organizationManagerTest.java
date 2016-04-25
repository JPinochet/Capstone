package logicTest;

import java.sql.SQLException;

import problemDomain.Employee;
import problemDomain.Organization;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientNameNotUniqueException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.DiscountInvalidException;
import exceptions.NameInvalidException;
import junit.framework.TestCase;
import logic.EmployeeManager;
import logic.OrganizationManager;

public class organizationManagerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShouldBeAbleToCreateAOrganization()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "john", "10%", "jorge", "test");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (NameInvalidException e)
		{
			fail("Name is not valid");
		}
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	
	public void testShouldNotBeAbleToCreateAOrganizationWithInvalidId()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-5, "john", "10%", "jorge", "test");
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
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	
	public void testShouldNotBeAbleToCreateAOrganizationWithInvalidName()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "", "10%", "jorge", "test");
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
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	public void testShouldNotBeAbleToCreateAOrganizationWithInvalidDiscount()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "john", "", "jorge", "test");
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
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	public void testShouldNotBeAbleToCreateAOrganizationWithInvalidContact()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "john", "10%", "", "test");
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
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	public void testShouldNotBeAbleToCreateAOrganizationWithInvalidDescription()
	{
		try 
		{
			OrganizationManager om = new OrganizationManager();
			om.save(-1, "john", "10%", "jorge", "");
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
		catch (DiscountInvalidException e)
		{
			fail("Could not connect to database");
		}
		catch (DescriptionInvalidException e) 
		{
			fail("Description is not valid");
		}
		catch (ClientNameNotUniqueException e) 
		{
			fail("ClientName is not Unique");
		}
		catch (ClientDoesNotExistException e)
		{
			fail("Client is not valid");
		} 
		catch (SQLException e) 
		{
			fail("SQL not found");
		}
	}
	public void testShouldBeAbleToDeleteOrganization()
	{
		try {
			OrganizationManager om = new OrganizationManager();
			Organization o = new Organization(0, "test", "test");
			o.setId(19);
			om.remove(o);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}
