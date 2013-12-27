<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
	<jsp:include page="template/head.jsp"/>
    <body>
        <div class="container">            
            <jsp:include page="template/navbar.jsp"/>   
            <div class="row">
				<div class="col-md-12">
					<jsp:include page="template/user.jsp" />
				</div>
			</div>          
            <div class="row">
                <div class="col-md-8" id="main">
                    <div>   
                    	<div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1>
                                        <t:message code="page.trabajo.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form id="form-registro" method="post" action="registrar-trabajo.html" commandName="trabajo" >
                                    <div class="form-horizontal" role="form">
                                    	<div class="form-group">
                                            <label for="inputFecha" class="col-lg-2 control-label">
                                            	<t:message code="page.trabajo.label.curso"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<f:select path="idCursoAperturadoFk.idCursoAperturado" cssClass="form-control">
                                            		<f:options items="${cursos}" itemValue="idCursoAperturado" itemLabel="idCursoFk.nombre"/>
                                            	</f:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputFecha" class="col-lg-2 control-label">
                                            	<t:message code="page.trabajo.label.fecha"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="fechaPresentacion" class="hidden-date"/>
                                            	<t:message code="page.trabajo.placeholder.fecha" var="placeholder_fecha"/>
                                            	<input class="form-control datepicker" id="inputFecha" 
                                            	placeholder="${placeholder_fecha}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputDescripcion" class="col-lg-2 control-label">
                                            	<t:message code="page.trabajo.label.descripcion"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<t:message code="page.trabajo.placeholder.descripcion" var="placeholder_descripcion"/>
                                            	<f:textarea path="descripcion" cssClass="form-control" id="inputDescripcion" 
                                            	placeholder="${placeholder_descripcion}" rows="3"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10"> 
                                                <button type="button" class="btn btn-default">
                                                	<t:message code="btn.default.limpiar" />
                                               	</button>
                                               	<button type="submit" class="btn btn-primary pull-right">
                                                	<t:message code="btn.default.registar" />
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
    </body>
</html>