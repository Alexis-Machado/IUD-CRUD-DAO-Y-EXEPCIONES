
package DAO;

import DTO.FuncionarioDTO;
import DTO.FuncionarioServicio;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Configuracion.Conexion;
import Modelos.EstadoCivil;
import Modelos.Funcionario;
import Modelos.TipoIdentificacion;
import Utils.Mensajes;

/**
 *
 * @author Alexis Machado
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    private FuncionarioServicio funcionarioService;// Variable para acceder al servicio de funcionarios
    private Conexion conexion;// Variable para la conexión a la base de datos
    private ResultSet result;// Resultado de una consulta a la base de datos
    private PreparedStatement preparedQuery; // Consulta preparada

    @Override
    public List<Funcionario> findAll() {
        funcionarioService = new FuncionarioServicio(); // Se crea una instancia del servicio de funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();// Lista para almacenar los funcionarios obtenidos
        List<FuncionarioDTO> funcionariosDto = funcionarioService.buscarFuncionarios();//Se obtiene una lista de funcionariosDTO a través del servicio
        for (FuncionarioDTO f : funcionariosDto) {// Se itera sobre cada FuncionarioDTO en la lista obtenida
            Funcionario funcionario = new Funcionario(f.getId(), f.getNumeroIdentificacion(),
                    f.getNombres(), f.getApellidos(), f.getSexo(), f.getDireccion(), f.getTelefono(),
                    f.getFechaNacimiento(), new EstadoCivil(f.getEstadoCivil()), new TipoIdentificacion(f.getTipoId()));
             // Se crea un nuevo objeto Funcionario a partir de los datos del FuncionarioDTO actual
            funcionarios.add(funcionario);// Se agrega el objeto Funcionario a la lista de funcionarios
        }
        return funcionarios; // Se devuelve la lista de funcionarios
    }

@Override
public Funcionario findByDocumento(String documento) {
    Funcionario funcionario = null; // Variable para almacenar el objeto Funcionario encontrado (inicializado a null si no se encuentra el funcionario)
    String sql = "SELECT * FROM funcionarios WHERE numero_identificacion=?";
    try {
        conexion = new Conexion();// Se establece la conexión a la base de datos
        preparedQuery = conexion.getCon().prepareStatement(sql);// Se prepara la consulta SQL
        preparedQuery.setString(1, documento);// Se establece el valor del parámetro en la consulta SQL
        result = preparedQuery.executeQuery(); // Se ejecuta la consulta y se obtiene el resultado

        if (result.next()) { // Si hay un registro en el resultado
            funcionario = new Funcionario(); // Se crea una instancia de Funcionario
            // Se asignan los valores obtenidos del resultado a las propiedades del objeto Funcionario
            funcionario.setNumeroIdentificacion(result.getString("numero_identificacion"));
            funcionario.setNombres(result.getString("nombres"));
            funcionario.setApellidos(result.getString("apellidos"));
            funcionario.setSexo(result.getString("sexo"));
            funcionario.setDireccion(result.getString("direccion"));
            funcionario.setTelefono(result.getString("telefono"));
            funcionario.setFechaNacimiento(LocalDate.parse(result.getString("fecha_nacimiento")));
            funcionario.setTipoIdentificacionId(new TipoIdentificacion(result.getInt("tipos_identificaciones_id")));
            funcionario.setEstadoCivilId(new EstadoCivil(result.getInt("estados_civiles_id")));
        }

        //Secierra la consulta, el resultado y la conexion
        preparedQuery.close();
        result.close();
        conexion.getCon().close();
    } catch (SQLException ex) {
        Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 2");// Manejo de excepciones en caso de error
    }
    return funcionario;// Se devuelve el objeto Funcionario encontrado
}

@Override
public int save(Funcionario funcionario) {
    int res = 0; // Variable para almacenar el resultado de la operación de inserción
    String sql = "INSERT INTO funcionarios(numero_identificacion,nombres,apellidos,sexo,direccion,telefono,fecha_nacimiento,"
            + "estados_civiles_id,tipos_identificaciones_id) "
            + "VALUES(?,?,?,?,?,?,?,?,?);"; // Consulta SQL para insertar un nuevo registro en la tabla "funcionarios"
    conexion = new Conexion(); // Se establece la conexión a la base de datos
    try {
        preparedQuery = conexion.getCon().prepareStatement(sql); // Se prepara la consulta SQL
        // Se establecen los valores de los parámetros en la consulta SQL utilizando los métodos correspondientes del objeto Funcionario
        preparedQuery.setString(1, funcionario.getNumeroIdentificacion());
        preparedQuery.setString(2, funcionario.getNombres());
        preparedQuery.setString(3, funcionario.getApellidos());
        preparedQuery.setString(4, funcionario.getSexo());
        preparedQuery.setString(5, funcionario.getDireccion());
        preparedQuery.setString(6, funcionario.getTelefono());
        preparedQuery.setString(7, funcionario.getFechaNacimiento().toString());
        preparedQuery.setInt(8, funcionario.getEstadoCivilId().getId());
        preparedQuery.setInt(9, funcionario.getTipoIdentificacionId().getId());

        res = preparedQuery.executeUpdate(); // Se ejecuta la consulta y se obtiene el resultado de la operación de inserción
        preparedQuery.close(); // Se cierra la consulta preparada
        conexion.getCon().close(); // Se cierra la conexión a la base de datos

    } catch (SQLException ex) {
        Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 3"); // Manejo de excepciones en caso de error
    }
    return res; // Se devuelve el resultado de la operación de inserción 
}

   @Override
public int update(Funcionario funcionario) {
    int res = 0; // Variable para almacenar el resultado de la operación de actualización
    String sql = "UPDATE funcionarios "
            + "SET numero_identificacion=?, nombres=?, apellidos=?, "
            + "sexo=?, direccion=?, telefono=?, fecha_nacimiento=?, "
            + "estados_civiles_id=?,tipos_identificaciones_id=?, fecha_actualizacion=now() "
            + "WHERE numero_identificacion=?"; // Consulta SQL para actualizar un registro en la tabla "funcionarios"
    conexion = new Conexion(); // Se establece la conexión a la base de datos
    try {
        preparedQuery = conexion.getCon().prepareStatement(sql); // Se prepara la consulta SQL
        // Se establecen los valores de los parámetros en la consulta SQL utilizando los métodos correspondientes del objeto Funcionario
        preparedQuery.setString(1, funcionario.getNumeroIdentificacion());
        preparedQuery.setString(2, funcionario.getNombres());
        preparedQuery.setString(3, funcionario.getApellidos());
        preparedQuery.setString(4, funcionario.getSexo());
        preparedQuery.setString(5, funcionario.getDireccion());
        preparedQuery.setString(6, funcionario.getTelefono());
        preparedQuery.setString(7, funcionario.getFechaNacimiento().toString());
        preparedQuery.setInt(8, funcionario.getEstadoCivilId().getId());
        preparedQuery.setInt(9, funcionario.getTipoIdentificacionId().getId());
        preparedQuery.setString(10, funcionario.getNumeroIdentificacion());

        res = preparedQuery.executeUpdate(); // Se ejecuta la consulta y se obtiene el resultado de la operación de actualización
        preparedQuery.close(); // Se cierra la consulta preparada
        conexion.getCon().close(); // Se cierra la conexión a la base de datos
    } catch (SQLException ex) {
        Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 4"); // Manejo de excepciones en caso de error
    }

    return res; // Se devuelve el resultado de la operación de actualización 
}

@Override
public void delete(String documento) {
    String sql = "DELETE FROM funcionarios WHERE "
            + "numero_identificacion=?"; // Consulta SQL para eliminar un registro de la tabla "funcionarios"
    conexion = new Conexion(); // Se establece la conexión a la base de datos
    try {
        preparedQuery = conexion.getCon().prepareStatement(sql); // Se prepara la consulta SQL
        preparedQuery.setString(1, documento); // Se establece el valor del parámetro en la consulta SQL utilizando el documento proporcionado
        preparedQuery.executeUpdate(); // Se ejecuta la consulta para realizar la eliminación
        preparedQuery.close(); // Se cierra la consulta preparada
        conexion.getCon().close(); // Se cierra la conexión a la base de datos
    } catch (SQLException ex) {
        Mensajes.mensajeError(ex.getMessage(), "Error De Base De Datos 5"); // Manejo de excepciones en caso de error
    }
    
}

}