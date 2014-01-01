<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="utf-8">
    <link href="<c:url value='resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='resources/platacad/css/platacad.css'/>" rel="stylesheet">
    <!--link href="<c:url value='resources/platacad/css/custom-theme/jquery-ui-1.10.0.custom.css'/>" rel="stylesheet"-->
    <link href="<c:url value='resources/platacad/css/dropzone.css'/>" rel="stylesheet">
    <link href="<c:url value='resources/platacad/css/timeline.css'/>" rel="stylesheet">
    <link href="<c:url value='resources/platacad/css/bootstrap-wysiwyg.css'/>" rel="stylesheet">
    <link href="<c:url value='resources/platacad/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<c:url value='resources/platacad/css/datepicker.css'/>" rel="stylesheet">
    
    <script src="<c:url value='resources/platacad/js/jquery.min.js'/>" type="text/javascript"></script>    
    <script src="<c:url value='resources/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
    <!--script src="<c:url value='resources/platacad/js/jquery-ui-1.10.3.custom.min.js'/>" type="text/javascript"></script-->
    <script src="<c:url value='resources/platacad/js/dropzone.js'/>" type="text/javascript"></script>
    <script src="<c:url value='resources/platacad/js/platacad.js'/>" type="text/javascript"></script>
    <script src="<c:url value='resources/platacad/js/timeline.js'/>" type="text/javascript"></script>
    
    <script src="<c:url value='resources/platacad/js/jquery.hotkeys.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='resources/platacad/js/bootstrap-wysiwyg.js'/>" type="text/javascript"></script>  
    <script src="<c:url value='resources/platacad/js/typeahead.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='resources/platacad/js/bootstrap-datepicker.js'/>" type="text/javascript"></script>
    <script src="<c:url value='resources/platacad/js/locale/bootstrap-datepicker.es.js'/>" type="text/javascript"></script>
     
    <title><t:message code="app.titulo.largo" /></title>
</head>