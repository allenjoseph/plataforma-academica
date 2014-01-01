<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>        
        <a class="navbar-brand" href="<c:url value="/inicio.html"/>"><t:message code="app.titulo"/></a>
    </div>
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
        <ul class="nav navbar-nav navbar-right"> 
        	<c:if test="${user.isAdministrativo}">
	        	<li>
	                <a href="<c:url value="/evento.html"/>"><t:message code="nav.info.evento"/></a>                        
	            </li>
	            <li>
	                <a href="<c:url value="/documento.html"/>"><t:message code="nav.info.documento"/></a>                        
	            </li>
        	</c:if>   
        	<c:if test="${user.isDocente or user.isAlumno}">
	        	<li>
	                <a href="<c:url value="/aporte.html"/>"><t:message code="nav.info.aportar"/></a>                        
	            </li>
        	</c:if>       	            
            <c:if test="${user.isDocente}">
            	<li>
	                <a href="<c:url value="/trabajo.html"/>"><t:message code="nav.info.trabajo"/></a>                        
	            </li>
	        	<li>
	                <a href="<c:url value="/examen.html"/>"><t:message code="nav.info.examen"/></a>                        
	            </li>
            </c:if>            
            <li>
                <a href="<c:url value="/mensaje.html"/>"><t:message code="nav.info.mensaje"/></a>
            </li>
            <li class="dropdown">
	        	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${user.nombres}"/></a>
		        <ul class="dropdown-menu">
					<li>
						<a href="#">
							<i class="icon-user"></i>
							<t:message code="nav.info.usuario"/>
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="<c:url value="/logout.html"/>">
							<i class="icon-off"></i>
							<t:message code="nav.info.logout"/>
						</a>
					</li>
		        </ul>
      		</li>
        </ul>
	</nav>
</header>
