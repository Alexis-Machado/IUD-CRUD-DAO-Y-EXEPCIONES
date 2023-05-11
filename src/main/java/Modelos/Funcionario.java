
package Modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Carlos
 */
public class Funcionario {

    private int id;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private EstadoCivil estadoCivilId;
    private TipoIdentificacion tipoIdentificacionId;

    public Funcionario() {

    }

    public Funcionario(int id, String numeroIdentificacion, String nombres, String apellidos, String sexo, String direccion, String telefono, LocalDate fechaNacimiento, EstadoCivil estadosCivilesId, TipoIdentificacion tiposIdentificacionesId) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivilId = estadosCivilesId;
        this.tipoIdentificacionId = tiposIdentificacionesId;
    }

    public Funcionario(int id, String numeroIdentificacion, String nombres, String apellidos, String sexo, String direccion, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Funcionario(int id) {
        this.id = id;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EstadoCivil getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(EstadoCivil estadosCivilesId) {
        this.estadoCivilId = estadosCivilesId;
    }

    public TipoIdentificacion getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(TipoIdentificacion tiposIdentificacionesId) {
        this.tipoIdentificacionId = tiposIdentificacionesId;
    }

}
