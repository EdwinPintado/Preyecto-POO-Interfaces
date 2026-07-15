/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Libro;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface LibroDAO {

    void agregar(Libro libro);

    Libro buscar(String isbn) throws Exception;

    void actualizar(Libro libro);

    void eliminar(String isbn);

    List<Libro> listar();

    int contar();
}
