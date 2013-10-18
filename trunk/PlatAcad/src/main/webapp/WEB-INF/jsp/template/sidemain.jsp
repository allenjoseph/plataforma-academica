<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<div class="col-md-4" id="side-main">
    <ul class="nav nav-tabs nav-justified">
        <li class="active">
            <a href="#"><t:message code="tab.actividades"/></a>
        </li>
        <li>
            <a href="#"><t:message code="tab.documentos"/></a>
        </li>
        <li>
            <a href="#"><t:message code="tab.chat"/></a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active">
            <ul class="nav nav-pills nav-stacked">
                <li>
                    <a href="mensaje.html">
                        <span class="badge pull-right">0</span>
                        <t:message code="tab.actividad.mensaje"/>
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
    </div>
</div>