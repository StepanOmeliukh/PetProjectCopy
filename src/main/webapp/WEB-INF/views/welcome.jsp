
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
</head>
<body>
<form method="post" action="login.jsp">
    <center><h2 style="color:green">JSP Login Example</h2></center>
    <table border="1" align="center">
        <tr>
            <td>Enter Your Name :</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Enter Your Password :</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="submit"/></td>
    </table>
</form>
</body>
</html>
