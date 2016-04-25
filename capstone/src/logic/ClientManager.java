/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import exceptions.AddressInvalidException;
import exceptions.CityInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DiscountInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.SurnameInvalidException;
import persistence.ClientBroker;
import problemDomain.Client;
import problemDomain.Organization;
import problemDomain.Phone;

/**
 * @author 432873
 * 
 */
public class ClientManager {
	ClientBroker clb;
	
	public ClientManager() throws DatabaseConnectionException
	{
		clb = ClientBroker.getBroker();
	}
	
	
	
	/**
	 * @param client
	 * @return
	 * @throws GivenNameInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws AddressInvalidException 
	 * @throws EmailInvalidException 
	 * @throws CityInvalidException 
	 * @throws CountryInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws ProvinceInvalidException 
	 */
	public boolean validate(Client client) throws GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException 
	{	
		if(client.getGivenName() == null)
			throw new GivenNameInvalidException("A client must have a given name");
		if(client.getGivenName().length() > 45)
			throw new GivenNameInvalidException("A client cannot excede 45 characters");
		if(client.getSurname() == null)
			throw new SurnameInvalidException("A client must have a surname");
		if(client.getSurname().length() > 63)
			throw new SurnameInvalidException("A client surname cannot excede 63 characters");
		if(client.getAddress() != null)
			if(client.getAddress().length() > 75)
				throw new AddressInvalidException("An address cannot excede 75 characters");
		if(client.getEmail() == null)
			throw new EmailInvalidException("A client must have an email");
		if(client.getEmail().length() > 50)
			throw new EmailInvalidException("A clients email address cannot excede 50 characters");
		if(validateEmail(client.getEmail()))
			throw new EmailInvalidException("Invalid Email format.");
		if(client.getCity() != null)
			if(client.getCity().length() > 75)
				throw new CityInvalidException("A clients city name cannot excede 75 characters");
		if(client.getCountry() != null)
			if(client.getCountry().length() > 25)
				throw new CountryInvalidException("A clients country name cannot excede 25 characters");
		if(client.getProvince() != null)
			if(client.getProvince().length() > 2)
				throw new ProvinceInvalidException("A clients province name cannot excede 2 characters, remember you abbreiviate it");
		if(client.getPostalCode() != null)
		{
			if(client.getPostalCode().length() > 6)
				throw new PostalCodeInvalidException("A clients postal code cannot excede 6 characters");
			
			if(client.getPostalCode().length() == 6)
				if(validatePostalCode(client.getPostalCode()))
					throw new PostalCodeInvalidException("Invalid Postal Code format.");
			
			if(client.getPostalCode().length() == 5)
			{
				try
				{
					if(Double.isNaN(Integer.parseInt(client.getPostalCode())))
						throw new PostalCodeInvalidException("Invalid Zip Code format.");
				}
				catch(NumberFormatException nfe)
				{
					throw new PostalCodeInvalidException("Invalid Zip Code format or missing a character in Postal Code.");
				}
					
			}
		}
		
		return true;
	}
	
