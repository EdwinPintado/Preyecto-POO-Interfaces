/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAO;

import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import java.util.List;

/**
 *
 * @author katherine
 */
public interface PrestamoDAO {

    void agregar(Prestamo prestamo);

    Prestamo buscar(String codigo) throws Exception;

    void actualizar(Prestamo prestamo);

    void eliminar(String codigo);

    List<Prestamo> listar();

    int contar();
}
