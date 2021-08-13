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
            <a href="#booking">Booking</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="#orders" style="float:right" >Orders</a>
            <a href="#users"style="float:right">All users</a>
        </div>
    </header>
    <section>
        <h2>Add Country</h2>
        <form action="/admin/save" method="post">
            <input type="text" name="countryName">
            <button type="submit">Submit</button>
        </form>

<%--        <h2>Add Hotel</h2>--%>
<%--        <form:form action="admin.jsp" class="add_hotel">--%>
<%--            <input type="text" class="hotel" placeholder="Enter hotel name">--%>
<%--            <input type="text" class="">--%>
<%--        </form:form>--%>

<%--        <h2>Add Rooms to hotels</h2>--%>
<%--        <form:form action="admin.jsp" class="add_hotel">--%>
<%--            <input type="text" class="room" placeholder="Enter room name">--%>

<%--        </form:form>--%>
<%--        --%>
    </section>
    <section>
        <label>
            Country list:
            <select name="country">
                <c:forEach var="country" items="${countries}">
                    <option value="${country.countryName}">${country.countryName}</option>
                </c:forEach>
            </select>
        </label>
    </section>
</body>
</html>
