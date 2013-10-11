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
                    <a href="mensajes.html">
                        <span class="badge pull-right">5</span>
                        Mensajes
                    </a>
                </li>
                <li>
                    <a href="articulos.html">
                        <span class="badge pull-right">3</span>
                        Articulos
                    </a>
                </li>
            </ul>            
        </div>
    </div>
</div>