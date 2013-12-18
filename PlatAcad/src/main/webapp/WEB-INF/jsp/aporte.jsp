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
                <div class="col-md-8" id="main">
                    <div>
                        <jsp:include page="template/user.jsp"/>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1>
                                        <t:message code="page.aporte.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form  id="form-aporte" method="post" action="grabar-aporte.html" commandName="aporte" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="selectCurso" class="col-lg-2 control-label">Curso</label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="idUsuarioFk"/>
                                            	<f:select path="idCursoAperturadoFk.idCursoAperturado" cssClass="form-control">
                                            		<f:options items="${cursos}" itemValue="idCursoAperturado" itemLabel="idCursoFk.nombre"/>
                                            	</f:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputTitulo" class="col-lg-2 control-label">Titulo</label>
                                            <div class="col-lg-10">
                                            	<f:input path="titulo" cssClass="form-control" id="inputTitulo" placeholder="Ingrese el titulo del aporte"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAsunto" class="col-lg-2 control-label">Aporte</label>
                                            <div class="col-lg-10">
                                            	<f:textarea cssClass="form-control" path="contenido" id="inputAsunto" placeholder="Mensaje" rows="3"/>                                            	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAdjunto" class="col-lg-2 control-label">Adjuntar Archivo</label>
                                            <div class="col-lg-10">
                                            	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">                                            
                                                <button type="submit" class="btn btn-primary">Enviar</button>
                                                <button type="button" class="btn btn-default pull-right">Limpiar</button>
                                            </div>
                                        </div>
                                    </div>
                                </f:form>
                                <form action="file-aporte.html" class="dropzone" id="inputAdjunto" enctype="multipart/form-data"></form>
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
