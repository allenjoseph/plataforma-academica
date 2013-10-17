<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div id="panel-user" class="panel panel-default">
    <div class="panel-body">
        <h5><i class="icon-user"></i><c:out value="${user.nombreCompleto}"/></h5>
    </div>
</div>