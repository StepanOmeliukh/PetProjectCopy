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
</head>
<body>
    <header>
        <div class="topnav">
            <a class="active" href="/auth/success">Home</a>
            <a href="booking">Booking</a>
            <a href="/admin/list">Admin</a>

            <form class="btn__item" style="float:right; " action="/auth/logout" method="POST">
            <button class="btn" type="submit">Logout</button>
            </form>
        </div>
    </header>
    <section class="booking">
        <form action="/booking/filter" class="booking_form" method="post">
            <div class="custom-select" style="width:40%;">
                <label for="selectField">
                    Choose country:
                    <select style="width: 100%; height: 30px" id="selectField" name="countryName">
                        <c:forEach var="country" items="${countries}">
                            <option value="${country.countryName}">${country.countryName}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="custom-select" id="select" style="width:40%;">
                <label>
                    Number of beds:
                    <select style="width: 100%; height: 30px" name="roomsType">
                        <c:forEach var="roomsType" items="${roomsType}">
                            <option value="${roomsType}">${roomsType}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="custom-select" id="select2" style="width:40%;">
                <label>
                    Choose number of stars:
                    <select style="width: 100%; height: 30px" name="stars">
                        <c:forEach var="stars" items="${stars}">
                            <option value="${stars}">${stars}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="custom-select" id="select3" style="width:40%;">
                <label>
                    Do you want cleaning?
                    <select name="cateringService">
                        <option [ngValue]="true">Yes</option>
                        <option [ngValue]="false">No</option>
                    </select>
                </label>
            </div>
            <div class="enter_time" id="select4" style="margin-left: 5%; ">
                <label>
                    Enterence date and time:
                    <input type="date" name="dateOfEntrance">
                </label>
            </div>
            <div class="departure_time" id="select5">
                <label>
                    Departure date and time:
                    <input type="date" name="dateOfDeparture">
                </label>
            </div>
            <input type="submit" class="book" placeholder="Book">
        </form>
    </section>
</body>
</html>
