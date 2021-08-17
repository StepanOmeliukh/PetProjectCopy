
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/resources/css/loginStyle.css"%></style>
<!DOCTYPE html>
<html lang="en">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600&display=swap" rel="stylesheet">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="form-control">
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" placeholder="Username" required autofocus>
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password"  placeholder="Password" required>
            </p>
        </div>
        <div class="btn__block">
            <button class="btn" type="submit"><a href="/welcome">Sign in</a></button>
            <button class="btn"><a class="btn_out" href="/registers/registers">Sign up</a></button>
        </div>
    </form>
</div>
</body>
</html>



<%--<html>--%>
<%--<head>--%>

<%--</head>--%>
<%--<style>--%>
<%--    <%@include file="/WEB-INF/resources/css/loginStyle.css" %>--%>
<%--</style>--%>

<%--<body>--%>
<%--<div class="allCenter">--%>
<%--    <div class="container">--%>
<%--        &lt;%&ndash;@declare id="uname"&ndash;%&gt;&lt;%&ndash;@declare id="psw"&ndash;%&gt;<label for="uname"><b>Username</b></label>--%>
<%--            <br>--%>
<%--        <input type="text"  placeholder="Enter Username" name="uname" required>--%>
<%--<br>--%>
<%--        <label for="psw"><b>Password</b></label><br>--%>

<%--        <input type="password" placeholder="Enter Password" name="psw" required>--%>
<%--<br>--%>
<%--        <button type="submit" style="max-width: 20%">Login</button>--%>
<%--    </div>--%>

<%--    <div class="container"  >--%>
<%--        <span class="psw">Back to <a href="#">home</a></span>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>