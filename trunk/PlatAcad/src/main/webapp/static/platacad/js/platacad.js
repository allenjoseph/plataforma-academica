$(function(){
   $(".page-header h1 a").mouseenter(function(){
        $(this).siblings("i").attr('class','icon-folder-open');
   }).mouseleave(function(){
        $(this).siblings("i").attr('class','icon-folder-close');
   });
});


