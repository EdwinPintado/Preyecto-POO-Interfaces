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
import java.util.Locale;
import java.util.ResourceBundle;
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
    private String agUmsj;
    private String sCUmsj;
    private String canCUmsj;
    private String actUmsj;
    private String sAUmsj;
    private String dlUmsj;
    private String sDUmsj;
    private String tCUmsj;
    private String cfmLmsj;
    private String fchmsj;
    private String nUmsj;
    private String IDmsj;
    private String Nmsj;
    private String Amsj;
    private String TFmsj;
    private String Cmsj;
    private String IDUmsj;
    private String exlUmsj;
    private String mAmsj;
    
    
    

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
        //mensajes
        agUmsj = "¿Quieres crear un nuevo usuario?";
        sCUmsj = "Usuario creado exitosamente :)";
        canCUmsj = "Acción cancelada :(";
        actUmsj = "¿Quieres actualizar este usuario?";
        sAUmsj = "Usuario actualizado correctamente :)";
        dlUmsj = "¿Desea eliminar este usuario?";
        sDUmsj = "Usuario eliminado correctamente :)";
        tCUmsj = "Todos los campos deben estar llenos para guardar el usuario.";
        cfmLmsj = "Confirmar";
        fchmsj = "Error: El formato de fecha debe ser DD-MM-YYYY.";
        nUmsj = "No se encontró el usuario";
        IDmsj="La cédula debe contener exactamente 10 dígitos.";
        TFmsj ="El teléfono debe contener exactamente 10 dígitos.";
        Nmsj ="El nombre solo puede contener letras.";
        Amsj="El apellido solo puede contener letras.";
        Cmsj = "El correo electrónico no tiene un formato válido."; 
        IDUmsj = "Debe ingresar la cédula del usuario.";
        exlUmsj = "Error al cargar la lista de usuarios: ";
        mAmsj = "Todos los campos deben estar llenos.";
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarUsuario() {

        int respuesta = JOptionPane.showConfirmDialog(
                crearUsuario,
                agUmsj,
                cfmLmsj,
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

                    throw new IllegalArgumentException(tCUmsj);
                }

                if (!cedula.matches("\\d{10}")) {
                    throw new IllegalArgumentException(IDmsj);
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Nmsj);
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Amsj);
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(TFmsj);
                }

                if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    throw new IllegalArgumentException(Cmsj);
                }

                Date fecha;

                try {

                    fecha = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(fchmsj);
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

                crearUsuario.mostrarInformacion1(sCUmsj);

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

            crearUsuario.mostrarInformacion(canCUmsj);
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
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
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
            
            buscarUsuario.getjTextFieldBUDireccion()
                    .setText(usuario.getDireccion());

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
            buscarUsuario.getjTextFieldBUDireccion().setText("");

            buscarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            buscarUsuario.mostrarInformacion(e.getMessage());
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
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
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

            actualizarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            actualizarUsuario.mostrarInformacion(e.getMessage());
        }
    }

    public void actualizarUsuario() {

        try {

            String cedula = actualizarUsuario.getjTextFieldAUCedula()
                    .getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
                );
            }

            // Si no existe lanza UsuarioNoExiste
            usuarioDao.buscar(cedula);

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarUsuario,
                    actUmsj,
                    cfmLmsj,
                    JOptionPane.YES_NO_OPTION);

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
                            mAmsj
                    );
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            Nmsj
                    );
                }

                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(
                            Amsj
                    );
                }

                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(
                            TFmsj
                    );
                }

                if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    throw new IllegalArgumentException(
                            Cmsj
                    );
                }

                Date fecha;

                try {

                    fecha = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    throw new IllegalArgumentException(fchmsj);
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

                actualizarUsuario.mostrarInformacion1(sAUmsj);
            }

        } catch (UsuarioNoExiste e) {

            actualizarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            actualizarUsuario.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarEliminarUsuario() {

        try {

            String cedula = eliminarUsuario.getjTextFieldEUCedula()
                    .getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
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
            
            eliminarUsuario.getjTextFieldEUDireccion()
                    .setText(String.valueOf(usuario.getDireccion()));

            eliminarUsuario.getjTextFieldEUFNacimiento()
                    .setText(String.valueOf(usuario.getFechaNacimiento()));

        } catch (UsuarioNoExiste e) {

            eliminarUsuario.getjTextFieldEUNombre().setText("");
            eliminarUsuario.getjTextFieldEUApellido().setText("");
            eliminarUsuario.getjTextFieldEUTelefono().setText("");
            eliminarUsuario.getjTextFieldEUCElectronico().setText("");
            eliminarUsuario.getjTextFieldEUFNacimiento().setText("");
            eliminarUsuario.getjTextFieldEUDireccion().setText("");

            eliminarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarUsuario() {

        try {

            String cedula = eliminarUsuario.getjTextFieldEUCedula()
                    .getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
                );
            }

            // Si el usuario no existe lanza UsuarioNoExiste
            usuarioDao.buscar(cedula);

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarUsuario,
                    dlUmsj,
                    cfmLmsj,
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                usuarioDao.eliminar(cedula);

                eliminarUsuario.mostrarInformacion(sDUmsj);

                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");
            }

        } catch (UsuarioNoExiste e) {

            eliminarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(e.getMessage());
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
                        IDUmsj
                );
            }

            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(
                        IDmsj
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

            eliminarUsuario.mostrarInformacion(nUmsj);

        } catch (IllegalArgumentException e) {

            eliminarUsuario.mostrarInformacion(e.getMessage());
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

            listaUsuarios.mostrarInformacion(exlUmsj + e.getMessage());
        }
    }

    public void mostrarContadorUsuarios() {

        int total = usuarioDao.contar();

        listaUsuarios.getTxtContadordeUsuarios().setText(String.valueOf(total));
    }

    public void configurarEventosListarUsuarios() {

        listaUsuarios.getBtnMostrarListaUsuarios().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
                mostrarContadorUsuarios();
            }
            
        });
    }

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        agUmsj = (bundle.getString("agUmsj"));
        sCUmsj = (bundle.getString("sCUmsj"));
        canCUmsj = (bundle.getString("canCUmsj"));
        actUmsj = (bundle.getString("actUmsj"));
        sAUmsj = (bundle.getString("sAUmsj"));
        dlUmsj = (bundle.getString("dlUmsj"));
        sDUmsj = (bundle.getString("sDUmsj"));
        tCUmsj = (bundle.getString("tCUmsj"));
        cfmLmsj = (bundle.getString("cfmLmsj"));
        fchmsj = (bundle.getString("fchmsj"));
        nUmsj = (bundle.getString("nUmsj"));
        IDmsj= (bundle.getString("IDmsj"));
        TFmsj = (bundle.getString("TFmsj"));
        Nmsj = (bundle.getString("Nmsj"));
        Amsj= (bundle.getString("Amsj"));
        Cmsj= (bundle.getString("Cmsj"));
        IDUmsj = (bundle.getString("IDUmsj"));
        exlUmsj = (bundle.getString("exlUmsj"));
        mAmsj = (bundle.getString("mAmsj"));
        
        
    }
}