/**
 * 
 */
package test;

import java.util.ArrayList;

import exceptions.DatabaseConnectionException;

import persistence.ClientBroker;
import problemDomain.Client;
import problemDomain.Organization;
import problemDomain.Phone;
import problemDomain.Rate;
import persistence.RateBroker;

/**
 * @author Administrator
 * 
 */
public class test 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ClientBroker broker = null;
		try 
		{
			broker = (ClientBroker) ClientBroker.getBroker();
		} catch (DatabaseConnectionException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Phone phoneNumber = new Phone("HOME", 403, 1234567); Phone
		 * phoneNumber2 = new Phone("BUSINESS", 403, 1234566); Phone
		 * phoneNumber3 = new Phone("CELL", 403, 1234577); ArrayList<Phone>
		 * phoneNmbers = new ArrayList<Phone>();
		 * 
		 * phoneNmbers.add(phoneNumber); phoneNmbers.add(phoneNumber2);
		 * phoneNmbers.add(phoneNumber3);
		 * 
		 * Client client = new Client("Jorge", "Pinochet", "123 Fake Street",
		 * "Nowhere", "AB", "T2B0C2", "Canada", "jorge@pinochet.com",
		 * phoneNmbers, -100.00, null, "password");
		 * 
		 * Organization org = new Organization(1, "Midnapore Fail Association",
		 * -200.00, client, "These people are the tits.");
		 * ArrayList<Organization> orgs = new ArrayList<Organization>();
		 * orgs.add(org);
		 * 
		 * client.setOrganizations(orgs);
		 * 
		 * broker.persist(client);
		 * 
		 * 
		 * client.setId(40); client.setGivenName("Not Jorge");
		 * broker.persist(client); broker.remove(client);
		 */
		try
		{
		ArrayList<Client> clients = (ArrayList<Client>) broker.getAll();
		for (int i = 0; i < clients.size(); i++) 
		{
			System.out.println(i + 1 + ": " + clients.get(i).getGivenName() + " " + clients.get(i).getSurname());
			ArrayList<Phone> phone = (ArrayList<Phone>) clients.get(i).getPhoneNumbers();
			for (int j = 0; j < phone.size(); j++) 
			{
				System.out.println("\t" + phone.get(j).getType() + ": " + phone.get(j).getAreacode() + phone.get(j).getNumber());

			}
			ArrayList<Organization> orgs2 = (ArrayList<Organization>) clients.get(i).getOrganizations();
			for (int j = 0; j < orgs2.size(); j++) 
			{
				System.out.println("\t" + orgs2.get(j).getName());
			}
		
			broker.close();
		 }
		 }
		
		catch(DatabaseConnectionException dce)
		{
			dce.printStackTrace();
		}
	}
}
