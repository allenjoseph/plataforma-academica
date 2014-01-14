<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
$(function(){
	$("#input-filtrar-documento").on("keypress",function(){		
		var input_text = $(this).val().trim();
			if(input_text != ''){
				$.getJSON("get-documentos.json",{texto : input_text})
				.done(function( data ) {
					$("#sensitive-search-result").html("");
					var items = [];
					$.each( data, function( key, val ) {
						items.push( "<a href=\"#!\" class=\"list-group-item\">" + val.titulo + "</a>" );
					});
					 
					$("<div/>", {
						"class": "list-group",
						html: items.join( "" )
					}).appendTo("#sensitive-search-result");
			});	
		} else{
			$("#sensitive-search-result").html("");
		}
	});
});
</script>
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
        	<div class="list-group" id="list-novedades">
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">NUEVO MENSAJE</h4>
					<p class="list-group-item-text">Daniel Chunga, Cuando vienes a clases???</p>
					<p><small class="label-light pull-left">Albert Einsten</small> <small class="label-light pull-right">Hace 20 minutos</small></p>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">GEOMETRIA ANALITICA</h4>
					<p class="list-group-item-text">Se registro examen para el dia 16 de enero del 2013.</p>
					<p><small class="label-light pull-left">Albert Einsten</small> <small class="label-light pull-right">Hace 10 horas</small></p>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">MATEMATICA I</h4>
					<p class="list-group-item-text">Daniela Silva Yesang realizo nuevo aporte.</p>
					<p><small class="label-light pull-left">Albert Einsten</small> <small class="label-light pull-right">Ayer</small></p>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">QUIMICA GENERAL</h4>
					<p class="list-group-item-text">Se registro examen para el dia 18 de febrero del 2013.</p>
					<p><small class="label-light pull-left">Albert Einsten</small> <small class="label-light pull-right">Hace 3 dias</small></p>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">FACULTAD DE MECATRONICA</h4>
					<p class="list-group-item-text">Se registro evento para el dia 25 de marzo del 2013.</p>
					<p><small class="label-light pull-left">Facultad de Mecatronica</small> <small class="label-light pull-right">Hace 7 dias</small></p>
				</a>
			</div>
            <ul class="nav nav-pills nav-stacked" id="nav-listar">
            	<li>
                    <a href="mensajes.html">
                        <t:message code="tab.actividad.listar.mensaje"/>
                    </a>
                </li>
                <li>
                    <a href="eventos.html">
                        <t:message code="tab.actividad.listar.evento"/>
                    </a>
                </li>
            	<c:if test="${user.isDocente or user.isAlumno}">            		
	                <li>
	                    <a href="examenes.html">
	                        <t:message code="tab.actividad.listar.examen"/>
	                    </a>
	                </li>
	                <li>
	                    <a href="aportes.html">
	                        <t:message code="tab.actividad.listar.aporte"/>
	                    </a>
	                </li>
	                <li>
	                    <a href="trabajos.html">
	                        <t:message code="tab.actividad.listar.trabajo"/>
	                    </a>
	                </li>            	
            	</c:if>                
            </ul>           
        </div>
        <div class="tab-pane" id="tab-two">
        	<div id="panel-busqueda-documento">
        		<input type="text" class="form-control" placeholder="Ingresa tu busqueda" id="input-filtrar-documento"/>
        	</div>        	
        	<div id="sensitive-search-result"></div>
        	<ul class="nav nav-pills nav-stacked">
                <li>
                    <div class="label-light-center"><a href="documentos.html">Todos los Documentos</a></div>
                </li>
            </ul>
        </div>
        <div class="tab-pane" id="tab-three">
        	<ul class="nav nav-pills nav-stacked">
                <li>
                    <div class="label-light-center">En Implementacion</div>
                </li>
            </ul>
        </div>
    </div>
</div>