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
        .form-group label {width: 40%;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border: 1px solid #ccc; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: 40%; display: inline-block;}
        p {color:red; font-size:200%;}
        h1 {color:green;}
        h2 {color:white;}
        label {color:orange;}
        body {text-align: center; background-image: url("background.jpg");}
    </style>
    <body>
    <%
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String membershipid = (String) session.getAttribute("membershipid");
        String type = (String) session.getAttribute("type");
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("membershipid", membershipid);
        session.setAttribute("type", type);
        if (type == "user" | type == "guest")
        {%>
            <h1><b>Welcome ${name}</b></h1>
        <%}
        else if (type == "newuser")
        {%>
            <h1><b>Successfully registered! Your membership id is ${membershipid}</b></h1>
        <%}%>
        <h2><b>Do you want to reserve a car?</b></h2>
        <div class="container">
            <form class="form-horizontal" role="form" action="LookUp" method="post"><br>
                <div class="form-group">
                    <label for="carcategory">Car Category ID</label>
                    <input type="number" class="form-control" name="carcategory">
                </div>
                <div class="form-group">
                    <label for="pickupdate">Pick-Up Date</label>
                    <input type="date" class="form-control" name="pickupdate">
                </div>
                <div class="form-group">
                    <label for="returndate">Return Date</label>
                    <input type="date" class="form-control" name="returndate">
                </div><br>
                <button type="submit"><b>Look-Up Car Availability</b></button><br><br>
            </form>
        </div><br>
    </body>
</html>