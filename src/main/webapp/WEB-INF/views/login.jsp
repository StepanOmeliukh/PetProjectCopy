<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/resources/css/login.css"%></style>

<!DOCTYPE html>
<html lang="en">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600&display=swap" rel="stylesheet">

</script>
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
    <div class="container">


        <div class="header">
            <h2>Please sign in</h2>
        </div>
    <div style="text-align: center">
        <br><br>
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red">
                Your login attempt was not successful due to <br/><br>
                <c:out value="incorrect Username or Password"/>.
            </font>
        </c:if>
    </div>
    <form class="form" id="form" method="post" action="/auth/login" name="myForm">
            <p><div class="form-control">
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" placeholder="Username" required autofocus>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
        </div>
            </p>
            <p><div class="form-control">
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password"  placeholder="Password" required>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
        </div>
            </p>
        <div class="btn__block">
            <button type="submit">Sign in</button> <br>
            <button class="btn"><a class="btn_out" href="/registration/register" style="color: white; text-decoration: none" >Sign up</a></button>
        </div>
    </form>
</div>


</body>

</html>