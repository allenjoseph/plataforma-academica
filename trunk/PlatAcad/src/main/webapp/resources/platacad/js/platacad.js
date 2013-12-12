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
		
	$.datepicker.setDefaults($.datepicker.regional['es']);  
	$('.datepicker').datepicker({
	   dateFormat: 'DD, d MM yy'
	});  
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	$('#form-registro').on('submit', function(e){
	   e.preventDefault();
	   alert("hola");
	   FormularioRegistro(container_examen, $(this));
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

/* Inicialización en español para la extensión 'UI date picker' para jQuery. */
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
                dayNames: ['domingo','lunes','martes','miércoles','jueves','viernes','sábado'],
                dayNamesShort: ['dom','lun','mar','mié','juv','vie','sáb'],
                dayNamesMin: ['D','L','M','X','J','V','S'],
                weekHeader: 'Sm',
                dateFormat: 'dd/mm/yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
        $.datepicker.setDefaults($.datepicker.regional['es']);
});
