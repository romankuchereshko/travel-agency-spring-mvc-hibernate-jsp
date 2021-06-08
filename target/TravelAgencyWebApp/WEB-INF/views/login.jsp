<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form method="post" action="/login">
        <h2 class="form-heading">Login</h2>
        <div>
            <c:if test="${errorMessage}">Wrong user name or password</c:if>
        </div>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </p>
    </form>
</div>
</body>
</html>
