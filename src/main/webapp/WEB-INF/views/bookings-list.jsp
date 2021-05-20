<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Booking list</title>
</head>
<body>
<%@include file="header.html" %>
<h1>Management</h1>

<table>
    <c:forEach var="booking" items="${all}">
        <tr>
            <td><c:out value="Hotel: ${booking.hotel.name}"/></td>
            <td><c:out value="Room number: ${booking.room.id}"/></td>
            <td><c:out value="Arrival: ${booking.arrival.toString()}"/></td>
            <td><c:out value="Checkout: ${booking.checkout.toString()}"/></td>
        </tr>
    </c:forEach>
    <c:if test="${empty all}">
        no bookings added yet.
    </c:if>
</table>

</body>
</html>