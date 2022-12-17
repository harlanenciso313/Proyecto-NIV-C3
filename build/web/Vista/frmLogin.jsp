<%-- 
    Document   : frmLogin
    Created on : 6/09/2019, 04:13:45 PM
    Author     : CesarCuellar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<form name="frmLogin" id="frmLogin" method="POST" action="../ControllerUsuario">
    <table border="1" class="table table-bordered w-50" align="center">
        <thead>
            <tr align="center" class="bg-dark text-white">
                <th colspan="2" >INICIO DE SESIÓN</th>              
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="txtLogin" id="txtLogin" required value="" class="form-control"  /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="txtPassword" id="txtPassword" required value="" class="form-control" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" id="btnIngresar" value="Ingresar" class="btn btn-success" /></td>
                
            </tr>
            
        </tbody>
    </table>
    <br>
    <p align="center">
        <%
            try{
                if (request.getParameter("x").equals("1")){
                    out.print("Usuario Inactivo, comuniquese "
                            + "con el Administrador");                  
                }
                if (request.getParameter("x").equals("2")){
                    out.print("Credenciales no validas, verifique");                  
                }
                }catch(Exception ex){
                    //out.print(ex.getMessage());
                }
       
        %>
    </p>

</form>

