<%-- 
    Document   : FrmAgregarAprendiz
    Created on : 21/08/2019, 10:49:11 AM
    Author     : CesarCuellar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            //response.sendRedirect("index.jsp");
             response.sendRedirect("index.jsp");
      
%>
<script src="Js/funcionesAprendiz.js" type="text/javascript"></script>
<script src="Js/funcionesCurso.js" type="text/javascript"></script>
<br>
<form id="frmAprendiz">
    <input type="hidden" name="accion" id="accion" value="Agregar" />  
    <input type="hidden" name="idAprendiz" id="idAprendiz" value="" />    
    <table style="width: 50%" border="0" align="center" class="table table-bordered">
        <thead>
            <tr class="bg-dark text-white">
                <th  colspan="2" style="text-align: center"> GESTIONAR APRENDICES </th>                      
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="negrillaaaa">Identificación:</td>
                <td>
                    <div class="form-group">
                        <input type="number" name="txtIdentificacion" id="txtIdentificacion" class="form-control" required />
                        <div id="msjIdentifica"></div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Nombres:</td>
                <td>
                    <div class="form-group">
                        <input type="text" name="txtNombres" id="txtNombres" autocomplete="off" class="form-control" required />
                    </div>
                </td>
            </tr>
            <tr>
                <td>Apellidos:</td>
                <td>
                    <div class="form-group">
                        <input type="text" name="txtApellidos" id="txtApellidos" class="form-control" required />
                    </div>
                </td>
            </tr>
            <tr>
                <td>Correo:</td>
                <td>
                    <div class="form-group">
                        <input type="email" name="txtCorreo" id="txtCorreo" class="form-control" required />
                    </div>
                </td>
            </tr>
            <tr>
                <td>Genero:</td>
                <td>
                    <div class="form-group">
                        <select name="cbGenero" id="cbGenero" class="form-control custom-select" required>
                            <option value="Femenino">Femenino</option>
                            <option value="Masculino">Masculino</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Fecha Nacimiento</td>
                <td>
                    <div class="form-group">
                        <input type="text" name="txtFechaNacimiento" id="txtFechaNacimiento" class="form-control" autocomplete="off" required />
                    </div>
                </td>
            </tr>
            <tr>
                <td>Curso que estudia</td>
                <td>
                    <div class="form-group">
                        <select name="cbCurso" id="cbCurso" class="form-control custom-select" required>
                            <option value="0">Seleccione</option>
                           
                        </select>
                    </div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="button" value="Agregar" name="btnAgregar" id="btnAgregar" class="btn btn-success" />
                    <input type="button" value="Consultar" id="btnConsultar" name="btnConsultar" class="btn btn-success" />
                    <input type="button" value="Actualizar" name="btnActualizar" id="btnActualizar" class="btn btn-success" />
                    <input type="button" value="Eliminar" id="btnEliminar" name="btnEliminar" class="btn btn-success" />
                    <input type="button" value="Listar" id="btnListar" name="btnListar" class="btn btn-success" />
                </td>                        
            </tr>                    
        </tbody>
    </table>            
</form>

<!--  Ventana modal cuando se va a eliminar -->   
<!-- The Modal -->
<div class="modal" id="modalEliminar">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Encabezado -->
            <div class="modal-header bg-info text-white">
              <h4 class="modal-title">Eliminar Aprendiz</h4>
              <button type="button" class="text-white close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal Contenido -->
            <div class="modal-body">
              ¿Está seguro de eliminar el Aprendiz?
            </div>

            <!-- Modal Pie Página -->
            <div class="modal-footer">
              <button type="button" class="btn btn-success" data-dismiss="modal" id="btnSiModal">Si</button>
              <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>


<div id="msj" class="alert alert-info alert-dismissible" style="display: none">
    <button type="button" class="close" data-dismiss="alert">&times;</button> 
    <strong><div id="mensaje"></div></strong>
</div>

<br>
<!-- Tabla de Aprendices -->
<table border="1" id="tblAprendices" align="center" class="table table-bordered" style="width: 80%; display: none">
    <thead>
        <tr class="bg-dark text-white" style="text-align: center">
            <th>Identificación</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Correo</th>
            <th>Genero</th>
            <th>Fecha Nacimiento</th>
            <th>Curso</th>
         </tr>
    </thead>
    <tbody>                    
        <tr id="fila" class="primeraFila">
            <td id="aIdentifica"></td>
            <td id="aNombres"></td>
            <td id="aApellidos"></td>
            <td id="aCorreo"></td>
            <td id="aGenero"></td>
            <td id="aFechaNacimiento"></td>
            <td id="aCurso"></td>
        </tr>
    </tbody>
</table>