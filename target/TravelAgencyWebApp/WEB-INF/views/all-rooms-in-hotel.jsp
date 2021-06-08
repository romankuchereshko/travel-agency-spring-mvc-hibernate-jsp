<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>All hotels room</title>
</head>
<body>
<div>
    <div>
        <h2>All Rooms</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Room id</th>
                <th>Room price</th>
                <th>Guest count</th>
                <th>Bed</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td align="center" >${room.id}</td>
                    <td align="center">${room.price}$</td>
                    <td align="center">${room.guestsCount}</td>
                    <td align="center">${room.bed.toString()}</td>
                </tr>
                <c:set var="hotelId" value="${room.hotel.id}"/>
            </c:forEach>
            </tbody>

        </table>
        <p><a href="/rooms/add/${hotelId}">Add room</a></p>
        <p><a href="/home">Back home</a></p>
    </div>

</div>
</body>
</html>
