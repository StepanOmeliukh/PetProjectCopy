<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    <%@include file="/WEB-INF/resources/css/allUsersStyle.css"%></style>
<html>
<head>
    <title>Users</title>
</head>
<body>
<header>
    <div class="topnav">
        <a class="active" href="#home">Home</a>
        <a href="booking">Booking</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <a href="#sign in" style="float:right" >Sign in</a>
        <a href="#"style="float:right">Sign up</a>
    </div>
</header>
<div style="text-align: center">
<table border="1" class="styled-table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">

        <sf:form method="get" action="${ordersLink}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
<%--                <td>--%>
<%--                    <a href = "<c:url value ="/management/getOrders/${user.id}"/>">See Orders</a>--%>
<%--                </td>--%>
            </tr>
        </sf:form>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
