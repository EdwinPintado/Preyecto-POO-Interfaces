
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
    }
    
    public void mostrarInformacion(java.awt.Component ventana, String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje);
        java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(ventana);
        if (win != null) {
            win.dispose();
        }
    }
    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarLibro() {

        int respuesta = JOptionPane.showConfirmDialog(crearLibro,"¿Desea registrar un nuevo libro?","Confirmar",JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                String isbn = crearLibro.getjTextFieldLbISBN().getText();
                String titulo = crearLibro.getjTextFieldLbTitulo().getText();
                String editorial = crearLibro.getjTextFieldLbEditorial().getText();
                Date anio = Date.valueOf(crearLibro.getjTextFieldLbAnio().getText());
                String cedulaAutor = crearLibro.getjTextFieldLbACedula().getText();
                
                Autor autor = autorDao.buscar(cedulaAutor);
                if (autor == null) {
                    mostrarInformacion(crearLibro, "Autor no encontrado");
                    return;
                }
                crearLibro.getjTextFieldLbANombre().setText(autor.getNombre());
                Libro libro = new Libro(isbn, titulo, editorial, anio, autor);
                libroDAO.agregar(libro);
                mostrarInformacion(crearLibro, "Libro registrado correctamente :)");
                crearLibro.getjTextFieldLbISBN().setText("");
                crearLibro.getjTextFieldLbTitulo().setText("");
                crearLibro.getjTextFieldLbEditorial().setText("");
                crearLibro.getjTextFieldLbAnio().setText("");
                crearLibro.getjTextFieldLbACedula().setText("");
                crearLibro.getjTextFieldLbANombre().setText("");
            } catch (IllegalArgumentException e) {
                mostrarInformacion(crearLibro, "Error: formato de fecha AAAA-MM-DD");
            }
        } else {
            mostrarInformacion(crearLibro, "Acción cancelada");
        }
    }

    public void configurarEventosAgregarLibro() {
        crearLibro.getjButtonLbCLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
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

        } else {

            buscarLibro.getjTextFieldBsISBN().setText("");
            buscarLibro.getjTextFieldBsTitulo().setText("");
            buscarLibro.getjTextFieldBsEditorial().setText("");
            buscarLibro.getjTextFieldBsAnio().setText("");

            mostrarInformacion(buscarLibro, "No se encontró el libro");
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

            mostrarInformacion(eliminarLibro, "No se encontró el libro");
        }
    }

    public void eliminarLibro() {

        String isbn = eliminarLibro.getjTextFieldBrISBN().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarLibro,
                    "¿Desea eliminar el libro: " + libro.getTitulo() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                libroDAO.eliminar(isbn);

                mostrarInformacion(eliminarLibro, "Libro eliminado correctamente :)");

                eliminarLibro.getjTextFieldBrISBN().setText("");
                eliminarLibro.getjTextFieldBrTitulo().setText("");
                eliminarLibro.getjTextFieldBrEditorial().setText("");
                eliminarLibro.getjTextFieldBrAnio().setText("");

            } else {
                mostrarInformacion(eliminarLibro, " eliminarLibroAcción cancelada :(");
            }

        } else {

            mostrarInformacion(eliminarLibro, "No se encontró el libro");
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

            mostrarInformacion(actualizarLibro, "Libro no encontrado");
        }
    }

    public void actualizarLibro() {

        String isbn = actualizarLibro.getjTextFieldActISBN().getText();
        Libro libroExistente = libroDAO.buscar(isbn);

        if (libroExistente != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibro,
                    "¿Desea actualizar el libro: " + libroExistente.getTitulo() + "?",
                    "Confirmar actualización",
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

                mostrarInformacion(actualizarLibro, "Libro actualizado correctamente :)");

                actualizarLibro.getjTextFieldActISBN().setText("");
                actualizarLibro.getjTextFieldActLTitulo().setText("");
                actualizarLibro.getjTextFieldActLEditorial().setText("");
                actualizarLibro.getjTextFieldActLAnio().setText("");

            } else {
                mostrarInformacion(actualizarLibro, "Actualización cancelada :(");
            }

        } else {
            mostrarInformacion(actualizarLibro, "No se encontró el libro");
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
}
