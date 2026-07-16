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
import java.util.Locale;
import java.util.ResourceBundle;

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
        //mensajes
        agPmsjE = "Error: El código del préstamo no puede estar vacío.";
        nfPmsj = "Ya existe un préstamo con ese código.";
        nUPmsj = "Error: El usuario con cédula ";
        nUpmn = " no existe.";
        nLPmsj = "Error: El libro con ISBN ";
        prelmsj =  "El libro ya está prestado.";
        nBPmsj = "Error: El bibliotecario con código ";
        datemsj = "Error: El formato de fecha debe ser YYYY-MM-DD.";
        dateLmsj =  "La fecha límite debe ser posterior a la fecha del préstamo.";
        Plmsj = "Préstamo creado correctamente";
        ePmsj = "Ocurrió un error inesperado: ";
        uPmsj = "Error: El usuario con cédula ";
        lPmsj = "Error: El libro con ISBN ";
        busPmsj = "No se encontró el préstamo";
        
    }

    public void agregarPrestamo() {
        try {
            String codigo = agregarPrestamoView.getjTextFieldCPCodigo().getText().trim();
            if (codigo.isEmpty()) {
                agregarPrestamoView.mostrarInformacion(agPmsjE);
                return;
            }
            if (prestamoDao.buscar(codigo) != null) {
                agregarPrestamoView.mostrarInformacion(nfPmsj);
                return;
            }
            String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();

            Usuario usuario = usuarioDAO.buscar(cedula);
            if (usuario == null) {
                agregarPrestamoView.mostrarInformacion(nUPmsj + cedula + nUpmn);
                return;
            }
            String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();
            Libro libro = libroDAO.buscar(isbn);
            if (libro == null) {
                agregarPrestamoView.mostrarInformacion(nLPmsj + isbn + nUpmn);
                return;

            }
            if (!libro.isDisponible()) {
                agregarPrestamoView.mostrarInformacion(
                        prelmsj);
                return;
            }
            String codigoBibliotecario = agregarPrestamoView.getjTextFieldCPBCodigo().getText().trim();
            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(codigoBibliotecario);
            if (bibliotecario == null) {
                agregarPrestamoView.mostrarInformacion(nBPmsj + codigoBibliotecario + nUpmn);
                return;
            }

            Date fechaPrestamo;
            Date fechaLimite;
            try {
                fechaPrestamo = Date.valueOf(agregarPrestamoView.getjTextFieldCPFPrestamo().getText().trim());
                fechaLimite = Date.valueOf(agregarPrestamoView.getjTextFieldCPFLimite().getText().trim());
            } catch (IllegalArgumentException e) {
                agregarPrestamoView.mostrarInformacion(datemsj);
                return;
            }
            if (fechaLimite.before(fechaPrestamo)) {
                agregarPrestamoView.mostrarInformacion(
                        dateLmsj);
                return;
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

            agregarPrestamoView.mostrarInformacion1(Plmsj);
            agregarPrestamoView.getjTextFieldCPCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPUCedula().setText("");
            agregarPrestamoView.getjTextFieldCPISBNLibro().setText("");
            agregarPrestamoView.getjTextFieldCPBCodigo().setText("");
            agregarPrestamoView.getjTextFieldCPFPrestamo().setText("");
            agregarPrestamoView.getjTextFieldCPFLimite().setText("");

        } catch (Exception e) {
            agregarPrestamoView.mostrarInformacion(ePmsj + e.getMessage());
        }
    }

    public void buscarPrestamoUsuario() {
        String cedula = agregarPrestamoView.getjTextFieldCPUCedula().getText().trim();
        Usuario usuario = usuarioDAO.buscar(cedula);
        if (usuario == null) {
            agregarPrestamoView.mostrarInformacion(uPmsj + cedula + nUpmn);
        } else {
            agregarPrestamoView.getjTextFieldCPUNombre().setText(usuario.getNombre());
        }
    }

    public void buscarPrestamoLibro() {
        String isbn = agregarPrestamoView.getjTextFieldCPISBNLibro().getText().trim();
        Libro libro = libroDAO.buscar(isbn);
        if (libro == null) {
            agregarPrestamoView.mostrarInformacion(lPmsj + isbn + nUpmn);

        } else {
            agregarPrestamoView.getjTextFieldCPTLibro().setText(libro.getTitulo());
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

            buscarPrestamoView.mostrarInformacion(busPmsj);
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
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =  ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
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
    }
}
