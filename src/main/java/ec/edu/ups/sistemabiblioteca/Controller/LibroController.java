package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.AutorNoEncontradoException;
import ec.edu.ups.sistemabiblioteca.Exceptions.LibroNoEncontrado;
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

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarLibro() {

        int respuesta = JOptionPane.showConfirmDialog(
                crearLibro,
                "¿Desea registrar un nuevo libro?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                String isbn = crearLibro.getjTextFieldLbISBN().getText().trim();
                String titulo = crearLibro.getjTextFieldLbTitulo().getText().trim();
                String editorial = crearLibro.getjTextFieldLbEditorial().getText().trim();
                String fechaTexto = crearLibro.getjTextFieldLbAnio().getText().trim();
                String cedulaAutor = crearLibro.getjTextFieldLbACedula().getText().trim();

                if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()
                        || fechaTexto.isEmpty() || cedulaAutor.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Todos los campos deben estar llenos para guardar el libro.");
                }

                if (!isbn.matches("\\d+")) {
                    throw new IllegalArgumentException(
                            "El ISBN solo debe contener números.");
                }

                if (!titulo.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ0-9 ]+")) {
                    throw new IllegalArgumentException(
                            "El título contiene caracteres no válidos.");
                }

                if (!editorial.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            "La editorial solo puede contener letras.");
                }

                Date anio;

                try {

                    anio = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            "El formato de fecha debe ser AAAA-MM-DD.");
                }

                Autor autor = autorDao.buscar(cedulaAutor);

                crearLibro.getjTextFieldLbANombre()
                        .setText(autor.getNombre());

                Libro libro = new Libro(
                        isbn,
                        titulo,
                        editorial,
                        anio,
                        autor
                );

                libroDAO.agregar(libro);

                crearLibro.mostrarInformacion1(
                        "Libro registrado correctamente :)");

                crearLibro.getjTextFieldLbISBN().setText("");
                crearLibro.getjTextFieldLbTitulo().setText("");
                crearLibro.getjTextFieldLbEditorial().setText("");
                crearLibro.getjTextFieldLbAnio().setText("");
                crearLibro.getjTextFieldLbACedula().setText("");
                crearLibro.getjTextFieldLbANombre().setText("");

            } catch (AutorNoEncontradoException e) {

                crearLibro.mostrarInformacion(e.getMessage());

            } catch (IllegalArgumentException e) {

                crearLibro.mostrarInformacion(e.getMessage());
            }

        } else {

            crearLibro.mostrarInformacion1("Acción cancelada");
        }
    }

    public void buscarRegistroLibro() {

        try {

            String cedula = crearLibro.getjTextFieldLbACedula().getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        "La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autor = autorDao.buscar(cedula);

            crearLibro.getjTextFieldLbANombre()
                    .setText(autor.getNombre());

        } catch (AutorNoEncontradoException e) {

            crearLibro.mostrarInformacion(e.getMessage());

            crearLibro.getjTextFieldLbANombre().setText("");

        } catch (IllegalArgumentException e) {

            crearLibro.mostrarInformacion(e.getMessage());
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

        try {

            String isbn = buscarLibro.getjTextFieldBsISBN().getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debe ingresar el ISBN del libro.");
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        "El ISBN solo debe contener números.");
            }

            Libro libro = libroDAO.buscar(isbn);

            buscarLibro.getjTextFieldBsISBN()
                    .setText(libro.getIsbn());

            buscarLibro.getjTextFieldBsTitulo()
                    .setText(libro.getTitulo());

            buscarLibro.getjTextFieldBsEditorial()
                    .setText(libro.getEditorial());

            buscarLibro.getjTextFieldBsAnio()
                    .setText(String.valueOf(libro.getAnioPublicacion()));

            buscarLibro.getjTextFieldBsACedula()
                    .setText(libro.getAutor().getCedula());

            buscarLibro.getjTextFieldBsANombre()
                    .setText(libro.getAutor().getNombre());

        } catch (LibroNoEncontrado e) {

            buscarLibro.getjTextFieldBsTitulo().setText("");
            buscarLibro.getjTextFieldBsEditorial().setText("");
            buscarLibro.getjTextFieldBsAnio().setText("");
            buscarLibro.getjTextFieldBsACedula().setText("");
            buscarLibro.getjTextFieldBsANombre().setText("");

            buscarLibro.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            buscarLibro.mostrarInformacion(e.getMessage());
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

    public void BuscarEliminarLibro() {

        try {

            String isbn = buscarLibro.getjTextFieldBsISBN()
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

            buscarLibro.getjTextFieldBsISBN()
                    .setText(libro.getIsbn());

            buscarLibro.getjTextFieldBsTitulo()
                    .setText(libro.getTitulo());

            buscarLibro.getjTextFieldBsEditorial()
                    .setText(libro.getEditorial());

            buscarLibro.getjTextFieldBsAnio()
                    .setText(String.valueOf(libro.getAnioPublicacion()));

            buscarLibro.getjTextFieldBsACedula()
                    .setText(libro.getAutor().getCedula());

            buscarLibro.getjTextFieldBsANombre()
                    .setText(libro.getAutor().getNombre());

        } catch (LibroNoEncontrado e) {

            buscarLibro.mostrarInformacion(e.getMessage());

            buscarLibro.getjTextFieldBsISBN().setText("");
            buscarLibro.getjTextFieldBsTitulo().setText("");
            buscarLibro.getjTextFieldBsEditorial().setText("");
            buscarLibro.getjTextFieldBsAnio().setText("");
            buscarLibro.getjTextFieldBsACedula().setText("");
            buscarLibro.getjTextFieldBsANombre().setText("");

        } catch (IllegalArgumentException e) {

            buscarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarLibro() {

        try {

            String isbn = eliminarLibro.getjTextFieldBrISBN().getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar el ISBN del libro.");
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException("El ISBN solo debe contener números.");
            }

            Libro libro = libroDAO.buscar(isbn);

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarLibro,
                    "¿Desea eliminar el libro: " + libro.getTitulo() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                libroDAO.eliminar(isbn);

                eliminarLibro.mostrarInformacion1(
                        "Libro eliminado correctamente :)"
                );

                eliminarLibro.getjTextFieldBrISBN().setText("");
                eliminarLibro.getjTextFieldBrTitulo().setText("");
                eliminarLibro.getjTextFieldBrEditorial().setText("");
                eliminarLibro.getjTextFieldBrAnio().setText("");

            } else {

                eliminarLibro.mostrarInformacion(
                        "Acción cancelada :("
                );
            }

        } catch (LibroNoEncontrado e) {

            eliminarLibro.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            eliminarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void configurarEventosEliminarLibro() {
        eliminarLibro.getjButtonBrBISBN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarEliminarLibro();
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

        try {

            String cedula = actualizarLibro.getjTextFieldActLACedula()
                    .getText().trim();

            String isbn = actualizarLibro.getjTextFieldActISBN()
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

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debe ingresar la cédula del autor."
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        "La cédula debe contener exactamente 10 dígitos."
                );
            }

            Libro libro = libroDAO.buscar(isbn);
            Autor autor = autorDao.buscar(cedula);

            actualizarLibro.getjTextFieldActLTitulo()
                    .setText(libro.getTitulo());

            actualizarLibro.getjTextFieldActLEditorial()
                    .setText(libro.getEditorial());

            actualizarLibro.getjTextFieldActLAnio()
                    .setText(String.valueOf(libro.getAnioPublicacion()));

        } catch (LibroNoEncontrado e) {

            actualizarLibro.getjTextFieldActLTitulo().setText("");
            actualizarLibro.getjTextFieldActLEditorial().setText("");
            actualizarLibro.getjTextFieldActLAnio().setText("");
            actualizarLibro.getjTextFieldActLACedula().setText("");

            actualizarLibro.mostrarInformacion(e.getMessage());

        } catch (AutorNoEncontradoException e) {

            actualizarLibro.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            actualizarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void actualizarLibro() {

        try {

            String isbn = actualizarLibro.getjTextFieldActISBN()
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

            Libro libroExistente = libroDAO.buscar(isbn);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibro,
                    "¿Desea actualizar el libro: "
                    + libroExistente.getTitulo() + "?",
                    "Confirmar actualización",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                String titulo = actualizarLibro.getjTextFieldActLTitulo()
                        .getText().trim();

                String editorial = actualizarLibro.getjTextFieldActLEditorial()
                        .getText().trim();

                String fechaTexto = actualizarLibro.getjTextFieldActLAnio()
                        .getText().trim();

                if (titulo.isEmpty() || editorial.isEmpty()
                        || fechaTexto.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Todos los campos deben estar llenos para actualizar el libro."
                    );
                }

                if (!titulo.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ0-9 ]+")) {

                    throw new IllegalArgumentException(
                            "El título contiene caracteres no válidos."
                    );
                }

                if (!editorial.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {

                    throw new IllegalArgumentException(
                            "La editorial solo puede contener letras."
                    );
                }

                Date anio;

                try {

                    anio = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            "El formato de fecha debe ser AAAA-MM-DD."
                    );
                }

                Libro libroActualizado = new Libro(
                        isbn,
                        titulo,
                        editorial,
                        anio,
                        libroExistente.getAutor()
                );

                libroDAO.actualizar(libroActualizado);

                actualizarLibro.mostrarInformacion1(
                        "Libro actualizado correctamente :)"
                );

                actualizarLibro.getjTextFieldActISBN().setText("");
                actualizarLibro.getjTextFieldActLTitulo().setText("");
                actualizarLibro.getjTextFieldActLEditorial().setText("");
                actualizarLibro.getjTextFieldActLAnio().setText("");

            } else {

                actualizarLibro.mostrarInformacion(
                        "Actualización cancelada :("
                );
            }

        } catch (LibroNoEncontrado e) {

            actualizarLibro.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            actualizarLibro.mostrarInformacion(e.getMessage());
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

        try {

            List<Libro> lista = libroDAO.listar();

            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException("No existen libros registrados.");
            }

            listarLibro.cargarDatos(lista);

        } catch (IllegalArgumentException e) {

            listarLibro.mostrarInformacion(e.getMessage());
        }
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
