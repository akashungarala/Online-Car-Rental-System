package org.apache.jsp.Pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Welcome</title><!-- Latest compiled and minified CSS -->\n");
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
      out.write("    <body>\n");
      out.write("        <h1><center>Welcome to <b>MIAA Car Rental System</b></center></h1>\n");
      out.write("        <br>\n");
      out.write("        <h2><center><b>Log In</b></center></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-inline\" role=\"form\">                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email ID:</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Enter Email ID\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Password:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter Password\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-default\" formaction=\"user.jsp\">Log In</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <h2><center><b>Register for membership</b></center></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"first\">First Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"first\" placeholder=\"Enter First Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"middle\">Middle Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"middle\" placeholder=\"Enter Middle Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"last\">Last Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"last\" placeholder=\"Enter Last Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email ID:</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Enter Email ID\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Password:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter Password\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Re-enter Password:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Re-enter Password\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-default\" formaction=\"newuser.jsp\">Register</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <h2><center><b>Log In as a guest</b></center></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"first\">First Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"first\" placeholder=\"Enter First Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"middle\">Middle Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"middle\" placeholder=\"Enter Middle Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"last\">Last Name:</label>\n");
      out.write("                    <input type=\"input\" class=\"form-control\" id=\"last\" placeholder=\"Enter Last Name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email ID:</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Enter Email ID\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-default\" formaction=\"guest.jsp\">Log In as a Guest</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
