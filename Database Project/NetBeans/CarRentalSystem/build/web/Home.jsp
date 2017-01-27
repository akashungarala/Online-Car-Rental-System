<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIAA Car Rental System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>-->
    </head>
    <style>
        .form-group label {width: 200px;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: auto; display: inline-block;}
        p {color:red; font-size:200%;}
        h1 {color:green;}
        h2 {color:white;}
        label {color:orange;}
        body {text-align: center; background-image: url("background.jpg");}
    </style>
    <body>
        <h1><b>MIAA Car Rental System</b></h1><br>
        <img src="Cars.jpg" width="600" height="300"><br><br>
        <h2><b>Are you a registered user?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="User" method="post"><br>
                <div class="form-group">
                    <label for="useremail">Email ID</label>
                    <input type="email" class="form-control" name="useremail" placeholder="Enter your Email ID here">
                </div>
                <div class="form-group">
                    <label for="userpassword">Password</label>
                    <input type="password" class="form-control" name="userpassword" placeholder="Enter your Password here">
                </div><br>
                <button type="submit"><b>Log In</b></button><br><br>
                <!--<button type="submit" class="btn btn-default user_btn"><b>Log In</b></button><br><br>-->
            </form>
        </div><br>
        <h2><b>Do you want to register?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="AddUser" method="post"><br>
                <div class="form-group">
                    <label for="first">First Name</label>
                    <input type="text" class="form-control" name="first" placeholder="What's your first name?">
                </div>
                <div class="form-group">
                    <label for="middle">Middle Name</label>
                    <input type="text" class="form-control" name="middle" placeholder="What's your middle name?">
                </div>
                <div class="form-group">
                    <label for="last">Last Name</label>
                    <input type="text" class="form-control" name="last" placeholder="What's your last name?">
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" class="form-control" name="phone" placeholder="What's your number?">
                </div>
                <div class="form-group">
                    <label for="email">Email ID</label>
                    <input type="email" class="form-control" name="email" placeholder="What's your email id?">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Choose a password">
                </div>
                <div class="form-group">
                    <label for="confirmpassword">Confirm Password</label>
                    <input type="text" class="form-control" name="confirmpassword" placeholder="Re-type your password">
                </div><br>
                <button type="submit"><b>Register</b></button><br><br>
                <!--<button type="submit" class="btn btn-default newuser_btn"><b>Register</b></button><br><br>-->
            </form>
        </div><br>
        <h2><b>Are you a guest?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="AddGuest" method="post"><br>
                <div class="form-group">
                    <label for="guestfirst">First Name</label>
                    <input type="text" class="form-control" name="guestfirst" placeholder="What's your first name?">
                </div>
                <div class="form-group">
                    <label for="guestmiddle">Middle Name</label>
                    <input type="text" class="form-control" name="guestmiddle" placeholder="What's your middle name?">
                </div>
                <div class="form-group">
                    <label for="guestlast">Last Name</label>
                    <input type="text" class="form-control" name="guestlast" placeholder="What's your last name?">
                </div>
                <div class="form-group">
                    <label for="guestphone">Phone Number</label>
                    <input type="text" class="form-control" name="guestphone" placeholder="What's your number?">
                </div>
                <div class="form-group">
                    <label for="guestemail">Email ID</label>
                    <input type="email" class="form-control" name="guestemail" placeholder="What's your email id?">
                </div><br>
                <button type="submit"><b>Log In as a guest</b></button>br><br>
                <!--<button type="submit" class="btn btn-default guest_btn"><b>Log In as a guest</b></button>br><br>-->
            </form>
        </div><br>
    </body>
</html>