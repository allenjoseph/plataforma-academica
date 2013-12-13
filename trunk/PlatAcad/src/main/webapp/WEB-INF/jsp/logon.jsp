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
                
                	<c:url value="/login" var="loginUrl"/>
				    <form name="f" action="${loginUrl}" method="post">
				        <fieldset>
				            <legend>Please Login</legend>
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
				            <label for="j_username">Username</label>
				            <input type="text" id="j_username" name="username" value="${username}"/>
				            <label for="j_password">Password</label>
				            <input type="password" id="j_password" name="password"/>
				            <div class="form-actions">
				                <button type="submit" class="btn">Log in</button>
				            </div>
				        </fieldset>
				    </form>
                
                
                </div>
			</div>
    	</div>
    </body>
</html>