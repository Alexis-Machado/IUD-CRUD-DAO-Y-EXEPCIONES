
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Configuracion.Conexion;
import Modelos.EstadoCivil;
import Utils.Mensajes;

/**
 *
 * @author ALexisMachado
 */
public class EstadoCivilDAOImpl implements EstadoCivilDAO {

    Conexion conexion;  // Variable para la conexión a la base de datos
    private Statement query;  // Consulta SQL
    private ResultSet result;  // Resultado de la consulta

    @Override
    public List<EstadoCivil> findAll() {
        List<EstadoCivil> tipoEstado = new ArrayList<>();  // Lista de objetos EstadoCivil
        try {
            String sql = "SELECT * FROM estados_civiles";  // Consulta SQL para obtener todos los estados civiles
            conexion = new Conexion();  // Creación de una instancia de la clase Conexion para establecer la conexión a la base de datos
            query = conexion.getCon().createStatement();  // Creación de un objeto Statement para ejecutar la consulta
            result = query.executeQuery(sql);  // Ejecución de la consulta y obtención del resultado
            while (result.next()) {
                // Creación de un objeto EstadoCivil a partir de los datos obtenidos en el resultado de la consulta
                EstadoCivil estadoCivil = new EstadoCivil(result.getInt("id"), result.getString("nombre"));
                tipoEstado.add(estadoCivil);  // Agregar el objeto EstadoCivil a la lista tipoEstado
            }
            query.close();  // Cierre del objeto Statement
            result.close();  // Cierre del objeto ResultSet
            conexion.getCon().close();  // Cierre de la conexión a la base de datos
        } catch (SQLException ex) {
            Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 1");  // Mensaje de error en caso de excepción SQL
        }
        return tipoEstado;  // Devolver la lista de estados civiles
    }
}