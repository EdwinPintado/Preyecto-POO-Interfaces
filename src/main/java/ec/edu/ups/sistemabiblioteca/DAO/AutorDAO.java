/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.AutorNoEncontradoException;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface AutorDAO {

    void agregar(Autor autor);

    Autor buscar(String codigo) throws AutorNoEncontradoException;

    void actualizar(Autor autor);

    void eliminar(String codigo);

    List<Autor> listar();

    int contar();
}
