<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <jsp:include page="template/head.jsp"/>
    <body>
        <div class="container" id="container-aporte">
            <jsp:include page="template/navbar.jsp"/>            
            <div class="row">
				<div class="col-md-12">
					<jsp:include page="template/user.jsp" />
				</div>
			</div>
			<div class="row">
                <div class="col-md-8" id="main">
                    <div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header">
                                    <h1>
                                        <t:message code="page.aportar.titulo"/>
                                        <i class="icon-envelope"></i>
                                    </h1>       
                                </div>                                
                                <f:form  id="form-aporte" method="post" action="grabar-aporte.html" commandName="aporte" >
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.curso"/>
                                            </label>
                                            <div class="col-lg-10">
                                            	<f:hidden path="idUsuarioFk"/>
                                            	<f:select path="idCursoAperturadoFk.idCursoAperturado" cssClass="form-control">
                                            		<f:options items="${cursos}" itemValue="idCursoAperturado" itemLabel="idCursoFk.nombre"/>
                                            	</f:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.titulo"/>
                                            </label>
                                            <div class="col-lg-10">    
                                            	<t:message code="page.aportar.placeholder.titulo" var="placeholder_titulo"/>                                        	
                                            	<f:input path="titulo" cssClass="form-control" id="inputTitulo" 
                                            	placeholder="${placeholder_titulo}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">
                                            	<t:message code="page.aportar.label.contenido"/>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-12">
                                            	<div id="alerts"></div>
												<div class="btn-group" data-role="editor-toolbar" data-target="#editor">
													<div class="btn-group">
													  	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" title="Font">
													  		<i class="icon-font"></i><b class="caret"></b>
												  		</button>
													    <ul class="dropdown-menu"></ul>
												  	</div>
													<div class="btn-group">
													  	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" title="Font Size">
													  		<i class="icon-text-height"></i>&nbsp;<b class="caret"></b>
												  		</button>
													    <ul class="dropdown-menu">
														    <li>
														    	<a data-edit="fontSize 5"><font size="5">Grande</font></a>
													    	</li>
															<li>
																<a data-edit="fontSize 3"><font size="3">Normal</font></a>
															</li>
															<li>
																<a data-edit="fontSize 1"><font size="1">Pequeña</font></a>
															</li>
												      	</ul>
													</div>
												  	<div class="btn-group">
													    <button type="button" class="btn btn-default" data-edit="bold" title="Negrita (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></button>
													    <button type="button" class="btn btn-default" data-edit="italic" title="Cursiva (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></button>
													    <button type="button" class="btn btn-default" data-edit="strikethrough" title="Tachado"><i class="fa fa-strikethrough"></i></button>
													    <button type="button" class="btn btn-default" data-edit="underline" title="Subrayado (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></button>
												  	</div>
												  	<div class="btn-group">
													    <button type="button" class="btn btn-default" data-edit="insertunorderedlist" title="Viñeta"><i class="fa fa-list-ul"></i></button>
													    <button type="button" class="btn btn-default" data-edit="insertorderedlist" title="Lista"><i class="fa fa-list-ol"></i></button>
													    <button type="button" class="btn btn-default" data-edit="outdent" title="Disminuir Sangria (Shift+Tab)"><i class="fa fa-indent"></i></button>
													    <button type="button" class="btn btn-default" data-edit="indent" title="Aumetar Sangria (Tab)"><i class="fa fa-outdent"></i></button>
												  	</div>
												  	<div class="btn-group">
													    <button type="button" class="btn btn-default" data-edit="justifyleft" title="Alinear a la Izquierda (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></button>
													    <button type="button" class="btn btn-default" data-edit="justifycenter" title="Centrar (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></button>
													    <button type="button" class="btn btn-default" data-edit="justifyright" title="Alinear a la Derecha (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></button>
													    <button type="button" class="btn btn-default" data-edit="justifyfull" title="Justificar (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></button>
												  	</div>
												  	<div class="btn-group">
													    <button type="button" class="btn btn-default" title="Insertar Imagen (o solo arrastrala)" id="pictureBtn"><i class="fa fa-picture-o"></i></button>
													    <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
												  	</div>
												  	<div class="btn-group">
														<button class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></button>													  	
													  	<div class="dropdown-menu">
													  		<div class="input-group">
													  			<input type="text" class="form-control" placeholder="URL" data-edit="createLink"/>
													   			<span class="input-group-btn">
												        			<button class="btn btn-default" type="button">Add</button>
													      		</span>	
													  		</div>										   		
													    </div>												
												  	</div>	
												</div>
                                            	<div id="editor">
											    </div>                                         	
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        	<c:if test="${error == true}">
                                        		<div class="col-lg-offset-2 col-lg-10" >
	                                            	<div class="alert alert-warning"></div>                                            	
	                                            </div>
                                        	</c:if>                                            
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">   
                                            	<button type="button" class="btn btn-default">
                                            		<t:message code="btn.default.limpiar"/>
                                            	</button>                                         
                                                <button type="submit" class="btn btn-primary pull-right">
                                                	<t:message code="page.aportar.btn.aportar"/>
                                                </button>                                                
                                            </div>
                                        </div>
                                    </div>
                                </f:form>
                                <div class="form-horizontal" role="form">
									<div class="form-group">
									    <label class="col-lg-2 control-label">
								    		<t:message code="page.aportar.label.upload"/>
								    	</label>
									    <div class="col-lg-10">
									  		<form action="file-aporte.html" class="dropzone" id="inputAdjunto" enctype="multipart/form-data"></form>  	
									    </div>
									</div>
                                </div>                                
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="template/sidemain.jsp"/>     
            </div>
            <jsp:include page="template/footer.jsp"/>
        </div>
        <script type="text/javascript">
	        $(function(){
	        	function initToolbarBootstrapBindings() {
					var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
					      'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
					      'Times New Roman', 'Verdana'],
					fontTarget = $('[title=Font]').siblings('.dropdown-menu');
	        	      $.each(fonts, function (idx, fontName) {
	        	          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
        	      	});
        	      	$('a[title]').tooltip({container:'body'});
       	    		$('.dropdown-menu input').click(function() {return false;})
        			    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
	        	        .keydown('esc', function () {this.value='';$(this).change();});

       	      		$('[data-role=magic-overlay]').each(function () { 
	        	        var overlay = $(this), target = $(overlay.data('target')); 
	        	        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
        	      	});
        	      	if ("onwebkitspeechchange"  in document.createElement("input")) {
	        	        var editorOffset = $('#editor').offset();
	        	        $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
       	      		} else {
	        	        $('#voiceBtn').hide();
        	      	}
        		};
	        	function showErrorAlert (reason, detail) {
	        		var msg='';
	        		if (reason==='unsupported-file-type') { msg = "Formato no soportado " +detail; }
	        		else {
	        			console.log("error al subir archivo", reason, detail);
	        		}
	        		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
	        		 '<strong>Error al subir Archivo</strong> '+msg+' </div>').prependTo('#alerts');
	        	};  
	        	initToolbarBootstrapBindings();  
	        	$('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
	          });
        </script>
    </body>
</html>
