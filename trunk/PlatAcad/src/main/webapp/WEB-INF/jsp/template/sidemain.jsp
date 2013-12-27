<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<div class="col-md-4" id="side-main">
    <ul class="nav nav-tabs nav-justified" id="nav-tab-main">
        <li class="active">
            <a href="#tab-one"><t:message code="tab.actividades"/></a>
        </li>
        <li>
            <a href="#tab-two"><t:message code="tab.documentos"/></a>
        </li>
        <li>
            <a href="#tab-three"><t:message code="tab.chat"/></a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="tab-one">
        	<ul class="nav nav-pills nav-stacked">
                <li>
                    <div class="label-light-center">Sin Novedades</div>
                </li>
            </ul>
        	<hr/>
            <ul class="nav nav-pills nav-stacked">
            	<li>
                    <a href="listar-mensajes.html">
                        <t:message code="tab.actividad.listar.mensaje"/>
                    </a>
                </li>
                <li>
                    <a href="listar-mensajes.html">
                        <t:message code="tab.actividad.listar.evento"/>
                    </a>
                </li>
            	<c:if test="${user.isDocente or user.isAlumno}">            		
	                <li>
	                    <a href="listar-examenes.html">
	                        <t:message code="tab.actividad.listar.examen"/>
	                    </a>
	                </li>
	                <li>
	                    <a href="listar-aportes.html">
	                        <t:message code="tab.actividad.listar.aporte"/>
	                    </a>
	                </li>
	                <li>
	                    <a href="listar-trabajos.html">
	                        <t:message code="tab.actividad.listar.trabajo"/>
	                    </a>
	                </li>            	
            	</c:if>                
            </ul>           
        </div>
        <div class="tab-pane" id="tab-two">
        	<input type="text" class="form-control" placeholder="Ingresa tu busqueda">
        	<div class="sensitive-search-result"></div>
        </div>
        <div class="tab-pane" id="tab-three"> tres </div>
    </div>
</div>