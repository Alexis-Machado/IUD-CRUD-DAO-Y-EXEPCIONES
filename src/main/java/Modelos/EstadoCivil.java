
package Modelos;

/**
 *
 * @author JUli
 */
public class EstadoCivil {
    private int id;
    private String nombre;
    private String descripcion;

    public EstadoCivil(){
        
    }

    public EstadoCivil(String nombre) {
        this.nombre = nombre;
    }
    
    public EstadoCivil(int id) {
        this.id = id;
    }

    public EstadoCivil(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
