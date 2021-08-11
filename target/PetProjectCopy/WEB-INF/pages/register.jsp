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
<form:form class="form-signin" method="post" action="/" modelAttribute="user">
<div class="allCenter" style="margin-top: 8%">
    <div class="container">
        <%--@declare id="uname"--%><%--@declare id="psw"--%>
            <label for="uname"><b>Username</b></label><br>

        <input type="text"  placeholder="Create Username" name="uname" required><br>

        <label for="psw"><b>Password</b></label><br>

        <input type="password" placeholder="Create Password" name="psw" required><br>

            <label for="uname"><b>Email</b></label><br>

            <input type="email" placeholder="Write your email" name="email" required><br>

            <form action="/">
                <input type="submit" value="Sign up" />
            </form>
    </div>

    <div class="container"  >
        <span class="psw">Back to <a href="">home</a></span>
    </div>
</div>
</form:form>
</body>
</html>