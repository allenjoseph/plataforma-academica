<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <jsp:include page="template/head.jsp"/>
    <body>
    	<div class="container">
    		<div class="row">
                <div class="col-md-8" id="main">
                	<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">Plataforma Academica</h3>
					  </div>
					  <div class="panel-body">
					  	<c:url value="/login.html" var="loginUrl"/>
					    <form class="form-horizontal" role="form" name="f" action="${loginUrl}" method="post">
						  <div class="form-group">
						    <label for="j_username" class="col-sm-2 control-label">Email</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="j_username" placeholder="Codigo de Usuario">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="j_password" class="col-sm-2 control-label">Contraseña</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" id="j_password" placeholder="Password">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default">Entrar</button>
						    </div>
						  </div>
						  <div class="form-group">
						  	<c:if test="${param.error != null}">
				                <div class="alert alert-error">
				                    Failed to login.
				                    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
				                      Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				                    </c:if>
				                </div>
				            </c:if>
				            <c:if test="${param.logout != null}">
				                <div class="alert alert-success">
				                    You have been logged out.
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