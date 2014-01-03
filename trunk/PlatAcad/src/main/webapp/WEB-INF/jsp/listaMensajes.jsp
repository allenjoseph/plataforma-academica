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
			<div class="col-md-8 main-content" id="main-lista-trabajos">
				<c:if test="${not empty error}">
				    <div class="alert alert-danger">
				        <a class="close" data-dismiss="alert" href="#">×</a>
				        <p>${error}</p>
				    </div>
				</c:if>
				<c:if test="${not empty mensaje}">
				    <div class="alert alert-success">
				        <a class="close" data-dismiss="alert" href="#">×</a>
				        <p>${mensaje}</p>
				    </div>
				</c:if>
				<div>
					<div class="list-group">			
						<c:forEach items="${mensajes}" var="mensaje">						
							<a href="#" class="list-group-item">
								<h3>${mensaje.asunto}</h3>								
								<p class="label-light">
									${mensaje.idUsuarioFk.fullName}
									<span class="label label-success pull-right">NUEVO</span>
								</p>
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
			<jsp:include page="template/sidemain.jsp" />
		</div>
		<jsp:include page="template/footer.jsp" />
	</div>
</body>
</html>