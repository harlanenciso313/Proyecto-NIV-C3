
package Modelo.Entidad;


public class Curso {
    
    private int idCurso;
    private int codigo;
    private String nombre;

   
    public Curso(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public Curso(){
            
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
