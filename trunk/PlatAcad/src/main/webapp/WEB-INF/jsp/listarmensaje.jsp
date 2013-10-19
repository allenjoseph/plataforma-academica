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
                                <div class="form-horizontal" role="form">
                                    <table border=0 align="center" width="80%">
                                        <tr>
                                            <th>Enviado a </th>
                                            <th>Asunto</th>
                                            <th>Mensaje</th>
                                            <th>Opciones</th>
                                        </tr>
                                        <c:forEach items="${listado}" var="t" >
                                            <tr>
                                            	<td><c:out value="${t.nombres}"/></td>
                                                <td> <c:out value="${t.asunto}"/></td>
                                                <td><c:out value="${t.mensaje}"/></td>                                                
                                                <td><a href="eliminar-mensaje.html?codigo=<c:out value="${t.id_mensaje_pk}"/>">Eliminar</a>
                                            </tr>
                                        </c:forEach>
                                </table>
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
