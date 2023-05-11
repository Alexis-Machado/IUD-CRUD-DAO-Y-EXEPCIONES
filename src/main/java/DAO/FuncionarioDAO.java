
package DAO;

import java.util.List;
import Modelos.Funcionario;

/**
 *
 * @author ALexis Machado
 */
public interface FuncionarioDAO {
 
    //Se declaran los métodos del CRUD
    List<Funcionario> findAll();
    
    Funcionario findByDocumento(String documento);
    
    int save(Funcionario funcionario);
    
    int update(Funcionario funcionario);
    
    void delete(String documento);
}
