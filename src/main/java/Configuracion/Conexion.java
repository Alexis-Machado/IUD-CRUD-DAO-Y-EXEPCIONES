
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Utils.Mensajes;

/**
 *
 * @author Carlos
 */

/**
 * Esta clase se utiliza para establecer la conexión con la base de datos MySQL.
 * Utiliza la biblioteca JDBC para realizar la conexión.
 * La URL, el nombre de usuario y la contraseña se establecen como constantes en la clase.
 */
public class Conexion {

    private final String URL = "jdbc:mysql://localhost:3306/iudrecursoshumanos";
    private final String USUARIO = "root";
    private final String PASSWORD = "";

    private Connection con;

    /**
     * Constructor de la clase Conexion.
     * Intenta establecer una conexión con la base de datos utilizando la URL, el nombre de usuario y la contraseña.
     * Si ocurre una excepción SQLException, nos muestra un mensaje de error.
     */
    public Conexion() {
        try {
            this.con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            con.createStatement();
        } catch (SQLException ex) {
            Mensajes.mensajeError(ex.getMessage(), "Error De Conexión");
        }
    }
    
    /**
     * Método para obtener la conexión establecida.
     * @return La conexión a la base de datos.
     */
    public Connection getCon() {
        return con;
    }

    /**
     * Método para establecer la conexión.
     * @param con La conexión a establecer.
     */
    public void setCon(Connection con) {
        this.con = con;
    }
}
