<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hotels in country</title>
</head>
<body>
<div>
    <div>
        <h2>Hotels In The Country</h2>
        <table>
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
<%--                    <sec:authorize access="hasAuthority('all_permissions')">--%>
<%--                        <p><a href="${contextPath}/management">Management page</a></p>--%>
<%--                    </sec:authorize>--%>
<%--                    <td><a href="/hotels/delete/${hotel.id}">Delete hotel</a></td>--%>
<%--                    <td><a href="/rooms/add/${hotel.id}">Add room</a></td>--%>
<%--                    <td><a href="/rooms/all_rooms_in_hotel/${hotel.id}/">All rooms in hotel</a></td>--%>
                    <td>
                        <form action="/rooms/all_rooms_in_hotel/${hotel.id}" method="get">
                            <input type="submit" value="check available room">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
