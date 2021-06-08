<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Booking list</title>
</head>
<body>
<h1>Management</h1>
<table border="1">
    <c:forEach var="booking" items="${all}">
        <tr>
            <th>Room</th>
            <th>Hotel</th>
            <th>Checkin</th>
            <th>Checkout</th>
        </tr>
        <tr>
            <td><c:out value="${booking.room.id}"/></td>
            <td><c:out value="${booking.room.hotel.name}"/></td>
            <td><c:out value="${booking.checkIn}"/></td>
            <td><c:out value="${booking.checkOut}"/></td>
            <td><a href="/booking/delete/${booking.id}">Cancel booking</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty all}">
        User don't have any bookings :(
    </c:if>
</table>
<p><a href="/home">Back home</a></p>
</body>
</html>