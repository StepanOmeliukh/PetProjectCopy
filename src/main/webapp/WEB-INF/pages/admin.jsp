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
            <a href="#booking">Booking</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="#orders" style="float:right" >Orders</a>
            <a href="#users"style="float:right">All users</a>
        </div>
    </header>
    <section>
        <h2>Add Country</h2>
        <form action="admin.jsp" class="add_hotel">
            <input type="text" class="hotel" placeholder="Enter country name">
            <input type="text" class="">
        </form>

        <h2>Add Hotel</h2>
        <form action="admin.jsp" class="add_hotel">
            <input type="text" class="hotel" placeholder="Enter hotel name">
            <input type="text" class="">
        </form>

        <h2>Add Rooms to hotels</h2>
        <form action="admin.jsp" class="add_hotel">
            <input type="text" class="room" placeholder="Enter room name">

        </form>
    </section>

</body>
</html>
