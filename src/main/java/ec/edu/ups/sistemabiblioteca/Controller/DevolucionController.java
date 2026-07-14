/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.DevolucionDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Devolucion;
import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import ec.edu.ups.sistemabiblioteca.view.devolucion.ListarDevolucion;
import ec.edu.ups.sistemabiblioteca.view.devolucion.RealizarDevolucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author katherine
 */
public class DevolucionController {

    private DevolucionDAOMemoria devolucionDAO;
    private PrestamoDAOMemoria prestamoDAO;

    private RealizarDevolucion agregarDevolucionView;
    private ListarDevolucion listarDevolucionView;

    public DevolucionController(DevolucionDAOMemoria devolucionDAO, PrestamoDAOMemoria prestamoDAO, RealizarDevolucion agregarDevolucionView, ListarDevolucion listarDevolucionView) {
        this.devolucionDAO = devolucionDAO;
        this.prestamoDAO = prestamoDAO;
        this.agregarDevolucionView = agregarDevolucionView;
        this.listarDevolucionView = listarDevolucionView;
        
        configurarEventosBuscarDevolucion();
        configurarEventosListarDevoluciones();
       
    }

    public void buscarDevolucion() {
        String codigo = agregarDevolucionView.getjTextFieldDCodigo().getText();
        Prestamo prestamo = prestamoDAO.buscar(codigo);
        if (prestamo != null) {
            agregarDevolucionView.getjTextFieldDUCedula().setText(prestamo.getUsuario().getCedula());
            agregarDevolucionView.getjTextFieldDUNombre().setText(prestamo.getUsuario().getNombre());
            agregarDevolucionView.getjTextFieldDISBNLibro().setText(prestamo.getLibro().getIsbn());
            agregarDevolucionView.getjTextFieldDTLibro().setText(prestamo.getLibro().getTitulo());
            agregarDevolucionView.getjTextFieldDBCodigo().setText(prestamo.getBibliotecario().getCodigo());
            agregarDevolucionView.getjTextFieldDFPrestamo().setText(String.valueOf(prestamo.getFechaPrestamo()));
        } else {
            agregarDevolucionView.mostrarInformacion("No existe ese prestamo");
            agregarDevolucionView.getjTextFieldDUCedula().setText(" ");
            agregarDevolucionView.getjTextFieldDUNombre().setText(" ");
            agregarDevolucionView.getjTextFieldDISBNLibro().setText(" ");
            agregarDevolucionView.getjTextFieldDTLibro().setText(" ");
            agregarDevolucionView.getjTextFieldDBCodigo().setText(" ");
            agregarDevolucionView.getjTextFieldDFPrestamo().setText(" ");
            agregarDevolucionView.getjTextFieldDFLimite().setText(" ");
        }
        Date fechaDevolucion=Date.valueOf(agregarDevolucionView.getjTextFieldDFPrestamo().getText());
        
        Devolucion devolucion = new Devolucion(prestamo , fechaDevolucion);
        devolucionDAO.agregar(devolucion);
        agregarDevolucionView.mostrarInformacion("Devolcuion exitosa ,tenga buen dia");
    }
    public void listarDevoluciones() {

        List<Devolucion> lista = devolucionDAO.listar();

        listarDevolucionView.cargarDatos(lista);

    }
    public void contadorDevolucion(){
        int total = devolucionDAO.contar();
        listarDevolucionView.getTxtContadordeDevoluciones().setText(String.valueOf(total));
                
    }

    public void configurarEventosBuscarDevolucion() {

        agregarDevolucionView.getjButtonBuscarPresamoD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDevolucion();
            }
        });

    }

    public void configurarEventosListarDevoluciones() {

       listarDevolucionView.getBtnMostrarListaDevoluciones().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               listarDevoluciones();
               contadorDevolucion();
           }
           
       });
       

    }

}
