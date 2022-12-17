<%-- 
    Document   : FrmAgregarAprendiz
    Created on : 21/08/2019, 10:49:11 AM
    Author     : CesarCuellar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String pagina = request.getParameter("page");    
    if (pagina==null){
        pagina="contenido.jsp";
    }else{
        pagina+=".jsp";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel='stylesheet' href='https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css'>
        <link rel='stylesheet' href='https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <script src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>
    <script src='https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js'></script>
    <script src='https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js'></script>
    <script src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.bootstrap4.min.js'></script>
        
        <script src="Recursos/Librerias/jquery/jquery-ui.js" type="text/javascript"></script>
        <link href="Recursos/Librerias/jquery/jquery-ui.css" rel="stylesheet" type="text/css"/>
        
        <link href="Css/misEstilos.css" rel="stylesheet" type="text/css"/>
        <title>EJEMPLO CRUD MYSQL EN JAVA WEB</title>
    </head>
    <!-- Aquí todo el cuerpo del formulario -->
    <body>
        <div class="container">
            <header><jsp:include page="encabezado.jsp"/></header>
            <nav><jsp:include page="menu.jsp"/></nav>
            <section><jsp:include page="<%=pagina%>"/></section>
            <footer> <jsp:include page="piePagina.jsp"/></footer>
        </div>
    </body>
</html>
