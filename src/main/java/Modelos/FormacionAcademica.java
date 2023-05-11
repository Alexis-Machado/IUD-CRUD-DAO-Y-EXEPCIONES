
package Modelos;

/**
 *
 * @author JUli
 */
public class FormacionAcademica {

    private int id;
    private String nombre;
    private NivelEducativo nivelEducativoId;
    private Universidad universidadId;
    private Estado estadoId;
    private Funcionario funcionarioId;
    
    public FormacionAcademica(){
        
    }

    public FormacionAcademica(int id, String nombre, NivelEducativo nivelEducativoId, Universidad universidadId, Estado estadoId, Funcionario funcionarioId) {
        this.id = id;
        this.nombre = nombre;
        this.nivelEducativoId = nivelEducativoId;
        this.universidadId = universidadId;
        this.estadoId = estadoId;
        this.funcionarioId = funcionarioId;
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

    public NivelEducativo getNivelEducativoId() {
        return nivelEducativoId;
    }

    public void setNivelEducativoId(NivelEducativo nivelEducativoId) {
        this.nivelEducativoId = nivelEducativoId;
    }

    public Universidad getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Universidad universidadId) {
        this.universidadId = universidadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

}
