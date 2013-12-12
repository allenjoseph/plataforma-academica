<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
                    <a href="mensaje.html">
                        <span class="badge pull-right">0</span>
                        <t:message code="tab.actividad.mensaje"/>
                    </a>
                </li>
                <li>
                    <a href="listarMensaje.html">
                        <span class="badge pull-right">0</span>
                        Listar Mensajes
                    </a>
                </li>
                <li>
                    <a href="examen.html">
                        <span class="badge pull-right">0</span>
                        <t:message code="tab.actividad.docente.examen"/>
                    </a>
                </li>
                <li>
                    <a href="trabajo.html">
                        <span class="badge pull-right">0</span>
                        <t:message code="tab.actividad.docente.trabajo"/>
                    </a>
                </li>
            </ul>            
        </div>
        <div class="tab-pane" id="tab-two">
        	<input type="text" class="form-control" placeholder="Ingresa tu busqueda">
        	<div class="sensitive-search-result"> CAMPO DONDE SE MOSTRARAN LOS RESULTADOS POR LA BUSQUEDA SENSITIVA</div>
        </div>
        <div class="tab-pane" id="tab-three"> tres </div>
    </div>
</div>