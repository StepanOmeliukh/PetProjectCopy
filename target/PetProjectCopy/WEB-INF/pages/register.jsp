<html>
<head>

</head>
<style>
    <%@include file="/WEB-INF/resources/css/registerStyle.css" %>
</style>

<body>
<div class="allCenter" style="margin-top: 8%">
    <div class="container">
        <%--@declare id="uname"--%><%--@declare id="psw"--%>
            <label for="uname"><b>Username</b></label><br>
        <input type="text"  placeholder="Create Username" name="uname" required><br>
        <label for="psw"><b>Password</b></label><br>
        <input type="password" placeholder="Create Password" name="psw" required><br>
            <label for="uname"><b>Email</b></label><br>
            <input type="email" placeholder="Write your email" name="email" required><br>
        <button type="submit" style="max-width: 20%">Sign up</button>
    </div>

    <div class="container"  >
        <span class="psw">Back to <a href="#">home</a></span>
    </div>
</div>
</body>
</html>