package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class return_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Return</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\" integrity=\"sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .form-group label {color:orange; width: 40%;}\n");
      out.write("        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}\n");
      out.write("        .form-group .form-control {width: auto; display: inline-block;}\n");
      out.write("        p {text-align: center; color:green; font-size:200%;}\n");
      out.write("        body {text-align: center; background-image: url(\"background.jpg\");}\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("    ");

    String rentalid = request.getParameter("rentalid");
    String reservationid = request.getParameter("reservationid");
    String pickuptime = request.getParameter("pickuptime");
    String returntime = request.getParameter("returntime");
    String rentperday = request.getParameter("rentperday");
    String expectedreturndate = request.getParameter("expectedreturndate");
    String expectedamount = request.getParameter("expectedamount");
    String overdueamount = request.getParameter("overdueamount");
    String taxamount = request.getParameter("taxamount");
    String discountamount = request.getParameter("discountamount");
    String amounttopay = request.getParameter("amounttopay");
    String ccname = request.getParameter("ccname");
    String ccnumber = request.getParameter("ccnumber");
    if (rentalid != null)
    {
    
      out.write("<br><br>\n");
      out.write("    <div class=\"container\">\n");
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
      out.write("                    <label>Pick-Up Time</label>\n");
      out.write("                    <label>");
      out.print( pickuptime.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Return Time</label>\n");
      out.write("                    <label>");
      out.print( returntime.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Rent per Day (in $)</label>\n");
      out.write("                    <label>");
      out.print( rentperday.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Expected Return Date</label>\n");
      out.write("                    <label>");
      out.print( expectedreturndate.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Expected Amount</label>\n");
      out.write("                    <label>");
      out.print( expectedamount.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Over-Due Amount</label>\n");
      out.write("                    <label>");
      out.print( overdueamount.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Tax Amount</label>\n");
      out.write("                    <label>");
      out.print( taxamount.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Discount Amount</label>\n");
      out.write("                    <label>");
      out.print( discountamount.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Total Payable Amount</label>\n");
      out.write("                    <label>");
      out.print( amounttopay.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Name as on Credit Card</label>\n");
      out.write("                    <label>");
      out.print( ccname.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Credit Card Number</label>\n");
      out.write("                    <label>");
      out.print( ccnumber.toString() );
      out.write("</label>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div><br><br>\n");
      out.write("    <p><b>The total payable amount has been deducted from the credit card.</b></p><br>\n");
      out.write("    <p><b>Thank you for renting from us! We hope to serve you again.</b></p><br>\n");
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
