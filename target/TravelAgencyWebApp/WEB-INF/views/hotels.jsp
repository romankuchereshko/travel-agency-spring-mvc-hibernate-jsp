<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>All hotels</title>
</head>
<body>
<div>
    <div>
        <h2>All Hotels</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Hotel</th>
                <th>Accommodation type</th>
                <th>Country</th>
                <th>Rate</th>
                <th>Facilities</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.name}</td>
                    <td>${hotel.type.toString()}</td>
                    <td>${hotel.country.name}</td>
                    <td align="center">${hotel.rate}</td>
                    <td>
                        <c:if test="${hotel.hasWiFi == true}">Free WiFi, </c:if>
                        <c:if test="${hotel.hasPool == true}">Pool, </c:if>
                        <c:if test="${hotel.isPetsAllowed == true}">Pets are allowed, </c:if>
                        <c:if test="${hotel.canSmoke == true}">Smoking is allowed</c:if>
                    </td>
                    <td><a href="/hotels/delete/${hotel.id}">Delete hotel</a></td>
                    <td><a href="/rooms/add/${hotel.id}">Add room</a></td>
                    <td><a href="/rooms/all_rooms_in_hotel/${hotel.id}/">All rooms in hotel</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <p><a href="<c:url value="/hotels/add"/>">Add hotel</a></p>
    <p><a href="/home">Back home</a></p>
</div>
</body>
</html>
