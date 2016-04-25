package logicTest;

import java.util.ArrayList;

import problemDomain.Client;
import problemDomain.Organization;
import exceptions.AddressInvalidException;
import exceptions.CellPhoneInvalidException;
import exceptions.CityInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DiscountInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.HomePhoneInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.WorkPhoneInvalidException;
import junit.framework.TestCase;
import logic.ClientManager;

public class ClientManagerTest extends TestCase
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
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code is not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name is not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname is not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address is not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email is not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City is not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country is not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province is not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount is not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidPostalCode()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	
	public void testShouldNotBeAbleToCreateAClientWithInvalidGivenName()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidSurname()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidAddress()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidEmail()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	
	public void testShouldNotBeAbleToCreateAClientWithInvalidCity()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidCountry()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidProvince()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidDisount()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "", "2445555", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidHomePhoneNumber()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "", "6667777", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidWorkPhone()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "", "3334444", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	public void testShouldNotBeAbleToCreateAClientWithInvalidCellPhone()
	{
		try 
		{
			ArrayList<Organization> Organization = new ArrayList<Organization>();
			ClientManager cm = new ClientManager();
			cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "", "Password",  Organization );
			fail("Client created");
		}
		catch (DatabaseConnectionException e) 
		{
			fail("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			fail("Postal code not valid");
		}
		catch (GivenNameInvalidException e)
		{
			fail("Given name not valid");
		}
		catch (SurnameInvalidException e)
		{
			fail("Surname not valid");
		} 
		catch (AddressInvalidException e) 
		{
			fail("Address not valid");
		}
		catch (EmailInvalidException e) 
		{
			fail("Email not valid");
		}
		catch (CityInvalidException e) 
		{
			fail("City not valid");
		} 
		catch (CountryInvalidException e) 
		{
			fail("Country not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			fail("Province not valid");
		} 
		catch (DiscountInvalidException e)
		{
			fail("Discount not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			fail("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			fail("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			fail("Cell phone number is not valid");
		} 
	}
	
	public void testShouldBeAbleToDeleteClient()
	{
		try {
			ClientManager cm = new ClientManager();
			Client c = new Client();
			c.setId(30);
			cm.remove(c);
		}
		catch(DatabaseConnectionException e)
		{
			fail("Database connection is not valid");
		}
		
	}
}
