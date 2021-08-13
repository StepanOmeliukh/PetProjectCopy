<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/resources/css/registerStyle.css" %>
    </style>
</head>
<body>
        <div class="allCenter" style="margin-top: 8%">
                <div class="container">
                    <form action="/register/save" method="post">
                        <label>
                            Username:
                            <input type="text"  placeholder="Create Username" name="username" required>
                        </label><br>

                        <label>
                            Password:
                            <input type="password" placeholder="Create Password" name="password" required>
                        </label><br>

                        <label>
                            Email:
                            <input type="email" placeholder="Write your email" name="email" required>
                        </label><br>

                        <button type="submit">Sign up</button>
                    </form>
                </div>

            <div class="container"  >
                <span class="psw">Back to <a href="">home</a></span>
            </div>
        </div>
</body>
</html>