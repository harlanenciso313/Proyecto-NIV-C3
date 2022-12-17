<%-- 
    Document   : pruebaConexion
    Created on : 21/08/2019, 07:27:00 AM
    Author     : CesarCuellar
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Datos.DatosAprendiz"%>
<%@page import="Modelo.Entidad.Aprendiz"%>
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.Datos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
           
            String mensaje = "<br><b>Prueba de Conexión a la Base de Datos</b>";
            out.print(mensaje);
            Connection con = Conexion.getConexion();
            out.print("<br>" + Conexion.getMensaje());    
        %>
    </body>
</html>
