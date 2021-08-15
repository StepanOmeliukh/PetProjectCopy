<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Booking</title>
    <style>
        <%@include file="/WEB-INF/resources/css/reset.css" %>
        <%@include file="/WEB-INF/resources/css/bookingStyle.css" %>
        <%@include file="/WEB-INF/resources/css/bookingSelectCss.css" %>
    </style>
</head>
<body>
    <header>
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="booking">Booking</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="#sign in" style="float:right" >Sign in</a>
            <a href="#"style="float:right">Sign up</a>
        </div>
    </header>
    <section class="booking">
        <form action="booking" class="booking_form" method="post">
            <div class="custom-select" style="width:40%;">
                <form action="/booking">
                    <label for="selectField">
                        Choose country:
                        <select style="width: 100%; height: 30px" id="selectField" name="country" onclick="{
                            if (document.getElementById('selectField').options.selectedIndex !== 0)
                                document.getElementById('select').style.display = 'block';
                            else
                                document.getElementById('select').style.display = 'none';
                        }">
                            <c:forEach var="country" items="${countries}">
                                <option value="${country.countryName}">${country.countryName}</option>
                            </c:forEach>
                        </select>
                    </label>
                </form>
            </div>
            <div class="custom-select" id="select" style="width:40%; display: none">
                <label>
                    Choose hotel:
                    <select style="width: 100%; height: 30px" name="hotel" >
                        <c:forEach var="hotel" items="${hotels}">
                            <option class="select" value="${hotel.hotelName}">${hotel.hotelName}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="custom-select" id="select2" style="width:40%;">
                <label>
                    Choose number of stars:
                    <select style="width: 100%; height: 30px" name="stars">
                        <option value="0">One</option>
                        <option value="1">Two</option>
                        <option value="2">Three</option>
                        <option value="3">Four</option>
                        <option value="4">Five</option>
                    </select>
                </label>
            </div>
            <div class="custom-select" id="select3" style="width:40%;">
                <label>
                    Do you want cleaning?
                    <select style="width: 100%; height: 30px" name="country" >
                        <option value="0">Yes</option>
                        <option value="1">No</option>
                    </select>
                </label>
            </div>
            <div class="enter_time" id="select4" style="margin-left: 5%; ">
                <label>
                    Enterence date and time:
                    <input type="datetime-local">
                </label>
            </div>
            <div class="departure_time" id="select5">
                <label>
                    Departure date and time:
                    <input type="datetime-local">
                </label>
            </div>
            <div class="price">

            </div><br>
            <input type="submit" class="book" placeholder="Book">
        </form>
    </section>
    <section class="bookinh_list">

    </section>
    <footer>

    </footer>
</body>
<script type="text/javascript">
    function country() {
        console.log("smth");
        document.getElementById('select2').style.display = "block";
    }
</script>
</html>
