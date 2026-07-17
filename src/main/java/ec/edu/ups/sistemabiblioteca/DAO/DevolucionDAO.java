/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.Exceptions.DevolucionNoEncontradaException;
import ec.edu.ups.sistemabiblioteca.models.Devolucion;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface DevolucionDAO {

    void agregar(Devolucion devolucion);

    Devolucion buscar(String codigo) throws DevolucionNoEncontradaException;

    void actualizar(Devolucion devolucion);

    void eliminar(String codigo);

    List<Devolucion> listar();

    int contar();
}
