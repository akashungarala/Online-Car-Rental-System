<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    </head>
    <style>
        .form-group label {color:orange; width: 40%;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: auto; display: inline-block;}
        .form-group button {width: 30%;}
        p {text-align: center; color:green; font-size:200%;}
        body {text-align: center; background-image: url("background.jpg");}
    </style>
    <body>
        <%
        String name = (String) request.getAttribute("name");
        String membershipid = (String) request.getAttribute("membershipid");
        String email = (String) request.getAttribute("email");
        String type = (String) request.getAttribute("type");
        String carcategory = (String) request.getAttribute("carcategory");
        String carcategoryname = (String) request.getAttribute("carcategoryname");
        String pickupdate = (String) request.getAttribute("pickupdate");
        String returndate = (String) request.getAttribute("returndate");
        String rentingprice = (String) request.getAttribute("rentingprice");
        String discountamount = (String) request.getAttribute("discountamount");
        String taxamount = (String) request.getAttribute("taxamount");
        String totalamount = (String) request.getAttribute("totalamount");
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("membershipid", membershipid);
        session.setAttribute("type", type);
        session.setAttribute("carcategory", carcategory);
        session.setAttribute("carcategoryname", carcategoryname);
        session.setAttribute("pickupdate", pickupdate);
        session.setAttribute("returndate", returndate);
        session.setAttribute("rentingprice", rentingprice);
        session.setAttribute("discountamount", discountamount);
        session.setAttribute("taxamount", taxamount);
        session.setAttribute("totalamount", totalamount);
        %>
        <br><p><b>The selected Car Category is available</b></p>
        <div class="container">
            <form class="form-horizontal" role="form" action="Reservation" method="post"><br>
                <div class="form-group">
                    <label>Car Category</label>
                    <label>${carcategoryname}</label>
                </div>
                <div class="form-group">
                    <label>Pick-Up Date</label>
                    <label>${pickupdate}</label>
                </div>
                <div class="form-group">
                    <label>Return Date</label>
                    <label>${returndate}</label>
                </div>
                <div class="form-group">
                    <label>Rent Per Day (in $)</label>
                    <label>${rentingprice}</label>
                </div>
                <div class="form-group">
                    <label>Discount Amount (in $)</label>
                    <label>${discountamount}</label>
                </div>
                <div class="form-group">
                    <label>Expected Tax Amount (in $)</label>
                    <label>${taxamount}</label>
                </div>
                <div class="form-group">
                    <label>Expected Total Amount (in $)</label>
                    <label>${totalamount}</label>
                </div>
                <div class="form-group">
                    <label for="licenseid">Driver's License ID</label>
                    <input type="input" class="form-control" name="licenseid">
                </div>
                <div class="form-group">
                    <label for="fname">Driver's First Name</label>
                    <input type="input" class="form-control" name="fname">
                </div>
                <div class="form-group">
                    <label for="mname">Driver's Middle Name</label>
                    <input type="input" class="form-control" name="mname">
                </div>
                <div class="form-group">
                    <label for="lname">Driver's Last Name</label>
                    <input type="input" class="form-control" name="lname">
                </div><br>
                <div class="form-group">
                    <button type="submit"><b>Reserve</b></button>
                </div>
            </form>
        </div><br>
        <button onclick="goBack()"><b>Back to Look-Up</b></button>
        <script> function goBack(){ window.history.back(); } </script><br><br><br>
    </body>
</html>