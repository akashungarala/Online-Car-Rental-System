package RentalSystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Return extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String rentalid = "7001";
            String reservationid = "2001";
            String pickuptime = "2015-12-01 20:10:30";
            String returntime = "2015-12-30 14:15:48";
            String rentperday = "24.99";
            String expectedreturndate = "2015-12-15";
            String expectedamount = "374.85";
            String overdueamount = "374.85";
            String taxamount = "61.85025";
            String discountamount = "3.00";
            String amounttopay = "808.55025";
            String ccname = "Venkata Naga Akash Ungarala";
            String ccnumber = "1234123412341234";            
            request.setAttribute("rentalid", rentalid);
            request.setAttribute("reservationid", reservationid);
            request.setAttribute("pickuptime", pickuptime);
            request.setAttribute("returntime", returntime);
            request.setAttribute("rentperday", rentperday);
            request.setAttribute("expectedreturndate", expectedreturndate);
            request.setAttribute("expectedamount", expectedamount);
            request.setAttribute("overdueamount", overdueamount);
            request.setAttribute("taxamount", taxamount);
            request.setAttribute("discountamount", discountamount);
            request.setAttribute("amounttopay", amounttopay);
            request.setAttribute("ccname", ccname);
            request.setAttribute("ccnumber", ccnumber);
            request.getRequestDispatcher("return.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("Error", e);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}