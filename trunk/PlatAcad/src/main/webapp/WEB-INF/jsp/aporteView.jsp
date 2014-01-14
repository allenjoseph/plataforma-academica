<%@ taglib prefix="t" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="template/head.jsp" />
<body>
	<div class="container">
		<jsp:include page="template/navbar.jsp" />
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="template/user.jsp" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 main-content" id="main-aporte-view">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header">
							<h1>
								<c:out value="${aporte.titulo}" />
								<c:url value="listar-aportes.html" var="urlAportes">
									<c:param name="cursoId" value="${aporte.idCursoAperturadoFk.idCursoAperturado}"/>
								</c:url>
								<a href="${urlAportes}" title="Volver"><i class="fa fa-reply"></i></a>
							</h1>
						</div>
						<div>
							<c:out value="${aporte.contenidoValue}" escapeXml="false"/>
						</div>						
					</div>
					<div class="panel-footer">
						<div class="panel-footer-info">
							<small>
								<i class="icon-star"></i>
								<c:out value="${aporte.idUsuarioFk.fullName}" />
							</small>
						</div>
						<div class="footer-date-info">
							<small>
								<i class="icon-calendar"></i>
								<t:message code="page.list.aportar.fecha.creacion" />									
								<c:out value="${aporte.auditoria.creacionFecha}" />
							</small>
						</div>
					</div>
				</div>	
			</div>
			<jsp:include page="template/sidemain.jsp" />
		</div>
		<jsp:include page="template/footer.jsp" />
	</div>
</body>
</html>