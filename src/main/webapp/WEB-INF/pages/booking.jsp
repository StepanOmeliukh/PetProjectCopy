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
        <form action="booking.html" class="booking_form" method="post">
            <div class="dropdown">
                <input class="mainmenubtn">Главное меню</input>
                <div class="dropdown-child">
                    <a href="http://www.вашдомен.ru/page1.html">Подраздел 1</a>
                    <a href="http://www.вашдомен.ru/page2.html">Подраздел 2</a>
                    <a href="http://www.вашдомен.ru/page3.html">Подраздел 3</a>
                    <a href="http://www.вашдомен.ru/page4.html">Подраздел 4</a>
                    <a href="http://www.вашдомен.ru/page5.html">Подраздел 5</a>
                </div>
            </div>
        </form>
    </section>
    <section class="bookinh_list">

    </section>
    <footer>

    </footer>
</body>
</html>
