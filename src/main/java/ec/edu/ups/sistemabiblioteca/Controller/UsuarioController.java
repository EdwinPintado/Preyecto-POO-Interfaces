package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAOMemoria.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.UsuarioNoExiste;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.ActualizarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BorrarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BuscarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.ListarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.CrearUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class UsuarioController {

    //Dao
    private UsuarioDAOMemoria usuarioDao;

    private CrearUsuario crearUsuario;
    private BorrarUsuario eliminarUsuario;
    private BuscarUsuario buscarUsuario;
    private ActualizarUsuario actualizarUsuario;
    private ListarUsuario listaUsuarios;

    public UsuarioController(
            UsuarioDAOMemoria usuarioDao,
            CrearUsuario crearUsuario,
            BorrarUsuario eliminarUsuario,
            BuscarUsuario buscarUsuario,
            ActualizarUsuario actualizarUsuario,
            ListarUsuario listaUsuarios) {

        this.usuarioDao = usuarioDao;
        this.crearUsuario = crearUsuario;
        this.eliminarUsuario = eliminarUsuario;
        this.buscarUsuario = buscarUsuario;
        this.actualizarUsuario = actualizarUsuario;
        this.listaUsuarios = listaUsuarios;

        configurarEventosAgregarUsuario();
        configurarEventosBuscarUsuario();
        configurarEventosEliminarUsuario();
        configurarEventosActualizarUsuario();
        configurarEventosListarUsuarios();
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarUsuario() {

        int respuesta = JOptionPane.showConfirmDialog(
                crearUsuario,
                "¿Quieres crear un nuevo usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                String cedula = crearUsuario.getjTextFieldCUCedula().getText().trim();
                String nombre = crearUsuario.getjTextFieldCUNombre().getText().trim();
                String apellido = crearUsuario.getjTextFieldCUApellido().getText().trim();
                String telefono = crearUsuario.getjTextFieldCUTelefono().getText().trim();
                String correo = crearUsuario.getjTextFieldCUCElectronico().getText().trim();
                String direccion = crearUsuario.getjTextFieldCUDireccion().getText().trim();
                String fechaTexto = crearUsuario.getjTextFieldCUFNacimiento().getText().trim();

                if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                        || telefono.isEmpty() || correo.isEmpty()
                        || direccion.isEmpty() || fechaTexto.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Todos los campos deben estar llenos para guardar el usuario.");
                }

                if (!cedula.matches("\\d{10}")) {
                    throw new IllegalArgumentException("La cédula debe contener exactamente 10 dígitos.");
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException("El apellido solo puede contener letras.");
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos.");
                }

                if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
                }

                Date fecha;

                try {

                    fecha = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            "Error: El formato de fecha debe ser AAAA-MM-DD.");
                }

                Usuario usuario = new Usuario(
                        correo,
                        direccion,
                        cedula,
                        nombre,
                        apellido,
                        telefono,
                        fecha);

                usuarioDao.agregar(usuario);

                crearUsuario.mostrarInformacion1("Usuario creado exitosamente :)");

                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");

            } catch (IllegalArgumentException e) {

                crearUsuario.mostrarInformacion(e.getMessage());
            }

        } else {

            crearUsuario.mostrarInformacion("Acción cancelada :(");
        }
    }

    public void configurarEventosAgregarUsuario() {
        crearUsuario.getjButtonCUCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
    }

    public void buscarUsuario() {

        try {

            String cedula = buscarUsuario.getjTextFieldBUCedula()
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

            Usuario usuario = usuarioDao.buscar(cedula);

            buscarUsuario.getjTextFieldBUCedula()
                    .setText(usuario.getCedula());

            buscarUsuario.getjTextFieldBUNombre()
                    .setText(usuario.getNombre());

            buscarUsuario.getjTextFieldBUApellido()
                    .setText(usuario.getApellido());

            buscarUsuario.getjTextFieldBUTelefono()
                    .setText(usuario.getTelefono());

            buscarUsuario.getjTextFieldBUCElectronico()
                    .setText(usuario.getCorreoElectronico());

            buscarUsuario.getjTextFieldBUFNacimiento()
                    .setText(String.valueOf(usuario.getFechaNacimiento()));

        } catch (UsuarioNoExiste e) {

            buscarUsuario.getjTextFieldBUCedula().setText("");
            buscarUsuario.getjTextFieldBUNombre().setText("");
            buscarUsuario.getjTextFieldBUApellido().setText("");
            buscarUsuario.getjTextFieldBUTelefono().setText("");
            buscarUsuario.getjTextFieldBUCElectronico().setText("");
            buscarUsuario.getjTextFieldBUFNacimiento().setText("");

            buscarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            buscarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void configurarEventosBuscarUsuario() {
        buscarUsuario.getjButtonBUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
    }

    public void buscarActualizarUsuario() {

        try {

            String cedula = actualizarUsuario.getjTextFieldAUCedula()
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

            Usuario usuario = usuarioDao.buscar(cedula);

            actualizarUsuario.getjTextFieldAUNombre()
                    .setText(usuario.getNombre());

            actualizarUsuario.getjTextFieldAUApellido()
                    .setText(usuario.getApellido());

            actualizarUsuario.getjTextFieldAUTelefono()
                    .setText(usuario.getTelefono());

            actualizarUsuario.getjTextFieldAUCElectronico()
                    .setText(usuario.getCorreoElectronico());

            actualizarUsuario.getjTextFieldAUDireccion()
                    .setText(usuario.getDireccion());

            actualizarUsuario.getjTextFieldAUFNacimiento()
                    .setText(String.valueOf(usuario.getFechaNacimiento()));

        } catch (UsuarioNoExiste e) {

            actualizarUsuario.getjTextFieldAUNombre().setText("");
            actualizarUsuario.getjTextFieldAUApellido().setText("");
            actualizarUsuario.getjTextFieldAUTelefono().setText("");
            actualizarUsuario.getjTextFieldAUCElectronico().setText("");
            actualizarUsuario.getjTextFieldAUDireccion().setText("");
            actualizarUsuario.getjTextFieldAUFNacimiento().setText("");

            actualizarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            actualizarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void actualizarUsuario() {

        try {

            String cedula = actualizarUsuario.getjTextFieldAUCedula()
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

            // Si no existe lanza UsuarioNoExiste
            usuarioDao.buscar(cedula);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarUsuario,
                    "¿Quieres actualizar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                String nombre = actualizarUsuario.getjTextFieldAUNombre()
                        .getText().trim();

                String apellido = actualizarUsuario.getjTextFieldAUApellido()
                        .getText().trim();

                String telefono = actualizarUsuario.getjTextFieldAUTelefono()
                        .getText().trim();

                String correo = actualizarUsuario.getjTextFieldAUCElectronico()
                        .getText().trim();

                String direccion = actualizarUsuario.getjTextFieldAUDireccion()
                        .getText().trim();

                String fechaTexto = actualizarUsuario.getjTextFieldAUFNacimiento()
                        .getText().trim();

                if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()
                        || correo.isEmpty() || direccion.isEmpty() || fechaTexto.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Todos los campos deben estar llenos."
                    );
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            "El nombre solo puede contener letras."
                    );
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            "El apellido solo puede contener letras."
                    );
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(
                            "El teléfono debe contener exactamente 10 dígitos."
                    );
                }

                if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    throw new IllegalArgumentException(
                            "El correo electrónico no tiene un formato válido."
                    );
                }

                Date fecha;

                try {

                    fecha = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(
                            "El formato de fecha debe ser AAAA-MM-DD."
                    );
                }

                Usuario nuevo = new Usuario(
                        correo,
                        direccion,
                        cedula,
                        nombre,
                        apellido,
                        telefono,
                        fecha
                );

                usuarioDao.actualizar(nuevo);

                actualizarUsuario.mostrarInformacion1(
                        "Usuario actualizado correctamente :)"
                );
            }

        } catch (UsuarioNoExiste e) {

            actualizarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            actualizarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void buscarEliminarUsuario() {

        try {

            String cedula = eliminarUsuario.getjTextFieldEUCedula()
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

            Usuario usuario = usuarioDao.buscar(cedula);

            eliminarUsuario.getjTextFieldEUNombre()
                    .setText(usuario.getNombre());

            eliminarUsuario.getjTextFieldEUApellido()
                    .setText(usuario.getApellido());

            eliminarUsuario.getjTextFieldEUTelefono()
                    .setText(usuario.getTelefono());

            eliminarUsuario.getjTextFieldEUCElectronico()
                    .setText(usuario.getCorreoElectronico());

            eliminarUsuario.getjTextFieldEUFNacimiento()
                    .setText(String.valueOf(usuario.getFechaNacimiento()));

        } catch (UsuarioNoExiste e) {

            eliminarUsuario.getjTextFieldEUNombre().setText("");
            eliminarUsuario.getjTextFieldEUApellido().setText("");
            eliminarUsuario.getjTextFieldEUTelefono().setText("");
            eliminarUsuario.getjTextFieldEUCElectronico().setText("");
            eliminarUsuario.getjTextFieldEUFNacimiento().setText("");

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void eliminarUsuario() {

        try {

            String cedula = eliminarUsuario.getjTextFieldEUCedula()
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

            // Si el usuario no existe lanza UsuarioNoExiste
            usuarioDao.buscar(cedula);

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarUsuario,
                    "¿Desea eliminar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                usuarioDao.eliminar(cedula);

                eliminarUsuario.mostrarInformacion(
                        "Usuario eliminado correctamente :)"
                );

                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");
            }

        } catch (UsuarioNoExiste e) {

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void configurarEventosActualizarUsuario() {
        actualizarUsuario.getjButtonAUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarUsuario();
            }
        });

        actualizarUsuario.getjButtonAUActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });
    }

    public void buscarUsuarioParaEliminar() {

        try {

            String cedula = eliminarUsuario.getjTextFieldEUCedula()
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

            Usuario usuario = usuarioDao.buscar(cedula);

            eliminarUsuario.getjTextFieldEUNombre()
                    .setText(usuario.getNombre());

            eliminarUsuario.getjTextFieldEUApellido()
                    .setText(usuario.getApellido());

            eliminarUsuario.getjTextFieldEUTelefono()
                    .setText(usuario.getTelefono());

            eliminarUsuario.getjTextFieldEUCElectronico()
                    .setText(usuario.getCorreoElectronico());

            eliminarUsuario.getjTextFieldEUFNacimiento()
                    .setText(String.valueOf(usuario.getFechaNacimiento()));

        } catch (UsuarioNoExiste e) {

            eliminarUsuario.getjTextFieldEUNombre().setText("");
            eliminarUsuario.getjTextFieldEUApellido().setText("");
            eliminarUsuario.getjTextFieldEUTelefono().setText("");
            eliminarUsuario.getjTextFieldEUCElectronico().setText("");
            eliminarUsuario.getjTextFieldEUFNacimiento().setText("");

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(
                    e.getMessage()
            );
        }
    }

    public void configurarEventosEliminarUsuario() {
        eliminarUsuario.getjButtonEUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarUsuario();
            }
        });

        eliminarUsuario.getjButtonEUABorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
    }

    public void listarUsuarios() {

        try {

            List<Usuario> lista = usuarioDao.listar();
            listaUsuarios.cargarDatos(lista);

        } catch (Exception e) {

            listaUsuarios.mostrarInformacion("Error al cargar la lista de usuarios: " + e.getMessage());
        }
    }

    public void mostrarContadorAutores() {

        int total = usuarioDao.contar();

        listaUsuarios.getTxtContadordeUsuarios().setText(String.valueOf(total));
    }

    public void configurarEventosListarUsuarios() {

        listaUsuarios.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                listarUsuarios();
                mostrarContadorAutores();
            }
        });
    }
}
