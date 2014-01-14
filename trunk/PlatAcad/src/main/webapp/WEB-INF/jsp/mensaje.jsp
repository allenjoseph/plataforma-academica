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
                <div class="col-md-8 main-content" id="main-mensaje">
                    <div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1 class="page-header-main">
                                        <t:message code="page.mensaje.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form  id="form-mensaje" method="post" action="enviar-mensaje.html" commandName="mensaje" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="inputUsuario" class="col-lg-2 control-label">
                                            	<t:message code="page.mensaje.label.de"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="idUsuarioFk.idUsuarioPk"/>
                                                <f:input path="idUsuarioFk.fullName" cssClass="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputDestinatario" class="col-lg-2 control-label">
                                            	<t:message code="page.mensaje.label.para"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<t:message code="page.mensaje.placeholder.para" var="placeholder_para"/>
                                            	<f:input path="idUsuarioDestinoFk.idUsuarioPk" cssClass="form-control" 
                                            	id="inputDestinatario" placeholder="${placeholder_para}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAsunto" class="col-lg-2 control-label">
                                            	<t:message code="page.mensaje.label.asunto"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<t:message code="page.mensaje.placeholder.asunto" var="placeholder_asunto"/>
                                            	<f:input path="asunto" cssClass="form-control" 
                                            	id="inputAsunto" placeholder="${placeholder_asunto}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputMensaje" class="col-lg-2 control-label">
                                            	<t:message code="page.mensaje.label.mensaje"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<t:message code="page.mensaje.placeholder.mensaje" var="placeholder_mensaje"/>
                                            	<f:textarea cssClass="form-control" path="mensaje" 
                                            	id="inputMensaje" placeholder="${placeholder_mensaje}" rows="3"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">   
                                                <button type="button" class="btn btn-default">
                                                	<t:message code="btn.default.limpiar"/>
                                                </button>
                                                <button type="submit" class="btn btn-primary pull-right">
                                                	<t:message code="page.mensaje.btn.enviar"/>
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
        <script type="text/javascript">     
        </script>
    </body>
</html>

