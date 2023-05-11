
package Modelos;

/**
 *
 * @author Carlos
 */
public class Universidad {

    private int id;
    private String nombre;

    public Universidad(){
        
    }
    
    public Universidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    
}
