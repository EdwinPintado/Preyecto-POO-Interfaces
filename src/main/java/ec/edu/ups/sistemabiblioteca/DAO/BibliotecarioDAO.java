/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface BibliotecarioDAO {

    void agregar(Bibliotecario bibliotecario);

    Bibliotecario buscar(String cedula) throws Exception;

    void actualizar(Bibliotecario bibliotecario);

    void eliminar(String cedula);

    List<Bibliotecario> listar();

    int contar();
}
