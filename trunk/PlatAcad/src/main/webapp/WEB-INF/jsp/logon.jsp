<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="template/head.jsp" />
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="logon-main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<t:message code="page.login.titulo"/>
						</h3>
					</div>
					<div class="panel-body">
						<c:url value="process-login.html" var="loginUrl" />
						<form class="form-horizontal" role="form" name="f"
							action="${loginUrl}" method="post">
							<div class="form-group">
								<label for="txt-username" class="col-sm-2 control-label">
									<t:message code="page.login.label.usuario"/>
								</label>
								<div class="col-sm-10">
									<t:message code="page.login.placeholder.usuario" var="placeholder_usuario"/>
									<input type="text" class="form-control"	name="security_username" 
									id="txt-username" placeholder="${placeholder_usuario}">
								</div>
							</div>
							<div class="form-group">
								<label for="txt-password" class="col-sm-2 control-label">
									<t:message code="page.login.label.password"/>
								</label>
								<div class="col-sm-10">
									<t:message code="page.login.placeholder.password" var="placeholder_password"/>
									<input type="password" class="form-control" name="security_password" 
									id="txt-password" placeholder="${placeholder_password}">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success pull-right">
										<t:message code="page.login.btn.login"/>
									</button>
								</div>
							</div>
							<div class="form-group">
								<c:if test="${not empty error}">
						            <div class="alert alert-danger">
						                <a class="close" data-dismiss="alert" href="#">×</a>
						                <p><c:out value="${error}" /></p>
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