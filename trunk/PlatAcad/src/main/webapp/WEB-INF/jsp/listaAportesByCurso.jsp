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
			<div class="col-md-8 main-content" id="main-lista-aportes">
				<div>					
					<c:forEach items="${aportes}" var="aporte">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="page-header">
									<h1>
										<a href="#!" class="enlace-ver-aporte" data-id="<c:out value="${aporte.idArticuloPk}"/>">
											<c:out value="${aporte.titulo}" />
										</a> <i class="icon-folder-close"></i>
									</h1>
								</div>
								<p>
									<span class="input-title"> <t:message
											code="page.list.aportar.autor" />
									</span>
									<c:out value="${aporte.idUsuarioFk.fullName}" />
								</p>
							</div>
							<div class="panel-footer">
								<div class="panel-footer-info">
									<small>
										<i class="icon-calendar"></i>
										<t:message code="page.list.aportar.fecha.creacion" />									
										<c:out value="${aporte.auditoria.creacionFecha}" />
									</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<f:form id="form-ver-aporte" method="post" action="ver-aporte.html" commandName="aporteSelected">
					<f:hidden path="idArticuloPk" id="form-ver-aporte-id"/>
				</f:form>
			</div>
			<jsp:include page="template/sidemain.jsp" />
		</div>
		<jsp:include page="template/footer.jsp" />
	</div>
	<script type="text/javascript">
		$(function(){
			$("a.enlace-ver-aporte").on("click",function(){
				var id = $(this).data("id");
				$("#form-ver-aporte-id").val(id);
				$("#form-ver-aporte").submit();
			});
		});
	</script>
</body>
</html>