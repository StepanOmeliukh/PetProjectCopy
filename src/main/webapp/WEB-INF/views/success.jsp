
<html>
<head>
    <style><%@include file="/WEB-INF/resources/css/success.css"%></style>
    <title>Travel Agency</title>
</head>
<body>
<div class="container">
    <div class="success__item">
        <div class="btn__sc">
            <h1>Travel Agency</h1>
            <form class="btn__item" action="/auth/logout" method="POST">
                <button class="btn" type="submit">Logout </button>
            </form>
            <form class="btn__item" action="/booking" method="GET">
                <button class="btn" type="submit">Booking </button>
            </form>
            <sec:authorize access="hasAuthority('developers:edit')">
                <form class="btn__item" action="/admin/list" method="GET">
                    <button class="btn" type="submit">Management</button>
                </form>
            </sec:authorize>
        </div>
    </div>

</div>

</div>

</div>
</body>
</html>