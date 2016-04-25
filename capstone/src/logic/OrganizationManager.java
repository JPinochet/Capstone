/**
 * 
 */
package logic;

import java.util.List;

import exceptions.AddressInvalidException;
import exceptions.CityInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.NameInvalidException;
import exceptions.DiscountInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.SurnameInvalidException;
import persistence.OrganizationBroker;
import problemDomain.Client;
import problemDomain.Organization;

/**
 * @author 432873
 * 
 */
/**
 * @author 432873
 *
 */
public class OrganizationManager 
{
	OrganizationBroker ob;
	
	/**
	 * @throws DatabaseConnectionException
	 */
	public OrganizationManager() throws DatabaseConnectionException
	{
		ob = OrganizationBroker.getBroker();
	}
	
	/**
	 * @param org
	 * @return
	 * @throws DescriptionInvalidException 
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 */
	public boolean validate(String name, String discount, Client contact, String description) throws NameInvalidException, DiscountInvalidException, DescriptionInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException
	{
		if(name == null)
			throw new NameInvalidException("An organization requires a name to identify it.");
		if(name.length() > 30)
			throw new NameInvalidException("An organizations name cannot excede 30 characters."); 
		if(description.length() > 400)
			throw new DescriptionInvalidException("A description cannot excede 400 characters");
		
		try
		{
			Double disCount = Double.parseDouble(discount);
			if(disCount < 0)
				throw new DiscountInvalidException("A discount cannot be a negative number");
		}
		catch(NumberFormatException nfe)
		{
			throw new DiscountInvalidException("A discount must be inputed in a number format.");
		}
		
		ClientManager cm = new ClientManager();
		cm.validate(contact);
		
		return true;
	}
	
	/**
	 * @param org
	 * @return
	 * @throws DiscountInvalidException
	 * @throws DescriptionInvalidException
	 * @throws NameInvalidException
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 */
	public boolean validate(Organization org) throws DiscountInvalidException, DescriptionInvalidException, NameInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException
	{
		if(org.getName() == null)
			throw new NameInvalidException("An organization requires a name to identify it.");
		if(org.getName().length() > 30)
			throw new NameInvalidException("An organizations name cannot excede 30 characters."); 
		if(org.getDescription().length() > 400)
			throw new DescriptionInvalidException("A description cannot excede 400 characters");
		
		if(org.getDiscount() < 0)
			throw new DiscountInvalidException("A discount cannot be a negative number");
		
		ClientManager cm = new ClientManager();
		cm.validate(org.getContact());
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<Organization> search(String query) {
		return null;
	}

	
	/**
	 * @param name
	 * @param discount
	 * @param contact
	 * @param description
	 * @return
	 * @throws NumberFormatException
	 * @throws NameInvalidException
	 * @throws DiscountInvalidException
	 * @throws DescriptionInvalidException
	 * @throws DatabaseConnectionException
	 * @throws GivenNameInvalidException
	 * @throws SurnameInvalidException
	 * @throws AddressInvalidException
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 */
	public boolean save(String name, String discount, Client contact, String description) throws NumberFormatException, NameInvalidException, DiscountInvalidException, DescriptionInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException 
	{
		Organization org = null;
		
		if(this.validate(name, discount, contact, description))
				org = new Organization(name, Double.parseDouble(discount), contact, description);
		
		return ob.persist(org);
	}
	
	/**
	 * @param org
	 * @return
	 * @throws DiscountInvalidException
	 * @throws DescriptionInvalidException
	 * @throws NameInvalidException
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 */
	public boolean save(Organization org) throws DiscountInvalidException, DescriptionInvalidException, NameInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException
	{
		if(this.validate(org))
			return ob.persist(org);
		
		return false;
	}

	/**
	 * @param org
	 * @return
	 */
	public boolean remove(Organization org) 
	{
		return ob.remove(org);
	}
	
	/**
	 * 
	 */
	public void close() {
		ob.close();
	}
	
	/**
	 * @return
	 */
	private List<Organization> getAll()
	{
		return null;
	}
}
