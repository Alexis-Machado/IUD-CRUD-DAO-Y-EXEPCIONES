
package Controlador;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import Modelos.TipoIdentificacion;
import DAO.TipoIdentificacionDAO;

/**
 *
 * @author ALexis Machado
 */
public class TipoIdentificacionControlador {
    
    private TipoIdentificacionDAO tipoIdentificacionDao;

    /**
     * Constructor de la clase TipoIdentificacionControlador.
     * Recibe un objeto TipoIdentificacionDAO como parámetro para utilizarlo en las operaciones.
     * @param tipoIdentificacionDao El DAO de TipoIdentificacion utilizado por el controlador.
     */
    public TipoIdentificacionControlador(TipoIdentificacionDAO tipoIdentificacionDao) {
        this.tipoIdentificacionDao = tipoIdentificacionDao;
    }
    
    /**
     * Método para llenar un selector (combobox) con los tipos de identificación disponibles.
     * Realiza una consulta al DAO de TipoIdentificacion para obtener la lista de tipos de identificación.
     * Itera sobre la lista y agrega los nombres de los tipos de identificación al selector.
     * @return El modelo de combobox con los nombres de los tipos de identificación.
     */
    public DefaultComboBoxModel llenarSelector(){
        DefaultComboBoxModel selectorTipoID = new DefaultComboBoxModel();
        List<TipoIdentificacion> tiposID = tipoIdentificacionDao.findAll();
        for(TipoIdentificacion elem: tiposID){
            selectorTipoID.addElement(elem.getNombre());
        }
        return selectorTipoID;
    }
    
}