<%@ taglib prefix="t" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                <div class="col-md-8 main-content" id="main-administrativo">
                    <div> 
                    	<div class="panel panel-default">
							<div class="panel-body">
							    <div class="page-header">
							        <h1>
							            <a href="#!">
							            	<t:message code="page.home.administrativo.titulo" />
										</a>
							        	<i class="icon-folder-close"></i>
							    	</h1>                                  
								</div>
								<p>
									<span class="input-title">
										<t:message code="page.home.administrativo.eventos" />
									</span>											
									<c:out value="5"/>
								</p>  
								<p>
									<span class="input-title">
										<t:message code="page.home.administrativo.documentos" />
									</span>											
									<c:out value="34"/>
								</p>               
							</div>
							<div class="panel-footer">
								<div class="panel-footer-info">
								</div>
						   		<div class="footer-date-info">
						       		<small><t:message code="label.default.fecha" /><c:out value=""/></small>
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
