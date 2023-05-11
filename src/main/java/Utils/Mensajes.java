
package Utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public interface Mensajes {
    
    // Método estático para mostrar un mensaje en una ventana emergente
    public static void mostrarMensaje(String msg, String titulo, int tipo){
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }
    
    // Método estático para mostrar un mensaje de error en una ventana emergente
    public static void mensajeError(String msg, String titulo){
        mostrarMensaje(msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    // Método estático para mostrar un cuadro de diálogo de confirmación y obtener la respuesta del usuario
    public static boolean mensajeConfirm(String msg, String titulo) {
        JOptionPane jp = new JOptionPane();
        // El método showConfirmDialog muestra el cuadro de diálogo con los parámetros especificados y devuelve el botón que el usuario seleccionó
        // Comparamos el botón seleccionado con la constante YES_OPTION para determinar si el usuario eligió "Sí" o no
        return jp.showConfirmDialog(null, titulo, msg, jp.YES_NO_OPTION) == jp.YES_OPTION;
    }

}