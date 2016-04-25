/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.AddressInvalidException;
import exceptions.BooleanInvalidException;
import exceptions.CityInvalidException;
import exceptions.CostInvalidException;
import exceptions.CountryInvalidException;
import exceptions.DatabaseConnectionException;
import exceptions.DescriptionInvalidException;
import exceptions.EmailInvalidException;
import exceptions.GivenNameInvalidException;
import exceptions.NameInvalidException;
import exceptions.NumberInvalidException;
import exceptions.PostalCodeInvalidException;
import exceptions.ProvinceInvalidException;
import exceptions.ScheduleInvalidException;
import exceptions.SetupTimeInvalidException;
import exceptions.SurnameInvalidException;
import exceptions.TearDownTimeInvalidException;

import persistence.InvoiceBroker;
import problemDomain.Booking;
import problemDomain.Client;
import problemDomain.Invoice;
import problemDomain.Payment;

/**
 * @author 432873
 * 
 */
public class InvoiceManager {
	InvoiceBroker ib;
	
	/**
	 * @throws DatabaseConnectionException
	 */
	public InvoiceManager() throws DatabaseConnectionException
	{
		ib = InvoiceBroker.getBroker();
	}
	
	/**
	 * @param date
	 * @param client
	 * @param bookings
	 * @param paid
	 * @param paymentDue
	 * @param description
	 * @param dueDate
	 * @param payments
	 * @return
	 * @throws BooleanInvalidException 
	 * @throws DescriptionInvalidException 
	 * @throws CostInvalidException 
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 * @throws NumberInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws NameInvalidException 
	 */
	public boolean validate(String date, Client client, ArrayList<Booking> bookings, String Paid, String paymentDue, String description, String dueDate, ArrayList<Payment> payments) throws BooleanInvalidException, DescriptionInvalidException, CostInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException 
	{
		ClientManager cm = new ClientManager();
		cm.validate(client);
		
		BookingManager om = new BookingManager();
		for(int i = 0; i < bookings.size(); i++)
		{
			om.validate(bookings.get(i));
		}
		
		boolean paid = Boolean.parseBoolean(Paid);
		if(paid != true || paid != false)
			throw new BooleanInvalidException("Not a boolean");
		
		if(description.length() > 400)
			throw new DescriptionInvalidException("An invoice description cannot excede 400 characters");
		
		for(int i = 0; i < payments.size(); i ++)
		{
			if(Double.isNaN(payments.get(i).getAmount()))
				throw new CostInvalidException("The value for the price of an Invoice must be entered as a number");
			if(payments.get(i).getAmount() < 0)
				throw new CostInvalidException("The invoice cost cannot be negative");
		}
		
		return true;
	}
	
	/**
	 * @param invoice
	 * @return
	 * @throws CostInvalidException
	 * @throws DescriptionInvalidException
	 * @throws BooleanInvalidException
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 * @throws NumberInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws NameInvalidException 
	 */
	public boolean validate(Invoice invoice) throws CostInvalidException, DescriptionInvalidException, BooleanInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException
	{
		ClientManager cm = new ClientManager();
		cm.validate(invoice.getClient());
		
		BookingManager om = new BookingManager();
		for(int i = 0; i < invoice.getBookings().size(); i++)
		{
			om.validate(invoice.getBookings().get(i));
		}
		
		if(invoice.getPaid() != true || invoice.getPaid() != false)
			throw new BooleanInvalidException("Not a boolean");
		
		if(invoice.getDescription().length() > 400)
			throw new DescriptionInvalidException("An invoice description cannot excede 400 characters");
		
		for(int i = 0; i < invoice.getPayments().size(); i ++)
		{
			if(Double.isNaN(invoice.getPayments().get(i).getAmount()))
				throw new CostInvalidException("The value for the price of an Invoice must be entered as a number");
			if(invoice.getPayments().get(i).getAmount() < 0)
				throw new CostInvalidException("The invoice cost cannot be negative");
		}
		
		return true;
	}

	/**
	 * @param query
	 * @return
	 */
	public List<Invoice> search(String query) {
		return null;
	}

	/**
	 * @param date
	 * @param client
	 * @param bookings
	 * @param paid
	 * @param paymentDue
	 * @param description
	 * @param dueDate
	 * @param payments
	 * @return
	 * @throws BooleanInvalidException 
	 * @throws NumberFormatException 
	 * @throws DescriptionInvalidException 
	 * @throws CostInvalidException 
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 * @throws NumberInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws NameInvalidException 
	 */
	public boolean save(String date, Client client, ArrayList<Booking> bookings, String paid, String paymentDue, String description, String dueDate, ArrayList<Payment> payments) throws NumberFormatException, BooleanInvalidException, DescriptionInvalidException, CostInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException 
	{
		Invoice invoice = null;
		
		if(validate(date, client, bookings, paid, paymentDue, description, dueDate, payments))
			invoice = new Invoice(new Date(date), client, bookings, Boolean.parseBoolean(paid), Double.parseDouble(paymentDue), description, new Date(dueDate), payments);
		
		return ib.persist(invoice);
	}
	
	/**
	 * @param invoice
	 * @return
	 * @throws CostInvalidException
	 * @throws DescriptionInvalidException
	 * @throws BooleanInvalidException
	 * @throws DatabaseConnectionException 
	 * @throws AddressInvalidException 
	 * @throws SurnameInvalidException 
	 * @throws GivenNameInvalidException 
	 * @throws ProvinceInvalidException 
	 * @throws PostalCodeInvalidException 
	 * @throws CountryInvalidException 
	 * @throws CityInvalidException 
	 * @throws EmailInvalidException 
	 * @throws NumberInvalidException 
	 * @throws TearDownTimeInvalidException 
	 * @throws SetupTimeInvalidException 
	 * @throws ScheduleInvalidException 
	 * @throws NameInvalidException 
	 */
	public boolean save(Invoice invoice) throws CostInvalidException, DescriptionInvalidException, BooleanInvalidException, DatabaseConnectionException, GivenNameInvalidException, SurnameInvalidException, AddressInvalidException, EmailInvalidException, CityInvalidException, CountryInvalidException, PostalCodeInvalidException, ProvinceInvalidException, NameInvalidException, ScheduleInvalidException, SetupTimeInvalidException, TearDownTimeInvalidException, NumberInvalidException
	{
		if(this.validate(invoice))
			return ib.persist(invoice);
		
		return false;
	}

	/**
	 * @param invoice
	 * @return
	 */
	public boolean remove(Invoice invoice) 
	{
		return ib.remove(invoice);
	}
	
	/**
	 * 
	 */
	public void close() {
		ib.close();
	}
	
	/**
	 * @return
	 */
	private List<Invoice> getAll()
	{
		return null;
	}
}
