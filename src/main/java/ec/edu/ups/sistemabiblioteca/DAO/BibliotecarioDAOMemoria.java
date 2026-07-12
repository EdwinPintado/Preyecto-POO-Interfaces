
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import java.util.ArrayList;
import java.util.List;

public class BibliotecarioDAOMemoria implements SistemaDAO<Bibliotecario> {

    private List<Bibliotecario> bibliotecarios;
    
    public BibliotecarioDAOMemoria(){
        bibliotecarios = new ArrayList<>();
                bibliotecarios.add(new Bibliotecario(
                "BIB001",
                "Mañana",
                "Encargado de préstamos",
                "0102030405",
                "Juan",
                "Pérez",
                "0991112223",
                java.sql.Date.valueOf("1990-05-12")
        ));

        bibliotecarios.add(new Bibliotecario(
                "BIB002",
                "Tarde",
                "Asistente de biblioteca",
                "0203040506",
                "María",
                "Gómez",
                "0982223334",
                java.sql.Date.valueOf("1992-09-25")
        ));

        bibliotecarios.add(new Bibliotecario(
                "BIB003",
                "Noche",
                "Supervisor",
                "0304050607",
                "Carlos",
                "López",
                "0973334445",
                java.sql.Date.valueOf("1988-01-18")
        ));
    }

    @Override
    public void agregar(Bibliotecario datos) {
        bibliotecarios.add(datos);
    }

    @Override
    public void eliminar(String cedula) {
        for (int i = 0; i < bibliotecarios.size(); i++) {
            if (bibliotecarios.get(i).getCedula().equals(cedula)) {
                bibliotecarios.remove(i);
            }
        }
    }

    @Override
    public Bibliotecario buscar(String cedula) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getCedula().equals(cedula)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Bibliotecario datos) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getCedula().equals(datos.getCedula())) {
                b.setNombre(datos.getNombre());
                b.setApellido(datos.getApellido());
                b.setTelefono(datos.getTelefono());
                b.setFechaNacimiento(datos.getFechaNacimiento());
                b.setCargo(datos.getCargo());
                b.setTurno(datos.getTurno());
            }
        }
    }

    @Override
    public List<Bibliotecario> listar() {
        return bibliotecarios;
    }

    @Override
    public int contar() {
        return bibliotecarios.size();
    }
    
}