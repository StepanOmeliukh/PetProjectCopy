<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/resources/css/register.css"%></style>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Register</title>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Create Account</h2>
    </div>
    <form:form class="form" id="form" method="post" action="/registration/register" modelAttribute="user">
        <p> <div class="form-control">
            <label for="email" >Your Email </label>
                <form:input type="text" path="email" id="Email" placeholder="Email"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
                <form:errors path="email"/>
    </div>
        </p>
        <p> <div class="form-control">
            <label for="firstName" >First name</label>
            <form:input type="text" id="firstName" path="firstName" class="form-control" placeholder="First name"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <form:errors path="firstName"/>
    </div>
        </p>
        <p> <div class="form-control">
            <label for="lastName" >Last name</label>
            <form:input type="text" id="lastName" path="lastName" class="form-control" placeholder="Last name"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <form:errors path="lastName"/>
    </div>
        </p>
        <p> <div class="form-control">
            <label for="password" >Password</label>
            <form:input type="password" id="password" path="password" class="form-control" placeholder="Password"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <form:errors path="password"/>
    </div>
        </p>
        <button type="submit">Sign up</button>
    </form:form>
</div>
</body>

</html>