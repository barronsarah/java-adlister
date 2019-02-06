<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Login</title>
    <%@ include file="/WEB-INF/partials/head.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/partials/navbar.jsp" %>

    <h2>Login!</h2><br>

    <div class="container mx-4">
        <div class="row justify-content-left">
            <div class="col-md-4">
                <form method="POST" action="/login">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" aria-describedby=""
                               placeholder="Enter username">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                            else.
                        </small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Login!</button>
                </form>
            </div>
        </div>
    </div>


</body>
</html>
