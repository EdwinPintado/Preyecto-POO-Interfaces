/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.UsuarioNoExiste;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface UsuarioDAO {

    void agregar(Usuario usuario);

    Usuario buscar(String cedula) throws UsuarioNoExiste;

    void actualizar(Usuario usuario);

    void eliminar(String cedula);

    List<Usuario> listar();

    int contar();
}
