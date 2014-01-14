<%@ taglib prefix="t" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="template/head.jsp" />
<body>
	<div class="container">
		<jsp:include page="template/navbar.jsp" />
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="template/user.jsp" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 main-content" id="main-lista-trabajos">				
				<div>
				</div>
			</div>
			<jsp:include page="template/sidemain.jsp" />
		</div>
		<jsp:include page="template/footer.jsp" />
	</div>
</body>
</html>