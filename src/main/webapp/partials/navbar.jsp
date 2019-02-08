<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <li><a href="/logout">Logout</a></li>
<%--using jstl to show/hide login/logout button (does not work- possibly for sessionScope.user--%>
        <%--<c:choose>--%>
                <%--<c:when test="${sessionScope.user != null}">--%>
            <%--<li><a href="/logout">Logout</a></li>--%>
                <%--</c:when>--%>
                <%--<c: otherwise>--%>
            <%--<li><a href="/login">Login</a></li>--%>
                <%--</c:>--%>
            <%--</c:choose>--%>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
