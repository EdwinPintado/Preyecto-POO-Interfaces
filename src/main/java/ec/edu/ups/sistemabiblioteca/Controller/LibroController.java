package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.models.Libro;
import ec.edu.ups.sistemabiblioteca.view.libro.ActualizarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.BorrarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.BuscarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.CrearLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.ListarLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class LibroController {

    private LibroDAOMemoria libroDAO;
    private AutorDAOMemoria autorDao;

    private CrearLibro crearLibro;
    private BuscarLibro buscarLibro;
    private BorrarLibro eliminarLibro;
    private ActualizarLibro actualizarLibro;
    private ListarLibro listarLibro;
    private String agregarLmsj;
    private String noALmsj; 
    private String LpreMsj; 
    private String Canmsj; 
    private String bALmsj; 
    private String bALddmsj; 
    private String deleLmsj;  
    private String cfmDLmsj; 
    private String afmDLmsj; 
    private String canDLmsj; 
    private String noFDLmsj;
    private String busACLnmsj;
    private String actLmsj; 
    private String cfmALmsj; 
    private String acpACLmsj; 
    private String canACLmsj; 
    private String nfACLmsj; 
    private String cfmLmsj;
    private String fchmsj;
    private String tCLmsj;

    public LibroController(
            LibroDAOMemoria libroDAO,
            AutorDAOMemoria autorDao,
            CrearLibro crearLibro,
            BuscarLibro buscarLibro,
            BorrarLibro eliminarLibro,
            ActualizarLibro actualizarLibro,
            ListarLibro listarLibro) {

        this.libroDAO = libroDAO;
        this.autorDao = autorDao;

        this.crearLibro = crearLibro;
        this.buscarLibro = buscarLibro;
        this.eliminarLibro = eliminarLibro;
        this.actualizarLibro = actualizarLibro;
        this.listarLibro = listarLibro;

        configurarEventosAgregarLibro();
        configurarEventosBuscarLibro();
        configurarEventosEliminarLibro();
        configurarEventosActualizarLibro();
        configurarEventosListarLibro();
        //mensajes
        agregarLmsj = "¿Desea registrar un nuevo libro?";
        noALmsj = "Autor no encontrado";
        LpreMsj = "Libro registrado correctamente :)";
        Canmsj = "Acción cancelada";
        bALmsj = "Error: El usuario con cédula";
        bALddmsj = " no existe.";
        deleLmsj = "¿Desea eliminar el libro: ";
        cfmDLmsj = "Confirmar eliminación";
        afmDLmsj = "Libro eliminado correctamente :)";
        canDLmsj = " eliminar Libro Acción cancelada :(";
        noFDLmsj = "No se encontró el libro";
        busACLnmsj = "Libro no encontrado";
        actLmsj = "¿Desea actualizar el libro: ";
        cfmALmsj = "Confirmar actualización";
        acpACLmsj = "Libro actualizado correctamente :)";
        canACLmsj = "Actualización cancelada :(";
        nfACLmsj = "No se encontró el libro";
        cfmLmsj = "Confirmar";
        fchmsj  = "Error: El formato de fecha debe ser AAAA-MM-DD."; 
        tCLmsj = "Todos los campos deben estar llenados , para guardar el libro";
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarLibro() {

        int respuesta = JOptionPane.showConfirmDialog(crearLibro, agregarLmsj, cfmLmsj, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                String isbn = crearLibro.getjTextFieldLbISBN().getText().trim();
                String titulo = crearLibro.getjTextFieldLbTitulo().getText().trim();
                String editorial = crearLibro.getjTextFieldLbEditorial().getText().trim();
                String fechaTexto = crearLibro.getjTextFieldLbAnio().getText().trim();
                String cedulaAutor = crearLibro.getjTextFieldLbACedula().getText().trim();
                if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty() || fechaTexto.isEmpty() || cedulaAutor.isEmpty()) {
                    crearLibro.mostrarInformacion(tCLmsj);
                }
                Date anio;

                try {
                    anio = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    crearLibro.mostrarInformacion(
                            fchmsj);
                    return;
                }
                Autor autor = autorDao.buscar(cedulaAutor);
                if (autor == null) {
                    crearLibro.mostrarInformacion(noALmsj);
                    return;
                }
                crearLibro.getjTextFieldLbANombre().setText(autor.getNombre());
                Libro libro = new Libro(isbn, titulo, editorial, anio, autor);
                libroDAO.agregar(libro);
                crearLibro.mostrarInformacion1(LpreMsj);
                crearLibro.getjTextFieldLbISBN().setText("");
                crearLibro.getjTextFieldLbTitulo().setText("");
                crearLibro.getjTextFieldLbEditorial().setText("");
                crearLibro.getjTextFieldLbAnio().setText("");
                crearLibro.getjTextFieldLbACedula().setText("");
                crearLibro.getjTextFieldLbANombre().setText("");
            } catch (IllegalArgumentException e) {
                mostrarMensaje(crearLibro, fchmsj, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            crearLibro.mostrarInformacion1(Canmsj);
        }
    }

    public void buscarRegistroLibro() {
        String cedula = crearLibro.getjTextFieldLbACedula().getText().trim();
        Autor autor = autorDao.buscar(cedula);
        if (autor == null) {
            crearLibro.mostrarInformacion(bALmsj + cedula + bALddmsj);
        } else {
            crearLibro.getjTextFieldLbANombre().setText(autor.getNombre());
        }
    }

    public void configurarEventosAgregarLibro() {
        crearLibro.getjButtonLbCLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        crearLibro.getjButtonLbBAutor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistroLibro();
            }

        });
    }

    public void BuscarLibro() {

        String isbn = buscarLibro.getjTextFieldBsISBN().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            buscarLibro.getjTextFieldBsISBN().setText(libro.getIsbn());
            buscarLibro.getjTextFieldBsTitulo().setText(libro.getTitulo());
            buscarLibro.getjTextFieldBsEditorial().setText(libro.getEditorial());
            buscarLibro.getjTextFieldBsAnio().setText(String.valueOf(libro.getAnioPublicacion()));
            buscarLibro.getjTextFieldBsACedula().setText(libro.getAutor().getCedula());
            buscarLibro.getjTextFieldBsANombre().setText(libro.getAutor().getNombre());

        } else {

            buscarLibro.getjTextFieldBsISBN().setText("");
            buscarLibro.getjTextFieldBsTitulo().setText("");
            buscarLibro.getjTextFieldBsEditorial().setText("");
            buscarLibro.getjTextFieldBsAnio().setText("");
            buscarLibro.getjTextFieldBsACedula().setText("");
            buscarLibro.getjTextFieldBsANombre().setText("");

            buscarLibro.mostrarInformacion(noFDLmsj);
        }
    }

    public void configurarEventosBuscarLibro() {
        buscarLibro.getjButtonBsBISBN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarLibro();
            }
        });
    }

    public void buscarEliminarLibro() {

        String isbn = eliminarLibro.getjTextFieldBrISBN().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            eliminarLibro.getjTextFieldBrISBN().setText(libro.getIsbn());
            eliminarLibro.getjTextFieldBrTitulo().setText(libro.getTitulo());
            eliminarLibro.getjTextFieldBrEditorial().setText(libro.getEditorial());
            eliminarLibro.getjTextFieldBrAnio().setText(String.valueOf(libro.getAnioPublicacion()));

        } else {

            eliminarLibro.getjTextFieldBrISBN().setText("");
            eliminarLibro.getjTextFieldBrTitulo().setText("");
            eliminarLibro.getjTextFieldBrEditorial().setText("");
            eliminarLibro.getjTextFieldBrAnio().setText("");

            eliminarLibro.mostrarInformacion(noFDLmsj);
        }
    }

    public void eliminarLibro() {

        String isbn = eliminarLibro.getjTextFieldBrISBN().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarLibro,
                    deleLmsj + libro.getTitulo() + "?",
                    cfmDLmsj,
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                libroDAO.eliminar(isbn);

                eliminarLibro.mostrarInformacion1(afmDLmsj);

                eliminarLibro.getjTextFieldBrISBN().setText("");
                eliminarLibro.getjTextFieldBrTitulo().setText("");
                eliminarLibro.getjTextFieldBrEditorial().setText("");
                eliminarLibro.getjTextFieldBrAnio().setText("");

            } else {
                eliminarLibro.mostrarInformacion(canDLmsj);
            }

        } else {

            eliminarLibro.mostrarInformacion(noFDLmsj);
        }
    }

    public void configurarEventosEliminarLibro() {
        eliminarLibro.getjButtonBrBISBN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarLibro();
            }
        });
        eliminarLibro.getjButtonBrALibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }

    public void buscarActualizarLibro() {
        String cedula = actualizarLibro.getjTextFieldActLACedula().getText();
        String isbn = actualizarLibro.getjTextFieldActISBN().getText();

        Libro libro = libroDAO.buscar(isbn);
        Autor autor = autorDao.buscar(cedula);
        if (libro != null) {

            actualizarLibro.getjTextFieldActLTitulo().setText(libro.getTitulo());
            actualizarLibro.getjTextFieldActLEditorial().setText(libro.getEditorial());
            actualizarLibro.getjTextFieldActLAnio().setText(String.valueOf(libro.getAnioPublicacion()));

        } else {

            actualizarLibro.getjTextFieldActLTitulo().setText("");
            actualizarLibro.getjTextFieldActLEditorial().setText("");
            actualizarLibro.getjTextFieldActLAnio().setText("");
            actualizarLibro.getjTextFieldActLACedula().setText("");

            actualizarLibro.mostrarInformacion(busACLnmsj);
        }
    }

    public void actualizarLibro() {

        String isbn = actualizarLibro.getjTextFieldActISBN().getText();
        Libro libroExistente = libroDAO.buscar(isbn);

        if (libroExistente != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibro,
                    actLmsj + libroExistente.getTitulo() + "?",
                    cfmALmsj,
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                String titulo = actualizarLibro.getjTextFieldActLTitulo().getText();
                String editorial = actualizarLibro.getjTextFieldActLEditorial().getText();
                Date anio = Date.valueOf(actualizarLibro.getjTextFieldActLAnio().getText());

                Libro libroActualizado = new Libro(
                        isbn,
                        titulo,
                        editorial,
                        anio,
                        libroExistente.getAutor()
                );

                libroDAO.actualizar(libroActualizado);

                actualizarLibro.mostrarInformacion1(acpACLmsj);

                actualizarLibro.getjTextFieldActISBN().setText("");
                actualizarLibro.getjTextFieldActLTitulo().setText("");
                actualizarLibro.getjTextFieldActLEditorial().setText("");
                actualizarLibro.getjTextFieldActLAnio().setText("");

            } else {
                actualizarLibro.mostrarInformacion(canACLmsj);
            }

        } else {
            actualizarLibro.mostrarInformacion(nfACLmsj);
        }
    }

    public void configurarEventosActualizarLibro() {
        actualizarLibro.getjButtonActLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarLibro();
            }
        });
        actualizarLibro.getjButtonBsLISBN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLibro();
            }
        });
    }

    public void listarLibro() {
        List<Libro> lista = libroDAO.listar();
        listarLibro.cargarDatos(lista);
    }

    public void mostrarContadorAutores() {

        int total = libroDAO.contar();

        listarLibro.getTxtContadordeLibro().setText(String.valueOf(total));
    }

    public void configurarEventosListarLibro() {

        listarLibro.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                listarLibro();
                mostrarContadorAutores();
            }
        });

    }
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =  ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        agregarLmsj = (bundle.getString("agregarLmsj"));
        noALmsj = (bundle.getString("noALmsj"));
        LpreMsj = (bundle.getString("LpreMsj"));
        Canmsj = (bundle.getString("Canmsj"));
        bALmsj = (bundle.getString("bALmsj"));
        bALddmsj = (bundle.getString("bALddmsj"));
        deleLmsj = (bundle.getString("deleLmsj"));
        cfmDLmsj = (bundle.getString("cfmDLmsj"));
        afmDLmsj = (bundle.getString("afmDLmsj"));
        canDLmsj = (bundle.getString("canDLmsj"));
        noFDLmsj = (bundle.getString("noFDLmsj"));
        busACLnmsj = (bundle.getString("busACLnmsj"));
        actLmsj = (bundle.getString("actLmsj"));
        cfmALmsj = (bundle.getString("cfmALmsj"));
        acpACLmsj = (bundle.getString("acpACLmsj"));
        canACLmsj = (bundle.getString("canACLmsj"));
        nfACLmsj = (bundle.getString("nfACLmsj"));
        cfmLmsj = (bundle.getString("cfmLmsj"));
        fchmsj = (bundle.getString("fchmsj"));
        tCLmsj = (bundle.getString("tCLmsj"));
    }
}
