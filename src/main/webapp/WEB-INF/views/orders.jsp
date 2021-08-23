<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@include file="/WEB-INF/resources/css/allUsersStyle.css"%></style>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h2>Orders of ${user.email}</h2>
<table border="1" class="styled-table">
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Hotel</th>
        <th>Room</th>
        <th>Arrival Date</th>
        <th>Departure Date</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${bookings}">
        <tr>
            <td>${order.id}</td>
            <td>${order.hotel.name}</td>
            <td>${order.room.roomsType}</td>
            <td>${order.room.cateringService}</td>
            <td>${order.room.enterDateTime}</td>
            <td>${order.room.departureDateTime}</td>
            <td>${order.room.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>