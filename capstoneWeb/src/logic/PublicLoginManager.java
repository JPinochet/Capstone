package logic;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.ClientBroker;

public class PublicLoginManager extends HttpServlet {
	private static final long serialVersionUID = 2813783322025726288L;
	HttpSession session = null;
    /**
     * Gets Email, password and logout parameters and validates them to ensure
     * they are valid than redirects to the proper jsp.
     * If validation fails than a error message will be displayed.
     * When you log out a message will be displayed
     * @param request is the request that is called
     * @param response is the response that is returned
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String logout=request.getParameter("logout");
    	
    	try
    	{
	    	ClientBroker cb = ClientBroker.getBroker();

            if (email!=null && password!=null)
            {
            	
                //if(validateCredentials(email,password,session))
            	int clientID = cb.validateLogin(email,password);
            	if (clientID>0)
                {
                	session.setAttribute("email",email);
                	session.setAttribute("clientid",clientID);
                    response.sendRedirect("public/clientinvoice.jsp");
                }
                else
                {
                    response.sendRedirect("public/login.jsp?message=Invalid email or password");
                }
            }

            if (logout!=null)
            {
                session.invalidate();
                response.sendRedirect("public/login.jsp?message=Logged out.");
            }
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
      
    } 

 /**
 * Sets up a new instance of the database connection and runs a query
 * Next the getResultSet is called and if the count == 1 then setAttribute for Session
 * is set.
 * Closes resultSet and connection. appropriate Exceptions are thrown if a error occurs
 * @param email is the email for the login
 * @param password is the password for the login
 * @return true/false if the object is valid.
 */
boolean validateCredentials(String email, String password, HttpSession session){
	boolean result=false;
	
	try
	{
		/*Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/indusdb", "root", "password");
		Statement s=conn.createStatement();
		
		String sql="SELECT COUNT(*), client_id " +
					"FROM client " +
					"WHERE email = '" + email + "' " +
					"AND password='" + password +  "';";
		
		s.executeQuery(sql);
		
		ResultSet rs = s.getResultSet();
		
		rs.next();
		
		int count=rs.getInt(1);
		
		if(count==1)
		{
			result=true;
			session.setAttribute("clientid", rs.getInt(2));
		}

		rs.close();
		conn.close();*/

		
	}
	
	catch (Exception e)
	{
		e.printStackTrace();
	}
        
	
	return result;
 }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
