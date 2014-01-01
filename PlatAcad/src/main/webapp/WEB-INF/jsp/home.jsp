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
			<div class="col-md-8 main-content" id="main-alumno">
				<div>					
					<c:forEach items="${cursos}" var="curso">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="page-header">
									<h1>
										<c:url value="listar-aportes.html" var="urlAportes">
											<c:param name="cursoId" value="${curso.idCursoAperturado}"/>
										</c:url>
										<a href="${urlAportes}">
											<c:out value="${curso.idCursoFk.nombre}" />
										</a> 
										<i class="icon-folder-close"></i>
									</h1>
								</div>
								<p>
									<span class="input-title"> <t:message
											code="page.home.curso.docente" />
									</span>
									<c:out value="${curso.docenteValue}" />
								</p>
								<p>
									<span class="input-title"> <t:message
											code="page.home.curso.articulos" />
									</span>
									<c:out value="${curso.totalArticulos}"/>
								</p>
							</div>
							<div class="panel-footer">
								<div class="panel-footer-info">
									<small>
										<i class="icon-star"></i><c:out value="${curso.idCursoFk.creditos}" />
									</small>
									<small>
										<i class="icon-book"></i><c:out value="${curso.idCursoFk.tipoValue}" />
									</small>
								</div>
								<div class="footer-date-info">
									<small> <t:message code="page.home.curso.fecha" />
									</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<jsp:include page="template/sidemain.jsp" />
		</div>
		<jsp:include page="template/footer.jsp" />
	</div>
</body>
</html>