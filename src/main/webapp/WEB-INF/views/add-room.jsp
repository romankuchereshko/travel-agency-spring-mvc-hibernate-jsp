<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add room</title>
</head>
<body>
<h2>Add room</h2>
<form:form action="/rooms/add" modelAttribute="room" method="post">
    <p>
        <label for="price">Room price</label>
        <form:input path="price" type="number" id="price" placeholder="Price" required="true" min="1"/>
    </p>
    <p>
        <label for="guestCount">Guest count</label>
        <form:input path="guestCount" type="number" id="guestCount" placeholder="Guests count" required="true" min="1"/>
    </p>
    <p>
        <label for="bed">Bed type</label>
        <form:select path="bed">
            <form:options items="${beds}"/>
        </form:select>
    </p>
    <p>
        <input type="submit" value="Add room">
    </p>
</form:form>
</body>
</html>
