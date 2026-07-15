package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.AutorNoEncontradoException;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOMemoria implements SistemaDAO<Autor> {

    private List<Autor> autores;

    public AutorDAOMemoria() {
        autores = new ArrayList<>();
        autores.add(new Autor("Ecuador", "Novela", "Escritor clásico",
                "0102030405", "Juan", "Pérez", "0991112223",
                java.sql.Date.valueOf("1995-04-12")));

        autores.add(new Autor("Perú", "Cuento", "Escritora contemporánea",
                "0203040506", "María", "Gómez", "0982223334",
                java.sql.Date.valueOf("1998-09-25")));

        autores.add(new Autor("Colombia", "Poesía", "Premiado internacional",
                "0304050607", "Carlos", "López", "0973334445",
                java.sql.Date.valueOf("1992-01-18")));
    }

    @Override
    public void agregar(Autor datos) {
        autores.add(datos);
        System.out.println("se agresknfsd");
    }

    @Override
    public void eliminar(String cedula) {
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getCedula().equals(cedula)) {
                autores.remove(i);
                break;
            }
        }

    }

    @Override
    public Autor buscar(String cedula) throws AutorNoEncontradoException {

        for (Autor a : autores) {

            if (a.getCedula().equals(cedula)) {
                return a;
            }
        }

        throw new AutorNoEncontradoException(
                "No se encontró el autor con cédula: " + cedula
        );
    }

    @Override
    public void actualizar(Autor datos) {
        for (Autor a : autores) {
            if (a.getCedula().equals(datos.getCedula())) {
                a.setNombre(datos.getNombre());
                a.setApellido(datos.getApellido());
                a.setTelefono(datos.getTelefono());
                a.setFechaNacimiento(datos.getFechaNacimiento());
                a.setNacionalidad(datos.getNacionalidad());
                a.setGeneroLiterario(datos.getGeneroLiterario());
                a.setBibliografia(datos.getBibliografia());
            }
        }
    }

    @Override
    public List<Autor> listar() {
        return autores;
    }

    @Override
    public int contar() {
        return autores.size();
    }

}
