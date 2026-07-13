/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import ec.edu.ups.sistemabiblioteca.models.Libro;
import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import ec.edu.ups.sistemabiblioteca.view.prestamo.BuscarPrestamo;
import ec.edu.ups.sistemabiblioteca.view.prestamo.CrearPrestamo;
import ec.edu.ups.sistemabiblioteca.view.prestamo.ListarPrestamo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author katherine
 */
public class PrestamoController {

    private PrestamoDAOMemoria prestamoDao;
    private UsuarioDAOMemoria usuarioDAO;
    private LibroDAOMemoria libroDAO;
    private BibliotecarioDAOMemoria bibliotecarioDAO;

    private BuscarPrestamo buscarPrestamoView;
    private CrearPrestamo agregarPrestamoView;
    private ListarPrestamo listarPrestamoView;

    public PrestamoController(PrestamoDAOMemoria prestamoDao, UsuarioDAOMemoria usuarioDAO, LibroDAOMemoria libroDAO, BibliotecarioDAOMemoria bibliotecarioDAO, BuscarPrestamo buscarPrestamoView, CrearPrestamo agregarPrestamoView, ListarPrestamo listarPrestamoView) {
        this.prestamoDao = prestamoDao;
        this.usuarioDAO = usuarioDAO;
        this.libroDAO = libroDAO;
        this.bibliotecarioDAO = bibliotecarioDAO;
        this.buscarPrestamoView = buscarPrestamoView;
        this.agregarPrestamoView = agregarPrestamoView;
        this.listarPrestamoView = listarPrestamoView;
    }

    public void agregarPrestamo() {
        try {
            String codigo = agregarPrestamoView.getjTextFieldCPCodigo().getText().trim();
            if (codigo.isEmpty()) {
                agregarPrestamoView.mostrarInformacion("Error: El código del préstamo no puede estar vacío.");
                return; // Detiene la ejecución del método
            }

            String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();
            Usuario usuario = usuarioDAO.buscar(cedula);
            if (usuario == null) {
                agregarPrestamoView.mostrarInformacion("Error: El usuario con cédula " + cedula + " no existe.");
                return;
            }

            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();
            Libro libro = libroDAO.buscar(isbn);
            if (libro == null) {
                agregarPrestamoView.mostrarInformacion("Error: El libro con ISBN " + isbn + " no existe.");
                return;
            }

            String codigoBibliotecario = agregarPrestamoView.getjTextFieldCPBCodigo().getText().trim();
            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(codigoBibliotecario);
            if (bibliotecario == null) {
                agregarPrestamoView.mostrarInformacion("Error: El bibliotecario con código " + codigoBibliotecario + " no existe.");
                return;
            }

            Date fecha;
            Date fechaLimite;
            try {
                fecha = Date.valueOf(agregarPrestamoView.getjTextFieldCPFPrestamo().getText().trim());
                fechaLimite = Date.valueOf(agregarPrestamoView.getjTextFieldCPFLimite().getText().trim());
            } catch (IllegalArgumentException e) {
                agregarPrestamoView.mostrarInformacion("Error: El formato de fecha debe ser YYYY-MM-DD.");
                return;
            }

            Prestamo prestamo = new Prestamo(
                    codigo,
                    fecha,
                    fechaLimite,
                    usuario,
                    libro,
                    bibliotecario
            );

            prestamoDao.agregar(prestamo); // Nota: En tu constructor usas 'prestamoDao' en minúscula, asegúrate de que coincida con tu variable de clase.

            agregarPrestamoView.mostrarInformacion("Préstamo creado correctamente");

        } catch (Exception e) {
            agregarPrestamoView.mostrarInformacion("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public void buscarPrestamo() {

        String codigo = buscarPrestamoView.getjTextFieldBPCodigo().getText();

        Prestamo prestamo = prestamoDao.buscar(codigo);

        if (prestamo != null) {

            buscarPrestamoView.getjTextFieldBPCodigo()
                    .setText(prestamo.getCodigoPrestamo());

            buscarPrestamoView.getjTextFieldBPUCedula()
                    .setText(prestamo.getUsuario().getCedula());

            buscarPrestamoView.getjTextFieldBPUNombre()
                    .setText(prestamo.getUsuario().getNombre());

            buscarPrestamoView.getjTextFieldBPISBNLibro()
                    .setText(prestamo.getLibro().getIsbn());

            buscarPrestamoView.getjTextFieldBPTLibro()
                    .setText(prestamo.getLibro().getTitulo());

            buscarPrestamoView.getjTextFieldBPBCodigo()
                    .setText(prestamo.getBibliotecario().getCodigo());

            buscarPrestamoView.getjTextFieldBPFPrestamo()
                    .setText(String.valueOf(prestamo.getFechaPrestamo()));

            buscarPrestamoView.getjTextFieldBPFLimite()
                    .setText(String.valueOf(prestamo.getFechaDevolucion()));

        } else {

            buscarPrestamoView.getjTextFieldBPUCedula().setText("");
            buscarPrestamoView.getjTextFieldBPUNombre().setText("");
            buscarPrestamoView.getjTextFieldBPISBNLibro().setText("");
            buscarPrestamoView.getjTextFieldBPTLibro().setText("");
            buscarPrestamoView.getjTextFieldBPBCodigo().setText("");
            buscarPrestamoView.getjTextFieldBPFPrestamo().setText("");
            buscarPrestamoView.getjTextFieldBPFLimite().setText("");

            buscarPrestamoView.mostrarInformacion("No se encontró el préstamo");
        }
    }

    public void listarPrestamos() {

        List<Prestamo> lista = prestamoDao.listar();

        listarPrestamoView.cargarDatos(lista);

    }

    public void mostrarContadorAutores() {

        int total = prestamoDao.contar();

        listarPrestamoView.getTxtContadordePrestamo().setText(String.valueOf(total));
    }

    public void configurarEventosAgregarPrestamo() {

        agregarPrestamoView.getjButtonCPCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPrestamo();
            }
        });

    }

    public void configurarEventosBuscarPrestamo() {

        buscarPrestamoView.getjButtonBuscarPresamo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamo();
            }
        });

    }
    public void configurarEventosListarPrestamo(){
        listarPrestamoView.getBtnMostrarListaPrestamo().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPrestamos();
                mostrarContadorAutores();
            }
            
        });
    }
}
