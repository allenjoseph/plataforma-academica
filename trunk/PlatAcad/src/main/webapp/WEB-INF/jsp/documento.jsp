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
                <div class="col-md-8 main-content">
                    <div>   
                    	<div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1 class="page-header-main">
                                        <t:message code="page.documento.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form id="form-registro-documento" method="post" action="subir-documento.html" commandName="documento" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
											<label class="col-lg-2 control-label"> 
												<t:message code="page.documento.label.titulo" />
											</label>
											<div class="col-lg-10">
												<t:message code="page.documento.placeholder.titulo"
													var="placeholder_titulo" />
												<f:input path="titulo" cssClass="form-control"
													id="inputTitulo" placeholder="${placeholder_titulo}" />
											</div>
										</div>
                                    </div>
                                </f:form>
                                <div class="form-horizontal">
									<div class="form-group">
										<label class="col-lg-2 control-label"> <t:message
												code="page.documento.label.upload" />
										</label>
										<div class="col-lg-10">
											<form action="file-documento.html" class="dropzone"
												id="inputAdjunto" enctype="multipart/form-data"></form>
										</div>
									</div>
								</div>
								<div class="form-horizontal">
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<button type="button" class="btn btn-default">
												<t:message code="btn.default.limpiar" />
											</button>
											<button type="button" class="btn btn-primary pull-right"
												id="btn-submit-documento">
												<t:message code="btn.default.registar" />
											</button>
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
        <script type="text/javascript">
			$(function(){
				$("#btn-submit-documento").on('click', function(){
					$("#form-registro-documento").submit();
				});
				
				$("#form-registro-documento").on('submit', function(e){		
					alert("grabar-documento");
				});
			});
        </script>
    </body>
</html>