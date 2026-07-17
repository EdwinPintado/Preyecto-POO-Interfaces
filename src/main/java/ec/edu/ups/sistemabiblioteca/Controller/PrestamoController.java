/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAO;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAO;
import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAO;
import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAO;
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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author katherine
 */
public class PrestamoController {

    private PrestamoDAO prestamoDao;
    private UsuarioDAO usuarioDAO;
    private LibroDAO libroDAO;
    private BibliotecarioDAO bibliotecarioDAO;
    private BuscarPrestamo buscarPrestamoView;
    private CrearPrestamo agregarPrestamoView;
    private ListarPrestamo listarPrestamoView;
    private String agPmsjE;
    private String nfPmsj;
    private String nUPmsj;
    private String nUpmn;
    private String nLPmsj;
    private String prelmsj;
    private String nBPmsj;
    private String datemsj;
    private String dateLmsj;
    private String Plmsj;
    private String ePmsj;
    private String uPmsj;
    private String lPmsj;
    private String busPmsj;
    private String pUmsj;
    private String IsbnPmsj;
    private String bliPmsj;
    private String IDPmsj;
    private String IPmsj;
    private String tPmsj;
    private String IDmsj;
    private String InLmsj;
    private String Isbnmsj;
    private String  efpi;

    public PrestamoController(PrestamoDAO prestamoDao, UsuarioDAO usuarioDAO, LibroDAO libroDAO, BibliotecarioDAO bibliotecarioDAO, BuscarPrestamo buscarPrestamoView, CrearPrestamo agregarPrestamoView, ListarPrestamo listarPrestamoView) {
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
        //mensajes
        agPmsjE = "Error: El código del préstamo no puede estar vacío.";
        nfPmsj = "Ya existe un préstamo con ese código.";
        nUPmsj = "Error: El usuario con cédula ";
        nUpmn = " no existe.";
        nLPmsj = "Error: El libro con ISBN ";
        prelmsj = "El libro ya está prestado.";
        nBPmsj = "Error: El bibliotecario con código ";
        datemsj = "Error: El formato de fecha debe ser YYYY-MM-DD.";
        dateLmsj = "La fecha límite debe ser posterior a la fecha del préstamo.";
        Plmsj = "Préstamo creado correctamente";
        ePmsj = "Ocurrió un error inesperado: ";
        uPmsj = "Error: El usuario con cédula ";
        lPmsj = "Error: El libro con ISBN ";
        busPmsj = "No se encontró el préstamo";
        pUmsj = "La cédula del usuario no puede estar vacía.";
        IsbnPmsj = "El ISBN del libro no puede estar vacío.";
        bliPmsj = "El código del bibliotecario no puede estar vacío.";
        IDPmsj = "Debe ingresar la cédula del usuario.";
        IPmsj = "Debe ingresar el código del préstamo.";
        tPmsj = "No existen préstamos registrados.";
        IDmsj = "La cédula debe contener exactamente 10 dígitos.";
        InLmsj = "Debe ingresar el ISBN del libro.";
        Isbnmsj = "El ISBN solo debe contener números.";
        efpi= "No pueden ser iguales las fechas de prestamo y limite";
    }

