package RentalSystem;

import static RentalSystem.Database.add_customer;
import static RentalSystem.Database.return_membershipid;
import static RentalSystem.Database.return_name;
import static RentalSystem.Database.validate_newuser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUser extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmpassword = request.getParameter("confirmpassword");
            if(password.equals(confirmpassword))
            {
                if(validate_newuser(email))
                {
                    HttpSession session = request.getSession(false);
                    String first = request.getParameter("first");
                    String middle = request.getParameter("middle");
                    String last = request.getParameter("last");
                    String phone = request.getParameter("phone");
                    add_customer(first, middle, last, phone, email, password);
                    int mid = return_membershipid(email);
                    String membershipid = Integer.toString(mid);
                    String name = return_name(email);
                    session.setAttribute("membershipid", membershipid);
                    session.setAttribute("name", name);
                    session.setAttribute("email", email);
                    session.setAttribute("type", "newuser");
                    request.getRequestDispatcher("user.jsp").forward(request, response);
                }
                else
                {    
                    out.print("<br><b><p>It looks like you already have an account. Please enter your email and password to log in</p></b>");
                    RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
                    rd.include(request,response);
                }
            }
            else
            {
                out.print("<br><b><p>'Password' and 'Confirm Password' fields do not match</p></b>");
                RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
                rd.include(request,response);
            }
        }
        catch(Exception e)
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