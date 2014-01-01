<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
$(function(){
	var timeline = new Timeline("timeline", new Date());
});
</script>
<div id="panel-timeline" class="panel panel-default">
    <div class="panel-body">
    	<div class="col-md-3">
    		<div class="media">
				<a class="pull-left" href="#">
					<c:if test="${user.isAlumno}">
						<img src="<c:url value='resources/platacad/images/alumno.jpg'/>" alt="" class="media-object img-thumbnail img-circle">
					</c:if>
					<c:if test="${user.isDocente}">
						<img src="<c:url value='resources/platacad/images/docente.jpg'/>" alt="" class="media-object img-thumbnail img-circle">
					</c:if>
					<c:if test="${user.isAdministrativo}">
						<img src="<c:url value='resources/platacad/images/administrativo.jpg'/>" alt="" class="media-object img-thumbnail img-circle">
					</c:if>			  		
				</a>
				<div class="media-body">
					<ul class="list-group" id="list-user-details">						
					  	<li class="list-group-item">
					    	<span class="badge pull-left"><c:out value="${user.totalMensajes}"/></span>
					    	<a href="#"><t:message code="panel.timeline.user.mensajes"/></a>
					  	</li>
					  	<c:if test="${user.isAlumno}">
					  		<li class="list-group-item">
						    	<span class="badge pull-left"><c:out value="${user.totalExamenes}"/></span>
								<a href="#"><t:message code="panel.timeline.user.examenes"/></a>
						  	</li>
						  	<li class="list-group-item">
						    	<span class="badge pull-left"><c:out value="${user.totalTrabajos}"/></span>
						    	<a href="#"><t:message code="panel.timeline.user.trabajos"/></a>
						  	</li>
					  	</c:if>					  	
					</ul>
				</div>
			</div>    		
    	</div>
    	<div class="col-md-9">
    		<div id="timeline"></div>
    	</div>
    </div>
</div>