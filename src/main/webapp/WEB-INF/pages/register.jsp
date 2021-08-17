<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<style>
    <%@include file="/WEB-INF/resources/css/registerStyle.css" %>
</style>
<body>
    <form class="form-signin" method="post" action="/save">
        <h2>Please sign in</h2>
        <p>
            <label for="email" >Email </label>
            <input type="text" name="email" id="Email" placeholder="Email"/>
    <%--        <form:errors path="email"/>--%>
        </p>
        <p>
            <label for="firstName" >First name</label>
            <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name"/>
    <%--        <form:errors path="firstName"/>--%>
        </p>
        <p>
            <label for="lastName" >Last name</label>
            <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last name"/>
    <%--        <form:errors path="lastName"/>--%>
        </p>
        <p>
            <label for="password" >Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
    <%--        <form:errors path="password"/>--%>
        </p>
        <button type="submit">Sign up</button>
    </form>
</body>
</html>