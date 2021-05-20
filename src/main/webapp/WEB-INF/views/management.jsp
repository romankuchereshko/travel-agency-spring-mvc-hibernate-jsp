<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Management</title>
</head>
<body>
<%@include file="header.html" %>
<h2>Management</h2>
<h3><a href="<c:url value="/hotels/add"/>">Add new hotel</a></h3>
<h3><a href="<c:url value="/rooms/add"/>">Add new room</a></h3>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:choose>
        <c:when test="${empty users}">
            <h3>No users added yet.</h3>
        </c:when>
    </c:choose>
    <c:forEach var="user" items="${users}">
        <tr>
            <th><c:out value="${user.id}"/></th>
            <th><c:out value="${user.name}"/></th>
            <th><c:out value="${user.email}"/></th>
            <th><a href="<c:url value="/booking/all/${user.id}"/>">Bookings</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
