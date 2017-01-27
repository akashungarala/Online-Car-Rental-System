package RentalSystem;

import static RentalSystem.Database.add_customer;
import static RentalSystem.Database.return_name;
import static RentalSystem.Database.validate_guest;
import static RentalSystem.Database.validate_newuser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddGuest extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String guestemail = request.getParameter("guestemail");
            String guestfirst = request.getParameter("guestfirst");
            String guestmiddle = request.getParameter("guestmiddle");
            String guestlast = request.getParameter("guestlast");
            String guestphone = request.getParameter("guestphone");
            String guestpassword = null;
            if(validate_guest(guestemail))
            {
                HttpSession session = request.getSession(false);
                add_customer(guestfirst, guestmiddle, guestlast, guestphone, guestemail, guestpassword);
                String name = return_name(guestemail);
                session.setAttribute("name", name);
                session.setAttribute("email", guestemail);
                session.setAttribute("type", "guest");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
            else if(validate_newuser(guestemail) == false)
            {
                out.print("<br><b><p>It looks like you already have an account. Please enter your email and password to log in</p></b>");
                RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
                rd.include(request,response);
            }
            else
            {
                HttpSession session = request.getSession(false);
                out.print("<br><b><p>It looks like you have signed in as a guest with this email id before.</p></b>");
                String name = return_name(guestemail);
                session.setAttribute("name", name);
                session.setAttribute("email", guestemail);
                session.setAttribute("type", "guest");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
        }
        catch (Exception e)
        {
            request.setAttribute("Error", e);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
        finally
        {
            out.close();
        }
    }
}