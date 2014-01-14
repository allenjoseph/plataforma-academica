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
					<div>
						<f:form id="form-lista-examenes" method="post"
								action="filtrar-examenes.html" commandName="curso">
							<div class="form-horizontal" role="form">
								<div class="form-group">
	                                <div class="col-lg-12">
	                                	<t:message code="label.default.cursos" var="todos_cursos"/>
	                                	<f:select path="idCursoAperturado" cssClass="form-control">
	                                		<f:option value="0" label="${todos_cursos}"/>
											<f:options items="${cursos}" itemValue="idCursoAperturado"
												itemLabel="idCursoFk.nombre" />
										</f:select>
	                                </div>
	                            </div>
								<div class="form-group">
		                            <div class="col-lg-12"> 
		                            	<a href="trabajos.html" class="btn btn-default">
					                        <t:message code="btn.default.todos" />
					                    </a>
		                               	<button type="submit" class="btn btn-primary pull-right">
		                                	<t:message code="btn.default.buscar" />
		                               	</button>
		                            </div>
		                        </div>							
							</div>		
						</f:form>
					</div>
					<div class="list-group">			
						<c:forEach items="${examenes}" var="examen">						
							<a href="#" class="list-group-item">
								<h3>${examen.tipoExamenValue} - ${examen.fechaExamen}</h3>								
								<p class="label-light">
									${examen.idCursoAperturadoFk.idCursoFk.nombre}
									<span class="label label-success pull-right">PENDIENTE</span>
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