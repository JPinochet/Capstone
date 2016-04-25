package logicTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import problemDomain.Organization;

import logic.ClientManager;

/**
 * Servlet implementation class ClientManagerTest2
 */
public class ClientManagerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientManagerTest2() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try
        {
        	ArrayList<Organization> Organization = new ArrayList<Organization>();
            ClientManager cm = new ClientManager();
    		cm.save(-1, "3g65p9", "test", "test", "test", "test@test.ca", "calgary", "canada",
					"ab", "10%", "2445555", "6667777", "3334444", "Password",  Organization );
        }
        catch (DatabaseConnectionException e) 
		{
			out.println("Could not connect to database");
		}
		catch (PostalCodeInvalidException e)
		{
			out.println("Postal code is not valid");
		}
		catch (GivenNameInvalidException e)
		{
			out.println("Given name is not valid");
		}
		catch (SurnameInvalidException e)
		{
			out.println("Surname is not valid");
		} 
		catch (AddressInvalidException e) 
		{
			out.println("Address is not valid");
		}
		catch (EmailInvalidException e) 
		{
			out.println("Email is not valid");
		}
		catch (CityInvalidException e) 
		{
			out.println("City is not valid");
		} 
		catch (CountryInvalidException e) 
		{
			out.println("Country is not valid");
		} 
		catch (ProvinceInvalidException e)
		{
			out.println("Province is not valid");
		} 
		catch (DiscountInvalidException e)
		{
			out.println("Discount is not valid");
		} 
		catch (HomePhoneInvalidException e) 
		{
			out.println("Home phone number is not valid");
		}
		catch (WorkPhoneInvalidException e) 
		{
			out.println("Work phone number is not valid");
		}
		catch (CellPhoneInvalidException e) 
		{
			out.println("Cell phone number is not valid");
		} 
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
