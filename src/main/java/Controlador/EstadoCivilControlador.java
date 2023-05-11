
package Controlador;

import DAO.EstadoCivilDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import Modelos.EstadoCivil;

/**
 *
 * @author Alexis Machado
 */

/**
 * Esta clase es el controlador para el modelo EstadoCivil.
 * Se encarga de interactuar con el DAO de EstadoCivil y proporcionar funcionalidad relacionada.
 */
public class EstadoCivilControlador {

    private EstadoCivilDAO estadoCivilDao;

    /**
     * Constructor de la clase EstadoCivilControlador.
     * Recibe un objeto EstadoCivilDAO como parámetro para utilizarlo en las operaciones.
     * @param estadoCivilDao El DAO de EstadoCivil utilizado por el controlador.
     */
    public EstadoCivilControlador(EstadoCivilDAO estadoCivilDao) {
        this.estadoCivilDao = estadoCivilDao;
    }

    /**
     * Método para llenar un selector (combobox) con los estados civiles disponibles.
     * Realiza una consulta al DAO de EstadoCivil para obtener la lista de estados civiles.
     * Itera sobre la lista y agrega los nombres de los estados civiles al selector.
     * @return El modelo de combobox con los nombres de los estados civiles.
     */
    public DefaultComboBoxModel llenarSelector() {
        DefaultComboBoxModel selectorEstadosCiviles = new DefaultComboBoxModel();

        List<EstadoCivil> estadosCiviles = estadoCivilDao.findAll();
        for (EstadoCivil elem : estadosCiviles) {
            selectorEstadosCiviles.addElement(elem.getNombre());
        }
        return selectorEstadosCiviles;
    }

}