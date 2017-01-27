<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIAA Car Rental System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    </head>
    <style>
        .form-group label {width: 40%;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: 40%; display: inline-block;}
        h1 {color:green;}
        h2 {color:white;}
        label {color:orange;}
        body {text-align: center; background-image: url("background.jpg");}
    </style>
    <body>
        <h1><b>Welcome Admin</b></h1><br>
        <h2><b>Do you want to record a Pick-Up for a reservation?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="PickUp" method="post"><br>
                <div class="form-group">
                    <label for="reservationid">Reservation ID</label>
                    <input type="number" class="form-control" name="reservationid" placeholder="Enter Reservation ID here">
                </div>
                <div class="form-group">
                    <label for="licenseid">Driver's License ID</label>
                    <input type="input" class="form-control" name="licenseid" placeholder="Enter Driver's License ID here">
                </div>
                <div class="form-group">
                    <label for="ccname">Name as on Credit card</label>
                    <input type="input" class="form-control" name="ccname" placeholder="Enter Card Holder's Name here">
                </div>
                <div class="form-group">
                    <label for="ccnumber">Credit Card Number</label>
                    <input type="number" class="form-control" name="ccnumber" placeholder="Enter Credit Card Number here">
                </div>
                <div class="form-group">
                    <label for="ccexpiryyear">Year of Expiry Date</label>
                    <input type="input" class="form-control" name="ccexpiryyear" placeholder="Enter Year of Expiry Date here">
                </div>
                <div class="form-group">
                    <label for="ccexpirymonth">Month of Expiry Date</label>
                    <input type="input" class="form-control" name="ccexpirymonth" placeholder="Enter Month of Expiry Date here">
                </div>
                <div class="form-group">
                    <label for="cvv">CVV</label>
                    <input type="number" class="form-control" name="cvv" placeholder="Enter CVV here">
                </div><br>
                <button type="submit"><b>Confirm Pick-Up</b></button><br><br>
            </form>
        </div><br>
        <h2><b>Do you want to record a Return for a Pick-Up?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="Return" method="post"><br>
                <div class="form-group">
                    <label for="reservationid">Reservation ID</label>
                    <input type="number" class="form-control" name="reservationid" placeholder="Enter Reservation ID here">
                </div>
                <div class="form-group">
                    <label for="licenseid">Driver's License ID</label>
                    <input type="input" class="form-control" name="licenseid" placeholder="Enter Driver's License ID here">
                </div>
                <div class="form-group">
                    <label for="vin">Vehicle Identification Number</label>
                    <input type="input" class="form-control" name="vin" placeholder="Enter VIN here">
                </div><br>
                <button type="submit"><b>Confirm Return</b></button><br><br>
            </form>
        </div><br>
    </body>
</html>