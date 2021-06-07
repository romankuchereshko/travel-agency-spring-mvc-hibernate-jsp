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
    <input type="hidden" name="hotelId" value="${room.hotelId}">
    <label for="price">Room price</label>
    <form:input path="price" type="number" id="price" placeholder="Price" required="true" min="1"/>
    </p>
    <p>
        <label for="guestsCount">Guest count</label>
        <form:input path="guestsCount" type="" id="guestsCount" placeholder="Guest count" required="true" min="1"/>
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
