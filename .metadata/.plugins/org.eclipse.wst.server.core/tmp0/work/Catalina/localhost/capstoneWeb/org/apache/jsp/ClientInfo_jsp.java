package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemDomain.Client;
import java.util.ArrayList;
import logic.ClientManager;
import logic.EmployeeManager;
import logic.OrganizationManager;
import exceptions.*;
import problemDomain.Organization;

public final class ClientInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	EmployeeManager em = new EmployeeManager();

	if(session.getAttribute("user") == null || em.getEmployeeInfo((Integer)session.getAttribute("user")) == null)
	{
		response.sendRedirect("index.jsp?error=main&message=Not Logged In!!");
		em.close();
		return;
	}
	em.close();
	
	ClientManager cm = new ClientManager();
	
	Client client= new Client();
	
	int id=0;
	String givenName = "";
	String surname = "";
	String email = "";
	String street = "";
	String city = "";
	String prov = "";
	String postalCode = "";
	String country = "";
	int discount = 0;
	String homePhone = "";
	String cellPhone = "";
	String workPhone = "";
	
	if(request.getParameter("client") != null) {
		client = cm.getClientInfo(Integer.parseInt(request.getParameter("client")));
		cm.close();
	
		id = client.getId();
		givenName = client.getGivenName();
		surname = client.getSurname();
		email = client.getEmail();
		street = (client.getAddress()==null)?"":client.getAddress();
		city = (client.getCity()==null)?"":client.getCity();
		prov = (client.getProvince()==null)?"":client.getProvince();
		postalCode = (client.getPostalCode()==null)?"":client.getPostalCode();
		country = (client.getCountry()==null)?"":client.getCountry();
		discount = client.getDiscount();
		homePhone = (client.getHomePhone()==null)?"":client.getHomePhone();
		workPhone = (client.getWorkPhone()==null)?"":client.getWorkPhone();
		cellPhone = (client.getCellPhone()==null)?"":client.getCellPhone();
	}
	
	if(request.getParameter("error") != null) {
		//0-id, 1-givenName, 2-surname, 3-email, 4-address, 5-city, 6-province, 7-country, 8-postalCode, 9-discount, 10-password, 11-homePhone, 12-workPhone, 13-cellPhone
		ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
		
		id = Integer.parseInt(errorText.get(0));
		givenName = errorText.get(1);
		surname = errorText.get(2);
		email = errorText.get(3);
		street = (errorText.get(4)==null)?"":errorText.get(4);
		city = (errorText.get(5)==null)?"":errorText.get(5);
		prov = (errorText.get(6)==null)?"":errorText.get(6);
		postalCode = (errorText.get(8)==null)?"":errorText.get(8);
		country = (errorText.get(7)==null)?"":errorText.get(7);
		discount = Integer.parseInt(errorText.get(9));
		homePhone = (errorText.get(11)==null)?"":errorText.get(11);
		workPhone = (errorText.get(12)==null)?"":errorText.get(12);
		cellPhone = (errorText.get(13)==null)?"":errorText.get(13);

      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" >\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$('label[for=");
      out.print( session.getAttribute("errorField") );
      out.write("]').parent().parent().addClass(\"error\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");

}

      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:30%;\r\n");
      out.write("\t}\r\n");
      out.write("\t-->\r\n");
      out.write("</style>\r\n");
      out.write("<form action=\"ClientManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 600px\">\r\n");
      out.write("\t");
 if(request.getParameter("error") != null) { 
      out.write("\r\n");
      out.write("\t\t<div id=\"errorDesc\">\r\n");
      out.write("\t\t\t");
      out.print( session.getAttribute("errorMessage") );
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\t<div style=\"width:49%;float:left;padding-right:1%\">\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"givenName\">Given Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"givenName\" size=\"15\" value=\"");
      out.print( givenName );
      out.write("\" />*</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"surname\">Surname:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"surname\" size=\"20\" value=\"");
      out.print( surname );
      out.write("\" />*</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"email\">Email:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"email\" size=\"23\" value=\"");
      out.print( email );
      out.write("\" />*</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"street\">Street:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"street\" size=\"20\" value=\"");
      out.print( street );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"city\">City:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"city\" size=\"10\" value=\"");
      out.print( city );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"prov\">Province:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"prov\" size=\"1\" maxlength=\"2\" value=\"");
      out.print( prov );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"postalCode\">Postal Code:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"postalCode\" size=\"5\" maxlength=\"7\" value=\"");
      out.print( postalCode );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"country\">Country:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"country\" size=\"10\" value=\"");
      out.print( country );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"discount\">Discount:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"discount\" size=\"1\" maxlength=\"3\" value=\"");
      out.print( discount );
      out.write("\" /> %</div></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"float:right;width:50%\">\r\n");
      out.write("\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t<legend><strong>Phone Numbers</strong></legend>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"homePhone\">Home Phone:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"homePhone\" size=\"10\" maxlength=\"10\" value=\"");
      out.print( homePhone );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"workPhone\">Work Phone:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"workPhone\" size=\"10\" maxlength=\"10\" value=\"");
      out.print( workPhone );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"cellPhone\">Cell Phone:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"cellPhone\" size=\"10\" maxlength=\"10\" value=\"");
      out.print( cellPhone );
      out.write("\" /></div></div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t<fieldset> \r\n");
      out.write("\t\t\t\t<legend><strong>Organizations</strong></legend>\r\n");
      out.write("\t\t\t\t<select name=\"orgs\" size=\"5\" style=\"width:100%\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t\t");

						OrganizationManager om = new OrganizationManager();
						ArrayList<Organization> orgs = new ArrayList<Organization>();
						try {
							orgs = (ArrayList<Organization>) om.getOrgList();
						} catch(DatabaseConnectionException e) {
							e.printStackTrace();
						}
						ArrayList<Organization> selectedOrgs = (request.getParameter("client") != null)?(ArrayList) client.getOrganization():(ArrayList) session.getAttribute("orgs");
					    for (int i=0; i<orgs.size(); i++) {
					    	String selected="";
					    	if(request.getParameter("client") != null || request.getParameter("error") != null) {
						    	for(int j=0; j < selectedOrgs.size(); j++) {
						    		if( selectedOrgs.get(j).getId() == orgs.get(i).getId() ){
						    			selected=" selected=\"selected\"";
						    		}
						    	}
					    	}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print( orgs.get(i).getId() );
      out.write('"');
      out.print( selected );
      out.write('>');
      out.print( orgs.get(i).getName() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 	
						} 
					    om.close();
					
      out.write("\r\n");
      out.write("\t\t\t\t</select>\t\t\t\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"clear:both;text-align:right;padding-top:10px\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\r\n");
      out.write("\t\t\t<!-- <input type=\"reset\" value=\"Reset\" /> -->\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"save\" value=\"Save\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"delete\" value=\"Delete\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
