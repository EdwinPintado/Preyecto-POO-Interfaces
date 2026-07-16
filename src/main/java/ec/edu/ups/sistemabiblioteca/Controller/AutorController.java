package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAO;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.AutorDAOMemoria;
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
import ec.edu.ups.sistemabiblioteca.enums.Cargo;
import ec.edu.ups.sistemabiblioteca.enums.Turno;
import javax.swing.JOptionPane;

public class AutorController {

    //Dao
    private AutorDAO autorDAO;
    //Autores
    private CrearAutor crearAutor;
    private BorrarAutor borrarAutor;
    private BuscarAutor buscarAutor;
    private ActualizarAutor actualizarAutor;
    private ListarAutor listarAutor;
    private String cAmsj;
    private String sCAmsj;
    private String busEAmsj;
    private String dAmsj;
    private String sDAmsj;
    private String exAmsj;
    private String acAmsj;
    private String sAcAmsj;
    private String canAcAmsj;
    private String cfmLmsj;
    private String fchmsj;
    private String exCamsj;
    private String canCUmsj;
    private String IDmsj;
    private String  TFmsj;
    private String  Nmsj; 
    private String  Amsj;
    private String  NAmsj; 
    private String  GLmsj; 
    private String  dfsAmsj; 
    private String  mAmsj;
    private String lAmsj;

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
        //Mensajes
        cAmsj = "¿Quieres crear un nuevo autor?";
        sCAmsj = "Autor creado exitosamente :)";
        busEAmsj = "No se encontro el autor (autor no existe)";
        dAmsj = "¿Quieres eliminar este autor: ";
        sDAmsj = "Autor eliminado con exito :)";
        exAmsj = "No se encontro el autor (cedula no existe)";
        acAmsj = "¿Quieres actualizar este autor: ";
        sAcAmsj = "Autor actualizado correctamente :)";
        canAcAmsj = "Actualizacion candelada";
        cfmLmsj = "Confirmar";
        fchmsj = "Error: El formato de fecha debe ser DD-MM-YYYY.";
        exCamsj = "Todos los campos deben estar llenos para guardar el autor.";
        canCUmsj = "Acción cancelada :(";
        IDmsj="La cédula debe contener exactamente 10 dígitos.";
        TFmsj ="El teléfono debe contener exactamente 10 dígitos.";
        Nmsj ="El nombre solo puede contener letras.";
        Amsj="El apellido solo puede contener letras.";
        NAmsj = "La nacionalidad solo puede contener letras.";
        GLmsj = "El género literario solo puede contener letras.";
        dfsAmsj = "Debe ingresar una cédula.";
        mAmsj = "Todos los campos deben estar llenos.";
        lAmsj = "No existen autores registrados.";
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    //Agregar autor
    public void agregarAutor() {
        int respuesta = JOptionPane.showConfirmDialog(crearAutor, cAmsj, cfmLmsj, JOptionPane.YES_NO_OPTION);
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

                    throw new IllegalArgumentException(exCamsj);
                }

                if (!cedula.matches("\\d{10}")) {
                    throw new IllegalArgumentException(IDmsj);
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(TFmsj);
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Nmsj);
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Amsj);
                }

                if (!nacionalidad.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(NAmsj);
                }

                if (!generoLiterario.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(GLmsj);
                }

                Date fechaNacimiento;

                try {

                    fechaNacimiento = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(fchmsj);
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

                crearAutor.mostrarInformacion1(sCAmsj);

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
            crearAutor.mostrarInformacion1(canCUmsj);
        }
    }

    public void buscarEliminarAutor() {

        try {

            String cedulaBuscar = borrarAutor.getjTextFieldEACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
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

            borrarAutor.mostrarInformacion(busEAmsj);

        } catch (IllegalArgumentException e) {

            borrarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarAutor() {

        try {

            String cedulaEliminar = borrarAutor.getjTextFieldEACedula().getText().trim();

            if (cedulaEliminar.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedulaEliminar.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Autor autor = autorDAO.buscar(cedulaEliminar);

            int respuesta = JOptionPane.showConfirmDialog(
                    borrarAutor,
                    dAmsj + autor.getNombre() + " ?",
                    cfmLmsj,
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                autorDAO.eliminar(cedulaEliminar);

                borrarAutor.mostrarInformacion1(sDAmsj);

                borrarAutor.getjTextFieldEACedula().setText("");

            } else {

                borrarAutor.mostrarInformacion1(canCUmsj);
            }

        } catch (AutorNoEncontradoException e) {

            borrarAutor.mostrarInformacion(exAmsj);

        } catch (IllegalArgumentException e) {

            borrarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarAutor() {

        try {

            String cedulaBuscar = buscarAutor.getjTextFieldBACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
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

            buscarAutor.mostrarInformacion(busEAmsj);

        } catch (IllegalArgumentException e) {

            buscarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarActualizarAutor() {

        try {

            String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
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

            actualizarAutor.mostrarInformacion(busEAmsj);

        } catch (IllegalArgumentException e) {

            actualizarAutor.mostrarInformacion(e.getMessage());
        }
    }

    public void actualizarAutor() {

        try {

            String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText().trim();

            if (cedulaBuscar.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }

            if (!cedulaBuscar.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Autor autorExt = autorDAO.buscar(cedulaBuscar);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarAutor,
                    acAmsj + autorExt.getNombre() + " ?",
                    cfmLmsj,
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

                    throw new IllegalArgumentException(mAmsj);
                }

                if (!nuevoNombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Nmsj);
                }

                if (!nuevoApellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Amsj);
                }

                if (!nuevoNacionalidad.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(NAmsj);
                }

                if (!nuevoGenero.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(GLmsj);
                }

                if (!nuevoTelefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(TFmsj);
                }

                Date nuevoFechaN;

                try {
                    nuevoFechaN = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            fchmsj);
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

                actualizarAutor.mostrarInformacion1(sAcAmsj);

            } else {

                actualizarAutor.mostrarInformacion1(canAcAmsj);
            }

        } catch (AutorNoEncontradoException e) {

            actualizarAutor.mostrarInformacion(exAmsj);

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

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n.mensajes", locale);
        cAmsj = (bundle.getString("cAmsj"));
        sCAmsj = (bundle.getString("sCAmsj"));
        busEAmsj = (bundle.getString("busEAmsj"));
        dAmsj = (bundle.getString("dAmsj"));
        sDAmsj = (bundle.getString("sDAmsj"));
        exAmsj = (bundle.getString("exAmsj"));
        acAmsj = (bundle.getString("acAmsj"));
        sAcAmsj = (bundle.getString("sAcAmsj"));
        canAcAmsj = (bundle.getString("canAcAmsj"));
        cfmLmsj = (bundle.getString("cfmLmsj"));
        fchmsj = (bundle.getString("fchmsj"));
        exCamsj = (bundle.getString("exCamsj"));
        canCUmsj = (bundle.getString("canCUmsj"));
        IDmsj= (bundle.getString("IDmsj"));
        TFmsj = (bundle.getString("TFmsj"));
        Nmsj = (bundle.getString("Nmsj"));
        Amsj= (bundle.getString("Amsj"));
        NAmsj = (bundle.getString("NAmsj"));
        GLmsj = (bundle.getString("GLmsj"));
        dfsAmsj = (bundle.getString("dfsAmsj"));
        mAmsj = (bundle.getString("mAmsj"));
        lAmsj = (bundle.getString("lAmsj"));



    }

}
