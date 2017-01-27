<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    </head>
    <style>
        .form-group label {color:orange; width: 40%;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: auto; display: inline-block;}
        p {text-align: center; color:green; font-size:200%;}
        body {text-align: center; background-image: url("background.jpg");}
    </style>
    <body>
    <%
    String reservationid = (String) request.getAttribute("reservationid");
    String licenseid = (String) request.getAttribute("licenseid");
    String drivername = (String) request.getAttribute("drivername");
    String carcategoryname = (String) request.getAttribute("carcategoryname");
    String pickupdate = (String) request.getAttribute("pickupdate");
    String returndate = (String) request.getAttribute("returndate");
    String rentingprice = (String) request.getAttribute("rentingprice");
    String discountamount = (String) request.getAttribute("discountamount");
    String taxamount = (String) request.getAttribute("taxamount");
    String totalamount = (String) request.getAttribute("totalamount");
    if (reservationid != null)
    {
    %><br><br>
    <p><b>The return date of a rental can not be extended to a date more than 30 days from the Pick-Up date.</b></p><br>
        <div class="container">
            <form class="form-horizontal" role="form"><br>
                <div class="form-group">
                    <label>Reservation ID</label>
                    <label>${reservationid}</label>
                </div>
                <div class="form-group">
                    <label>Driver's License ID</label>
                    <label>${licenseid}</label>
                </div>
                <div class="form-group">
                    <label>Driver's Name</label>
                    <label>${drivername}</label>
                </div>
                <div class="form-group">
                    <label>Car Category</label>
                    <label>${carcategoryname}</label>
                </div>
                <div class="form-group">
                    <label>Pick-Up Date</label>
                    <label>${pickupdate}</label>
                </div>
                <div class="form-group">
                    <label>Expected Return Date</label>
                    <label>${returndate}</label>
                </div>
                <div class="form-group">
                    <label>Rent per Day (in $)</label>
                    <label>${rentingprice}</label>
                </div>
                <div class="form-group">
                    <label>Discount Amount (in $)</label>
                    <label>${discountamount}</label>
                </div>
                <div class="form-group">
                    <label>Tax Amount (in $)</label>
                    <label>${taxamount}</label>
                </div>
                <div class="form-group">
                    <label>Expected Total Amount (in $)</label>
                    <label>${totalamount}</label>
                </div>
            </form>
        </div>
    <%
    }
    %>
    </body>
</html>