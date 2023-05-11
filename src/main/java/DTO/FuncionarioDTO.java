
package DTO;

import java.time.LocalDate;
import Modelos.Funcionario;

/**
 *
 * @author Carlos
 */
public class FuncionarioDTO extends Funcionario {
    // Declaración de variables
    private String estadoCivil;
    private String tipoId;

    // Constructor vacío
    public FuncionarioDTO() {
    }

    // Constructor con parámetros
    public FuncionarioDTO(int id, String numeroIdentificacion, String nombres, String apellidos,
            String sexo, String direccion, String telefono, LocalDate fechaNacimiento,
            String estadoCivil, String tipoId) {
        // Llamada al constructor de la clase base (Funcionario) 
        super(id, numeroIdentificacion, nombres, apellidos, sexo, direccion, telefono, fechaNacimiento);
        // Asignación de los valores a las variables adicionales
        this.estadoCivil = estadoCivil;
        this.tipoId = tipoId;
    }

    // Métodos getter y setter para las variables 
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
}