package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Date;

public final class AddCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public class Customer {

                String url = "jdbc:mysql://localhost:3306/CarRentalSystem";
                String username = "root";
                String password = "";
                Connection connection = null;
                PreparedStatement addCustomer = null;
                ResultSet resultSet = null;

                public Customer() {
                    try {
                        connection = DriverManager.getConnection(url, username, password);
                        addCustomer = connection.prepareStatement("INSERT INTO Customer (email_id, first_name, middle_name, last_name, phone_number, registration_time) VALUES (?, ?, ?, ?, ?, ?)");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setCustomer(String email, String first, String middle, String last, String phone, Timestamp time) {
                    int result = 0;
                    try {
                        addCustomer.setString(1, email);
                        addCustomer.setString(2, first);
                        addCustomer.setString(3, middle);
                        addCustomer.setString(4, last);
                        addCustomer.setString(5, phone);
                        addCustomer.setTimestamp(6, time);
                        result = addCustomer.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Adding a Customer into Customer table</title><!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\" integrity=\"sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .form-group label{\n");
      out.write("            width: 200px;\n");
      out.write("        }\n");
      out.write("        .form-inline, .form-horizontal{\n");
      out.write("            width: 50%;\n");
      out.write("            margin: 20px auto;\n");
      out.write("            text-align: center;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 30px;\n");
      out.write("            padding: 20px 0;\n");
      out.write("        }\n");
      out.write("        .form-group .form-control{\n");
      out.write("            width: auto;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body onLoad=\"displayResults()\">\n");
      out.write("        <h1>Adding a Customer into Customer table</h1>\n");
      out.write("        <h2>Enter below details</h2>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            int result = 0;
            if (request.getParameter("submit") != null) {
                String emailid = new String();
                String firstname = new String();
                String middlename = new String();
                String lastname = new String();
                String phonenumber = new String();
                Date date = new Date();
                if (request.getParameter("email") != null) {
                    emailid = request.getParameter("email");
                }
                if (request.getParameter("first") != null) {
                    firstname = request.getParameter("first");
                }
                if (request.getParameter("middle") != null) {
                    middlename = request.getParameter("middle");
                }
                if (request.getParameter("last") != null) {
                    lastname = request.getParameter("last");
                }
                if (request.getParameter("phone") != null) {
                    phonenumber = request.getParameter("phone");
                }
                Timestamp time = new Timestamp(date.getTime());
                Customer customer = new Customer();
                result = customer.setCustomer(emailid, firstname, middlename, lastname, phonenumber, time);
            }
        
      out.write("\n");
      out.write("        <form name=\"myForm\" action=\"AddCustomer.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th></th>\n");
      out.write("                        <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email ID: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"email\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>First Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"first\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Middle Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"middle\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"last\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Phone Number: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"phone\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(result);
      out.write("\" name=\"hidden\" />\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("        <SCRIPT LANGUAGE=\"JavaScript\">\n");
      out.write("            <!---\n");
      out.write("                function displayResults()\n");
      out.write("            {\n");
      out.write("                if (document.myForm.hidden.value == 1)\n");
      out.write("                    alert(\"Registration is done\");\n");
      out.write("            }\n");
      out.write("            // --->\n");
      out.write("        </SCRIPT>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
