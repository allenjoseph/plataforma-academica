$(function(){
   $(".page-header h1 a").mouseenter(function(){
        $(this).siblings("i").attr('class','icon-folder-open');
   }).mouseleave(function(){
        $(this).siblings("i").attr('class','icon-folder-close');
   });
   
   $.datepicker.setDefaults($.datepicker.regional['es']);
   var myDate = new Date();
   var prettyDate = myDate.getDate() + '/' + (myDate.getMonth()+1) + '/' + myDate.getFullYear();
   $(".datepicker").val(prettyDate);   
   $(".datepicker").datepicker({
	    dateFormat: 'dd/mm/yy'
   });
});

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
