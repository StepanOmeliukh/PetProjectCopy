<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ctepa
  Date: 21.08.2021
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Travel Agency!</title>
</head>
<body>
    <section class="bo okinh_list">
        <span>Forms!</span>
        <span id="emptyRoom" style="visibility: hidden">${emptyRoom}</span>
        <c:forEach var="rooms" items="${rooms}">
            <div>
                <form action="/booking/book" method="post" style="width: 60%; height: 150px">
                    <div style="display: inline-block">
                        <div style="display: block"><span>Hotel: ${rooms.hotel.hotelName}</span></div> <%-- Hotel name --%>
                        <div style="display: block"><span>Hotel stars: ${rooms.hotel.stars}</span></div> <%-- Stars --%>
                    </div>
                    <br>
                    <div style="display: inline-block">
                        <div style="display: block">Room number: <input name="id" value="${rooms.id}"/></div>
                        <div style="display: block"><span>Room type: ${rooms.roomsType}</span></div> <%-- Room type --%>
                        <div style="display: block"><span>Cleaning service: ${rooms.cateringService}</span></div> <%-- Cleaning --%>
                    </div>
                    <br>
                    <div style="display: inline-block">
                        <div style="display: block">Date of entrance: <input name="dateOfEntrance" value="${dateOfEntrance}"/></div> <%-- Enter date --%>
                        <div style="display: block">Date of departure: <input name="dateOfDeparture" value="${dateOfDeparture}"/></div> <%-- Departure date --%>
                    </div>
                    <br>
                    <div style="display: inline-block">
                        <div style="display: block"><span>Price: ${rooms.price}</span></div> <%-- Price --%>
                        <div style="display: block"><input type="submit" value="Book"></div> <%-- Submit --%>
                    </div>
                    <br>
                </form>
            </div>
        </c:forEach>
    </section>
</body>
</html>

<%--onclick="{--%>
<%--var element = document.getElementById('emptyRoom');--%>
<%--if (element.textContent === '0')--%>
<%--alert('There are no rooms available at this time')--%>
<%--}"--%>