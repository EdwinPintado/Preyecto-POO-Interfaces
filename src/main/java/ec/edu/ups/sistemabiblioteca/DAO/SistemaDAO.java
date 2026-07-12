
package ec.edu.ups.sistemabiblioteca.DAO;

import java.util.List;

public interface SistemaDAO<T> {
    
    void agregar(T datos);
    void eliminar(String cedula);
    T buscar(String id);
    void actualizar(T datos);
    List<T> listar();
    int contar();
    
}
