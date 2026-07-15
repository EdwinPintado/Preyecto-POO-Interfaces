/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAOMemoria.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.LibroNoEncontrado;
import ec.edu.ups.sistemabiblioteca.Exceptions.PrestamoNoEncontrado;
import ec.edu.ups.sistemabiblioteca.Exceptions.UsuarioNoExiste;
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

        configurarEventosAgregarPrestamo();
        configurarEventosBuscarPrestamo();
        configurarEventosListarPrestamo();
    }

    public void agregarPrestamo() {

        try {

            String codigo = agregarPrestamoView.getjTextFieldCPCodigo().getText().trim();

            if (codigo.isEmpty()) {
                throw new IllegalArgumentException("El código del préstamo no puede estar vacío.");
            }



            String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException("La cédula del usuario no puede estar vacía.");
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Usuario usuario = usuarioDAO.buscar(cedula);

            if (usuario == null) {
                throw new IllegalArgumentException("El usuario con cédula " + cedula + " no existe.");
            }

            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException("El ISBN del libro no puede estar vacío.");
            }

            Libro libro = libroDAO.buscar(isbn);

            if (libro == null) {
                throw new IllegalArgumentException("El libro con ISBN " + isbn + " no existe.");
            }

            if (!libro.isDisponible()) {
                throw new IllegalArgumentException("El libro ya está prestado.");
            }

            String codigoBibliotecario = agregarPrestamoView.getjTextFieldCPBCodigo().getText().trim();

            if (codigoBibliotecario.isEmpty()) {
                throw new IllegalArgumentException("El código del bibliotecario no puede estar vacío.");
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(codigoBibliotecario);

            if (bibliotecario == null) {
                throw new IllegalArgumentException(
                        "El bibliotecario con código " + codigoBibliotecario + " no existe.");
            }

            Date fechaPrestamo;
            Date fechaLimite;

            try {

                fechaPrestamo = Date.valueOf(
                        agregarPrestamoView.getjTextFieldCPFPrestamo().getText().trim());

                fechaLimite = Date.valueOf(
                        agregarPrestamoView.getjTextFieldCPFLimite().getText().trim());

            } catch (IllegalArgumentException e) {

                throw new IllegalArgumentException("El formato de fecha debe ser AAAA-MM-DD.");
            }

            if (fechaLimite.before(fechaPrestamo)) {
                throw new IllegalArgumentException(
                        "La fecha límite debe ser posterior a la fecha del préstamo.");
            }

            Prestamo prestamo = new Prestamo(
                    codigo,
                    fechaPrestamo,
                    fechaLimite,
                    usuario,
                    libro,
                    bibliotecario
            );

            libro.setDisponible(false);

            prestamoDao.agregar(prestamo);

            agregarPrestamoView.mostrarInformacion1("Préstamo creado correctamente");

            agregarPrestamoView.getjTextFieldCPCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPUCedula().setText("");
            agregarPrestamoView.getjTextFieldCPISBNLibro().setText("");
            agregarPrestamoView.getjTextFieldCPBCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPFPrestamo().setText("");
            agregarPrestamoView.getjTextFieldCPFLimite().setText("");

        } catch (IllegalArgumentException e) {

            agregarPrestamoView.mostrarInformacion(e.getMessage());

        } catch (Exception e) {

            agregarPrestamoView.mostrarInformacion(
                    "Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public void buscarPrestamoUsuario() {

        try {

            String cedula = agregarPrestamoView.getjTextFieldCPUCedula()
                    .getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debe ingresar la cédula del usuario."
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        "La cédula debe contener exactamente 10 dígitos."
                );
            }

            Usuario usuario = usuarioDAO.buscar(cedula);

            agregarPrestamoView.getjTextFieldCPUNombre()
                    .setText(usuario.getNombre());

        } catch (UsuarioNoExiste e) {

            agregarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );

            agregarPrestamoView.getjTextFieldCPUNombre()
                    .setText("");

        } catch (IllegalArgumentException e) {

            agregarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void buscarPrestamoLibro() {

        try {

            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro()
                    .getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debe ingresar el ISBN del libro."
                );
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        "El ISBN solo debe contener números."
                );
            }

            Libro libro = libroDAO.buscar(isbn);

            agregarPrestamoView.getjTextFieldCPTLibro()
                    .setText(libro.getTitulo());

        } catch (LibroNoEncontrado e) {

            agregarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );

            agregarPrestamoView.getjTextFieldCPTLibro()
                    .setText("");

        } catch (IllegalArgumentException e) {

            agregarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void buscarPrestamo() {

        try {

            String codigo = buscarPrestamoView.getjTextFieldBPCodigo()
                    .getText().trim();

            if (codigo.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debe ingresar el código del préstamo."
                );
            }

            Prestamo prestamo = prestamoDao.buscar(codigo);

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

        } catch (PrestamoNoEncontrado e) {

            buscarPrestamoView.getjTextFieldBPUCedula().setText("");
            buscarPrestamoView.getjTextFieldBPUNombre().setText("");
            buscarPrestamoView.getjTextFieldBPISBNLibro().setText("");
            buscarPrestamoView.getjTextFieldBPTLibro().setText("");
            buscarPrestamoView.getjTextFieldBPBCodigo().setText("");
            buscarPrestamoView.getjTextFieldBPFPrestamo().setText("");
            buscarPrestamoView.getjTextFieldBPFLimite().setText("");

            buscarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            buscarPrestamoView.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void listarPrestamos() {

        try {

            List<Prestamo> lista = prestamoDao.listar();

            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException("No existen préstamos registrados.");
            }

            listarPrestamoView.cargarDatos(lista);

        } catch (IllegalArgumentException e) {

            listarPrestamoView.mostrarInformacion(e.getMessage());
        }
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
        agregarPrestamoView.getjButtonCPUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamoUsuario();
            }

        });
        agregarPrestamoView.getjButtonCPLBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamoLibro();
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

    public void configurarEventosListarPrestamo() {
        listarPrestamoView.getBtnMostrarListaPrestamo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPrestamos();
                mostrarContadorAutores();
            }

        });
    }
}
