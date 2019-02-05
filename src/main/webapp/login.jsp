<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Login</title>
    <%@ include file="partials/head.jsp"%>
</head>
<body>
    <%@ include file="partials/navbar.jsp" %>

    <h2>Login!</h2><br>
    <form method="POST" action="/login">
        Username:
        <input type="text" id="username" name="username" placeholder="Enter Username Here"><br>
        Password:
        <input type="password" name="password"><br>
        <button type="submit">Login!</button>

    </form>
</body>
</html>
