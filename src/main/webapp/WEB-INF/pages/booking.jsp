<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <style>
        <%@include file="/WEB-INF/resources/css/reset.css" %>
        <%@include file="/WEB-INF/resources/css/bookingStyle.css" %>
    </style>
</head>
<body>
    <header>
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#booking">Booking</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="#sign in" style="float:right" >Sign in</a>
            <a href="#"style="float:right">Sign up</a>
        </div>
    </header>
    <section class="booking">
        <form action="booking" class="booking_form" method="post">
            <div class="dropdown">
                <input class="mainmenubtn" placeholder="Choise country"/>
                <div class="dropdown-child">
                    <button></button>
                </div>
            </div>
            <div class="dropdown2">
                <input class="mainmenubtn2" placeholder="Choise hotel"/>
                <div class="dropdown-child2">
                    <button></button>
                </div>
            </div>
            <input type="text" class="stars" placeholder="Stars">
            <input type="text" class="beds" placeholder="beds in room">
            <button class="search">Search</button>
        </form>
    </section>
    <section class="bookinh_list">

    </section>
    <footer>

    </footer>
</body>
</html>
