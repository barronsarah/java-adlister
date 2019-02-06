<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
    <title>Title</title>
</head>
<body>
    <%@ include file="/WEB-INF/partials/navbar.jsp" %>
    <h2>Here are all your ads!</h2>
    <c:forEach var="ad" items="${ads}">
        <div class="ad">
           <p>
               <%--${ad.userId--%>
            <h5>${ad.title}</h5>
             ${ad.description}<br>
           </p>
        </div>
    </c:forEach>

</body>
</html>
