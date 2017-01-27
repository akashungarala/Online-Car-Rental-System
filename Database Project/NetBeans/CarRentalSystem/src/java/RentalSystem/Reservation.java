package RentalSystem;

import static RentalSystem.Database.add_reservation_driver;
import static RentalSystem.Database.return_reservationid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reservation extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String licenseid = request.getParameter("licenseid");
            String fname = request.getParameter("fname");
            String mname = request.getParameter("mname");
            String lname = request.getParameter("lname");
            String name = (String) request.getSession().getAttribute("name");
            String membershipid = (String) request.getSession().getAttribute("membershipid");
            String email = (String) request.getSession().getAttribute("email");
            String type = (String) request.getSession().getAttribute("type");
            String carcategory = (String) request.getSession().getAttribute("carcategory");
            String carcategoryname = (String) request.getSession().getAttribute("carcategoryname");
            String pickupdate = (String) request.getSession().getAttribute("pickupdate");
            String returndate = (String) request.getSession().getAttribute("returndate");
            String rentingprice = (String) request.getSession().getAttribute("rentingprice");
            String discountamount = (String) request.getSession().getAttribute("discountamount");
            String taxamount = (String) request.getSession().getAttribute("taxamount");
            String totalamount = (String) request.getSession().getAttribute("totalamount");
            add_reservation_driver(email, carcategory, pickupdate, returndate, discountamount, totalamount, licenseid, fname, mname, lname);
            String drivername = fname+" "+lname;
            int rid = return_reservationid(email, carcategory, pickupdate);
            String reservationid = String.valueOf(rid);
            request.setAttribute("reservationid", reservationid);
            request.setAttribute("licenseid", licenseid);
            request.setAttribute("drivername", drivername);
            request.setAttribute("carcategoryname", carcategoryname);
            request.setAttribute("pickupdate", pickupdate);
            request.setAttribute("returndate", returndate);
            request.setAttribute("rentingprice", rentingprice);
            request.setAttribute("discountamount", discountamount);
            request.setAttribute("taxamount", taxamount);
            request.setAttribute("totalamount", totalamount);
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
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