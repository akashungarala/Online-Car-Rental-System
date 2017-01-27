package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!--<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>-->\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .form-group label {width: 200px;}\n");
      out.write("        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}\n");
      out.write("        .form-group .form-control {width: auto; display: inline-block;}\n");
      out.write("        p {color:red; font-size:200%;}\n");
      out.write("        h1 {color:green;}\n");
      out.write("        h2 {color:white;}\n");
      out.write("        label {color:orange;}\n");
      out.write("        body {text-align: center; background-image: url(\"background.jpg\");}\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <h1><b>MIAA Car Rental System</b></h1><br>\n");
      out.write("        <img src=\"Cars.jpg\" width=\"600\" height=\"300\"><br><br>\n");
      out.write("        <h2><b>Are you a registered user?</b></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"User\" method=\"post\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"useremail\">Email ID</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" name=\"useremail\" placeholder=\"Enter your Email ID here\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"userpassword\">Password</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" name=\"userpassword\" placeholder=\"Enter your Password here\">\n");
      out.write("                </div><br>\n");
      out.write("                <button type=\"submit\"><b>Log In</b></button><br><br>\n");
      out.write("                <!--<button type=\"submit\" class=\"btn btn-default user_btn\"><b>Log In</b></button><br><br>-->\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        <h2><b>Do you want to register?</b></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"AddUser\" method=\"post\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"first\">First Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"first\" placeholder=\"What's your first name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"middle\">Middle Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"middle\" placeholder=\"What's your middle name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"last\">Last Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"last\" placeholder=\"What's your last name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"phone\">Phone Number</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"phone\" placeholder=\"What's your number?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email ID</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"What's your email id?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Password</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Choose a password\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"confirmpassword\">Confirm Password</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"confirmpassword\" placeholder=\"Re-type your password\">\n");
      out.write("                </div><br>\n");
      out.write("                <button type=\"submit\"><b>Register</b></button><br><br>\n");
      out.write("                <!--<button type=\"submit\" class=\"btn btn-default newuser_btn\"><b>Register</b></button><br><br>-->\n");
      out.write("            </form>\n");
      out.write("        </div><br>\n");
      out.write("        <h2><b>Are you a guest?</b></h2>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\" action=\"AddGuest\" method=\"post\"><br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"guestfirst\">First Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"guestfirst\" placeholder=\"What's your first name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"guestmiddle\">Middle Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"guestmiddle\" placeholder=\"What's your middle name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"guestlast\">Last Name</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"guestlast\" placeholder=\"What's your last name?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"guestphone\">Phone Number</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"guestphone\" placeholder=\"What's your number?\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"guestemail\">Email ID</label>\n");
      out.write("                    <input type=\"email\" class=\"form-control\" name=\"guestemail\" placeholder=\"What's your email id?\">\n");
      out.write("                </div><br>\n");
      out.write("                <button type=\"submit\"><b>Log In as a guest</b></button>br><br>\n");
      out.write("                <!--<button type=\"submit\" class=\"btn btn-default guest_btn\"><b>Log In as a guest</b></button>br><br>-->\n");
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
