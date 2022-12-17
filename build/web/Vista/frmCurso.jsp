<%-- 
    Document   : frmCurso
    Created on : 30/08/2019, 06:07:44 AM
    Author     : CesarCuellar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="Js/funcionesCurso.js" type="text/javascript"></script>
<br>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="frmCurso">
            <input type="hidden" id="accion" name="accion">
            <table  class="table table-bordered w-50" align="center">
            <thead>
                <tr class="bg-dark text-white">
                    <th colspan="2" style="text-align: center">GESTIÓN DE CURSOS</th>
                   
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Código de Curso: </td>
                    <td>
                        <div class="form-group">
                            <input type="number" name="txtCodigo" id="txtCodigo" class="form-control" required />
                            <div id="msjCodigo"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Nombre Curso:</td>
                    <td>
                        <div class="form-group">
                            <input type="text" name="txtNombre" id="txtNombre" class="form-control" required />
                            <div id="msjCodigo"></div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                          <input type="button" value="Agregar" name="btnAgregarCurso" id="btnAgregarCurso" class="btn btn-success" />
                    </td>                    
                </tr>
            </tbody>
        </table>
        </form>
     
        <div id="mensaje" style="text-align: center"></div>
        
        <div class="toast" style="margin: 0 auto">
            <div class="toast-header">
              Aviso Importante
              
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>           
            <div class="toast-body" id="toastMensaje">
             
            </div>
        </div>
        <br>
    </body>
</html>