    public void agregarPrestamo() {
        try {
            String codigo = agregarPrestamoView.getjTextFieldCPCodigo().getText().trim();
            if (codigo.isEmpty()) {
                throw new IllegalArgumentException(agPmsjE);
            }
            try {
                prestamoDao.buscar(codigo);
                throw new IllegalArgumentException(nfPmsj);
            } catch (PrestamoNoEncontrado e) {

            }

            String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(pUmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }
            Usuario usuario = usuarioDAO.buscar(cedula);
            if (usuario == null) {
                throw new IllegalArgumentException(nUPmsj + cedula + nUpmn);
            }
            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();
            if (isbn.isEmpty()) {
                throw new IllegalArgumentException(IsbnPmsj);
            }

            Libro libro = libroDAO.buscar(isbn);

            if (libro == null) {
                throw new IllegalArgumentException(nLPmsj + isbn + nUpmn);
            }
            String codigoBibliotecario = agregarPrestamoView.getjTextFieldCPBCodigo().getText().trim();
            if (codigoBibliotecario.isEmpty()) {
                throw new IllegalArgumentException(bliPmsj);
            }
            if (!libro.isDisponible()) {
                throw new IllegalArgumentException("El libro ya está prestado.");
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(codigoBibliotecario);

            if (bibliotecario == null) {
                throw new IllegalArgumentException(nBPmsj + codigoBibliotecario + nUpmn);
            }

            Date fechaPrestamo;
            Date fechaLimite;

            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fechaPrestamo = formato.parse(agregarPrestamoView.getjTextFieldCPFPrestamo().getText().trim());
                fechaLimite = formato.parse(agregarPrestamoView.getjTextFieldCPFLimite().getText().trim());
                if (!fechaLimite.after(fechaPrestamo)) {
                    throw new IllegalArgumentException(datemsj);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(efpi);
            }

            Prestamo prestamo = new Prestamo(codigo, fechaPrestamo, fechaLimite, usuario, libro, bibliotecario);
            libro.setDisponible(false);
            libroDAO.actualizar(libro);

            prestamoDao.agregar(prestamo);
            agregarPrestamoView.mostrarInformacion1(Plmsj);
            agregarPrestamoView.getjTextFieldCPCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPUCedula().setText("");
            agregarPrestamoView.getjTextFieldCPISBNLibro().setText("");
            agregarPrestamoView.getjTextFieldCPBCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPFPrestamo().setText("");
            agregarPrestamoView.getjTextFieldCPFLimite().setText("");

        } catch (IllegalArgumentException e) {
            agregarPrestamoView.mostrarInformacion(e.getMessage());
        } catch (Exception e) {
            agregarPrestamoView.mostrarInformacion(ePmsj + e.getMessage());
        }
    }

    public void buscarPrestamoUsuario() {
        String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();
        try {
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(IDPmsj);
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Usuario usuario = usuarioDAO.buscar(cedula);

            if (usuario == null) {
                throw new UsuarioNoExiste(uPmsj + cedula + nUpmn);
            }

            agregarPrestamoView.getjTextFieldCPUNombre().setText(usuario.getNombre());

        } catch (UsuarioNoExiste e) {

            agregarPrestamoView.getjTextFieldCPUNombre().setText("");
            agregarPrestamoView.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {
            agregarPrestamoView.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarPrestamoLibro() {

        try {
            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException(InLmsj
                );
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(Isbnmsj);
            }

            Libro libro = libroDAO.buscar(isbn);

            if (libro == null) {
                throw new LibroNoEncontrado(lPmsj + isbn + nUpmn);
            }

            agregarPrestamoView.getjTextFieldCPTLibro().setText(libro.getTitulo());

        } catch (LibroNoEncontrado e) {
            agregarPrestamoView.mostrarInformacion(e.getMessage());
            agregarPrestamoView.getjTextFieldCPTLibro().setText("");
        } catch (IllegalArgumentException e) {
            agregarPrestamoView.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarPrestamo() {

        try {
            String codigo = buscarPrestamoView.getjTextFieldBPCodigo().getText().trim();
            if (codigo.isEmpty()) {
                throw new IllegalArgumentException(IPmsj);
            }

            Prestamo prestamo = prestamoDao.buscar(codigo);

            buscarPrestamoView.getjTextFieldBPCodigo().setText(prestamo.getCodigoPrestamo());
            buscarPrestamoView.getjTextFieldBPUCedula().setText(prestamo.getUsuario().getCedula());
            buscarPrestamoView.getjTextFieldBPUNombre().setText(prestamo.getUsuario().getNombre());
            buscarPrestamoView.getjTextFieldBPISBNLibro().setText(prestamo.getLibro().getIsbn());
            buscarPrestamoView.getjTextFieldBPTLibro().setText(prestamo.getLibro().getTitulo());
            buscarPrestamoView.getjTextFieldBPBCodigo().setText(prestamo.getBibliotecario().getCodigo());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            buscarPrestamoView.getjTextFieldBPFPrestamo().setText(formato.format(prestamo.getFechaPrestamo()));
            buscarPrestamoView.getjTextFieldBPFLimite().setText(formato.format(prestamo.getFechaDevolucion()));

        } catch (PrestamoNoEncontrado e) {

            buscarPrestamoView.getjTextFieldBPUCedula().setText("");
            buscarPrestamoView.getjTextFieldBPUNombre().setText("");
            buscarPrestamoView.getjTextFieldBPISBNLibro().setText("");
            buscarPrestamoView.getjTextFieldBPTLibro().setText("");
            buscarPrestamoView.getjTextFieldBPBCodigo().setText("");
            buscarPrestamoView.getjTextFieldBPFPrestamo().setText("");
            buscarPrestamoView.getjTextFieldBPFLimite().setText("");
            buscarPrestamoView.mostrarInformacion(busPmsj);

        } catch (IllegalArgumentException e) {
            buscarPrestamoView.mostrarInformacion(e.getMessage());
        }
    }

    public void listarPrestamos() {

        try {
            List<Prestamo> lista = prestamoDao.listar();
            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException(tPmsj);
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

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n.mensajes", locale);
        agPmsjE = (bundle.getString("agPmsjE"));
        nfPmsj = (bundle.getString("nfPmsj"));
        nUPmsj = (bundle.getString("nUPmsj"));
        nUpmn = (bundle.getString("nUpmn"));
        nLPmsj = (bundle.getString("nLPmsj"));
        prelmsj = (bundle.getString("prelmsj"));
        nBPmsj = (bundle.getString("nBPmsj"));
        datemsj = (bundle.getString("datemsj"));
        dateLmsj = (bundle.getString("dateLmsj"));
        Plmsj = (bundle.getString("Plmsj"));
        ePmsj = (bundle.getString("ePmsj"));
        uPmsj = (bundle.getString("uPmsj"));
        lPmsj = (bundle.getString("lPmsj"));
        busPmsj = (bundle.getString("busPmsj"));
        pUmsj = (bundle.getString("pUmsj"));
        IsbnPmsj = (bundle.getString("IsbnPmsj"));
        bliPmsj = (bundle.getString("bliPmsj"));
        IDPmsj = (bundle.getString("IDPmsj"));
        IPmsj = (bundle.getString("IPmsj"));
        tPmsj = (bundle.getString("lPmsj"));
        InLmsj = (bundle.getString("InLmsj"));
        Isbnmsj = (bundle.getString("Isbnmsj"));
        IDmsj = (bundle.getString("IDmsj"));
    }
}
