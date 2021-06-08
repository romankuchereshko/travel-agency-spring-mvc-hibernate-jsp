<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Available rooms in hotel</title>
</head>
<body>
<div>
    <h2>All rooms</h2>
    <c:if test="${not empty errorMessage}">
        <h4><strong>${errorMessage}</strong></h4>
    </c:if>
    <table border="1">
        <thead>
        <tr>
            <th>Room number</th>
            <th>Guests count</th>
            <th>Room price</th>
            <th>Bed</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td align="center">${room.id}</td>
                <td align="center">${room.guestsCount}</td>
                <td align="center">${room.price}$</td>
                <td align="center">${room.bed.toString()}</td>
                <td>
                    <form action="/rooms/available_room/${room.id}" method="post">
                        <div>
                            <label for="checkIn">Check in</label>
                            <input type="date" name="checkIn" id="checkIn" required>
                            <p>
                                <label for="checkOut">Check out</label>
                                <input type="date" name="checkOut" id="checkOut" required>
                            </p>
                            <p>
                                <input type="hidden" name="hotelId" value="${room.hotel.id}">
                            </p>
                            <input type="submit" value="Check the room">

                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="/home">Back home</a></p>
</div>

</body>
</html>
