<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal dialogo-confirmacion">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title"><t:message code="dialogo.confirmacion.titulo"/></h3>
      </div>
      <div class="modal-body">
        <p><t:message code="dialogo.confirmacion.mensaje"/></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal"><t:message code="btn.dialogo.cancelar"/></button>
        <button type="button" class="btn btn-sm btn-primary btn-confirmacion"><t:message code="btn.dialogo.grabar"/></button>
      </div>
    </div>
  </div>
</div>