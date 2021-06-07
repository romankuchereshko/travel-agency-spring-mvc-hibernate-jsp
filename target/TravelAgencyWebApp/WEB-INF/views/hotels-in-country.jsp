<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Hotels in country</title>
</head>
<body>
<div>
    <div>
        <h2>Hotels In The Country</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Hotel</th>
                <th>Country</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.name}</td>
                    <td>${hotel.country.name}</td>
                    <td>
                        <form action="/rooms/all_rooms_in_hotel/${hotel.id}" method="post">
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
