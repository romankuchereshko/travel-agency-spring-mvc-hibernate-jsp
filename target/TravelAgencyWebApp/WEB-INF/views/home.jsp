<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Welcome to Travel Agency</h2>
<form action="/home" method="post">
    <p><a href="/country/countries">Hotels</a></p>

    <sec:authorize access="hasAuthority('ADMIN')">
        <p><a href="/management">Management</a></p>
    </sec:authorize>

    <button type="submit">Logout</button>
</form>
</body>
</html>