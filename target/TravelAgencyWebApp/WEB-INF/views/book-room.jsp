<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Book room</title>
</head>
<body>
<h2>This room is available for booking now!</h2>
<h3>Booking room from ${checkIn.toString()} to ${checkOut.toString()}</h3>
<form action="/booking/book/${id}" method="post">
    <input type="hidden" name="checkIn" value="${checkIn.toString()}">
    <input type="hidden" name="checkOut" value="${checkOut.toString()}">
    <input type="submit" value="Book">
</form>
</body>
</html>