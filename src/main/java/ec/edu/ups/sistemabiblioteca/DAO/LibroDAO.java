/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.LibroNoEncontrado;
import ec.edu.ups.sistemabiblioteca.models.Libro;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface LibroDAO {

    void agregar(Libro libro);

    Libro buscar(String isbn) throws LibroNoEncontrado;

    void actualizar(Libro libro) throws LibroNoEncontrado;

    void eliminar(String isbn) throws LibroNoEncontrado;

    List<Libro> listar();

    int contar();
}
