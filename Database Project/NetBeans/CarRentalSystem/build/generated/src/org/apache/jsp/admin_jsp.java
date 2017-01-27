package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MIAA Car Rental System</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\" integrity=\"sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .form-group label {width: 40%;}\n");
      out.write("        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}\n");
      out.write("        .form-group .form-control {width: 40%; display: inline-block;}\n");
      out.write("        h1 {color:green;}\n");
      out.write("        h2 {color:white;}\n");
      out.write("        label {color:orange;}\n");
      out.write("        body {text-align: center; background-image: url(\"background.jpg\");}\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <h1><b>Welcome Admin</b></h1><br>\n");
      out.write("        <h2><b>Do you want to record a Pick-Up for a reservation?</b></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"PickUp\" method=\"post\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"reservationid\">Reservation ID</label>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"reservationid\" placeholder=\"Enter Reservation ID here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"licenseid\">Driver's License ID</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"licenseid\" placeholder=\"Enter Driver's License ID here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ccname\">Name as on Credit card</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"ccname\" placeholder=\"Enter Card Holder's Name here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ccnumber\">Credit Card Number</label>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"ccnumber\" placeholder=\"Enter Credit Card Number here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ccexpiryyear\">Year of Expiry Date</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"ccexpiryyear\" placeholder=\"Enter Year of Expiry Date here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ccexpirymonth\">Month of Expiry Date</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"ccexpirymonth\" placeholder=\"Enter Month of Expiry Date here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"cvv\">CVV</label>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"cvv\" placeholder=\"Enter CVV here\">\n");
      out.write("                </div><br>\n");
      out.write("                <button type=\"submit\"><b>Confirm Pick-Up</b></button><br><br>\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        <h2><b>Do you want to record a Return for a Pick-Up?</b></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"Return\" method=\"post\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"reservationid\">Reservation ID</label>\n");
      out.write("                    <input type=\"number\" class=\"form-control\" name=\"reservationid\" placeholder=\"Enter Reservation ID here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"licenseid\">Driver's License ID</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"licenseid\" placeholder=\"Enter Driver's License ID here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"vin\">Vehicle Identification Number</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" name=\"vin\" placeholder=\"Enter VIN here\">\n");
      out.write("                </div><br>\n");
      out.write("                <button type=\"submit\"><b>Confirm Return</b></button><br><br>\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
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
