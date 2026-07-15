package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.AutorNoEncontradoException;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.view.autor.ActualizarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BorrarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BuscarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.CrearAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.ListarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class AutorController {

    //Dao
    private AutorDAOMemoria autorDAO;
    //Autores
    private CrearAutor crearAutor;
    private BorrarAutor borrarAutor;
    private BuscarAutor buscarAutor;
    private ActualizarAutor actualizarAutor;
    private ListarAutor listarAutor;

    public AutorController(AutorDAOMemoria autorDAO, CrearAutor crearAutor, BorrarAutor borrarAutor, BuscarAutor buscarAutor, ActualizarAutor actualizarAutor, ListarAutor listarAutor) {
        this.autorDAO = autorDAO;
        this.crearAutor = crearAutor;
        this.borrarAutor = borrarAutor;
        this.buscarAutor = buscarAutor;
        this.actualizarAutor = actualizarAutor;
        this.listarAutor = listarAutor;
        configurarEventosAgregarAutor();
        configurarEventosBuscarAutor();
        configurarEventosActualizarAutor();
        configurarEventosEliminarAutor();
        configurarEventosListarAutor();
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    //Agregar autor
    public void agregarAutor() {
        int respuesta = JOptionPane.showConfirmDialog(crearAutor, "¿Quieres crear un nuevo autor?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {

                String cedula = crearAutor.getjTextFieldCACedula().getText().trim();
                String nombre = crearAutor.getjTextFieldCANombre().getText().trim();
                String apellido = crearAutor.getjTextFieldCAApellido().getText().trim();
                String telefono = crearAutor.getjTextFieldCATelefono().getText().trim();
                String fechaTexto = crearAutor.getjTextFieldCAFecha().getText().trim();
                String nacionalidad = crearAutor.getjTextFieldCANacionalidad().getText().trim();
                String generoLiterario = crearAutor.getjTextFieldCAGenero().getText().trim();
                String bibliografia = crearAutor.getjTextFieldCABibliografia().getText().trim();

                if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                        || telefono.isEmpty() || fechaTexto.isEmpty()
                        || nacionalidad.isEmpty() || generoLiterario.isEmpty()
                        || bibliografia.isEmpty()) {

                    throw new IllegalArgumentException("Todos los campos deben estar llenos para guardar el autor.");
                }

                if (!cedula.matches("\\d{10}")) {
                    throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos.");
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El apellido solo puede contener letras.");
                }

                if (!nacionalidad.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("La nacionalidad solo puede contener letras.");
                }

                if (!generoLiterario.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El género literario solo puede contener letras.");
                }

                Date fechaNacimiento;

                try {

                    fechaNacimiento = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException("Error: El formato de fecha debe ser AAAA-MM-DD.");
                }

                Autor autor = new Autor(
                        nacionalidad,
                        generoLiterario,
                        bibliografia,
                        cedula,
                        nombre,
                        apellido,
                        telefono,
                        fechaNacimiento);

                autorDAO.agregar(autor);

                crearAutor.mostrarInformacion1("Autor creado exitosamente :)");

                crearAutor.getjTextFieldCANombre().setText("");
                crearAutor.getjTextFieldCAApellido().setText("");
                crearAutor.getjTextFieldCANacionalidad().setText("");
                crearAutor.getjTextFieldCATelefono().setText("");
                crearAutor.getjTextFieldCAGenero().setText("");
                crearAutor.getjTextFieldCAFecha().setText("");
                crearAutor.getjTextFieldCABibliografia().setText("");

            } catch (IllegalArgumentException e) {
                crearAutor.mostrarInformacion(e.getMessage());
            }

        } else {
            crearAutor.mostrarInformacion1("Acción cancelada :(");
        }
    }

    public void buscarEliminarAutor() {

        try {

            String cedulaBuscar = borrarAutor.getjTextFieldEACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autor = autorDAO.buscar(cedulaBuscar);

            borrarAutor.getjTextFieldEANombre().setText(autor.getNombre());
            borrarAutor.getjTextFieldEAApellido().setText(autor.getApellido());
            borrarAutor.getjTextFieldEANacionalidad().setText(autor.getNacionalidad());
            borrarAutor.getjTextFieldEATelefono().setText(autor.getTelefono());
            borrarAutor.getjTextFieldEAGenero().setText(autor.getGeneroLiterario());
            borrarAutor.getjTextFieldEAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            borrarAutor.getjTextFieldEABibliografia().setText(autor.getBibliografia());

        } catch (AutorNoEncontradoException e) {

            borrarAutor.getjTextFieldEANombre().setText("");
            borrarAutor.getjTextFieldEAApellido().setText("");
            borrarAutor.getjTextFieldEANacionalidad().setText("");
            borrarAutor.getjTextFieldEATelefono().setText("");
            borrarAutor.getjTextFieldEAGenero().setText("");
            borrarAutor.getjTextFieldEAFecha().setText("");
            borrarAutor.getjTextFieldEABibliografia().setText("");

            borrarAutor.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            borrarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarAutor() {

        try {

            String cedulaEliminar = borrarAutor.getjTextFieldEACedula().getText().trim();

            if (cedulaEliminar.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedulaEliminar.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autor = autorDAO.buscar(cedulaEliminar);

            int respuesta = JOptionPane.showConfirmDialog(
                    borrarAutor,
                    "¿Quieres eliminar este autor: " + autor.getNombre() + " ?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                autorDAO.eliminar(cedulaEliminar);

                borrarAutor.mostrarInformacion1("Autor eliminado con éxito :)");

                borrarAutor.getjTextFieldEACedula().setText("");

            } else {

                borrarAutor.mostrarInformacion1("Acción cancelada :(");
            }

        } catch (AutorNoEncontradoException e) {

            borrarAutor.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            borrarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarAutor() {

        try {

            String cedulaBuscar = buscarAutor.getjTextFieldBACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autor = autorDAO.buscar(cedulaBuscar);

            buscarAutor.getjTextFieldBANombre().setText(autor.getNombre());
            buscarAutor.getjTextFieldBAApellido().setText(autor.getApellido());
            buscarAutor.getjTextFieldBANacionalidad().setText(autor.getNacionalidad());
            buscarAutor.getjTextFieldBATelefono().setText(autor.getTelefono());
            buscarAutor.getjTextFieldBAGenero().setText(autor.getGeneroLiterario());
            buscarAutor.getjTextFieldBAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            buscarAutor.getjTextFieldBABibliografia().setText(autor.getBibliografia());

        } catch (AutorNoEncontradoException e) {

            buscarAutor.getjTextFieldBANombre().setText("");
            buscarAutor.getjTextFieldBAApellido().setText("");
            buscarAutor.getjTextFieldBANacionalidad().setText("");
            buscarAutor.getjTextFieldBATelefono().setText("");
            buscarAutor.getjTextFieldBAGenero().setText("");
            buscarAutor.getjTextFieldBAFecha().setText("");
            buscarAutor.getjTextFieldBABibliografia().setText("");

            buscarAutor.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            buscarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarActualizarAutor() {

        try {

            String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autor = autorDAO.buscar(cedulaBuscar);

            actualizarAutor.getjTextFieldActANombre().setText(autor.getNombre());
            actualizarAutor.getjTextFieldActAApellido().setText(autor.getApellido());
            actualizarAutor.getjTextFieldActANacionalidad().setText(autor.getNacionalidad());
            actualizarAutor.getjTextFieldActATelefono().setText(autor.getTelefono());
            actualizarAutor.getjTextFieldActAGenero().setText(autor.getGeneroLiterario());
            actualizarAutor.getjTextFieldActAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            actualizarAutor.getjTextFieldActABibliografia().setText(autor.getBibliografia());

        } catch (AutorNoEncontradoException e) {

            actualizarAutor.getjTextFieldActANombre().setText("");
            actualizarAutor.getjTextFieldActAApellido().setText("");
            actualizarAutor.getjTextFieldActANacionalidad().setText("");
            actualizarAutor.getjTextFieldActATelefono().setText("");
            actualizarAutor.getjTextFieldActAGenero().setText("");
            actualizarAutor.getjTextFieldActAFecha().setText("");
            actualizarAutor.getjTextFieldActABibliografia().setText("");

            actualizarAutor.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            actualizarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void actualizarAutor() {

        try {

            String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException("Debe ingresar una cédula.");
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
            }

            Autor autorExt = autorDAO.buscar(cedulaBuscar);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarAutor,
                    "¿Quieres actualizar este autor: " + autorExt.getNombre() + " ?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                String nuevoNombre = actualizarAutor.getjTextFieldActANombre().getText().trim();
                String nuevoApellido = actualizarAutor.getjTextFieldActAApellido().getText().trim();
                String nuevoNacionalidad = actualizarAutor.getjTextFieldActANacionalidad().getText().trim();
                String nuevoTelefono = actualizarAutor.getjTextFieldActATelefono().getText().trim();
                String nuevoGenero = actualizarAutor.getjTextFieldActAGenero().getText().trim();
                String fechaTexto = actualizarAutor.getjTextFieldActAFecha().getText().trim();
                String nuevoBlibliografia = actualizarAutor.getjTextFieldActABibliografia().getText().trim();

                if (nuevoNombre.isEmpty() || nuevoApellido.isEmpty()
                        || nuevoNacionalidad.isEmpty() || nuevoTelefono.isEmpty()
                        || nuevoGenero.isEmpty() || fechaTexto.isEmpty()
                        || nuevoBlibliografia.isEmpty()) {

                    throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                }

                if (!nuevoNombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }

                if (!nuevoApellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El apellido solo puede contener letras.");
                }

                if (!nuevoNacionalidad.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("La nacionalidad solo puede contener letras.");
                }

                if (!nuevoGenero.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El género literario solo puede contener letras.");
                }

                if (!nuevoTelefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos.");
                }

                Date nuevoFechaN;

                try {
                    nuevoFechaN = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            "La fecha debe tener el formato AAAA-MM-DD.");
                }

                Autor autorAct = new Autor(
                        nuevoNacionalidad,
                        nuevoGenero,
                        nuevoBlibliografia,
                        cedulaBuscar,
                        nuevoNombre,
                        nuevoApellido,
                        nuevoTelefono,
                        nuevoFechaN
                );

                autorDAO.actualizar(autorAct);

                actualizarAutor.mostrarInformacion1(
                        "Autor actualizado correctamente :)");

            } else {

                actualizarAutor.mostrarInformacion1(
                        "Actualización cancelada");
            }

        } catch (AutorNoEncontradoException e) {

            actualizarAutor.mostrarInformacion(e.getMessage());

        } catch (IllegalArgumentException e) {

            actualizarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void listarAutores() {

        try {

            List<Autor> lista = autorDAO.listar();

            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException("No existen autores registrados.");
            }

            listarAutor.cargarDatos(lista);

        } catch (IllegalArgumentException e) {

            listarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void mostrarContadorAutores() {

        int total = autorDAO.contar();

        listarAutor.getTxtContadordeAutores().setText(String.valueOf(total));
    }

    public void configurarEventosAgregarAutor() {
        crearAutor.getjButtonCACrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAutor();
            }
        });
    }

    public void configurarEventosBuscarAutor() {
        buscarAutor.getjButtonBACedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAutor();
            }
        });
    }

    public void configurarEventosActualizarAutor() {
        actualizarAutor.getjButtonActABCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarAutor();
            }
        });
        actualizarAutor.getjButtonActAActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAutor();
            }
        });
    }

    public void configurarEventosEliminarAutor() {
        borrarAutor.getjButtonEABCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarAutor();
            }
        });
        borrarAutor.getjButtonEAEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAutor();
            }
        });
    }

    public void configurarEventosListarAutor() {

        listarAutor.getBtnMostrarListaAutores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAutores();
                mostrarContadorAutores();
            }
        });
    }

    /*
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle = new ResourceBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        
        
    }
     */
}
