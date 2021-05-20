<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add new hotel</title>
</head>
<body>
<h2>Add new hotel</h2>
<%@include file="header.html" %>

<form:form method="post" modelAttribute="hotel">
<%--    <form:hidden path="id"/>--%>

    <form:label path="name">Name</form:label>
    <form:input path="name" type="text" required="required"/>
    <form:errors path="name" cssClass="text-warning"/>

<%--    <form:select path="country">--%>
<%--        <form:option value="Ukraine" label="Ukraine"/>--%>
<%--        <form:option value="Germany" label="Germany"/>--%>
<%--        <form:option value="Poland" label="Poland"/>--%>
<%--    </form:select>--%>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>