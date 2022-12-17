
package Controlador;

import Modelo.Datos.DatosAprendiz;
import Modelo.Entidad.Aprendiz;
import Modelo.Entidad.Curso;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControllerAprendiz", urlPatterns = {"/ControllerAprendiz"})
public class ControllerAprendiz extends HttpServlet {

    
    private DatosAprendiz dAprendiz = new DatosAprendiz();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerAprendiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerAprendiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        consultar(request, response); 
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String tarea = request.getParameter("accion");        
        switch (tarea){
            case    "Agregar":      agregar2(request, response); 
                break;
            case    "Consultar":    consultar(request, response);
                break;   
            case    "Actualizar":   actualizar(request, response);
                break; 
            case    "Eliminar":     eliminar(request, response);
                break; 
            case    "Listar":       listar(request, response);
                break;
            case    "Existe":       consultar(request, response);
                break;
        }        
    }
    
    
    private void agregar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{       
        String identifica = request.getParameter("txtIdentificacion");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String correo = request.getParameter("txtCorreo");    
        String genero = request.getParameter("cbGenero");  
        String fechaNacimiento = request.getParameter("txtFechaNacimiento");
        int idCurso = Integer.parseInt(request.getParameter("cbCurso"));
        Curso unCurso = new Curso();
        unCurso.setIdCurso(idCurso);
        
        Aprendiz unAprendiz = new Aprendiz(identifica, nombres, apellidos, 
                correo, genero, fechaNacimiento, unCurso);       
       
        
        boolean agregado = dAprendiz.agregarAprendiz(unAprendiz);
        
        String mensaje = dAprendiz.getMensaje(); 
        
        response.sendRedirect(request.getContextPath()+"/Vista/frmAprendiz.jsp?mensaje=" + mensaje);               
    }
    
    
     private void agregar2(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{       
        String identifica = request.getParameter("txtIdentificacion");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String correo = request.getParameter("txtCorreo");    
        String genero = request.getParameter("cbGenero");  
        String fechaNacimiento = request.getParameter("txtFechaNacimiento");
        int idCurso = Integer.parseInt(request.getParameter("cbCurso"));
        Curso unCurso = new Curso();
        unCurso.setIdCurso(idCurso);
        Aprendiz unAprendiz = new Aprendiz(identifica, nombres, apellidos, 
                correo, genero, fechaNacimiento, unCurso);
        boolean agregado = dAprendiz.agregarAprendiz(unAprendiz);     
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(agregado);   
        out.print(json);       
    }
    
     
    private void consultar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String identifica = request.getParameter("identificacion");  
        Aprendiz unAprendiz = dAprendiz.obtenerAprendizPorIdentificacion(identifica); 
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(unAprendiz);   
        out.print(json);       
    }
    
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        int idAprendiz  =Integer.parseInt(request.getParameter("idAprendiz"));
        String identifica = request.getParameter("txtIdentificacion");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String correo = request.getParameter("txtCorreo");    
        String genero = request.getParameter("cbGenero");  
        String fechaNacimiento = request.getParameter("txtFechaNacimiento");
        int idCurso = Integer.parseInt(request.getParameter("cbCurso"));
        Curso unCurso = new Curso();
        unCurso.setIdCurso(idCurso);
        Aprendiz unAprendiz = new Aprendiz(identifica, nombres, apellidos, 
                correo, genero, fechaNacimiento, unCurso);       
        unAprendiz.setIdAprendiz(idAprendiz);
        boolean actualizado = dAprendiz.actualizarAprendiz(unAprendiz);        
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(actualizado);   
        out.print(json);   
    }
    
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        int idAprendiz = Integer.parseInt(request.getParameter("idAprendiz"));  
        boolean eliminado = dAprendiz.eliminarAprendiz(idAprendiz);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(eliminado);   
        out.print(json);    
    }
    
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        ArrayList<Aprendiz> lista = dAprendiz.listarAprendices();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(lista);   
        out.print(json);   
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    

}
