<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <c:forEach items="${cursos_matriculados}" var="curso">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="page-header">
                                        <h1>
                                            <a href="#!"><c:out value="${curso.nombre}"/></a>
                                            <i class="icon-folder-close"></i>
                                        </h1>                                  
                                    </div>
                                    <p>
                                    	<span class="input-title">
											<t:message code="page.home.curso.docente" />
										</span>
										<c:out value="${curso.docente}"/>
									</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.curso.articulos" />
                                    	</span>
                                  	</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.curso.examenes" />
                                   		</span>
                                   	</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.curso.trabajos" />
                                    	</span>											
										
									</p>                                    
                                </div>
                                <div class="panel-footer">
                                	<div class="footer-curso-info">
                                		<small><i class="icon-star"></i><c:out value="${curso.creditos}"/></small>
                                		<small><i class="icon-book"></i><c:out value="${curso.tipo.descripcion}"/></small>
                                	</div>
                                    <div class="footer-date-info">
                                        <small>
                                        	<t:message code="page.home.curso.fecha" />
										</small>
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
