/**
 * 
 */
package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.DatabaseConnectionException;

import persistence.EmployeeBroker;

/**
 * @author 432873
 *
 */
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = -396134032675202261L;
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
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String logout=request.getParameter("logout");

        session = request.getSession();

        if (username != null && password != null)
        {
        	try {
        		EmployeeBroker eb = EmployeeBroker.getBroker();
        		
				if(eb.validateLogin(username, password) != 0)
				{
					session.setAttribute("user", eb.validateLogin(username, password));
					response.sendRedirect("index.jsp");
				}
				else
				{
					response.sendRedirect("index.jsp?error=main&message=Invalid username or password");
				}
			} catch (DatabaseConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if (logout!=null)
        {
        	session.invalidate();
        	response.sendRedirect("index.jsp?error=mainMessage&message=Logged out.");
        }
        
    }
	
	/**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
