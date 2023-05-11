
package Controlador;

import DAO.FuncionarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Modelos.Funcionario;

/**
 *
 * @author Alexis Machado
 */
public class FuncionarioControlador {

    private FuncionarioDAO funcionarioDao;

       /**
     * Constructor de la clase FuncionarioControlador.
     * Recibe un objeto FuncionarioDAO como parámetro para utilizarlo en las operaciones.
     * @param funcionarioDao El DAO de Funcionario utilizado por el controlador.
     */
    public FuncionarioControlador(FuncionarioDAO funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }

      /**
     * Método para llenar una tabla con los datos de los funcionarios.
     * Se Crea un DefaultTableModel y se agrega las columnas necesarias.
     * Obtiene la lista de funcionarios utilizando el método findAll del DAO de Funcionario.
     * Itera sobre la lista y agrega los datos de cada funcionario a una fila del modelo de tabla.
     * @return El modelo de tabla lleno con los datos de los funcionarios.
     */
    public DefaultTableModel llenarTabla() {
        DefaultTableModel tablaFuncionarios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaFuncionarios.addColumn("ID");
        tablaFuncionarios.addColumn("Tipo Doc.");
        tablaFuncionarios.addColumn("N°Doc.");
        tablaFuncionarios.addColumn("Nombres");
        tablaFuncionarios.addColumn("Apellidos");
        tablaFuncionarios.addColumn("Fecha Nac.");
        tablaFuncionarios.addColumn("Estado Civil");
        List<Funcionario> funcionarios = funcionarioDao.findAll();
        String registros[] = new String[7];
        for (Funcionario f : funcionarios) {
            registros[0] = String.valueOf(f.getId());
            registros[1] = f.getTipoIdentificacionId().getNombre();
            registros[2] = f.getNumeroIdentificacion();
            registros[3] = f.getNombres();
            registros[4] = f.getApellidos();
            registros[5] = f.getFechaNacimiento().toString();
            registros[6] = f.getEstadoCivilId().getNombre();
            tablaFuncionarios.addRow(registros);
        }

        return tablaFuncionarios;
    }
    
      /**
     * Método para buscar un funcionario por su documento.
     * Utiliza el método findByDocumento del DAO de Funcionario.
     * @param documento El documento del funcionario a buscar.
     * @return El objeto Funcionario encontrado o null si no se encontró ningún funcionario.
     */
    public Funcionario buscarFuncionario(String documento){
        Funcionario funcionario = funcionarioDao.findByDocumento(documento);
        return funcionario;
    }
    
      /**
     * Método para guardar un funcionario.
     * Utiliza el método save del DAO de Funcionario.
     * @param funcionario El funcionario a guardar.
     * @return El número de registros afectados por la operación de guardado.
     */
    public int guardar(Funcionario funcionario){
        return funcionarioDao.save(funcionario);
    }
    
      /**
     * Método para editar un funcionario.
     * Utiliza el método update del DAO de Funcionario.
     * @param funcionario El funcionario a editar.
     * @return El número de registros afectados por la operación de edición.
     */
    public int editar(Funcionario funcionario){
        return funcionarioDao.update(funcionario);
    }
    
     /**
     * Método para eliminar un funcionario por su documento.
     * Utiliza el método delete del DAO de Funcionario.
     * @param documento El documento del funcionario a eliminar.
     */
    public void eliminar(String documento){
        funcionarioDao.delete(documento);
    }
}
