<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <th><c:out value="${user.name}"/></th>
            <th><c:out value="${user.email}"/></th>
            <th><c:out value="${user.role.name}"/></th>
            <th><a href="<c:url value="/booking/all/${user.id}"/>">Bookings</a></th>
        </tr>
    </c:forEach>
</table>
<p><a href="/home">Back home</a></p>
</body>
</html>
