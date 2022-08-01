<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="parchis_oca" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<%@ attribute name="pageName" required="true" %>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>
<parchis_oca:htmlHeader />

<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-default" role="navigation">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div id="navbarSupportedContent" class="collapse navbar-collapse h4 text-decoration-none">
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <parchis_oca:menuItem active="${name eq 'admin'}" url="/" title="admin page">
                            <a href="<c:url value="/admin" />" class="nav-link text-capitalize">admin</a>
                        </parchis_oca:menuItem>
                    </li>
                    <li class="nav-item">
                        <parchis_oca:menuItem active="${name eq 'player'}" url="/admin/players" title="admin players">
                            <a href="<c:url value="/admin/players" />" class="nav-link text-capitalize">players</a>
                        </parchis_oca:menuItem>
                    </li>
                    <li class="nav-item">
                        <parchis_oca:menuItem active="${name eq 'game'}" url="/admin/games" title="admin games">
                            <a href="<c:url value="/admin/games" />" class="nav-link text-capitalize">games</a>
                        </parchis_oca:menuItem>
                    </li>
                </ul>

                <ul class="nav navbar-nav ms-auto">
                    <sec:authorize access="isAuthenticated()">
                        <li class="dropdown nav-item">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"
                                data-bs-toggle="dropdown">
                                <strong>
                                    <sec:authentication property="name" />
                                </strong>
                            </a>

                            <div class="dropdown-menu dropdown-menu-end bg-dark p-1">
                                <a href="<c:url value="/admin/editProfile" />" class="btn btn-danger btn-block w-100
                                text-capitalize">Edit your Profile</a>
                                <div class="dropdown-divider bg-light"></div>
                                <a href="<c:url value="/logout" />" class="btn btn-primary btn-block w-100
                                text-capitalize">Logout</a>
                            </div>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="container xd-container">
            <c:if test="${not empty message}">
                <div class="alert alert-${not empty messageType ? messageType : 'info'}" role="alert">
                    <c:out value="${message}"></c:out>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <jsp:doBody />

        </div>
    </div>
    <parchis_oca:footer />
    <jsp:invoke fragment="customScript" />
</body>

</html>
