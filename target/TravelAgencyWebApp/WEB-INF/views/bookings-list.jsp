<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Booking list</title>
</head>
<body>
<h1>Management</h1>
<table>
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
        </tr>
    </c:forEach>
    <c:if test="${empty all}">
        no bookings added yet.
    </c:if>
</table>
<a href="/home">Back home</a>
</body>
</html>