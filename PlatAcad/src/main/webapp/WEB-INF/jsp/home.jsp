<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="template/head.jsp"/>
    <body>
        <div class="container">
            <jsp:include page="template/header.jsp"/>            
            <div class="row">
                <div class="col-md-8" id="main">
                    <div class="well well-sm">
                        <c:out value="${user.nombreCompleto}"/>                        
                    </div>
                </div>
                <jsp:include page="template/sidemain.jsp"/>     
            </div>
            <jsp:include page="template/footer.jsp"/>
        </div>
    </body>
</html>
