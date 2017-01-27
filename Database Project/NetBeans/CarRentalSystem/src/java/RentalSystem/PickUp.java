package RentalSystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PickUp extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String pickuptime = "2015-12-01 20:10:30";
            String returndate = "2015-12-15";
            String reservationid = "2001";
            String rentalid = "7001";
            String VIN = "AK1234";
            request.setAttribute("pickuptime", pickuptime);
            request.setAttribute("returndate", returndate);
            request.setAttribute("reservationid", reservationid);
            request.setAttribute("rentalid", rentalid);
            request.setAttribute("VIN", VIN);
            request.getRequestDispatcher("pickup.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("Error", e);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}