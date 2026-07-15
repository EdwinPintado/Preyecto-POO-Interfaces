
package ec.edu.ups.sistemabiblioteca.DAOMemoria;

import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAO;
import ec.edu.ups.sistemabiblioteca.Exceptions.PrestamoNoEncontrado;
import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOMemoria implements PrestamoDAO {

    private List<Prestamo> prestamos;

    public PrestamoDAOMemoria() {
        prestamos = new ArrayList<>();
    }

    @Override
    public void agregar(Prestamo datos) {
        prestamos.add(datos);
    }

    @Override
    public void eliminar(String codigo) {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getCodigoPrestamo().equals(codigo)) {
                prestamos.remove(i);
                break;
            }
        }

    }

    @Override
    public Prestamo buscar(String codigo)throws PrestamoNoEncontrado{
        for (Prestamo p : prestamos) {
            if (p.getCodigoPrestamo().equals(codigo)) {
                return p;
            }
        }
        throw new PrestamoNoEncontrado("Nose encontro el prestamo con el codigo: "+codigo);
    }

    @Override
    public void actualizar(Prestamo datos) {
        for (Prestamo p : prestamos) {
            if (p.getCodigoPrestamo().equals(datos.getCodigoPrestamo())) {

                p.setUsuario(datos.getUsuario());
                p.setLibro(datos.getLibro());
                p.setBibliotecario(datos.getBibliotecario());
                p.setFechaPrestamo(datos.getFechaPrestamo());
                p.setFechaDevolucion(datos.getFechaDevolucion());
            }
        }
    }

    @Override
    public List<Prestamo> listar() {
        return prestamos;
    }

    @Override
    public int contar() {
        return prestamos.size();
    }
    
}

