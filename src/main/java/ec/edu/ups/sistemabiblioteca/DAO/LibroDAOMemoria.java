
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOMemoria implements SistemaDAO<Libro> {

    private List<Libro> libros = new ArrayList<>();

    public LibroDAOMemoria() {
        libros = new ArrayList<>();
    }

    @Override
    public void agregar(Libro libro) {
        libros.add(libro);
    }

    @Override
    public Libro buscar(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Libro libro) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(libro.getIsbn())) {

                l.setTitulo(libro.getTitulo());
                l.setAutor(libro.getAutor());
                l.setEditorial(libro.getEditorial());
            }
        }
    }

    @Override
    public void eliminar(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                libros.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Libro> listar() {
        return libros;
    }

    @Override
    public int contar() {
        return libros.size();
   }

}
