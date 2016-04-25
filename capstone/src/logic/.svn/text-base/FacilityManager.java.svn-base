/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.NameInvalidException;

import persistence.FacilityBroker;
import problemDomain.AdditionalCharge;
import problemDomain.Facility;
import problemDomain.Rate;

/**
 * @author 432873
 * 
 */
public class FacilityManager 
{
	FacilityBroker fb;
	
	/**
	 * @throws DatabaseConnectionException
	 */
	public FacilityManager() throws DatabaseConnectionException
	{
		fb = FacilityBroker.getBroker();
	}
	
	/**
	 * @param facility
	 * @return
	 * @throws CostInvalidException 
	 * @throws NameInvalidException 
	 * @throws DatabaseConnectionException 
	 * @throws DescriptionInvalidException 
	 */
	public boolean validate(String openTime, String closeTime, String setupTime, String tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			String maxCapacity, String minBookingInterval, String minBookingTime) throws CostInvalidException, NameInvalidException, DatabaseConnectionException, DescriptionInvalidException 
	{
		try
		{
			int OpenTime = Integer.parseInt(openTime);
			if(OpenTime < 0)
			{
				throw new CostInvalidException("A facilities opening time must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities opening time must be in an number format.");
		}
		
		try
		{
			int CloseTime = Integer.parseInt(closeTime);
			if(CloseTime < 0)
			{
				throw new CostInvalidException("A facilities closing time must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities closing time must be in an number format.");
		}
		
		try
		{
			int SetupTime = Integer.parseInt(setupTime);
			if(SetupTime < 0)
			{
				throw new CostInvalidException("A facilities setup time must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities setup time must be in an number format.");
		}
		
		try
		{
			int TearDownTime = Integer.parseInt(tearDownTime);
			if(TearDownTime < 0)
			{
				throw new CostInvalidException("A facilities teardown time must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities teardown time must be in an number format.");
		}
		
		if(name == null)
			throw new NameInvalidException("A facility requires a name to identify it.");
		if(name.length() > 30)
			throw new NameInvalidException("A facility's name cannot excede 30 characters.");
		
		RateManager rm = new RateManager();
		for(int i = 0; i < rates.size(); i++)
		{
			rm.validate(rates.get(i));
		}
		
		AdditionalChargeManager acm = new AdditionalChargeManager();
		for(int i = 0; i < additionalCharges.size(); i++)
		{
			acm.validate(additionalCharges.get(i));
		}
		
		try
		{
			int MaxCapacity = Integer.parseInt(maxCapacity);
			if(MaxCapacity < 0)
			{
				throw new CostInvalidException("A facilities max capacity must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities max capacity must be in an number format.");
		}
		
		try
		{
			int MinBookingInterval = Integer.parseInt(minBookingInterval);
			if(MinBookingInterval < 0)
			{
				throw new CostInvalidException("A facilities minimum booking interval must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities minimum booking interval must be in an number format.");
		}
		
		try
		{
			int MinBookingTime = Integer.parseInt(minBookingTime);
			if(MinBookingTime < 0)
			{
				throw new CostInvalidException("A facilities minimum booking time must be a positive number.");
			}
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("A facilities minimum booking time must be in an number format.");
		}
		
		return true;
	}
	
	/**
	 * @param facility
	 * @return
	 * @throws CostInvalidException
	 * @throws NameInvalidException
	 * @throws DatabaseConnectionException
	 * @throws DescriptionInvalidException
	 */
	public boolean validate(Facility facility) throws CostInvalidException, NameInvalidException, DatabaseConnectionException, DescriptionInvalidException
	{
		if(facility.getOpenTime() < 0)
		{
			throw new CostInvalidException("A facilities opening time must be a positive number.");
		}
		
		if(facility.getCloseTime() < 0)
		{
			throw new CostInvalidException("A facilities closing time must be a positive number.");
		}
		
		if(facility.getSetupTime() < 0)
		{
			throw new CostInvalidException("A facilities setup time must be a positive number.");
		}
		
		if(facility.getTearDownTime() < 0)
		{
			throw new CostInvalidException("A facilities teardown time must be a positive number.");
		}
		
		if(facility.getName() == null)
			throw new NameInvalidException("A facility requires a name to identify it.");
		if(facility.getName().length() > 30)
			throw new NameInvalidException("A facility's name cannot excede 30 characters.");
		
		RateManager rm = new RateManager();
		for(int i = 0; i < facility.getRates().size(); i++)
		{
			rm.validate(facility.getRates().get(i));
		}
		
		AdditionalChargeManager acm = new AdditionalChargeManager();
		for(int i = 0; i < facility.getAdditionalCharges().size(); i++)
		{
			acm.validate(facility.getAdditionalCharges().get(i));
		}
		
		if(facility.getMaxCapacity() < 0)
		{
			throw new CostInvalidException("A facilities max capacity must be a positive number.");
		}
		
		if(facility.getMinBookingInterval() < 0)
		{
			throw new CostInvalidException("A facilities minimum booking interval must be a positive number.");
		}
		
		if(facility.getMinBookingTime() < 0)
		{
			throw new CostInvalidException("A facilities minimum booking time must be a positive number.");
		}
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<Facility> search(String query) {
		return null;
	}

	/**
	 * @param facility
	 * @return
	 * @throws CostInvalidException 
	 * @throws NumberFormatException 
	 * @throws NameInvalidException 
	 * @throws DescriptionInvalidException 
	 * @throws DatabaseConnectionException 
	 */
	public boolean save(String openTime, String closeTime, String setupTime, String tearDownTime, String name, ArrayList<Rate> rates, ArrayList<AdditionalCharge> additionalCharges,
			String maxCapacity, String minBookingInterval, String minBookingTime) throws NumberFormatException, CostInvalidException, NameInvalidException, DatabaseConnectionException, DescriptionInvalidException 
	{
		Facility facility = null;
		
		if(this.validate(openTime, closeTime, setupTime, tearDownTime, name, rates, additionalCharges, maxCapacity, minBookingInterval, minBookingTime))
			facility = new Facility(Integer.parseInt(openTime), Integer.parseInt(closeTime), Integer.parseInt(setupTime), Integer.parseInt(tearDownTime), name, rates, additionalCharges, Integer.parseInt(maxCapacity), Integer.parseInt(minBookingInterval), Integer.parseInt(minBookingTime));
		
		return fb.persist(facility);
	}
	
	/**
	 * @param facility
	 * @return
	 * @throws CostInvalidException
	 * @throws NameInvalidException
	 * @throws DatabaseConnectionException
	 * @throws DescriptionInvalidException
	 */
	public boolean save(Facility facility) throws CostInvalidException, NameInvalidException, DatabaseConnectionException, DescriptionInvalidException
	{
		if(this.validate(facility))
			return fb.persist(facility);
		
		return false;
	}

	/**
	 * @param facility
	 * @return
	 */
	public boolean remove(Facility facility)
	{
		return fb.remove(facility);
	}
	
	/**
	 * 
	 */
	public void close() {
		fb.close();
	}
	
	/**
	 * @return
	 */
	private List<Facility> getAll()
	{
		return null;
	}
}
