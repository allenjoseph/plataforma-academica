<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
	<jsp:include page="template/head.jsp"/>
    <body>
        <div class="container" id="container-examen">            
            <jsp:include page="template/navbar.jsp"/>            
            <div class="row">
                <div class="col-md-8" id="main">
                    <div>                        
                        <jsp:include page="template/user.jsp"/>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1>
                                        <t:message code="page.examen.registar.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form id="form-registro" method="post" action="registrar-examen.html" commandName="examen" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="inputFecha" class="col-lg-2 control-label">Fecha</label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="fechaExamen" class="hidden-date"/>
                                            	<input class="form-control datepicker" id="inputFecha" placeholder="Fecha de examen"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputTipo" class="col-lg-2 control-label">Tipo</label>
                                            <div class="col-lg-10">
                                            	<f:select path="tipoExamen" cssClass="form-control ">
                                            		<f:options items="${tipos_examen}" itemValue="id" itemLabel="descripcion"/>
                                            	</f:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputDescripcion" class="col-lg-2 control-label">Descripcion</label>
                                            <div class="col-lg-10">
                                            	<f:textarea path="descripcion" cssClass="form-control" id="inputDescripcion" placeholder="Descripcion de los temas a tomar." rows="3"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">                                            
                                                <button type="submit" class="btn btn-primary">
                                                	<t:message code="btn.registar" />
                                               	</button>
                                                <button type="button" class="btn btn-default pull-right">
                                                	<t:message code="btn.limpiar" />
                                               	</button>
                                            </div>
                                        </div>
                                    </div>
                                </f:form>
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="template/sidemain.jsp"/>     
            </div>
            <jsp:include page="template/footer.jsp"/>
        </div>
        <jsp:include page="template/dialogoConfirmacion.jsp"/>
    </body>
</html>