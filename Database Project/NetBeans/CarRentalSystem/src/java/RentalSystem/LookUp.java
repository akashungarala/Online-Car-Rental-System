package RentalSystem;

import static RentalSystem.Database.return_basicamount;
import static RentalSystem.Database.return_carcategoryname;
import static RentalSystem.Database.return_discountpercentage;
import static RentalSystem.Database.return_rentingprice;
import static RentalSystem.Database.validate_car_category_availability;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LookUp extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String carcategory = request.getParameter("carcategory");
            String pickupdate = request.getParameter("pickupdate");
            String returndate = request.getParameter("returndate");
            String name = (String) request.getSession().getAttribute("name");
            String membershipid = (String) request.getSession().getAttribute("membershipid");
            String email = (String) request.getSession().getAttribute("email");
            String type = (String) request.getSession().getAttribute("type");
            if(validate_car_category_availability(carcategory, pickupdate))
            {
                int categoryid = Integer.parseInt(carcategory);
                double price = return_rentingprice(categoryid);
                Date pdate = Date.valueOf(pickupdate);
                Date rdate = Date.valueOf(returndate);
                double basicamount = return_basicamount(price, pdate, rdate);
                double taxpercentage = 8.25;
                double tax = (taxpercentage*basicamount)/100;
                int mid = Integer.parseInt(membershipid);
                int discountpercentage=0;
                if(type != "guest")
                    discountpercentage = return_discountpercentage(mid);
                double discount = (discountpercentage*basicamount)/100;
                double total = basicamount+tax-discount;
                String carcategoryname = return_carcategoryname(categoryid);
                String rentingprice = String.valueOf(price);
                String discountamount = String.valueOf(discount);
                String taxamount = String.valueOf(tax);
                String totalamount = String.valueOf(total);
                request.setAttribute("name", name);
                request.setAttribute("membershipid", membershipid);
                request.setAttribute("email", email);
                request.setAttribute("type", type);
                request.setAttribute("carcategory", carcategory);
                request.setAttribute("carcategoryname", carcategoryname);
                request.setAttribute("pickupdate", pickupdate);
                request.setAttribute("returndate", returndate);
                request.setAttribute("rentingprice", rentingprice);
                request.setAttribute("discountamount", discountamount);
                request.setAttribute("taxamount", taxamount);
                request.setAttribute("totalamount", totalamount);
                request.getRequestDispatcher("lookup.jsp").forward(request, response);
            }
            else
            {
                out.print("<br><b><p>The selected Car Category is not available for the selected Pick-Up Date</p></b>");
                RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
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