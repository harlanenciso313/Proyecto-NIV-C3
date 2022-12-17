<%-- 
    Document   : menu
    Created on : 30/08/2019, 05:59:09 AM
    Author     : CesarCuellar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-info navbar-info sticky-top">                
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
            <a class="navbar-brand av-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
                <img src="Recursos/Imagenes/foto.jpg" alt="Logo" id="foto" style="width:40px;"> 
            </a>            
            <div class="dropdown-menu">
                <b>César Cuéllar</b>
                <a class="dropdown-item " href="#">Actualizar Datos usuario</a>
                <a class="dropdown-item" href="#">Salir</a>               
            </div>
        </li>
    </ul>                    
    <button class="navbar-toggler bg-info text-white" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <!-- Dropdown -->                    
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
                    Cursos
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="index.jsp?page=frmCurso">Gestionar</a>                              
                </div>
            </li> 
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
                        Aprendices
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="index.jsp?page=frmAprendiz">Gestionar</a>                                
                    </div>
                </li> 
                
                <li class="nav-item">
                    <a class="nav-link text-white" href="index.jsp?page=frmLogin">Iniciar Sesión</a>
                </li>

                        
        </ul>
    </div>  
</nav>
