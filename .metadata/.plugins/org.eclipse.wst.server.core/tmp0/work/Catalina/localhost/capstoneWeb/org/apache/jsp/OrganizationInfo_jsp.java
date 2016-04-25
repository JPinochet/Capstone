package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.EmployeeManager;
import problemDomain.Client;
import java.util.ArrayList;
import logic.ClientManager;
import logic.OrganizationManager;
import exceptions.*;
import problemDomain.Organization;

public final class OrganizationInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	OrganizationManager om = new OrganizationManager();
	ClientManager cm = new ClientManager();
	
	Organization organization= new Organization();
	
	int id = 0;
	String name = "";
	String discount = "0";
	String description = "";
	Client client_contact = new Client();
	String contact = "";
	
	if(request.getParameter("organization") != null) {
		organization = om.getOrgInfo(Integer.parseInt(request.getParameter("organization")));
		om.close();
		
		id = organization.getId();
		name = (organization.getName()==null)?"":organization.getName();
		discount = organization.getDiscount()+"";
		description = (organization.getDescription()==null)?"":organization.getDescription();
		client_contact = organization.getContact();
		contact = organization.getContact().getGivenName() + " " +  organization.getContact().getSurname();
	}
	
	if(request.getParameter("error") != null) {
		//0-id, 1-name, 2-discount, 3-contact, 4-description
		ArrayList<String> errorText = (ArrayList<String>) session.getAttribute("errorText");
		
		id = Integer.parseInt(errorText.get(0));
		name = errorText.get(1);
		discount = errorText.get(2);
		contact = errorText.get(3);
		description = (errorText.get(4)==null)?"":errorText.get(4);

      out.write("\r\n");
      out.write("<script type=\"text/javascript\" >\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$('label[for=");
      out.print( session.getAttribute("errorField") );
      out.write("]').parent().parent().addClass(\"error\");\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");

	}

      out.write("\r\n");
      out.write("<link href=\"css/form.css\" rel=\"stylesheet\"  type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<style>\n");
      out.write("\t<!--\r\n");
      out.write("\t.cssForm .leftDiv{\r\n");
      out.write("\t\twidth:75px;\r\n");
      out.write("\t}\n");
      out.write("\t-->\n");
      out.write("</style>\r\n");
      out.write("\t\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//Run on page load\r\n");
      out.write("    jQuery(document).ready(function($) {\r\n");
      out.write("\t\t//setup for autocomplete\r\n");
      out.write("      \t$(\"#contactAC\").autocomplete(\"ClientManager\");\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<form action=\"OrganizationManager?do=manage\" method=\"post\" class=\"cssForm\">\r\n");
      out.write("\t<div style=\"width: 260px\">\r\n");
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
      out.write("\t\t<fieldset> \r\n");
      out.write("\t\t\t<legend><strong>Organization Details</strong></legend>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"name\">Name:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"name\" size=\"15\" value=\"");
      out.print( name );
      out.write("\" />*</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"contact\">Contact:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"contact\" size=\"15\" value=\"");
      out.print( contact );
      out.write("\" id=\"contactAC\" />*</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"discount\">Discount:</label></div><div class=\"rightDiv\"><input type=\"text\" name=\"discount\" size=\"2\" value=\"");
      out.print( discount );
      out.write("\" />%</div></div>\r\n");
      out.write("\t\t\t<div class=\"field\"><div class=\"leftDiv\"><label for=\"desc\">Description:</label></div><div class=\"rightDiv\"><textarea name=\"desc\" rows=\"3\" cols=\"15\">");
      out.print( description );
      out.write("</textarea></div></div>\r\n");
      out.write("\t\t</fieldset>\r\n");
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
