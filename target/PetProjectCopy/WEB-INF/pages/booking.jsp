<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Booking</title>
    <style>
        <%@include file="/WEB-INF/resources/css/reset.css" %>
        <%@include file="/WEB-INF/resources/css/bookingStyle.css" %>
        <%@include file="/WEB-INF/resources/css/bookingSelectCss.css" %>
    </style>

    <script type="text/javascript">
        function country() {
            document.getElementsByClassName('hider').onclick = function() {
                document.getElementById('text').hidden = true;
            }
        }
    </script>
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
            <div class="custom-select" style="width:40%;">
                <select style="width: 100%; height: 30px" name="country" >
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.countryName}" onclick="country()">${country.countryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="custom-select" style="width:40%;">
                <select style="width: 100%; height: 30px" name="country" >
                    <c:forEach var="country" items="${countries}">
                        <option class="select" value="${country.countryName}" onclick="country()">${country.countryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="custom-select" style="width:40%;">
                <select style="width: 100%; height: 30px" name="country" >
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.countryName}" onclick="country()">${country.countryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="custom-select" style="width:40%;">
                <select style="width: 100%; height: 30px" name="country" >
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.countryName}" onclick="country()">${country.countryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="enter_time" style="margin-left: 5%">
                <input type="datetime-local">
            </div>
            <div class="departure_time">
                <input type="datetime-local">
            </div>
            <div class="price">

            </div><br>
            <input type="submit" class="book" placeholder="Book">
        </form>
    </section>
    <section class="bookinh_list">

    </section>
    <footer>

    </footer>
</body>
</html>
