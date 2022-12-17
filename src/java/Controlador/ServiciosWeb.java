
package Controlador;

import Modelo.Datos.DatosAprendiz;
import Modelo.Entidad.Aprendiz;
import Modelo.Entidad.Curso;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("/Aprendices/")
@Produces("application/json")
public class ServiciosWeb {

    @Context
    private UriInfo context;
    
    private DatosAprendiz dAprendiz = new DatosAprendiz();
    
    
    public ServiciosWeb() {
    }

    
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarAprendices() {
            
        ArrayList<Aprendiz> lista = dAprendiz.listarAprendices();               
        String json = new Gson().toJson(lista);
        return json;         
    }
    
    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerAprendizById(@PathParam("id") String id) {
              
       String identifica = id;
       Aprendiz unAprendiz = dAprendiz.obtenerAprendizPorIdentificacion(identifica);
       String json = new Gson().toJson(unAprendiz);    
       return json;
    }
    
    @POST
    @Path("/actualizar")
    @Consumes(MediaType.APPLICATION_JSON) 
   
    public void actualizarAprendiz(String json){   
        
       Aprendiz unAprendiz = new Gson().fromJson(json, Aprendiz.class);
       System.out.println("Datos del aprendiz" + unAprendiz.getNombres());
        boolean actualizado = dAprendiz.actualizarAprendiz(unAprendiz);      
        String json2 = new Gson().toJson(actualizado);  
      
     
    }


    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
   
}
