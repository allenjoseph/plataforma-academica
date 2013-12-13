<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="template/head.jsp" />
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6" id="logon-main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Plataforma Academica</h3>
					</div>
					<div class="panel-body">
						<c:url value="process-login.html" var="loginUrl" />
						<form class="form-horizontal" role="form" name="f"
							action="${loginUrl}" method="post">
							<div class="form-group">
								<label for="txt-username" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"
										name="security_username" id="txt-username" placeholder="Codigo de Usuario">
								</div>
							</div>
							<div class="form-group">
								<label for="txt-password" class="col-sm-2 control-label">Contraseña</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										name="security_password" id="txt-password" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success pull-right">Entrar</button>
								</div>
							</div>
							<div class="form-group">
								<c:if test="${error == true}">
						            <div class="alert alert-danger">
						                <a class="close" data-dismiss="alert" href="#">×</a>
						                <p><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></p>
						            </div>
						        </c:if>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>