/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.DatabaseConnectionException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.TearDownTimeInvalidException;
import persistence.BookingBroker;
import problemDomain.AdditionalCharge;
import problemDomain.Booking;
import problemDomain.BookingType;
import problemDomain.Client;
import problemDomain.Employee;
import problemDomain.Facility;
import problemDomain.Rate;

/**
 * @author 432873
 * 
 */
public class BookingManager {
	BookingBroker bb; //Singleton again
	
	public BookingManager() throws DatabaseConnectionException
	{
		bb = BookingBroker.getBroker();
	}
	
	/**
	 * @param facility
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Booking> generateSchedule(Facility facility, Date start, Date end) {
		return null;
	}

	/**
	 * @param booking
	 * @return
	 * @throws NameInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws NumberInvalidException 
	 */
	public boolean validate(Booking booking) throws NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException 
	{
		if(booking.getEventTitle() == null)
			throw new NameInvalidException("A booking requires a title to identify it.");
		if(booking.getEventTitle().length() > 25)
			throw new NameInvalidException("A booking title cannot exceed 25 characters.");
		
		if(this.search(booking.getStartTime(), booking.getEndTime()) != null)
			throw new ScheduleInvalidException("A booking is already scheduled for this time.");
		
		if(booking.getSetupTime() < 0)
			throw new SetupTimeInvalidException("A setup time must be a positive number");
		if(booking.getTearDownTime() < 0)
			throw new TearDownTimeInvalidException("A setup time must be a positive number");
		if(booking.getNumberOfPeople() < 0)
			throw new NumberInvalidException("The number of people at an event must be a positive, whole number.");
		
		return true;
	}
	
	/**
	 * @param eventTitle
	 * @param eventType
	 * @param startTime
	 * @param endTime
	 * @param setupTime
	 * @param tearDownTime
	 * @param client
	 * @param creator
	 * @param rate
	 * @param additionalCharges
	 * @param facility
	 * @param invoice_no
	 * @return
	 * @throws NameInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws NumberInvalidException 
	 */
	public boolean validate(String eventTitle, BookingType eventType, Date startTime, Date endTime, String setupTime, String tearDownTime, Client client, Employee creator, String numberOfPeople, Rate rate,
			ArrayList<AdditionalCharge> additionalCharges, Facility facility, String invoice_no) throws NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException
	{
		if(eventTitle == null)
			throw new NameInvalidException("A booking requires a title to identify it.");
		if(eventTitle.length() > 25)
			throw new NameInvalidException("A booking title cannot exceed 25 characters.");
		
		if(this.search(startTime, endTime) != null)
			throw new ScheduleInvalidException("A booking is already scheduled for this time.");
		
		try
		{
			int setUpTime = Integer.parseInt(setupTime);
			if(setUpTime < 0)
				throw new SetupTimeInvalidException("A setup time must be a positive number");
		}
		catch(NumberFormatException nfe)
		{
			throw new SetupTimeInvalidException("The setup time must be in a  numerical format.");
		}
		
		try
		{
			int teardownTime = Integer.parseInt(tearDownTime);
			if(teardownTime < 0)
				throw new TearDownTimeInvalidException("A teardown time must be a positive number");
		}
		catch(NumberFormatException nfe)
		{
			throw new TearDownTimeInvalidException("The teardown time must be in a  numerical format.");
		}
		
		try
		{
			int NumberOfPeople = Integer.parseInt(numberOfPeople);
			if(NumberOfPeople < 0)
				throw new NumberInvalidException("The number of people at an event must be a positive, whole number.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberInvalidException("The number of people for a booking must be in a  numerical format.");
		}
		
		return true;
	}

	/**
	 * @param search
	 * @return
	 */
	public List<Booking> search(String search) {
		return null;
	}

	/**
	 * @param search
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Booking> search(String search, Date start, Date end) {
		return null;
	}
	
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Booking> search(Date start, Date end)
	{
		return null;
	}

	/**
	 * @param booking
	 * @return
	 */
	public boolean save(Booking booking) {
		return bb.persist(booking);
	}
	
	public boolean save(String eventTitle, BookingType eventType, Date startTime, Date endTime, String setupTime, String tearDownTime, Client client, Employee creator, String numberOfPeople, Rate rate,
			ArrayList<AdditionalCharge> additionalCharges, Facility facility, String invoice_no) throws NumberFormatException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException
	{
		Booking booking = null;
		
		if(this.validate(eventTitle, eventType, startTime, endTime, setupTime, tearDownTime, client, creator,  numberOfPeople, rate,
			additionalCharges, facility, invoice_no))
			booking = new Booking(eventTitle, eventType, startTime, endTime, Integer.parseInt(setupTime), Integer.parseInt(tearDownTime), client, creator, Integer.parseInt(numberOfPeople), rate,
			additionalCharges, facility, Integer.parseInt(invoice_no));
		
		return bb.persist(booking);
	}

	/**
	 * @param booking
	 * @return
	 */
	public boolean remove(Booking booking) {
		return bb.remove(booking);
	}
	
	/**
	 * 
	 */
	public void close() {
		bb.close();
	}
	
	/**
	 * @return
	 */
	private List<Booking> getAll()
	{
		return null;
	}
}
