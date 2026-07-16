/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAOMemoria.DevolucionDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.PrestamoNoEncontrado;
import ec.edu.ups.sistemabiblioteca.models.Devolucion;
import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import ec.edu.ups.sistemabiblioteca.view.devolucion.ListarDevolucion;
import ec.edu.ups.sistemabiblioteca.view.devolucion.RealizarDevolucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author katherine
 */
public class DevolucionController {

    private DevolucionDAOMemoria devolucionDAO;
    private PrestamoDAOMemoria prestamoDAO;

    private RealizarDevolucion agregarDevolucionView;
    private ListarDevolucion listarDevolucionView;
    private String agregarDmsj;
    private String noagDmsj;
    private String lDmsj;
    private String dDsmjs;
    private String fchmsj;

    public DevolucionController(DevolucionDAOMemoria devolucionDAO, PrestamoDAOMemoria prestamoDAO, RealizarDevolucion agregarDevolucionView, ListarDevolucion listarDevolucionView) {
        this.devolucionDAO = devolucionDAO;
        this.prestamoDAO = prestamoDAO;
        this.agregarDevolucionView = agregarDevolucionView;
        this.listarDevolucionView = listarDevolucionView;

        configurarEventosBuscarDevolucion();
        configurarEventosListarDevoluciones();
        //mensajes
        agregarDmsj = "Devolucion exitosa ,tenga buen dia";
        noagDmsj = "No existe ese prestamo";
        lDmsj = "No existen devoluciones registradas.";
        dDsmjs = "Debe ingresar un código de préstamo.";
        fchmsj = "Error: El formato de fecha debe ser DD-MM-YYYY.";
        

    }

    public void buscarDevolucion() {

        try {

            String codigo = agregarDevolucionView.getjTextFieldDCodigo().getText().trim();

            if (codigo.isEmpty()) {
                throw new IllegalArgumentException(dDsmjs);
            }

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            agregarDevolucionView.getjTextFieldDUCedula()
                    .setText(prestamo.getUsuario().getCedula());

            agregarDevolucionView.getjTextFieldDUNombre()
                    .setText(prestamo.getUsuario().getNombre());

            agregarDevolucionView.getjTextFieldDISBNLibro()
                    .setText(prestamo.getLibro().getIsbn());

            agregarDevolucionView.getjTextFieldDTLibro()
                    .setText(prestamo.getLibro().getTitulo());

            agregarDevolucionView.getjTextFieldDBCodigo()
                    .setText(prestamo.getBibliotecario().getCodigo());

            agregarDevolucionView.getjTextFieldDFPrestamo()
                    .setText(String.valueOf(prestamo.getFechaPrestamo()));

            Date fechaDevolucion;

            try {

                fechaDevolucion = Date.valueOf(
                        agregarDevolucionView.getjTextFieldDFPrestamo().getText().trim()
                );

            } catch (IllegalArgumentException e) {

                throw new IllegalArgumentException(
                        fchmsj
                );
            }

        } catch (PrestamoNoEncontrado e) {

            agregarDevolucionView.mostrarInformacion(e.getMessage());

            agregarDevolucionView.getjTextFieldDUCedula().setText("");
            agregarDevolucionView.getjTextFieldDUNombre().setText("");
            agregarDevolucionView.getjTextFieldDISBNLibro().setText("");
            agregarDevolucionView.getjTextFieldDTLibro().setText("");
            agregarDevolucionView.getjTextFieldDBCodigo().setText("");
            agregarDevolucionView.getjTextFieldDFPrestamo().setText("");
            agregarDevolucionView.getjTextFieldDFLimite().setText("");

        } catch (IllegalArgumentException e) {

            agregarDevolucionView.mostrarInformacion(e.getMessage());
        }
    }
    public void devulucion(){
        try {

            String codigo = agregarDevolucionView.getjTextFieldDCodigo().getText().trim();

            if (codigo.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar un código de préstamo.");
            }

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            agregarDevolucionView.getjTextFieldDUCedula()
                    .setText(prestamo.getUsuario().getCedula());

            agregarDevolucionView.getjTextFieldDUNombre()
                    .setText(prestamo.getUsuario().getNombre());

            agregarDevolucionView.getjTextFieldDISBNLibro()
                    .setText(prestamo.getLibro().getIsbn());

            agregarDevolucionView.getjTextFieldDTLibro()
                    .setText(prestamo.getLibro().getTitulo());

            agregarDevolucionView.getjTextFieldDBCodigo()
                    .setText(prestamo.getBibliotecario().getCodigo());

            agregarDevolucionView.getjTextFieldDFPrestamo()
                    .setText(String.valueOf(prestamo.getFechaPrestamo()));

            Date fechaDevolucion;

            try {

                fechaDevolucion = Date.valueOf(
                        agregarDevolucionView.getjTextFieldDFLimite().getText().trim()
                );

            } catch (IllegalArgumentException e) {

                throw new IllegalArgumentException(
                        "El formato de fecha debe ser AAAA-MM-DD."
                );
            }

            Devolucion devolucion = new Devolucion(prestamo, fechaDevolucion);

            devolucionDAO.agregar(devolucion);

            if (prestamo.getLibro() != null) {
                prestamo.getLibro().setDisponible(true);
            }

            agregarDevolucionView.mostrarInformacion1(agregarDmsj);

        } catch (PrestamoNoEncontrado e) {

            agregarDevolucionView.mostrarInformacion(noagDmsj);

            agregarDevolucionView.getjTextFieldDUCedula().setText("");
            agregarDevolucionView.getjTextFieldDUNombre().setText("");
            agregarDevolucionView.getjTextFieldDISBNLibro().setText("");
            agregarDevolucionView.getjTextFieldDTLibro().setText("");
            agregarDevolucionView.getjTextFieldDBCodigo().setText("");
            agregarDevolucionView.getjTextFieldDFPrestamo().setText("");
            agregarDevolucionView.getjTextFieldDFLimite().setText("");

        } catch (IllegalArgumentException e) {

            agregarDevolucionView.mostrarInformacion(e.getMessage());
        }
    }

    public void listarDevoluciones() {

        try {

            List<Devolucion> lista = devolucionDAO.listar();

            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException(lDmsj);
            }

            listarDevolucionView.cargarDatos(lista);

        } catch (IllegalArgumentException e) {

            listarDevolucionView.mostrarInformacion(e.getMessage());
        }
    }

    public void contadorDevolucion() {
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
        agregarDevolucionView.getjButtonDevolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                devulucion();
            }
            
        });

    }

    public void configurarEventosListarDevoluciones() {

        listarDevolucionView.getBtnMostrarListaDevoluciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarDevoluciones();
                contadorDevolucion();
            }

        });

    }

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n.mensajes", locale);
        agregarDmsj = (bundle.getString("agregarDmsj"));
        noagDmsj = (bundle.getString("noagDmsj"));
        lDmsj = (bundle.getString("lDmsj"));
        dDsmjs = (bundle.getString("dDmsj"));
        fchmsj = (bundle.getString("fchmsj"));

    }


}
