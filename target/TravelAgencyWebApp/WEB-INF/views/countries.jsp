<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Find by country</title>
</head>
<body>
<h2>Find hotels in the country</h2>
<form:form action="/country/getAllHotelsInCountry" modelAttribute="countries" method="post">
    <label for="country">Country</label>
    <select name="country" id="country">
        <c:forEach var="c" items="${countries}">
            <option value="${c.name}">${c.name}</option>
        </c:forEach>
    </select>
    <p>
        <input type="submit" value="Search">
    </p>
</form:form>
<p><a href="/home">Back home</a></p>
</body>
</html>
