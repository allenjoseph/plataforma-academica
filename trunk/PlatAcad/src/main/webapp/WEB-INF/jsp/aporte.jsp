<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <jsp:include page="template/head.jsp"/>
    <body>
        <div class="container" id="container-aporte">
            <jsp:include page="template/navbar.jsp"/>            
            <div class="row">
                <div class="col-md-8" id="main">
                    <div>
                        <jsp:include page="template/user.jsp"/>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1>
                                        <t:message code="page.aportar.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form  id="form-aporte" method="post" action="grabar-aporte.html" commandName="aporte" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.curso"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="idUsuarioFk"/>
                                            	<f:select path="idCursoAperturadoFk.idCursoAperturado" cssClass="form-control">
                                            		<f:options items="${cursos}" itemValue="idCursoAperturado" itemLabel="idCursoFk.nombre"/>
                                            	</f:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.titulo"/>
                                            </label>
                                            <div class="col-lg-10">    
                                            	<t:message code="page.aportar.placeholder.titulo" var="placeholder_titulo"/>                                        	
                                            	<f:input path="titulo" cssClass="form-control" id="inputTitulo" 
                                            	placeholder="${placeholder_titulo}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.contenido"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<t:message code="page.aportar.placeholder.contenido" var="placeholder_contenido"/>
                                            	<f:textarea cssClass="form-control" path="contenido" id="inputContenido" 
                                            	placeholder="${placeholder_contenido}" rows="3"/>                                            	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10" >
                                            	<div class="alert alert-warning"></div>                                            	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">   
                                            	<button type="button" class="btn btn-default">
                                            		<t:message code="btn.default.limpiar"/>
                                            	</button>                                         
                                                <button type="submit" class="btn btn-primary pull-right">
                                                	<t:message code="page.aportar.btn.aportar"/>
                                                </button>                                                
                                            </div>
                                        </div>
                                    </div>
                                </f:form>
                                <div class="form-horizontal" role="form">
									<div class="form-group">
									    <label class="col-lg-2 control-label">
								    		<t:message code="page.aportar.label.upload"/>
								    	</label>
									    <div class="col-lg-10">
									  		<form action="file-aporte.html" class="dropzone" id="inputAdjunto" enctype="multipart/form-data"></form>  	
									    </div>
									</div>
                                </div>                                
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
