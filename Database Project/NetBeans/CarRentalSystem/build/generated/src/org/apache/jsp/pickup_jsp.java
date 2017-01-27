package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pickup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Pick-Up</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\" integrity=\"sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .form-group label {width: 200px;}\n");
      out.write("        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}\n");
      out.write("        .form-group .form-control {width: auto; display: inline-block;}\n");
      out.write("        p {color:orange; font-size:200%;}\n");
      out.write("        h1, h2, label {color:white;}\n");
      out.write("        body {text-align: center; background-image: url(\"background.jpg\");}\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("    ");

    String pickuptime = request.getParameter("pickuptime");
    String returndate = request.getParameter("returndate");
    String reservationid = request.getParameter("reservationid");
    String rentalid = request.getParameter("rentalid");
    String VIN = request.getParameter("VIN");
    if (rentalid != null)
    {
    
      out.write("<br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Rental ID</label>\n");
      out.write("                    <label>");
      out.print( rentalid.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Reservation ID</label>\n");
      out.write("                    <label>");
      out.print( reservationid.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Vehicle Identification Number</label>\n");
      out.write("                    <label>");
      out.print( VIN.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Pick-Up Time</label>\n");
      out.write("                    <label>");
      out.print( pickuptime.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Expected Return Date</label>\n");
      out.write("                    <label>");
      out.print( returndate.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("    <p><b>The return date of a rental can not be extended to a date more than 30 days from the Pick-Up date.</b></p>\n");
      out.write("    ");

    }
    
      out.write("\n");
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
