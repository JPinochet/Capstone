/**
 * 
 */
package logic;

import java.util.List;

import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;
import persistence.RateBroker;
import problemDomain.Rate;

/**
 * @author 432873
 * 
 */
public class RateManager {
	RateBroker rb;
	
	public RateManager() throws DatabaseConnectionException 
	{
		rb = RateBroker.getBroker();
	}
	
	/**
	 * @param rate
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException
	 * @throws CostInvalidException
	 */
	public boolean validate(Rate rate) throws NameInvalidException, DescriptionInvalidException, CostInvalidException
	{
		if(rate.getName() == null)
			throw new NameInvalidException("A Rate must have a name to identify it");
		if(rate.getName().length() > 30)
			throw new NameInvalidException("A Rate name cannot excede 30 characters.");
		if(rate.getDescription().length() > 400)
			throw new DescriptionInvalidException("A description cannot excede 400 characters");
		
		try
		{
			if(rate.getRate() < 0 )
				throw new CostInvalidException("The Rate cost cannot be negative.");
			
			if(rate.getDamageDeposit() < 0)
				throw new CostInvalidException("The Rate damage deposit cannot be negative.");
			
			if(rate.getBookingDeposit() < 0)
				throw new CostInvalidException("The Rate booking deposit cannot be negative.");
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("The Rate cost must be entered in as a number format");
		}
		
		return true;
	}
	
	/**
	 * @param name
	 * @param description
	 * @param rateCost
	 * @param damageDeposit
	 * @param bookingDeposit
	 * @return
	 */
	public boolean validate(String name, String description, String rateCost, String damageDeposit, String bookingDeposit) throws CostInvalidException, NameInvalidException, DescriptionInvalidException
	{
		if(name == null)
			throw new NameInvalidException("A Rate must have a name to identify it");
		if(name.length() > 30)
			throw new NameInvalidException("A Rate name cannot excede 30 characters.");
		if(description.length() > 400)
			throw new DescriptionInvalidException("A description cannot excede 400 characters");
		
		try
		{
			Double cost = Double.parseDouble(rateCost);
			if(cost < 0 )
				throw new CostInvalidException("The Rate cost cannot be negative.");
			
			Double dd = Double.parseDouble(damageDeposit);
			if(dd < 0)
				throw new CostInvalidException("The Rate damage deposit cannot be negative.");
			
			Double bd = Double.parseDouble(bookingDeposit);
			if(bd < 0)
				throw new CostInvalidException("The Rate booking deposit cannot be negative.");
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("The Rate cost must be entered in as a number format");
		}
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<Rate> search(String query) 
	{
		return null;
	}

	/**
	 * @param name
	 * @param description
	 * @param rateCost
	 * @param damageDeposit
	 * @param bookingDeposit
	 * @return
	 * @throws DescriptionInvalidException 
	 * @throws NumberFormatException 
	 */
	public boolean save(String name, String description, String rateCost, String damageDeposit, String bookingDeposit) throws CostInvalidException, NameInvalidException, NumberFormatException, DescriptionInvalidException
	{
		Rate rate = null;
		
		if(this.validate(name, description, rateCost, damageDeposit, bookingDeposit))
			rate = new Rate(name, description, Double.parseDouble(rateCost), Double.parseDouble(damageDeposit), Double.parseDouble(bookingDeposit));
		
		return rb.persist(rate);
	}
	
	/**
	 * @param rate
	 * @return
	 * @throws NameInvalidException
	 * @throws DescriptionInvalidException
	 * @throws CostInvalidException
	 */
	public boolean save(Rate rate) throws NameInvalidException, DescriptionInvalidException, CostInvalidException
	{
		if(this.validate(rate))
			return rb.persist(rate);
		
		return false;
	}

	/**
	 * @param rate
	 * @return
	 */
	public boolean remove(Rate rate) 
	{
		return rb.remove(rate);
	}
	
	/**
	 * 
	 */
	public void close() {
		rb.close();
	}
	
	/**
	 * @return
	 */
	private List<Rate> getAll()
	{
		return null;
	}
}
