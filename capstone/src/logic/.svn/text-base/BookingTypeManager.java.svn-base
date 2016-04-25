/**
 * 
 */
package logic;

import java.util.List;

import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;
import persistence.BookingTypeBroker;
import problemDomain.BookingType;

/**
 * @author 432873
 * 
 */
public class BookingTypeManager {
	BookingTypeBroker btb;
	
	public BookingTypeManager() throws DatabaseConnectionException
	{
		btb = BookingTypeBroker.getBroker();
	}
	
	/**
	 * @param bt
	 * @return
	 * @throws NameInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws TearDownTimeInvalidException 
	 */
	public boolean validate(BookingType bt) throws NameInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException 
	{
		if(bt.getName() != null)
			throw new NameInvalidException("A booking type requires a name");
		if(bt.getName().length() > 45)
			throw new NameInvalidException("A booking type name cannot excede 45 characters");
		if(bt.getSetupTime() < 0)
			throw new SetupTimeInvalidException("A booking types setup time cannot be a negative number");
		if(bt.getTearDownTime() < 0)
			throw new TearDownTimeInvalidException("A booking types teardown time cannot be a negative number");
			
		return true;
	}
	
	/**
	 * @param name
	 * @param setupTime
	 * @param tearDownTime
	 * @return
	 * @throws TearDownTimeInvalidException
	 * @throws SetupTimeInvalidException
	 * @throws NameInvalidException
	 */
	public boolean validate(String name, String setupTime, String tearDownTime) throws TearDownTimeInvalidException, SetupTimeInvalidException, NameInvalidException
	{
		if(name == null)
			throw new NameInvalidException("A booking type requires a name");
		if(name.length() > 45)
			throw new NameInvalidException("A booking type name cannot excede 45 characters");
		
		try
		{
			int SetupTime = Integer.parseInt(setupTime);
			if(SetupTime < 0)
				throw new SetupTimeInvalidException("A booking types setup time cannot be a negative number");
		}
		catch(NumberFormatException nfe)
		{
			throw new SetupTimeInvalidException("A setup time must be in a numeric format");
		}
		
		try
		{
			int TearDownTime = Integer.parseInt(tearDownTime);
			if(TearDownTime < 0)
				throw new TearDownTimeInvalidException("A booking types teardown time cannot be a negative number");
		}
		catch(NumberFormatException nfe)
		{
			throw new TearDownTimeInvalidException("A booking type teardown time must be in a numeric format");
		}
		
		
		
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<BookingType> search(String query) {
		return null;
	}

	/**
	 * @param bt
	 * @return
	 * @throws TearDownTimeInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws NameInvalidException 
	 */
	public boolean save(BookingType bt) throws NameInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException {
		if(this.validate(bt))
			return btb.persist(bt);
		
		return false;
	}
	
	/**
	 * @param name
	 * @param setupTime
	 * @param tearDownTime
	 * @return
	 * @throws NameInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws NumberFormatException 
	 */
	public boolean save(String name, String setupTime, String tearDownTime) throws NumberFormatException, TearDownTimeInvalidException, SetupTimeInvalidException, NameInvalidException
	{
		BookingType bt = null;
		
		if(this.validate(name, setupTime, tearDownTime))
			bt = new BookingType(name, Integer.parseInt(setupTime), Integer.parseInt(tearDownTime));
		
		return btb.persist(bt);
	}

	/**
	 * @param bt
	 * @return
	 */
	public boolean remove(BookingType bt) {
		return btb.remove(bt);
	}
	
	/**
	 * 
	 */
	public void close() {
		btb.close();
	}
	
	/**
	 * @return
	 */
	private List<BookingType> getAll()
	{
		return null;
	}
}
