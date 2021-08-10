<html>
<head>

</head>
<style>
    <%@include file="/WEB-INF/resources/css/loginStyle.css" %>
</style>

<body>
<div class="allCenter">
    <div class="container">
        <%--@declare id="uname"--%><%--@declare id="psw"--%><label for="uname"><b>Username</b></label>
            <br>
        <input type="text"  placeholder="Enter Username" name="uname" required>
<br>
        <label for="psw"><b>Password</b></label><br>

        <input type="password" placeholder="Enter Password" name="psw" required>
<br>
        <button type="submit" style="max-width: 20%">Login</button>
    </div>

    <div class="container"  >
        <span class="psw">Back to <a href="#">home</a></span>
    </div>
</div>
</body>
</html>