package RentalSystem;

import static RentalSystem.Database.return_membershipid;
import static RentalSystem.Database.return_name;
import static RentalSystem.Database.validate_user;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class User extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String useremail = request.getParameter("useremail");
            String userpassword = request.getParameter("userpassword");
            String admin = "admin@carrentalsystem.com";
            if(validate_user(useremail, userpassword) == true)
            {
                HttpSession session = request.getSession(false);
                if(session!=null)
                    session.setAttribute("useremail", useremail);
                if(admin.equals(useremail))
                {
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    int mid = return_membershipid(useremail);
                    String membershipid = Integer.toString(mid);
                    String name = return_name(useremail);
                    session.setAttribute("membershipid", membershipid);
                    session.setAttribute("name", name);
                    session.setAttribute("email", useremail);
                    session.setAttribute("type", "user");
                    request.getRequestDispatcher("user.jsp").forward(request, response);
                }
            }
            else
            {
                out.print("<br><b><p>Sorry! Incorrect Email ID or Password</p></b>");
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