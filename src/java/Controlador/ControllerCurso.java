
package Controlador;


import Modelo.Datos.DatosCurso;
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


@WebServlet(name = "ControllerCurso", urlPatterns = {"/ControllerCurso"})
public class ControllerCurso extends HttpServlet {

    DatosCurso dCurso = new DatosCurso();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerCurso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCurso at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String tarea = request.getParameter("accion");        
        switch (tarea){
            case    "Agregar":     agregar(request, response); 
                break;
            case    "Listar":      listar(request, response); 
                break;
        }        
    }
    
    
    private void agregar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{       
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nombre = request.getParameter("txtNombre");
        Curso unCurso = new Curso(codigo,nombre);        
        boolean agregado = dCurso.agregarCurso(unCurso);
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(agregado);   
        out.print(json);               
    }
    
   
    public void listar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{ 
        ArrayList<Curso> lista = dCurso.listarCursos();        
        PrintWriter out = response.getWriter(); 
        String json = new Gson().toJson(lista);   
        out.print(json);               
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
