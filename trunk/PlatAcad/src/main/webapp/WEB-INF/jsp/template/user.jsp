<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div id="panel-user" class="panel panel-default">
    <div class="panel-body">
        <h5><i class="icon-user"></i><c:out value="${user.nombres}"/> <c:out value="${user.apellidoPaterno}"/> <c:out value="${user.apellidoMaterno}"/></h5>
    </div>
</div>