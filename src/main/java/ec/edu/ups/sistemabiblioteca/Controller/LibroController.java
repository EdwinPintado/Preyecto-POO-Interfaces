package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAOMemoria.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.LibroDAOMemoria;
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
    private String InLmsj; 
    private String Isbnmsj; 
    private String tLmsj;
    private String edmsj; 
    private String lLmsj; 
    private String  dfsAmsj;
    private String IDmsj;
    private String IDalmsj;
    private String Aclmsj;

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
        fchmsj = "Error: El formato de fecha debe ser DD-MM-YYYY.";
        tCLmsj = "Todos los campos deben estar llenados , para guardar el libro";
        InLmsj = "Debe ingresar el ISBN del libro.";
        Isbnmsj = "El ISBN solo debe contener números.";
        tLmsj = "El título contiene caracteres no válidos.";
        edmsj = "La editorial solo puede contener letras.";
        lLmsj = "No existen libros registrados.";
        IDmsj="La cédula debe contener exactamente 10 dígitos.";
        dfsAmsj = "Debe ingresar una cédula.";
        IDalmsj = "Debe ingresar la cédula del autor.";
        Aclmsj = "Todos los campos deben estar llenos para actualizar el libro.";
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

                if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()
                        || fechaTexto.isEmpty() || cedulaAutor.isEmpty()) {

                    throw new IllegalArgumentException(tCLmsj);
                }

                if (!isbn.matches("\\d+")) {
                    throw new IllegalArgumentException(
                            Isbnmsj);
                }

                if (!titulo.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ0-9 ]+")) {
                    throw new IllegalArgumentException(
                            tLmsj);
                }

                if (!editorial.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            edmsj);
                }

                Date anio;

                try {

                    anio = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(fchmsj);
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

                crearLibro.mostrarInformacion1(LpreMsj);

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

            crearLibro.mostrarInformacion1(Canmsj);
        }
    }

    public void buscarRegistroLibro() {

        try {

            String cedula = crearLibro.getjTextFieldLbACedula().getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj);
            }

            Autor autor = autorDao.buscar(cedula);

            if (autor == null) {
                throw new AutorNoEncontradoException(bALmsj + cedula + bALddmsj);
            }

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
                        InLmsj);
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        Isbnmsj);
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

            buscarLibro.mostrarInformacion(noFDLmsj);

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
                        InLmsj
                );
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        Isbnmsj
                );
            }

            Libro libro = libroDAO.buscar(isbn);

            eliminarLibro.getjTextFieldBrISBN()
                    .setText(libro.getIsbn());

            eliminarLibro.getjTextFieldBrTitulo()
                    .setText(libro.getTitulo());

            eliminarLibro.getjTextFieldBrEditorial()
                    .setText(libro.getEditorial());

            eliminarLibro.getjTextFieldBrAnio()
                    .setText(String.valueOf(libro.getAnioPublicacion()));

        } catch (LibroNoEncontrado e) {

            eliminarLibro.getjTextFieldBrISBN().setText("");
            eliminarLibro.getjTextFieldBrTitulo().setText("");
            eliminarLibro.getjTextFieldBrEditorial().setText("");
            eliminarLibro.getjTextFieldBrAnio().setText("");

            eliminarLibro.mostrarInformacion(noFDLmsj);

        } catch (IllegalArgumentException e) {

            eliminarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarLibro() {

        try {

            String isbn = eliminarLibro.getjTextFieldBrISBN().getText().trim();

            if (isbn.isEmpty()) {
                throw new IllegalArgumentException(InLmsj);
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(Isbnmsj);
            }

            Libro libro = libroDAO.buscar(isbn);

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
                eliminarLibro.getjTextFieldActACedula().setText("");
                eliminarLibro.getjTextFieldBrANombre().setText("");
                
            } else {

                eliminarLibro.mostrarInformacion(canDLmsj);
            }

        } catch (LibroNoEncontrado e) {

            eliminarLibro.mostrarInformacion(noFDLmsj);

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
                        InLmsj
                );
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        Isbnmsj
                );
            }
