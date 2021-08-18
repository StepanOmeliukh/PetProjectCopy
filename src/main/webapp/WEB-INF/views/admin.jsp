<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bufan
  Date: 8/10/2021
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<style>
    <%@include file="/WEB-INF/resources/css/adminStyle.css" %>
</style>
<body>
    <header>
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="/booking">Booking</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="/admin/list">Admin</a>
            <a href="#orders" style="float:right" >Orders</a>
            <a href="#users"style="float:right">All users</a>
        </div>
    </header>
    <section>
        <h2>Add Country</h2>
        <form action="/admin/country/save" method="post">
            <input type="text" name="countryName">
            <button type="submit">Submit</button>
        </form>

        <h2>Add Hotel</h2>
        <form action="/admin/hotel/save" method="post">
            <input type="text" name="hotelName" placeholder="Enter hotel name">
            <label>
                Stars:
                <select name="stars">
                    <c:forEach var="stars" items="${stars}">
                        <option value="${stars}">${stars}</option>
                    </c:forEach>
                </select>
            </label>
            <label>
                Choose Country:
                <select name="countryName" id="selectedCountry">
                    <c:forEach var="countries" items="${countries}">
                        <option value="${countries.countryName}">${countries.countryName}</option>
                    </c:forEach>
                </select>
            </label>
            <button type="submit" onclick="{
                if (document.getElementById('selectedCountry').value === 'No country selected')
                    alert('You have not selected a country');
            }">Submit</button>
        </form>

        <h2>Add Rooms to hotels</h2>
        <form action="/admin/hotel/find" method="get" id="find">
            <label>
                Choose Country:
                <select name="countryName">
                    <c:forEach var="countries" items="${countries}">
                        <option value="${countries.countryName}">${countries.countryName}</option>
                    </c:forEach>
                </select>
            </label>
            <input type="submit" value="Submit2" onclick="{
                document.getElementById('add_hotel').style.display = 'block';
            }"/>
        </form>

        <form action="/admin/room/save" id="add_hotel" method="post">
            <label for="selectedRoomType">
                Room type:
                <select name="roomsType" id="selectedRoomType">
                    <c:forEach var="roomsType" items="${roomsType}">
                        <option value="${roomsType}">${roomsType}</option>
                    </c:forEach>
                </select>
            </label>
            <label>
                Cleaning service:
                <select name="cateringService">
                    <option [ngValue]="true">Yes</option>
                    <option [ngValue]="false">No</option>
                </select>
            </label>
            <label>
                Price:
                <input type="text" name="price">
            </label>

            <label>
                Hotels list:
                <select name="hotelName">
                    <c:forEach var="filteredHotels" items="${filteredHotels}">
                        <option value="${filteredHotels.hotelName}">${filteredHotels.hotelName}</option>
                    </c:forEach>
                </select>
            </label>
            <button type="submit">Submit</button>
        </form>
    </section>
<%--    <section>--%>
<%--        <label>--%>
<%--            Countries list:--%>
<%--            <select name="country">--%>
<%--                <c:forEach var="countries" items="${countries}">--%>
<%--                    <option value="${countries.countryName}">${countries.countryName}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </label>--%>
<%--        <label>--%>
<%--            Hotels list:--%>
<%--            <select name="hotel">--%>
<%--                <c:forEach var="hotels" items="${hotels}">--%>
<%--                    <option value="${hotels.hotelName}">${hotels.hotelName}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </label>--%>
<%--    </section>--%>
</body>
</html>
