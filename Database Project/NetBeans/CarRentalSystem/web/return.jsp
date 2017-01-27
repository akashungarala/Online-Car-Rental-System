<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return</title>
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
    String rentalid = (String) request.getAttribute("rentalid");
    String reservationid = (String) request.getAttribute("reservationid");
    String pickuptime = (String) request.getAttribute("pickuptime");
    String returntime = (String) request.getAttribute("returntime");
    String rentperday = (String) request.getAttribute("rentperday");
    String expectedreturndate = (String) request.getAttribute("expectedreturndate");
    String expectedamount = (String) request.getAttribute("expectedamount");
    String overdueamount = (String) request.getAttribute("overdueamount");
    String taxamount = (String) request.getAttribute("taxamount");
    String discountamount = (String) request.getAttribute("discountamount");
    String amounttopay = (String) request.getAttribute("amounttopay");
    String ccname = (String) request.getAttribute("ccname");
    String ccnumber = (String) request.getAttribute("ccnumber");
    if (rentalid != null)
    {
    %><br><br>
    <p><b>The total payable amount has been deducted from the credit card.</b></p>
    <p><b>Thank you for renting from us! We hope to serve you again.</b></p><br>
    <div class="container">
            <form class="form-horizontal" role="form"><br>
                <div class="form-group">
                    <label>Rental ID</label>
                    <label>${rentalid}</label>
                </div>
                <div class="form-group">
                    <label>Reservation ID</label>
                    <label>${reservationid}</label>
                </div>
                <div class="form-group">
                    <label>Pick-Up Time</label>
                    <label>${pickuptime}</label>
                </div>
                <div class="form-group">
                    <label>Return Time</label>
                    <label>${returntime}</label>
                </div>
                <div class="form-group">
                    <label>Rent per Day (in $)</label>
                    <label>${rentperday}</label>
                </div>
                <div class="form-group">
                    <label>Expected Return Date</label>
                    <label>${expectedreturndate}</label>
                </div>
                <div class="form-group">
                    <label>Expected Amount (in $)</label>
                    <label>${expectedamount}</label>
                </div>
                <div class="form-group">
                    <label>Over-Due Amount (in $)</label>
                    <label>${overdueamount}</label>
                </div>
                <div class="form-group">
                    <label>Tax Amount (in $)</label>
                    <label>${taxamount}</label>
                </div>
                <div class="form-group">
                    <label>Discount Amount (in $)</label>
                    <label>${discountamount}</label>
                </div>
                <div class="form-group">
                    <label>Total Payable Amount (in $)</label>
                    <label>${amounttopay}</label>
                </div>
                <div class="form-group">
                    <label>Name as on Credit Card</label>
                    <label>${ccname}</label>
                </div>
                <div class="form-group">
                    <label>Credit Card Number</label>
                    <label>${ccnumber}</label>
                </div>
            </form>
        </div><br>
    <%
    }
    %>
    </body>
</html>