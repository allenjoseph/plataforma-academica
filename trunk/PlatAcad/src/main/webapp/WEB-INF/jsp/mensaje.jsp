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
                                        <t:message code="page.mensaje.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form  id="form-mensaje" method="post" action="enviarMensaje.html" commandName="mensaje" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="inputUsuario" class="col-lg-2 control-label">De:</label>
                                            <div class="col-lg-10">
                                                <f:input path="idUsuarioFk.idUsuarioPk"  cssClass="form-control" id="inputDestinatario" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputDestinatario" class="col-lg-2 control-label">Para</label>
                                            <div class="col-lg-10">
                                            	<f:input path="idUsuarioDestinoFk.idUsuarioPk" cssClass="form-control" id="inputDestinatario" placeholder="Usuarios o Cursos separados por comas"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAsunto" class="col-lg-2 control-label">Asunto</label>
                                            <div class="col-lg-10">
                                            	<f:input path="asunto" cssClass="form-control" id="inputAsunto" placeholder="Asunto"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputMensaje" class="col-lg-2 control-label">Mensaje</label>
                                            <div class="col-lg-10">
                                            	<f:textarea cssClass="form-control" path="mensaje" id="inputMensaje" placeholder="Mensaje" rows="3"/>
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
