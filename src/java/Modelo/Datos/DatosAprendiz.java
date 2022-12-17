package Modelo.Datos;

import Modelo.Entidad.Aprendiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatosAprendiz {
    private final Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    
    
    public DatosAprendiz(){
        miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    public boolean agregarAprendiz(Aprendiz unAprendiz){
        boolean agregado = false;        
        String consulta="insert into aprendices values(null,?,?,?,?,?,?,?)";
        try{
            ps = miConexion.prepareStatement(consulta);
            ps.setString(1,unAprendiz.getIdentificacion());
            ps.setString(2,unAprendiz.getNombres());
            ps.setString(3,unAprendiz.getApellidos());
            ps.setString(4,unAprendiz.getCorreo());
            ps.setString(5,unAprendiz.getGenero());
            ps.setString(6,unAprendiz.getFechaNacimiento());
            ps.setInt(7,unAprendiz.getUnCurso().getIdCurso());
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="Aprendiz agregado correctamente";
            }           
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }        
        return agregado;
    }
    
    
    public Aprendiz obtenerAprendizPorIdentificacion(String identificacion){
        Aprendiz unAprendiz=null;
        mensaje=null;        
        String consulta="select aprendices.*, cursos.* from aprendices"
                + " inner join cursos on aprendices.aprCurso=cursos.idCurso"
                + " where aprIdentificacion=?";
        try{
            ps = miConexion.prepareStatement(consulta);
            ps.setString(1, identificacion);
            rs = ps.executeQuery();
            if(rs.next()){
                 unAprendiz=new Aprendiz();
                 unAprendiz.setIdAprendiz(rs.getInt("idAprendiz"));
                 unAprendiz.setIdentificacion(rs.getString("aprIdentificacion"));
                 unAprendiz.setNombres(rs.getString("aprNombres"));
                 unAprendiz.setApellidos(rs.getString("aprApellidos"));
                 unAprendiz.setCorreo(rs.getString("aprCorreo"));
                 unAprendiz.setGenero(rs.getString("aprGenero"));
                 unAprendiz.setFechaNacimiento(rs.getString("aprFechaNacimiento"));
                 unAprendiz.getUnCurso().setIdCurso(rs.getInt("idCurso"));
                 unAprendiz.getUnCurso().setCodigo(rs.getInt("curCodigo"));
                 unAprendiz.getUnCurso().setNombre(rs.getString("curNombre"));
            }else{
                mensaje="No existe aprendiz con esa Identificación";
            }
            rs.close();            
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }
        return unAprendiz;
    }
    
    
    public boolean  actualizarAprendiz(Aprendiz unAprendiz){
        mensaje=null;
        boolean actualizado=false;
        String consulta="update aprendices set "
                + " aprIdentificacion=?, aprNombres=?, aprApellidos=?,"
                + " aprCorreo=?, aprGenero=?,aprFechaNacimiento=?, aprCurso=? "
                + " where idAprendiz=?";
        try{
            ps = miConexion.prepareStatement(consulta);
            ps.setString(1,unAprendiz.getIdentificacion());
            ps.setString(2,unAprendiz.getNombres());
            ps.setString(3,unAprendiz.getApellidos());
            ps.setString(4,unAprendiz.getCorreo());
            ps.setString(5,unAprendiz.getGenero());
            ps.setString(6,unAprendiz.getFechaNacimiento());
            ps.setInt(7, unAprendiz.getUnCurso().getIdCurso()); 
            ps.setInt(8, unAprendiz.getIdAprendiz()); 
            if (ps.executeUpdate()>0){
                actualizado=true;                
            }
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }        
        return actualizado;
    }
    
    
    public boolean eliminarAprendiz(int idAprendiz){
        mensaje=null;
        boolean eliminado=false;
        String consulta="delete from aprendices where idAprendiz=?";
        try{
            ps = miConexion.prepareStatement(consulta);            
            ps.setInt(1, idAprendiz);            
            if (ps.executeUpdate()>0){
                eliminado=true;                
            }
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }        
        return eliminado;
    }
    
    
    public ArrayList<Aprendiz> listarAprendices(){
        ArrayList<Aprendiz> lista=new ArrayList<>();
        mensaje=null;        
        String consulta="select aprendices.*, cursos.* from aprendices"
                + " inner join cursos on aprendices.aprCurso = cursos.idCurso";
        try{
            ps = miConexion.prepareStatement(consulta);           
            rs = ps.executeQuery();
            while(rs.next()){
                 Aprendiz unAprendiz=new Aprendiz();
                 unAprendiz.setIdAprendiz(rs.getInt("idAprendiz"));
                 unAprendiz.setIdentificacion(rs.getString("aprIdentificacion"));
                 unAprendiz.setNombres(rs.getString("aprNombres"));
                 unAprendiz.setApellidos(rs.getString("aprApellidos"));
                 unAprendiz.setCorreo(rs.getString("aprCorreo"));
                 unAprendiz.setGenero(rs.getString("aprGenero"));
                 unAprendiz.setFechaNacimiento(rs.getString("aprFechaNacimiento"));
                 unAprendiz.getUnCurso().setIdCurso(rs.getInt("idCurso"));
                 unAprendiz.getUnCurso().setCodigo(rs.getInt("curCodigo"));
                 unAprendiz.getUnCurso().setNombre(rs.getString("curNombre"));
                 lista.add(unAprendiz);
            }
            rs.close();            
        }catch(SQLException ex){
            mensaje=ex.getMessage();
        }
        return lista;
    }
}
