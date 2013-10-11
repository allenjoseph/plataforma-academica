<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <jsp:include page="template/head.jsp"/>
    <body>
        <div class="container">            
            <jsp:include page="template/navbar.jsp"/>            
            <div class="row">
                <div class="col-md-8" id="main">
                    <div>                        
                        <jsp:include page="template/user.jsp"/>
                        <c:forEach items="${cursos}" var="curso">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="page-header">
                                        <h1>
                                            <a href="#!"><c:out value="${curso.nombre}"/></a>
                                            <i class="icon-folder-close"></i>
                                        </h1>                                        
                                                                              
                                    </div>
                                    <p><span class="input-title">Profesor: </span>No Asignado</p>
                                    <p><span class="input-title">Cantidad de creditos: </span><c:out value="${curso.creditos}"/></p>
                                    <p><span class="input-title">Tipo de curso: </span><c:out value="${curso.tipo}" /></p>
                                    
                                </div>
                                <div class="panel-footer">
                                    <div class="footer-date-info">
                                        <small>Actualizado hace 2 Semanas</small>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <jsp:include page="template/sidemain.jsp"/>     
            </div>
            <jsp:include page="template/footer.jsp"/>
        </div>
    </body>
</html>