/*
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        IDalmsj
                );
            }


            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
                );
            }
*/
            Libro libro = libroDAO.buscar(isbn);
            //Autor autor = autorDao.buscar(cedula);

            actualizarLibro.getjTextFieldActLTitulo()
                    .setText(libro.getTitulo());

            actualizarLibro.getjTextFieldActLEditorial()
                    .setText(libro.getEditorial());

            actualizarLibro.getjTextFieldActLAnio()
                    .setText(String.valueOf(libro.getAnioPublicacion()));
            actualizarLibro.getjTextFieldActLACedula()
                    .setText(libro.getAutor().getCedula());

            actualizarLibro.getjTextFieldActLANombre()
                    .setText(libro.getAutor().getNombre());

        } catch (LibroNoEncontrado e) {

            actualizarLibro.getjTextFieldActLTitulo().setText("");
            actualizarLibro.getjTextFieldActLEditorial().setText("");
            actualizarLibro.getjTextFieldActLAnio().setText("");
            actualizarLibro.getjTextFieldActLACedula().setText("");
            actualizarLibro.getjTextFieldActLANombre().setText("");

            actualizarLibro.mostrarInformacion(busACLnmsj);

        } catch (AutorNoEncontradoException e) {

            actualizarLibro.getjTextFieldActLTitulo().setText("");
            actualizarLibro.getjTextFieldActLEditorial().setText("");
            actualizarLibro.getjTextFieldActLAnio().setText("");
            actualizarLibro.getjTextFieldActLACedula().setText("");

            actualizarLibro.mostrarInformacion(busACLnmsj);

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
                        InLmsj
                );
            }

            if (!isbn.matches("\\d+")) {
                throw new IllegalArgumentException(
                        Isbnmsj
                );
            }

            Libro libroExistente = libroDAO.buscar(isbn);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibro,
                    actLmsj + libroExistente.getTitulo() + "?",
                    cfmALmsj,
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
                            Aclmsj
                    );
                }

                if (!titulo.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ0-9 ]+")) {

                    throw new IllegalArgumentException(
                            tLmsj
                    );
                }

                if (!editorial.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {

                    throw new IllegalArgumentException(
                            edmsj
                    );
                }

                Date anio;

                try {

                    anio = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            fchmsj
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

                actualizarLibro.mostrarInformacion1(acpACLmsj);

                actualizarLibro.getjTextFieldActISBN().setText("");
                actualizarLibro.getjTextFieldActLTitulo().setText("");
                actualizarLibro.getjTextFieldActLEditorial().setText("");
                actualizarLibro.getjTextFieldActLAnio().setText("");
                actualizarLibro.getjTextFieldActLACedula().setText("");
                actualizarLibro.getjTextFieldActLANombre().setText("");

            } else {

                actualizarLibro.mostrarInformacion(canACLmsj);
            }

        } catch (LibroNoEncontrado e) {

            actualizarLibro.mostrarInformacion(nfACLmsj);

        } catch (IllegalArgumentException e) {

            actualizarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void configurarEventosActualizarLibro() {
        actualizarLibro.getjButtonBsLISBN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarLibro();
            }
        });
        actualizarLibro.getjButtonActLibro().addActionListener(new ActionListener() {
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
                throw new IllegalArgumentException(lLmsj);
            }

            listarLibro.cargarDatos(lista);

        } catch (IllegalArgumentException e) {

            listarLibro.mostrarInformacion(e.getMessage());
        }
    }

    public void mostrarContadorLibros() {
        int total = libroDAO.contar();
        listarLibro.getTxtContadordeLibro().setText(String.valueOf(total));
    }

    public void configurarEventosListarLibro() {
        listarLibro.getBtnMostrarListaLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLibro();
                mostrarContadorLibros();
            }
        });
    }

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
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
        InLmsj = (bundle.getString("InLmsj"));
        Isbnmsj = (bundle.getString("Isbnmsj"));
        tLmsj = (bundle.getString("tLmsj"));
        edmsj = (bundle.getString("edmsj"));
        lLmsj = (bundle.getString("lLmsj"));
        dfsAmsj = (bundle.getString("dfsAmsj"));
        IDmsj= (bundle.getString("IDmsj"));
        IDalmsj = (bundle.getString("IDalmsj"));
        Aclmsj = (bundle.getString("Aclmsj "));
    }
}
