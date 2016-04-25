package logicTest;

import problemDomain.Employee;
import exceptions.DatabaseConnectionException;
import exceptions.GivenNameInvalidException;
import exceptions.PasswordInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.UsernameInvalidException;
import junit.framework.TestCase;
import logic.EmployeeManager;

public class employeeManagerTest extends TestCase 
{
	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}
	
	public void testShouldBeAbleToCreateAClient()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "test", "john", "stuby", "1");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		
	}
	
	public void testShouldNotBeAbleToCreateAEmployeeWithInvalidUsername()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "", "tester", "john", "stuby", "1");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
	}
	
	public void testShouldNotBeAbleToCreateAEmployeeWithInvalidPassword()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "", "john", "stuby", "1");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
	}
	public void testShouldNotBeAbleToCreateAEmployeeWithInvalidGivenName()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "tester", "", "stuby", "1");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
	}
	public void testShouldNotBeAbleToCreateAEmployeeWithInvalidSurname()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "tester", "john", "", "1");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
	}
	public void testShouldNotBeAbleToCreateAEmployeeWithInvalidEmployeeLevel()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			em.save(-1, "tester", "tester", "john", "stuby", "");
			fail("Booking created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		} 
		catch (GivenNameInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (PasswordInvalidException e) 
		{
			fail("Could not connect to database");
		} 
		catch (SurnameInvalidException e) 
		{
			fail("Could not connect to database");
		}
		catch (UsernameInvalidException e) 
		{
			fail("Could not connect to database");
		}
	}
	public void testShouldBeAbleToDeleteEmployee()
	{
		try 
		{
			EmployeeManager em = new EmployeeManager();
			Employee e = new Employee(18, "username", "password", "givenName", "Surname", 1);
			e.setId(18);
			em.remove(e);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}