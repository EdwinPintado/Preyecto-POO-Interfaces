
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Devolucion;
import java.util.ArrayList;
import java.util.List;

public class DevolucionDAOMemoria implements SistemaDAO<Devolucion>{
    
    private List<Devolucion> devoluciones;
    
    public DevolucionDAOMemoria() {
        devoluciones = new ArrayList<>();
    }
    
    @Override
    public void agregar(Devolucion datos) {
        devoluciones.add(datos);
   }

    @Override
    public void eliminar(String isbn) {
          for (int i = 0; i < devoluciones.size(); i++) {
            if (devoluciones.get(i).getPrestamo().getLibro().getIsbn().equals(isbn)) {
                devoluciones.remove(i);
                break;
            }
        }
    }

    @Override
    public Devolucion buscar(String isbn) {
        for (Devolucion d : devoluciones) {
            if (d.getPrestamo().getLibro().getIsbn().equals(isbn)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Devolucion datos) {
         for (Devolucion d : devoluciones) {
            if (d.getPrestamo().getLibro().getIsbn().equals(datos.getPrestamo().getLibro().getIsbn())) {
                d.setPrestamo(datos.getPrestamo());
                d.setFechaDevolucion(datos.getFechaDevolucion());               
            }
        }
    }

    @Override
    public List<Devolucion> listar() {
        return devoluciones;
    }

    @Override
    public int contar() {
        return devoluciones.size();
    }
    
}
