
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.UsuarioNoExiste;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMemoria implements SistemaDAO<Usuario> {

    private List<Usuario> usuarios;

    public UsuarioDAOMemoria() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void agregar(Usuario datos) {
        usuarios.add(datos);
    }

    @Override
    public void eliminar(String cedula) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCedula().equals(cedula)) {
                usuarios.remove(i);
                break;
            }
        }
    }

    @Override
    public Usuario buscar(String cedula) throws UsuarioNoExiste{
        for (Usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u;
            }
        }
        throw new UsuarioNoExiste("No existe usuario con la cedula:"+cedula);
    }
    
    @Override
    public void actualizar(Usuario datos) {
        for (Usuario u : usuarios) {
            if(u.getCedula().equals(datos.getCedula())){
                u.setNombre(datos.getNombre());
                u.setApellido(datos.getApellido());
                u.setTelefono(datos.getTelefono());
                u.setFechaNacimiento(datos.getFechaNacimiento());
                u.setCorreoElectronico(datos.getCorreoElectronico());
                u.setDireccion(datos.getDireccion());
            }
        }
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
   }

    @Override
    public int contar() {
        return usuarios.size();
    }
    
}
