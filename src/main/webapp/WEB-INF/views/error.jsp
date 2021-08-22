<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Error page</title>
    <style>
        <%@include file="/WEB-INF/resources/css/error.css"%>
    </style>

</head>

<body>

<center><h1 style="color:red; padding-top: 10%">Sorry, your record is not available</h1></center>
<div class="container">
       <form class="btn__item" action="/auth/success" method="GET">
       <button type="submit">Back to main page</button>
</form>
</div>

</body>

</html>