<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="inicio.html"><t:message code="app.titulo"/></a>
    </div>
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
        <ul class="nav navbar-nav navbar-right">
        	<li>
                <a href="<c:url value="/logout.html"/>"><t:message code="nav.info.logout"/></a>                        
            </li>
            <li>
                <a href="<c:url value="/grabar-aporte.html"/>"><t:message code="nav.info.aportar"/></a>                        
            </li>
            <li>
                <a href="#"><t:message code="nav.info.academica"/></a>                        
            </li>
            <li>
                <a href="#"><t:message code="nav.info.usuario"/></a>
            </li>
            <li>
                <a href="#"><c:out value="${user.nombres}"/></a>
            </li>
        </ul>
	</nav>
</header>
