<%--
  Created by IntelliJ IDEA.
  User: sarahbarron
  Date: 2019-02-11
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div>
        <form method="post" action="/register">
            <label for="username">Username:</label>
            <input type="text" id="username" name ="username" placeholder="Enter username here"><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter email address here"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
        </form>
    </div>
    <button type="submit">Create my account</button>
    
</body>
</html>
