
package Modelo.Datos;

import Modelo.Entidad.Aprendiz;
import Modelo.Entidad.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatosCurso {
    private final Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    
    public DatosCurso(){
        miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    public boolean agregarCurso(Curso unCurso){
        boolean agregado = false;        
        String consulta="insert into cursos values(null,?,?)";
        try{
            ps = miConexion.prepareStatement(consulta);
            ps.setInt(1,unCurso.getCodigo());
            ps.setString(2,unCurso.getNombre());            
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="Curso agregado correctamente";
            }           
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }        
        return agregado;
    }
    
    public ArrayList<Curso> listarCursos(){
        ArrayList<Curso> lista=new ArrayList<>();
        mensaje=null;        
        String consulta="select * from cursos";
        try{
            ps = miConexion.prepareStatement(consulta);           
            rs = ps.executeQuery();
            while(rs.next()){
                 Curso unCurso=new Curso();
                 unCurso.setIdCurso(rs.getInt("idCurso"));
                 unCurso.setCodigo(rs.getInt("curCodigo"));
                 unCurso.setNombre(rs.getString("curNombre"));                 
                 lista.add(unCurso);
            }
            rs.close();            
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }
        return lista;
    }
}
