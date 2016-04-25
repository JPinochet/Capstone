/**
 * 
 */
package logic;

import java.util.List;

import exceptions.CostInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import persistence.AdditionalChargeBroker;
import problemDomain.AdditionalCharge;

/**
 * @author 432873
 * 
 */
public class AdditionalChargeManager {
	AdditionalChargeBroker acb;
	
	/**
	 * @throws DatabaseConnectionException 
	 * 
	 */
	public AdditionalChargeManager() throws DatabaseConnectionException {
		acb = AdditionalChargeBroker.getBroker();
	}

	public boolean validate(AdditionalCharge ac) throws NameInvalidException, CostInvalidException
	{
		if(ac.getName() == null)
			throw new NameInvalidException("An Additional Charge must have a name to identify it");
		if(ac.getName().length() > 30)
			throw new NameInvalidException("Additional Charge name cannot excede 30 characters.");
		
		if(!Double.isNaN(ac.getCost()))
			throw new CostInvalidException("The additional charge cost must be a number");
		
		if(ac.getCost() < 0 )
			throw new CostInvalidException("Cost cannot be negative.");
		
		return true;
	}
	
	/**
	 * @param ac
	 * @return
	 */
	public boolean validate(String acName, String cost) throws CostInvalidException, NameInvalidException/*throws AdditionalChargeNameTooLongException, etc...*/ 
	{
		
		if(acName == null)
			throw new NameInvalidException("An Additional Charge must have a name to identify it");
		if(acName.length() > 30)
			throw new NameInvalidException("Additional Charge name cannot excede 30 characters.");
		
		try
		{
			Double acCost = Double.parseDouble(cost);
			
			if(acCost < 0 )
				throw new CostInvalidException("Cost cannot be negative.");
		}
		catch(NumberFormatException nfe)
		{
			throw new CostInvalidException("The additional charge cost must be a number");
		}
		
		
		return true;
	}

	/**
	 * @param search
	 * @return
	 */
	public List<AdditionalCharge> search(String query) {
		return null;
	}

	/**
	 * @param ac
	 * @return
	 * @throws NameInvalidException 
	 * @throws CostInvalidException 
	 * @throws NumberFormatException 
	 */
	public boolean save(String acName, String acCost) throws NumberFormatException, CostInvalidException, NameInvalidException {
		AdditionalCharge ac = null;
		
		if(this.validate(acName, acCost))
			ac = new AdditionalCharge(acName, Double.parseDouble(acCost));
		
		return acb.persist(ac);
	}
	
	/**
	 * @param ac
	 * @return
	 * @throws NameInvalidException
	 * @throws CostInvalidException
	 */
	public boolean save(AdditionalCharge ac) throws NameInvalidException, CostInvalidException
	{
		if(this.validate(ac))
			return acb.persist(ac);
		
		return false;
	}

	/**
	 * @param ac
	 * @return
	 */
	public boolean remove(AdditionalCharge ac) {
		return acb.remove(ac);
	}
	
	/**
	 * 
	 */
	public void close() {
		acb.close();
	}
	
	/**
	 * @return
	 */
	private List<AdditionalCharge> getAll()
	{
		return null;
	}
}
