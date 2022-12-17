
package Controlador;

import Modelo.Datos.DatosUsuario;
import Modelo.Entidad.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Request;


@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {
   
    DatosUsuario dUsuario = new DatosUsuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String login = request.getParameter("txtLogin");
        String password= request.getParameter("txtPassword");
       
        
        Usuario unUsuario = new Usuario();
        unUsuario.setLogin(login);
        unUsuario.setPassword(password);
        
        String passwordEncriptado = unUsuario.passwordEncriptado();
        unUsuario.setPassword(passwordEncriptado);
        
        unUsuario = dUsuario.iniciarSesion(unUsuario);
        if (unUsuario!=null){
            if(unUsuario.getEstado().equals("Activo")){
                String rol = unUsuario.getRol();
                switch(rol){
                    case "Administrador":
                        response.sendRedirect(request.getContextPath() + "/Vista/Administrador/");
                    break;
                    case "Aprendiz":
                        response.sendRedirect(request.getContextPath() + "/Vista/Aprendiz/");
                    break;
                }
                
            }else{
                
                response.sendRedirect(request.getContextPath() + "/Vista/index.jsp?page=frmLogin&x=1");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/Vista/index.jsp?page=frmLogin&x=2");
        }     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
