
package DAO;

import java.util.ArrayList;
import java.util.List;
import Configuracion.Conexion;
import Modelos.TipoIdentificacion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Mensajes;

/**
 *
 * @author ALexis Machado
 */
public class TipoIdentificacionDAOImpl implements TipoIdentificacionDAO {
    // Declaración de variables
    private Conexion conexion;
    private Statement query;
    private ResultSet result;

    @Override
    public List<TipoIdentificacion> findAll() {
        // Creación de una lista para almacenar los objetos TipoIdentificacion
        List<TipoIdentificacion> tiposID = new ArrayList<>();
        try {
            // Definición de la consulta SQL para seleccionar todos los registros de la tabla "tipos_identificaciones"
            String sql = "SELECT * FROM tipos_identificaciones";
            // Creación de una instancia de la clase Conexion para establecer la conexión con la base de datos
            conexion = new Conexion();
            // Creación de un objeto Statement a partir de la conexión establecida
            query = conexion.getCon().createStatement();
            // Ejecución de la consulta y obtención de un objeto ResultSet con los resultados
            result = query.executeQuery(sql);

            // Recorrido de los resultados obtenidos
            while (result.next()) {
                // Creación de un objeto TipoIdentificacion a partir de los valores de las columnas en el resultado
                TipoIdentificacion tipoIdentificacion = new TipoIdentificacion(
                        result.getInt("id"), result.getString("nombre"), result.getString("descripcion"));
                // Agregado del objeto TipoIdentificacion a la lista tiposID
                tiposID.add(tipoIdentificacion);
            }

            // Cierre del Statement, ResultSet y la conexión para liberar recursos
            query.close();
            result.close();
            conexion.getCon().close();

        } catch (SQLException ex) {
            // En caso de una excepción SQLException, se muestra un mensaje de error utilizando la clase Mensajes
            Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 6");
        }

        // Devolución de la lista de TipoIdentificacion obtenida de la base de datos
        return tiposID;
    }
}