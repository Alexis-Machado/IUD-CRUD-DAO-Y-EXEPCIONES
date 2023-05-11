
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Configuracion.Conexion;
import Utils.Mensajes;

/**
 *
 * @author Carlos
 */
public class FuncionarioServicio {
    // Declaración de variables
    private Conexion conexion;
    private Statement query;
    private ResultSet result;

    // Método para buscar funcionarios y obtener una lista de FuncionarioDTO
    public List<FuncionarioDTO> buscarFuncionarios() {
        // Crear una lista vacía para almacenar los objetos FuncionarioDTO encontrados
        List<FuncionarioDTO> funcionariosDto = new ArrayList<>();
        try {
            // Consulta SQL para buscar los funcionarios y obtener información adicional de las tablas relacionadas
            String sql = """
                         SELECT funcionarios.*, estados_civiles.nombre EstadoCivil, tipos_identificaciones.nombre TipoID FROM funcionarios
                         INNER JOIN estados_civiles
                         ON funcionarios.estados_civiles_id=estados_civiles.id
                         INNER JOIN tipos_identificaciones
                         ON funcionarios.tipos_identificaciones_id=tipos_identificaciones.id""";
            conexion = new Conexion();
            query = conexion.getCon().createStatement();
            result = query.executeQuery(sql);

            while (result.next()) {
                // Crear un objeto FuncionarioDTO utilizando los datos obtenidos de la consulta
                FuncionarioDTO funcionarioDto = new FuncionarioDTO(
                        result.getInt("id"), result.getString("numero_identificacion"),
                        result.getString("nombres"), result.getString("apellidos"), result.getString("sexo"),
                        result.getString("direccion"), result.getString("telefono"),
                        LocalDate.parse(result.getString("fecha_nacimiento")), result.getString("EstadoCivil"),
                        result.getString("TipoID"));
                // Agregar el objeto FuncionarioDTO a la lista de funcionarios encontrados
                funcionariosDto.add(funcionarioDto);
            }

            // Cierre del Quet, Result y la conexión para liberar recursos
            query.close();
            result.close();
            conexion.getCon().close();

        } catch (SQLException ex) {
            Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos");
        }
        // Devolver la lista de funcionarios encontrados
        return funcionariosDto;
    }
}
