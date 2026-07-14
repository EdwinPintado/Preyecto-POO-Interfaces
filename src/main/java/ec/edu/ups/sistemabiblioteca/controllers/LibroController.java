
package ec.edu.ups.sistemabiblioteca.controllers;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAOMemoria;
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

    public void agregarLibro() {

        int respuesta = JOptionPane.showConfirmDialog(crearLibro,"¿Desea registrar un nuevo libro?","Confirmar",JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                String isbn = crearLibro.getTxtAgregarLibroISBN().getText();
                String titulo = crearLibro.getTxtTituloLibroRegistro().getText();
                String editorial = crearLibro.getTxtAgregarEditorialLibro().getText();
                Date anio = Date.valueOf(crearLibro.getTxtAnioPublicacionLibro().getText());
                String cedulaAutor = crearLibro.getTxtRegistrarLibroAutorNom().getText();
                Autor autor = autorDao.buscar(cedulaAutor);
                if (autor == null) {
                    agregarLibroView.mostrarInformacion("Autor no encontrado");
                    return;
                }
                agregarLibroView.getTxtRegistrarLibroNombreAutor().setText(autor.getNombre());
                Libro libro = new Libro(isbn, titulo, editorial, anio, autor);
                libroDAO.agregar(libro);
                agregarLibroView.mostrarInformacion("Libro registrado correctamente :)");
                agregarLibroView.getTxtAgregarLibroISBN().setText("");
                agregarLibroView.getTxtTituloLibroRegistro().setText("");
                agregarLibroView.getTxtAgregarEditorialLibro().setText("");
                agregarLibroView.getTxtAnioPublicacionLibro().setText("");
                agregarLibroView.getTxtRegistrarLibroAutorNom().setText("");
                agregarLibroView.getTxtRegistrarLibroNombreAutor().setText("");
            } catch (IllegalArgumentException e) {
                agregarLibroView.mostrarInformacion("Error: formato de fecha AAAA-MM-DD");
            }
        } else {
            agregarLibroView.mostrarInformacion("Acción cancelada");
        }
    }

    public void configurarEventosAgregarLibro() {
        agregarLibroView.getBtnRegistrarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
    }

    public void BuscarLibro() {

        String isbn = buscarLibroView.getTxtBuscarLibroIsbN().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            buscarLibroView.getTxtBuscarLibroIsbN().setText(libro.getIsbn());
            buscarLibroView.getTxtBuscarLibroTitulo().setText(libro.getTitulo());
            buscarLibroView.getTxtBuscarLibroEditorial().setText(libro.getEditorial());
            buscarLibroView.getTxtBuscarLibroAnio().setText(String.valueOf(libro.getAnioPublicacion()));

        } else {

            buscarLibroView.getTxtBuscarLibroIsbN().setText("");
            buscarLibroView.getTxtBuscarLibroTitulo().setText("");
            buscarLibroView.getTxtBuscarLibroEditorial().setText("");
            buscarLibroView.getTxtBuscarLibroAnio().setText("");

            buscarLibroView.mostrarInformacion("No se encontró el libro");
        }
    }

    public void configurarEventosBuscarLibro() {
        buscarLibroView.getBtnBuscarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarLibro();
            }
        });
    }

    public void buscarEliminarLibro() {

        String isbn = eliminarLibroView.getTxtEiminarLibro().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            eliminarLibroView.getTxtEiminarLibro().setText(libro.getIsbn());
            eliminarLibroView.getTxtEliminarLibroTitulo().setText(libro.getTitulo());
            eliminarLibroView.getTxtEliminarLibroEditorial().setText(libro.getEditorial());
            eliminarLibroView.getTxtEliminarLibroAnio().setText(String.valueOf(libro.getAnioPublicacion()));

        } else {

            eliminarLibroView.getTxtEiminarLibro().setText("");
            eliminarLibroView.getTxtEliminarLibroTitulo().setText("");
            eliminarLibroView.getTxtEliminarLibroEditorial().setText("");
            eliminarLibroView.getTxtEliminarLibroAnio().setText("");

            eliminarLibroView.mostrarInformacion("No se encontró el libro");
        }
    }

    public void eliminarLibro() {

        String isbn = eliminarLibroView.getTxtEiminarLibro().getText();
        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarLibroView,
                    "¿Desea eliminar el libro: " + libro.getTitulo() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                libroDAO.eliminar(isbn);

                eliminarLibroView.mostrarInformacion("Libro eliminado correctamente :)");

                eliminarLibroView.getTxtEiminarLibro().setText("");
                eliminarLibroView.getTxtEliminarLibroTitulo().setText("");
                eliminarLibroView.getTxtEliminarLibroEditorial().setText("");
                eliminarLibroView.getTxtEliminarLibroAnio().setText("");

            } else {
                eliminarLibroView.mostrarInformacion("Acción cancelada :(");
            }

        } else {

            eliminarLibroView.mostrarInformacion("No se encontró el libro");
        }
    }

    public void configurarEventosEliminarLibro() {
        eliminarLibroView.getBtnEliminarLibroBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarLibro();
            }
        });
        eliminarLibroView.getBtnEliminarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }

    public void buscarActualizarLibro() {
        String cedula = actualizarLibroView.getTxtActualizarLibroAutor().getText();
        String isbn = actualizarLibroView.getTxtActualizarLibroIsbn().getText();

        Libro libro = libroDAO.buscar(isbn);
        Autor autor = autorDao.buscar(cedula);
        if (libro != null) {

            actualizarLibroView.getTxtActualizarLibroTitulo().setText(libro.getTitulo());
            actualizarLibroView.getTxtActualizarLibroEditorial().setText(libro.getEditorial());
            actualizarLibroView.getTxtActualizarLibroAnio().setText(String.valueOf(libro.getAnioPublicacion()));

        } else {

            actualizarLibroView.getTxtActualizarLibroTitulo().setText("");
            actualizarLibroView.getTxtActualizarLibroEditorial().setText("");
            actualizarLibroView.getTxtActualizarLibroAnio().setText("");
            actualizarLibroView.getTxtActualizarLibroAutor().setText("");

            actualizarLibroView.mostrarInformacion("Libro no encontrado");
        }
    }

    public void actualizarLibro() {

        String isbn = actualizarLibroView.getTxtActualizarLibroIsbn().getText();
        Libro libroExistente = libroDAO.buscar(isbn);

        if (libroExistente != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibroView,
                    "¿Desea actualizar el libro: " + libroExistente.getTitulo() + "?",
                    "Confirmar actualización",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                String titulo = actualizarLibroView.getTxtActualizarLibroTitulo().getText();
                String editorial = actualizarLibroView.getTxtActualizarLibroEditorial().getText();
                Date anio = Date.valueOf(actualizarLibroView.getTxtActualizarLibroAnio().getText());

                Libro libroActualizado = new Libro(
                        isbn,
                        titulo,
                        editorial,
                        anio,
                        libroExistente.getAutor()
                );

                libroDAO.actualizar(libroActualizado);

                actualizarLibroView.mostrarInformacion("Libro actualizado correctamente :)");

                actualizarLibroView.getTxtActualizarLibroIsbn().setText("");
                actualizarLibroView.getTxtActualizarLibroTitulo().setText("");
                actualizarLibroView.getTxtActualizarLibroEditorial().setText("");
                actualizarLibroView.getTxtActualizarLibroAnio().setText("");

            } else {
                actualizarLibroView.mostrarInformacion("Actualización cancelada :(");
            }

        } else {
            actualizarLibroView.mostrarInformacion("No se encontró el libro");
        }
    }

    public void configurarEventosActualizarLibro() {
        actualizarLibroView.getBtnActualizarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarLibro();
            }
        });
        actualizarLibroView.getBtnActualizarLibroB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLibro();
            }
        });
    }

    public void listarLibro() {
        List<Libro> lista = libroDAO.listar();
        listarLibroView.cargarDatos(lista);
    }

    public void mostrarContadorAutores() {

        int total = libroDAO.contar();

        listarLibroView.getTxtContadorLibro().setText(String.valueOf(total));
    }

    public void configurarEventosListarLibro() {

        listarLibroView.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                listarLibro();
                mostrarContadorAutores();
            }
        });

    }
}
