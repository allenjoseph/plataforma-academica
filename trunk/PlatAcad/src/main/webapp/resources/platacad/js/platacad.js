var container_examen = $('#container-examen');

$(function(){		
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - */	
	
	$('.page-header h1 a').mouseenter(function(){
       $(this).siblings('i').attr('class','icon-folder-open');
	}).mouseleave(function(){
       $(this).siblings('i').attr('class','icon-folder-close');
	});
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	$('#nav-tab-main a').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	  $("#side-main .tab-pane.active input:first").focus();
	});
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	$('#form-registro').on('submit', function(e){
	   e.preventDefault();
	   alert("hola");
	   FormularioRegistro(container_examen, $(this));
	});	
	
	/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - */
	$('#alert-form-aporte').hide();
	$('.alert').find('button.close').on('click',function(){
		$(this).siblings('span').html('');
		$(this).parent().hide();
	});
	
	$('#form-aporte').on('submit', function(e){
		if($(this).find('#inputTitulo').val() == ''){
			e.preventDefault();
			$('#alert-form-aporte').find('span').html('El Aporte debe tener un Titulo').end().show();
		}else if($(this).find('#editor').html().trim() == ''){
			e.preventDefault();
			$('#alert-form-aporte').find('span').html('El Aporte debe tener un Contenido').end().show();
		}else{	
			$('#input-contenido-aporte').val($('#editor').html());
		}
	});
	
	$('#btn-submit-aporte').on('click', function(){
		$('#form-aporte').submit();
	});
});

function FormularioRegistro(contenedor,formulario){
	alert("hola2");
	var confirmacion = contenedor.find('div.dialogo-confirmacion');
	
	validarDatepicker(formulario); 
	   
	confirmacion.find('button.btn-confirmacion').on('click', function(){
		formulario.submit();
	});
	mostrarDialogo(confirmacion);	 
}

function validarDatepicker(formulario){
	alert("hola3");
	 var date = formulario.find('.datepicker').datepicker('getDate');
	 formulario.find('.hidden-date').val(date);
}

function mostrarDialogo(dialogo){	
	alert("hola4");
	dialogo.modal();
	dialogo.show();
}

/* Inicializacion en español para la extension 'UI date picker' para jQuery. */
/*
jQuery(function($){
        $.datepicker.regional['es'] = {
                closeText: 'Cerrar',
                prevText: '&#x3C;Ant',
                nextText: 'Sig&#x3E;',
                currentText: 'Hoy',
                monthNames: ['enero','febrero','marzo','abril','mayo','junio',
                'julio','agosto','septiembre','octubre','noviembre','diciembre'],
                monthNamesShort: ['ene','feb','mar','abr','may','jun',
                'jul','ogo','sep','oct','nov','dic'],
                dayNames: ['domingo','lunes','martes','miercoles','jueves','viernes','sabado'],
                dayNamesShort: ['dom','lun','mar','mie','juv','vie','sab'],
                dayNamesMin: ['D','L','M','X','J','V','S'],
                weekHeader: 'Sm',
                dateFormat: 'dd/mm/yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
        $.datepicker.setDefaults($.datepicker.regional['es']);
});*/

String.prototype.trim=function(){return this.replace(/^\s+|\s+$/g, '');};

String.prototype.ltrim=function(){return this.replace(/^\s+/,'');};

String.prototype.rtrim=function(){return this.replace(/\s+$/,'');};

String.prototype.fulltrim=function(){return this.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,'').replace(/\s+/g,' ');};
