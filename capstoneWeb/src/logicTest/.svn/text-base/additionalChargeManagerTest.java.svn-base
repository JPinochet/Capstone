package logicTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import problemDomain.AdditionalCharge;
import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import junit.framework.TestCase;
import logic.AdditionalChargeManager;

public class additionalChargeManagerTest extends TestCase
{
	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}
	
	public void testShouldBeAbleToCreateAAdditionalCharge()
	{
		try 
		{
			AdditionalChargeManager acm = new AdditionalChargeManager();
			acm.save(9,"test", "20");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (CostInvalidException e)
		{
			fail("Cost was not valid");
		} 
		catch (NameInvalidException e) 
		{
			fail("Name was not valid");
		}
	}
	public void testShouldNotBeAbleToCreateAAdditionalChargeWithInvalidName()
	{
		try 
		{
			AdditionalChargeManager acm = new AdditionalChargeManager();
			acm.save(0,"", "20");
			fail("Additional Charge created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (CostInvalidException e)
		{
			fail("Cost was not valid");
		} 
		catch (NameInvalidException e) 
		{
			fail("Name was not valid");
		}
	}
	public void testShouldNotBeAbleToCreateAAdditionalChargeWithInvalidCost()
	{
		try 
		{
			AdditionalChargeManager acm = new AdditionalChargeManager();
			acm.save(0,"test", "-5");
			fail("Additional Charge created");
			
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (CostInvalidException e)
		{
			fail("Cost was not valid");
		} 
		catch (NameInvalidException e) 
		{
			fail("Name was not valid");
		}
	}
	public void testShouldBeAbleToDeleteAdditionalCharge()
	{
		try {
			AdditionalChargeManager acm = new AdditionalChargeManager();
			AdditionalCharge ac = new AdditionalCharge();
			ac.setId(11);
			acm.remove(ac);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
	
}
