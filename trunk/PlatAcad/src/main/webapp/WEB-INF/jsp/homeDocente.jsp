<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
                        <c:forEach items="${cursos_docente}" var="curso">
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
											<t:message code="page.home.docente.curso.alumnos" />
										</span><c:out value="${curso.numero_alumnos}"/>
									</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.docente.curso.articulos" />
                                    	</span><c:out value="${curso.numero_articulos}"/>
                                  	</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.docente.curso.examenes" />
                                   		</span><c:out value="${curso.numero_examenes}"/>
                                   	</p>
                                    <p>
                                    	<span class="input-title">
                                    		<t:message code="page.home.docente.curso.trabajos" />
                                    	</span>											
										<c:out value="${curso.numero_trabajos}"/>
									</p>                                    
                                </div>
                                <div class="panel-footer">
                                	<div class="footer-curso-info">
                                		<small><i class="icon-star"></i><c:out value="${curso.creditos}"/></small>
                                		<small><i class="icon-book"></i><c:out value="${curso.tipo}"/></small>
                                	</div>
                                    <div class="footer-date-info">
                                        <small>
                                        	<t:message code="page.home.curso.fecha" />
											<c:out value="${curso.fecha_actualizacion}"/>
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