	/**
	 * @param givenName
	 * @param surname
	 * @param address
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param country
	 * @param email
	 * @param phoneNumbers
	 * @param discount
	 * @param organizations
	 * @param password
	 * @return
	 * @throws PostalCodeInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws AddressInvalidException 
	 * @throws EmailInvalidException 
	 * @throws CityInvalidException 
	 * @throws CountryInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws DiscountInvalidException 
	 */
	public boolean validate(String givenName, String surname, String address, String city, String province, String postalCode, String country, String email, ArrayList<Phone> phoneNumbers,
			String discount, ArrayList<Organization> organizations, String password) throws PostalCodeInvalidException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, ProvinceInvalidException, DiscountInvalidException
	{
		if(givenName == null)
			throw new GivenNameInvalidException("A client must have a given name");
		if(givenName.length() > 45)
			throw new GivenNameInvalidException("A client cannot excede 45 characters");
		if(surname == null)
			throw new SurnameInvalidException("A client must have a surname");
		if(surname.length() > 63)
			throw new SurnameInvalidException("A client surname cannot excede 63 characters");
		if(address != null)
			if(address.length() > 75)
				throw new AddressInvalidException("An address cannot excede 75 characters");
		if(email == null)
			throw new EmailInvalidException("A client must have an email");
		if(email.length() > 50)
			throw new EmailInvalidException("A clients email address cannot excede 50 characters");
		if(validateEmail(email))
			throw new EmailInvalidException("Invalid Email format.");
		if(city != null)
			if(city.length() > 75)
				throw new CityInvalidException("A clients city name cannot excede 75 characters");
		if(country != null)
			if(country.length() > 25)
				throw new CountryInvalidException("A clients country name cannot excede 25 characters");
		if(province != null)
			if(province.length() > 2)
				throw new ProvinceInvalidException("A clients province name cannot excede 2 characters, remember you abbreiviate it");
		if(postalCode != null)
		{
			if(postalCode.length() > 6)
				throw new PostalCodeInvalidException("A clients postal code cannot excede 6 characters");
			
			if(postalCode.length() == 6)
				if(validatePostalCode(postalCode))
					throw new PostalCodeInvalidException("Invalid Postal Code format.");
			
			if(postalCode.length() == 5)
			{
				try
				{
					if(!Double.isNaN(Integer.parseInt(postalCode)))
						throw new PostalCodeInvalidException("Invalid Zip Code format.");
				}
				catch(NumberFormatException nfe)
				{
					throw new PostalCodeInvalidException("Invalid Zip Code format or missing a character in Postal Code.");
				}
					
			}
		}
		
		try
		{
			if(discount.length() > 3)
				throw new DiscountInvalidException("A client discount cannot excede 3 characters as a percentage. % symbol not required.");
			
			if(!Double.isNaN(Integer.parseInt(discount)))
				throw new DiscountInvalidException("A client discount must be in a number format");
		}
		catch(NumberFormatException nfe)
		{
			throw new DiscountInvalidException("A client discount must be in a number format");
		}
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<Client> search(String query) {
		return null;
	}

	/**
	 * @param client
	 * @return
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws AddressInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 */
	public boolean save(Client client) throws GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException 
	{
		if(this.validate(client))
			return clb.persist(client);
		
		return false;
	}
	
	public boolean save(String givenName, String surname, String address, String city, String province, String postalCode, String country, String email, ArrayList<Phone> phoneNumbers,
			String discount, ArrayList<Organization> organizations, String password) throws PostalCodeInvalidException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, ProvinceInvalidException, DiscountInvalidException
	{
		Client client = null;
		
		if(this.validate(givenName, surname, address, city, province, postalCode, country, email, phoneNumbers, discount, organizations, password))
			client = new Client(givenName, surname, address, city, province, postalCode, country, email, phoneNumbers, password);
		
		return clb.persist(client);
	}

	/**
	 * @param client
	 * @return
	 */
	public boolean remove(Client client) 
	{
		return clb.remove(client);
	}
	
	/**
	 * 
	 */
	public void close() {
		clb.close();
	}
	
	/**
	 * @return
	 */
	private List<Client> getAll()
	{
		return null;
	}
	
	/**
	 * @param email
	 * @return
	 */
	private boolean validateEmail(String email)
	{
		//Set the email pattern string
	      Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

	      //Match the given string with the pattern
	      Matcher m = p.matcher(email);

	      //check whether match is found 
	      return m.matches();
	      
	}
	
	/**
	 * @param postalCode
	 * @return
	 */
	private boolean validatePostalCode(String postalCode)
	{
		Pattern p = Pattern.compile("^([A-Z][0-9][A-Z])([0-9][A-Z][0-9])$");
		
		Matcher m = p.matcher(postalCode);
		
		return m.matches();
	}
}
