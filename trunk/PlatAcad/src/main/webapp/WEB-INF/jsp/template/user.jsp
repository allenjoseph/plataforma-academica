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
			  		<img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQMY6VYDh6rRwU5pf0mhYsP4nKHzsAePs8-Rge6gQR0gix6iH3qig" 
			  		alt="" class="media-object img-thumbnail img-circle">
				</a>
				<div class="media-body">
					<ul class="list-group" id="list-user-details">						
					  	<li class="list-group-item">
					    	<span class="badge pull-left">14</span>
					    	<a href="#"><t:message code="panel.timeline.user.mensajes"/></a>
					  	</li>
					  	<c:if test="${user.isAlumno}">
					  		<li class="list-group-item">
						    	<span class="badge pull-left">4</span>
								<a href="#"><t:message code="panel.timeline.user.examenes"/></a>
						  	</li>
						  	<li class="list-group-item">
						    	<span class="badge pull-left">8</span>
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